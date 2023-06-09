package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity /* Anotación que mapea una tabla a la base de datos */
@Table(name = "productos") /*Referencia de la clase Producto a la BD productos*/
public class Producto {
    /*Utilizar clases wrapper*/
    @Id /*Clave primaria*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Aplica solo a claves primarias, especifica como se generan
    los valores de clave primaria, IDENTITY es una estrategia que se utiliza cuando la base de datos gestiona la
    generación de valores de clave primaria automáticamente, usada con auto incremento, compatible con MySQL, PostgreSQL
    y SQL Server*/
    @Column(name = "id_producto") /*Nombre de columna en la base de datos, usada cuando es distinto el nombre
    de la propiedad y la tabla*/
    private Integer idProducto;
    private String nombre;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;
    private Boolean estado;
    /*Relación entre producto y categoria*/
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) /*Insertable y updatable,
    significa que cada vez que se vaya a insertar una nueva categoría, se debe de hacer directamente a categoría*/
    private Categoria categoria;
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
