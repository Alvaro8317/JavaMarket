package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; /*Recibe dos parámetros, la tabla y el tipo de la llave
primaria*/

import java.util.List;
import java.util.Optional;

public interface IProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /*Con query Methods es más importante el camelCase en la primera parte, en los parámetros si va tal como se está
    en la clase*/
//    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true) Nativo, cuando es nativo
//    no es necesario seguir la nomenclatura de findByIdCategoria
    List<Producto> findByIdCategoriaOrderByNombreDesc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
