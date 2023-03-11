package com.albgott.inventoryservice.stock_product.application.create;

import com.albgott.inventoryservice.shared.application.CommandUseCase;
import com.albgott.inventoryservice.stock_product.domain.model.Product;
import com.albgott.inventoryservice.stock_product.domain.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService extends CommandUseCase<CreateProductCommand> {
    private final ProductRepository repository;

    public CreateProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    protected void doExec(CreateProductCommand command) {
        if(repository.existsById(command.productId()))
            throw new RuntimeException("Product already created");

        Product product = new Product(command.businessId(),command.productId(), command.productName());

        repository.save(product);
    }
}
