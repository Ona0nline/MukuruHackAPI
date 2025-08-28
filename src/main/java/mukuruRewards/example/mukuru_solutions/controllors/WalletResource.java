package mukuruRewards.example.mukuru_solutions.controllors;

import jakarta.servlet.http.HttpSession;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.WalletDTO;
import mukuruRewards.example.mukuru_solutions.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletResource {

    @Autowired
    HttpSession session;

    @Autowired
    private WalletService walletService;

    @PostMapping("/transaction/send")
    @CrossOrigin("http://127.0.0.1:5501")
    public ResponseEntity<?> send(@RequestBody WalletDTO walletDTO){
        String senderEmail = (String) session.getAttribute("email");
        return ResponseEntity.ok(walletService.sendMoney(walletDTO.getAmount(),senderEmail,walletDTO.getRecepient()));
    }
}
