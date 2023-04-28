package by.urbel.task04.controller;

import by.urbel.task04.controller.constants.Routes;
import by.urbel.task04.dto.ProductDto;
import by.urbel.task04.entity.enums.Role;
import by.urbel.task04.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(Routes.PRODUCTS)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @Secured(Role.Constants.ADMIN_ROLE)
    public void create(@RequestPart @Valid ProductDto productDto, @RequestPart MultipartFile productPhoto) {
        productService.create(productDto, productPhoto);
    }

    @GetMapping(Routes.ID)
    public ProductDto readById(@PathVariable long id) {
        return productService.readById(id);
    }

    @GetMapping
    @Secured(Role.Constants.ADMIN_ROLE)
    public List<ProductDto> readAll() {
        return productService.readAll();
    }

    @GetMapping(Routes.IN_STOCK)
    public List<ProductDto> readAllInStock() {
        return productService.readAllInStock();
    }

    @PutMapping(Routes.ID)
    @Secured(Role.Constants.ADMIN_ROLE)
    public void update(@PathVariable long id, @RequestBody @Valid ProductDto productDto) {
        productService.update(id, productDto);
    }

    @DeleteMapping(Routes.ID)
    @Secured(Role.Constants.ADMIN_ROLE)
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }
}
