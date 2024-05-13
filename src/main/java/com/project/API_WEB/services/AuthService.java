package com.project.API_WEB.services;

import com.project.API_WEB.domain.User;
import com.project.API_WEB.dto.UserDTO;
import com.project.API_WEB.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UsersRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    public boolean authenticateUser(UserDTO objDTO){
        if(objDTO.getEmail() == null) {
            return false;
        }
        User user = repository.findByEmail(objDTO.getEmail());
        if(user != null && user.getSenha() != null) {
            return encoder.matches(objDTO.getSenha(), user.getSenha());
        }

        return false;
    }
}
