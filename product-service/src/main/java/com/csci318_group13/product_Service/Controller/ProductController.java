package com.csci318_group13.product_Service.Controller;

import com.csci318_group13.product_Service.Service.ProductService;
import com.csci318_group13.product_Service.domain.model.aggregate.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    List<Product> allProducts() {

        return productService.getAllProducts() ;

    }

    @GetMapping("/api/products/{id}")
    Product findProduct(@PathVariable String id){
       // System.out.println("retreiving id" + productService.getProduct(id).toString());

        return productService.getProduct(id);


    }


    @PostMapping("/api/product/addProduct")
    Product createProduct(@RequestBody Product Product) {




        return productService.addProduct(Product);
    }
    @DeleteMapping("/api/product/delete/{id}")
    void deleteEmployee(@PathVariable String id) {
        productService.deleteProductByID(id);
    }



}