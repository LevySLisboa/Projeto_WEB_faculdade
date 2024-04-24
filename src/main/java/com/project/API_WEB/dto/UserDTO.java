package com.project.API_WEB.dto;

import com.project.API_WEB.domain.Product;
import com.project.API_WEB.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
    @Id
    private String id;
    private String nome,email;
    @DBRef(lazy = true)
    private List<Product> products;
    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.products = user.getProducts();
    }
    public UserDTO(){}

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getProducts() {
        return products;
    }
}