package com.project.API_WEB.services;

import com.project.API_WEB.dto.ProductDTO;
import com.project.API_WEB.domain.Product;
import com.project.API_WEB.repository.ProductsRepository;
import com.project.API_WEB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductsRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(String id) {
        Optional<Product> user = repository.findById(id);
        return user.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
    }
    public Product insert(Product obj){
        return repository.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
    public Product uptade(Product product){
        var newProduct = repository.findById(product.getId()).get();
        uptadeData(newProduct,product);
        return repository.save(product);
    }

    private void uptadeData(Product newProduct, Product product) {
        newProduct.setId(product.getId());
        newProduct.setNome(product.getNome());
        newProduct.setDescricao(product.getDescricao());
        newProduct.setPreco(product.getPreco());
        newProduct.setDataDeCadastro(product.getDataDeCadastro());
    }

    public Product fromDTO(ProductDTO objDTO){
        return new Product(objDTO.getId(),objDTO.getNome(), objDTO.getDescricao(),objDTO.getPreco()/*,objDTO.getSeller() */);
    }
}
