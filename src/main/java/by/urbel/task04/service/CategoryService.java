package by.urbel.task04.service;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.dto.ProductCategoryDto;
import by.urbel.task04.entity.ProductCategory;
import by.urbel.task04.mapper.CategoryMapper;
import by.urbel.task04.repository.ProductCategoryRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ProductCategoryRepository repository;
    private final CategoryMapper mapper;

    public void create(ProductCategoryDto dto) {
        if (repository.findByName(dto.getName()).isPresent()) {
            throw new EntityExistsException(String.format(Messages.CATEGORY_EXISTS, dto.getName()));
        }
        ProductCategory category = mapper.convert(dto);
        repository.save(category);
    }

    public List<ProductCategoryDto> readAll() {
        return mapper.convert(repository.findAll());
    }

    public void update(long categoryId, ProductCategoryDto dto) {
        if (repository.findByName(dto.getName()).isPresent()) {
            throw new EntityExistsException(String.format(Messages.CATEGORY_EXISTS, dto.getName()));
        }
        ProductCategory category = repository.findById(categoryId).orElseThrow(() ->
                new EntityNotFoundException(String.format(Messages.CATEGORY_NOT_FOUND, categoryId)));
        category.setName(dto.getName());
        repository.save(category);
    }

    public void delete(long categoryId) {
        repository.deleteById(categoryId);
    }
}
