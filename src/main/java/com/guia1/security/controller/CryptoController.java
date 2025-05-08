package com.guia1.security.controller;

import com.guia1.security.service.AesEncryptionService;
import com.guia1.security.service.RsaEncryptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {
    private final AesEncryptionService aesService;
    private final RsaEncryptionService rsaService;

    public CryptoController() throws Exception {
        this.aesService = new AesEncryptionService();
        this.rsaService = new RsaEncryptionService();
    }
    //encriptar con AES
    @PostMapping("/aes/encrypt")
    public String encryptAes(@RequestBody String input) throws
            Exception {
        return aesService.encrypt(input);
    }
    //Decencriptar con AES
    @PostMapping("/aes/decrypt")
    public String decryptAes(@RequestBody String input) throws
            Exception {
        return aesService.decrypt(input);
    }

    @PostMapping("/rsa/encrypt")
    public String encryptRsa(@RequestBody String input) throws
            Exception {
        return rsaService.encrypt(input);
    }

    @PostMapping("/rsa/decrypt")
    public String decryptRsa(@RequestBody String input) throws
            Exception {
        return rsaService.decrypt(input);
    }
}
