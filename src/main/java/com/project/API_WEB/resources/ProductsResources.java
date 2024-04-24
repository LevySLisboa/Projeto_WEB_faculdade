package com.project.API_WEB.resources;

import com.project.API_WEB.dto.ProductDTO;
import com.project.API_WEB.domain.Product;
import com.project.API_WEB.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsResources {
    @Autowired
    private ProductServices service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<Product> list = service.findAll();
        List<ProductDTO> listDto = list.stream().map(ProductDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(new ProductDTO(obj));
    }

    @PostMapping
    public  ResponseEntity<Void> insert(@RequestBody ProductDTO objDTO){
        Product Product = service.fromDTO(objDTO);
        Product = service.insert(Product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> uptade(@RequestBody ProductDTO ProductDTO,@PathVariable String id){
        Product Product = service.fromDTO(ProductDTO);
        Product.setId(id);
        Product = service.uptade(Product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Product.getId()).toUri();
        return ResponseEntity.noContent().build();
    }
}
