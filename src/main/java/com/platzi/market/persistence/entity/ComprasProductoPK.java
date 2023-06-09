package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable; /* se utiliza para marcar una clase como serializable, lo que permite que sus instancias
se conviertan en secuencias de bytes para su almacenamiento o transmisión, y luego se puedan restaurar a su forma
original mediante deserialización.*/

@Embeddable /*Indica que se va a incluir en compras producto*/
public class ComprasProductoPK /*Primary Key de compras productos*/ implements Serializable {
    @Column(name = "id_compra")
    private Integer idCompra;
    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
