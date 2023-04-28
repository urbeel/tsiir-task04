package by.urbel.task04.controller;

import by.urbel.task04.controller.constants.Routes;
import by.urbel.task04.dto.ProductCategoryDto;
import by.urbel.task04.entity.enums.Role;
import by.urbel.task04.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.CATEGORIES)
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @Secured(Role.Constants.ADMIN_ROLE)
    public void create(@RequestBody @Valid ProductCategoryDto categoryDto) {
        categoryService.create(categoryDto);
    }

    @GetMapping
    public List<ProductCategoryDto> readAll() {
        return categoryService.readAll();
    }

    @PutMapping(Routes.ID)
    @Secured(Role.Constants.ADMIN_ROLE)
    public void update(@PathVariable long id, @RequestBody @Valid ProductCategoryDto categoryDto) {
        categoryService.update(id, categoryDto);
    }

    @DeleteMapping(Routes.ID)
    @Secured(Role.Constants.ADMIN_ROLE)
    public void delete(@PathVariable long id) {
        categoryService.delete(id);
    }
}
