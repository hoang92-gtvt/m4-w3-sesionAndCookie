package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IProductRepository;

import java.util.Optional;

public class ProductService implements IProductService{


    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
