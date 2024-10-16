package com.csci318_group13.product_Service.Service;

import com.csci318_group13.product_Service.Repository.ProductRepository;
import com.csci318_group13.product_Service.domain.model.aggregate.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {



    private final ProductRepository productRepository;



    private final RestTemplate restTemplate;


    public ProductService(ProductRepository productRepository , RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String id) {
        Long longId =   Long.valueOf(id);  // this line to convert string id to Long id


        return productRepository.findById((longId)).orElseThrow();


    }

    public Product addProduct(Product product) {
        return productRepository.save(product);

    }

    public void deleteProductByID(String id) {
        Long longId =   Long.valueOf(id);
        productRepository.deleteById(longId);
    }
}
