package mukuruRewards.example.mukuru_solutions.controllors;

import jakarta.servlet.http.HttpSession;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.WalletDTO;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.WalletResponseDTO;
import mukuruRewards.example.mukuru_solutions.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        WalletResponseDTO walletResponseDTO = walletService.sendMoney(walletDTO.getAmount(),senderEmail,walletDTO.getRecepient());
        session.setAttribute("history", walletResponseDTO);
        return ResponseEntity.ok(walletResponseDTO);
    }

    @GetMapping("/transaction/history")
    @CrossOrigin("http://127.0.0.1:5501")
    public ResponseEntity<?> history(@RequestBody WalletResponseDTO walletResponseDTO){
        WalletResponseDTO walletResponseDTO1 = (WalletResponseDTO) session.getAttribute("history");
        return ResponseEntity.ok(walletResponseDTO1);
    }

}
