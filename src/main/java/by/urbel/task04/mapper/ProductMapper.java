package by.urbel.task04.mapper;

import by.urbel.task04.dto.ProductDto;
import by.urbel.task04.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = CategoryMapper.class)
public interface ProductMapper {
    Product convert(ProductDto dto);

    ProductDto convert(Product product);

    List<ProductDto> convert(List<Product> product);

    @Mapping(target = "id", source = "id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "category", source = "category", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "description", source = "description", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "price", source = "price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "quantity", source = "quantity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "photoUrl", source = "photoUrl", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExisting(@MappingTarget Product product, ProductDto dto);
}
