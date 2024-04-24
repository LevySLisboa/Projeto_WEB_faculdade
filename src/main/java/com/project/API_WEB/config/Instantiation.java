package com.project.API_WEB.config;

import com.project.API_WEB.dto.SellerDTO;
import com.project.API_WEB.domain.Product;
import com.project.API_WEB.domain.User;
import com.project.API_WEB.repository.ProductsRepository;
import com.project.API_WEB.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
        @Autowired
        private ProductsRepository repository;
        @Autowired
        private UsersRepository usersRepository;

        @Override
        public void run(String...args){/*
            repository.deleteAll();
            usersRepository.deleteAll();

            User maria = new User(null, "Maria Brown", "maria@gmail.com");
            User alex = new User(null, "Alex Green", "alex@gmail.com");
            User bob = new User(null, "Bob Grey", "bob@gmail.com");
            usersRepository.saveAll(Arrays.asList(maria,alex,bob));

            Product celular = new Product(null,"SAMSUNG Galaxy A22","128 GB de armazemamento e 4 GB DE RAM",4000.00,new SellerDTO(maria));
            Product pc = new Product(null,"PC Gamer","RYZEN 7 7000 + RTX 3090",5000.00,new SellerDTO(alex));
            Product mesa = new Product(null,"Mesa de carvalho","1 metro e meio de largura",1500.00,new SellerDTO(bob));
            Product laptop = new Product(null, "Laptop","Dell",15.90,new SellerDTO(alex));

            repository.saveAll(Arrays.asList(celular,pc,mesa,laptop));


            maria.getProducts().add(celular);
            alex.getProducts().addAll(Arrays.asList(pc,laptop));
            bob.getProducts().add(mesa);
            usersRepository.saveAll(Arrays.asList(maria,alex,bob));

             */
        }
}
