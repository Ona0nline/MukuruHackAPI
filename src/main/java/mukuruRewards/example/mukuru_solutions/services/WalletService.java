package mukuruRewards.example.mukuru_solutions.services;

import jakarta.transaction.Transactional;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.WalletResponseDTO;
import mukuruRewards.example.mukuru_solutions.database.details.UserDetails;
import mukuruRewards.example.mukuru_solutions.database.details.WalletDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.UserRepo;
import mukuruRewards.example.mukuru_solutions.database.repos.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private UserRepo userRepo;

//    Very nb for transactions in db
    @Transactional
    public WalletResponseDTO sendMoney(double amount, String senderEmail, String receiver){
        Optional<UserDetails> senderDetails = userRepo.findByEmail(senderEmail);
        Optional<UserDetails> receiverDetails = userRepo.findByName(receiver);


        if(senderDetails.isPresent()){

            UserDetails senderuserDetails = senderDetails.get();
            WalletDetails senderWalletDetails = walletRepo.findByUserId(senderuserDetails.getId());
            System.out.println(senderWalletDetails.getId());

            double newBalanceU = senderWalletDetails.getNewBalance() - amount;
            double newDebitValueU = senderWalletDetails.getDebit() + amount;
            double prev_balance = senderWalletDetails.getBalance();
            senderWalletDetails.setNewBalance(newBalanceU);
            senderWalletDetails.setDebit(newDebitValueU);


            walletRepo.save(senderWalletDetails);

//            POINTS INCREASING LOGIC

            //            Get sender details from the db
            UserDetails receiverUserDetails = receiverDetails.get();
            WalletDetails RwalletDetails = walletRepo.findByUserId(receiverUserDetails.getId());
            double newBalanceR = RwalletDetails.getBalance() + amount;
            double newCreditValueR = RwalletDetails.getCredit() + amount;

            RwalletDetails.setBalance(newBalanceR);
            RwalletDetails.setCredit(newCreditValueR);

            walletRepo.save(RwalletDetails);

            return new WalletResponseDTO(receiver,amount, senderWalletDetails.getCredit(), senderWalletDetails.getDebit(), prev_balance, senderWalletDetails.getNewBalance() );

        }

        return new WalletResponseDTO();


    }

}
