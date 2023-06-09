package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;
/*Los objetos de dominio se encargan de llevar toda la lógica de negocio*/
public interface IProductRepository {
    /*Se debe de indicar aquí el nombre de los métodos que cualquier repositorio que va a trabajar con productos, debe
    * de implementar, es similar al de persistencia, pero el ya construido implementará este, para que se hable al final
    * del programa en términos de dominio y no de tabla*/
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct (int productId);
    Product save(Product product);
    void delete(int productId);
}
