package com.example.myselectshop.service;

import com.example.myselectshop.entity.Product;
import com.example.myselectshop.dto.ProductMypriceRequestDto;
import com.example.myselectshop.dto.ProductRequestDto;
import com.example.myselectshop.dto.ProductResponseDto;
import com.example.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto) throws SQLException {
        Product product = new Product(requestDto);
        return productRepository.createProduct(product);
    }
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProducts() throws SQLException {
        return productRepository.getProducts();
    }

    @Transactional
    public Long updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productRepository.getProduct(id);

        if(product == null){
            throw new NullPointerException("해당 상품이 존재하지 않습니다.");
        }
        return productRepository.updateProduct(product.getId(), requestDto);
    }

}
