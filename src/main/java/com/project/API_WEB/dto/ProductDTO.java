package com.project.API_WEB.dto;

import com.project.API_WEB.domain.Product;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductDTO implements Serializable {
        @Id
        private String id;
        private String nome,descricao;
        private Double preco;
        private LocalDate dataDeCadastro;
        private SellerDTO seller;

        public ProductDTO(Product obj) {
            this.id = obj.getId();
            this.nome = obj.getNome();
            this.descricao = obj.getDescricao();
            this.preco = obj.getPreco();
            this.dataDeCadastro = obj.getDataDeCadastro();
            //this.seller = obj.getSeller();
        }
        public ProductDTO(){}

    public String getId() {
        return id;
    }

    public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public Double getPreco() {
            return preco;
        }

        public LocalDate getDataDeCadastro() {
            return dataDeCadastro;
        }

    public SellerDTO getSeller() {
        return seller;
    }
}

