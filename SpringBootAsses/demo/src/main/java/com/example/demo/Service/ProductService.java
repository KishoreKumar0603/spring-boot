package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository; 

    // Add Product
    public Product addProduct(Product product) {  
        return productRepository.save(product);
    }

    // Get Products
    public List<Product> getProducts() {  
        return productRepository.findAll();
    }

    // Update Product
    public Product updateProduct(Product product, int id) {  
        Product updateProduct = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));  

        updateProduct.setId(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setFeedback(product.getFeedback());
        return productRepository.save(updateProduct);
    }

    // Delete Product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
