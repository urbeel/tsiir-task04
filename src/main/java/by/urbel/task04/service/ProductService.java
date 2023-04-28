package by.urbel.task04.service;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.dto.ProductDto;
import by.urbel.task04.entity.Product;
import by.urbel.task04.mapper.ProductMapper;
import by.urbel.task04.repository.ProductRepository;
import by.urbel.task04.service.exception.InvalidPhotoUrlFormatException;
import by.urbel.task04.service.exception.UploadPhotoException;
import com.uploadcare.api.Client;
import com.uploadcare.upload.FileUploader;
import com.uploadcare.upload.UploadFailureException;
import com.uploadcare.upload.Uploader;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final Client photoCloudClient;

    private static final String DEFAULT_PHOTO = "https://ucarecdn.com/b0157e45-fe2f-4df1-9237-5156893d37c2/";
    private static final String REGEX_TO_GET_PHOTO_ID = "https://ucarecdn.com/(.+)/.";

    public void create(ProductDto productDto, MultipartFile productPhoto) {
        Product product = mapper.convert(productDto);
        if (!productPhoto.isEmpty()) {
            URI photoURI = uploadPhotoToCloud(productPhoto);
            product.setPhotoUrl(photoURI.toASCIIString());
        } else {
            product.setPhotoUrl(DEFAULT_PHOTO);
        }
        repository.save(product);
    }

    public ProductDto readById(long id) {
        return mapper.convert(repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(Messages.PRODUCT_NOT_FOUND, id))));
    }

    public List<ProductDto> readAll() {
        return mapper.convert(repository.findAll());
    }

    public List<ProductDto> readAllInStock() {
        return mapper.convert(repository.findAllByQuantityIsGreaterThan(0));
    }

    public void update(long id, ProductDto productDto) {
        productDto.setId(id);
        Product product = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(Messages.PRODUCT_NOT_FOUND, id)));
        mapper.updateExisting(product, productDto);
        System.out.println(product);
        repository.save(product);
    }

    public void delete(long id) {
        Product product = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(Messages.PRODUCT_NOT_FOUND, id)));
        repository.deleteById(id);
        if (!product.getPhotoUrl().equals(DEFAULT_PHOTO)) {
            deletePhotoFromStorage(product.getPhotoUrl());
        }
    }

    private URI uploadPhotoToCloud(MultipartFile photo) {
        try {
            Uploader uploader = new FileUploader(photoCloudClient, photo.getInputStream(), photo.getOriginalFilename());
            return uploader.upload().getOriginalFileUrl();
        } catch (IOException | UploadFailureException e) {
            throw new UploadPhotoException(e);
        }
    }

    private void deletePhotoFromStorage(String photoUrl) {
        Matcher matcher = Pattern.compile(REGEX_TO_GET_PHOTO_ID).matcher(photoUrl);
        if (matcher.find()) {
            String photoId = matcher.group(1);
            photoCloudClient.deleteFile(photoId);
        } else {
            throw new InvalidPhotoUrlFormatException(Messages.INVALID_PHOTO_URL);
        }
    }
}
