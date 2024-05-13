package com.project.API_WEB.dto;

import com.project.API_WEB.domain.Product;
import com.project.API_WEB.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
    private String id;
    private int matricula;
    private String nome,email,senha;
    @DBRef(lazy = true)
    private List<Product> products;
    public UserDTO(User user) {
        this.id = user.getId();
        this.matricula = user.getMatricula();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.products = user.getProducts();
        this.senha = user.getSenha();
    }
    public UserDTO(){}

    public String getId() {
        return id;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Product> getProducts() {
        return products;
    }
}
