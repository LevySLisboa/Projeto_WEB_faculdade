package com.project.API_WEB.resources;

import com.project.API_WEB.dto.UserDTO;
import com.project.API_WEB.domain.Product;
import com.project.API_WEB.domain.User;
import com.project.API_WEB.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
        @Autowired
        private UserServices service;

        @GetMapping
        public ResponseEntity<List<UserDTO>> findAll() {
            List<User> list = service.findAll();
            List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
            return ResponseEntity.ok().body(listDto);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<UserDTO> findById(@PathVariable String id) {
            User obj = service.findById(id);
            return ResponseEntity.ok().body(new UserDTO(obj));
        }


        @PostMapping
        public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
            User user = service.fromDTO(objDTO);
            user = service.insert(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<Void> uptade(@RequestBody UserDTO userDTO, @PathVariable String id) {
            User user = service.fromDTO(userDTO);
            user.setId(id);
            user = service.uptade(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.noContent().build();
        }

        @GetMapping(value = "/{id}/products")
        public ResponseEntity<List<Product>> findProducts(@PathVariable String id){
            User obj = service.findById(id);
            return ResponseEntity.ok().body(obj.getProducts());
        }

}