package com.albgott.inventoryservice.supplier.create;

import com.albgott.inventoryservice.shared.application.CommandUseCase;
import com.albgott.inventoryservice.supplier.domain.model.Supplier;
import com.albgott.inventoryservice.supplier.domain.repository.SupplierRespository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierService extends CommandUseCase<CreateSupplierCommand> {

    private final SupplierRespository supplierRespository;

    public CreateSupplierService(SupplierRespository supplierRespository) {
        this.supplierRespository = supplierRespository;
    }

    @Override
    @Transactional
    public void doExec(CreateSupplierCommand command) {
        if(supplierRespository.isNameUsedOnBusiness(command.companyName(), command.businessId()))
            throw new RuntimeException("Supplier company name already on use inside business");

        if(supplierRespository.existsById(command.supplierId()))
            throw new RuntimeException("Supplier id already added");
        Supplier supplier = new Supplier(
                command.supplierId(),
                command.businessId(),
                command.companyName()
        );

        supplierRespository.save(supplier);
    }
}
