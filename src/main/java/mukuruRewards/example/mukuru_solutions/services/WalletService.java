package mukuruRewards.example.mukuru_solutions.services;

import jakarta.transaction.Transactional;
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

    @Transactional
    public double sendMoney(double amount, String senderEmail, String receiver){
        Optional<UserDetails> senderDetails = userRepo.findByEmail(senderEmail);
        Optional<UserDetails> receiverDetails = userRepo.findByName(receiver);


        if(senderDetails.isPresent()){

            UserDetails senderuserDetails = senderDetails.get();
            WalletDetails UwalletDetails = walletRepo.findByUserId(senderuserDetails.getId());
            System.out.println(UwalletDetails.getId());

            double newBalanceU = UwalletDetails.getNewBalance() - amount;
            double newDebitValueU = UwalletDetails.getDebit() + amount;
            UwalletDetails.setNewBalance(newBalanceU);
            UwalletDetails.setDebit(newDebitValueU);


            walletRepo.save(UwalletDetails);
            System.out.println("Are we there yet?!");
//            POINTS INCREASING LOGIC

            //            Get sender details from the db
            UserDetails receiverUserDetails = receiverDetails.get();
            WalletDetails RwalletDetails = walletRepo.findByUserId(receiverUserDetails.getId());
            double newBalanceR = RwalletDetails.getBalance() + amount;
            double newCreditValueR = RwalletDetails.getCredit() + amount;

            RwalletDetails.setBalance(newBalanceR);
            RwalletDetails.setCredit(newCreditValueR);

            walletRepo.save(RwalletDetails);

        }

        return amount;

    }

}
