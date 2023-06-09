package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*Rest controller indica a spring que es un controlador de API REST*/
/*RequestMapping indica que path tendrá*/
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired /*Permite usar autowired porque ProductService tiene una anotación service que indica que es un
    componente de spring*/
    private ProductService productService;
    @GetMapping("/all")/*Retorna un ResponseEntity para representar la respuesta HTTP que se
    envía desde un controlador de Spring*/
    @ApiOperation("Get all supermarket products") /*Anotación para swagger*/
    @ApiResponse(code = 200, message = "OK!")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    @ApiOperation("Search a product with ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 404, message = "Product not found")
    }) /*Api Param parámetro de swagger que indica más información del parámetro*/
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7") @PathVariable("productId")int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<Product>(product, HttpStatus.OK))/*Busca y si no encuentra, retorna un NOT FOUND*/
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<List<Product>>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable("productId") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
