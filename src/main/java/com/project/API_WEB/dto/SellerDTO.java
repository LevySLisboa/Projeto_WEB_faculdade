package com.project.API_WEB.dto;

import com.project.API_WEB.domain.User;

import java.io.Serializable;

public class SellerDTO implements Serializable {
    private String id;
    private String name;

    public SellerDTO() {}

    public SellerDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
