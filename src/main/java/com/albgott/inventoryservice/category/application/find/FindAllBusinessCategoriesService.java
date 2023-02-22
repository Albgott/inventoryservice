package com.albgott.inventoryservice.category.application.find;

import com.albgott.inventoryservice.business.domain.exception.BusinessNotFound;
import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.business.domain.model.BusinessId;
import com.albgott.inventoryservice.business.domain.repository.BusinessRepository;
import com.albgott.inventoryservice.category.DTO.CategoriesDTO;
import com.albgott.inventoryservice.category.domain.repository.CategoryRepository;
import com.albgott.inventoryservice.shared.application.QueryUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindAllBusinessCategoriesService implements QueryUseCase<FindAllBusinessCategoriesQuery, CategoriesDTO> {

    private final BusinessRepository businessRepository;
    private final CategoryRepository categoryRepository;

    public FindAllBusinessCategoriesService(BusinessRepository businessRepository,
                                            CategoryRepository categoryRepository) {
        this.businessRepository = businessRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoriesDTO exec(FindAllBusinessCategoriesQuery query) {
        Business business = getBusinessFromQuery(query);
        return new CategoriesDTO(categoryRepository.findByBusiness(business));
    }

    private Business getBusinessFromQuery(FindAllBusinessCategoriesQuery query) {
        return businessRepository.findById(new BusinessId(query.businessId()))
                .orElseThrow(() -> new BusinessNotFound(query.businessId()));
    }
}
