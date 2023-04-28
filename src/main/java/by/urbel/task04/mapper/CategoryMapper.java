package by.urbel.task04.mapper;

import by.urbel.task04.dto.ProductCategoryDto;
import by.urbel.task04.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    ProductCategory convert(ProductCategoryDto dto);

    ProductCategoryDto convert(ProductCategory category);

    List<ProductCategoryDto> convert(List<ProductCategory> category);
}
