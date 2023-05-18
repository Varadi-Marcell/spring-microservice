package com.example.productservice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") String id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductDto dto){
        productService.createProduct(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") String id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/with-restaurant/{restaurant-id}")
    public ResponseEntity<List<ProductDto>> findAllProductsByRestaurantId(@PathVariable("restaurant-id") Long id){
        return new ResponseEntity<>(productService.getAllProductsByRestaurantId(id),HttpStatus.OK);
    }
    @DeleteMapping("/with-restaurant/{restaurant-id}")
    public ResponseEntity<Void> deleteAllProductsByRestaurantId(@PathVariable("restaurant-id") Long id){
        productService.deleteAllProductsByRestaurantId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
