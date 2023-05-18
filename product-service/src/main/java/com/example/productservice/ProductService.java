package com.example.productservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDTOMapper mapper;

    public List<ProductDto> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto getProductById(String id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        return productRepository.findById(id)
                .stream()
                .map(mapper)
                .findFirst()
                .get();
    }

    public void createProduct(CreateProductDto dto) {
        productRepository.insert(dto.convertToEntity(dto));
    }

    @Transactional
    public void deleteProductById(String id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    //    public List<ProductDto> getAllProductsByRestaurantId(Long id) {
//        return productRepository.findProductsByRestaurantId(id).stream()
//                .map(mapper)
//                .collect(Collectors.toList());
//    }
    public List<ProductDto> getAllProductsByRestaurantId(Long id) {
        System.out.println(productRepository.findProductsByRestaurantId(id).stream().map(mapper).collect(Collectors.toList()));
        return productRepository.findProductsByRestaurantId(id).stream().map(mapper).collect(Collectors.toList());
    }

    @Transactional
    public void deleteAllProductsByRestaurantId(Long id) {
        productRepository.deleteProductsByRestaurantId(id);
    }
}
