package mukuruRewards.example.mukuru_solutions.services;

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

    public double sendMoney(double amount, String senderEmail, String receiver){
        Optional<UserDetails> senderDetails = userRepo.findByEmail(senderEmail);
        Optional<UserDetails> receiverDetails = userRepo.findByName(receiver);


        if(senderDetails.isPresent()){
//            Get sender details from the db
            UserDetails senderuserDetails = senderDetails.get();
//            Get their wallet details from db
            WalletDetails UwalletDetails = walletRepo.findByUserId(senderuserDetails.getId());
            System.out.println(UwalletDetails.getId());
//            Edit their money
            double newBalanceU = UwalletDetails.getBalance() - amount;
            double newDebitValueU = UwalletDetails.getDebit() + amount;
            UwalletDetails.setBalance(newBalanceU);
            UwalletDetails.setDebit(newDebitValueU);
//            Save new wallet details
            walletRepo.save(UwalletDetails);
//            POINTS INCREASING LOGIC

            //            Get sender details from the db
            UserDetails receiverUserDetails = receiverDetails.get();
//            Get their wallet details from db
            WalletDetails RwalletDetails = walletRepo.findByUserId(receiverUserDetails.getId());
//            Edit their money
            double newBalanceR = RwalletDetails.getBalance() + amount;
            double newCreditValueR = RwalletDetails.getCredit() + amount;

            RwalletDetails.setBalance(newBalanceR);
            RwalletDetails.setCredit(newCreditValueR);
//            Save new wallet details
            walletRepo.save(RwalletDetails);


        }

        return amount;

    }

}
