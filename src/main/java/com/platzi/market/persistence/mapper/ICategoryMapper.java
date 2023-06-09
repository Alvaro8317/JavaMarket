package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") /*Indica que es un mapeador, tiene compatibilidad con spring*/
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    }) /*Mappings para indicar que se hará varios mapeos*/
    Category toCategory(Categoria categoria); /*Es importante el nombre toCategory*/
    @InheritInverseConfiguration /*Se le indica que la configuración es la inversa a la anterior*/
    @Mapping(target = "productos", ignore = true) /*Se le indica que productos no es relevante*/
    Categoria toCategoria(Category category);
}
