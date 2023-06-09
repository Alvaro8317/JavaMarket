package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*Esta clase service sirve como intermediario entre controlador y la capa de repositorio*/
/*Anotación que se puede reemplazar por component, pero indica con la anotación @Service que es un servicio, añadiendo
* un sentido semántico*/
@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
//    public boolean delete(int productId){
//        /*Primera alternativa*/
//        getProduct(productId).map(product -> {
//            productRepository.delete(productId);
//            return true;
//        });
////        }).orElse(false);
//        return false;
//
//        /*Segunda alternativa*/
////        if (getProduct(productId).isPresent()){
////            productRepository.delete(productId);
////            return true;
////        }
////        return false;
//    }
}
