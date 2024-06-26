package com.project.API_WEB.resources;

import com.project.API_WEB.dto.UserDTO;
import com.project.API_WEB.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthResources {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserDTO objDTO){
        if (objDTO.getEmail() == null || objDTO.getSenha() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email e senha são obrigatórios");
        }

        try {
            if (authService.authenticateUser(objDTO)) {
                return ResponseEntity.ok("Sucesso no Login");
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email e/ou senha inválido(s)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Um erro ocorreu durante o login");
        }
    }
}
