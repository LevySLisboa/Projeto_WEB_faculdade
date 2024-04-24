package com.project.API_WEB.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "users")
public class User{
    @Id
    private String id;
    private String nome,email,senha,senhaConfirmada;
    @DBRef(lazy = true)
    private List<Product> products = new ArrayList<>();

    public User() {}

    public User(String id, String nome, String email, String senha, String senhaConfirmada) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.senhaConfirmada = senhaConfirmada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaConfirmada() {
        return senhaConfirmada;
    }

    public void setSenhaConfirmada(String senhaConfirmada) {
        this.senhaConfirmada = senhaConfirmada;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
