package user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import user.dto.ProductDTO;
import user.model.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "type", source = "type.name")
    ProductDTO toDto(ProductEntity productEntity);

    @Mapping(target = "type", source = "type")
    ProductEntity toEntity(ProductDTO productDTO);
}
