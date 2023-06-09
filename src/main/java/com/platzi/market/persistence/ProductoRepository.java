package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import com.platzi.market.persistence.crud.IProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository /*Clase que interactua con la base de datos, es un estereotipo de spring, se le indica que esta clase
se encarga de interactuar con la base de datos*/
//@Component /*Componente de spring general, es muy genérico*/
public class ProductoRepository implements IProductRepository {
    /*Aquí está estos valores en null, si se lanza el programa se obtendrá una excepción de null exception*/
    /*Spring se encarga de crear los objetos gracias a contenedor de inversión de control, solo se debe de escribir
    * @Autowired, los objetos que reciban esa anotación, spring creará las instancias*/
    /*Para usarlo, se debe de confirmar que la entidad es un componente de spring*/
    @Autowired
    private IProductoCrudRepository productoCrudRepository;
    @Autowired
    private IProductMapper mapper;
    @Override
    public List<Product> getAll() {
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreDesc(categoryId);
        return Optional.of(mapper.toProducts(productos)); /*Se usa Optional.of porque el método findByIdCategoria
        de la interfaz productoCrudRepository debe de retornar un Optional<List<Product>>.*/
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct((productoCrudRepository.save(producto)));
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreDesc(idCategoria);
    }
//    public Optional<List<Producto>> getEscasos(int cantidad){
//        return
//    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    @Override
    public void delete(int id){
        productoCrudRepository.deleteById(id);
    }
}
