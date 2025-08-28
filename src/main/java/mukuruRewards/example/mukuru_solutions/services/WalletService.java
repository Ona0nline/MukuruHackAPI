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

        if(senderDetails.isPresent()){
//            Get sender details from the db
            UserDetails senderuserDetails = senderDetails.get();
//            Get their wallet details from db
            WalletDetails UwalletDetails = walletRepo.findByUserId(senderuserDetails.getId());
            System.out.println(UwalletDetails.getId());
//            Edit their money
            double newBalanceU = UwalletDetails.getBalance() - amount;
            double newDebitValueU = UwalletDetails.getDebit() + amount;
//            Save new wallet details
            var newWalletDetails = WalletDetails.builder()
                    .balance(newBalanceU)
                    .debit(newDebitValueU).build();

            walletRepo.save(newWalletDetails);
//            POINTS INCREASING LOGIC

            //            Get sender details from the db
            UserDetails receiverUserDetails = senderDetails.get();
//            Get their wallet details from db
            WalletDetails RwalletDetails = walletRepo.findByUserId(receiverUserDetails.getId());
//            Edit their money
            double newBalanceR = RwalletDetails.getBalance() + amount;
            double newDebitValueR = RwalletDetails.getCredit() + amount;
//            Save new wallet details
            var newWalletDetailsR = WalletDetails.builder()
                    .balance(newBalanceR)
                    .debit(newDebitValueR).build();

            walletRepo.save(newWalletDetailsR);


        }

        return 0.0;

    }

}
