package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.domain.PriceFilter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

/**
 * This method has the logic of Price repository with Criteria, can apply
 * multiple filters.
 * 
 * @author Alejandro Martin Marques
 */
@Component
@RequiredArgsConstructor
public class PricesCriteriaRepositoryImpl implements PricesCustomRepository {
    private final EntityManager entityManager;

    @Override
    public Optional<List<PriceEntity>> findPricesByPriceFilter(PriceFilter priceFilter) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceEntity> criteriaQuery = criteriaBuilder.createQuery(PriceEntity.class);
        Root<PriceEntity> root = criteriaQuery.from(PriceEntity.class);

        // Get list of predicates aplicable by priceFilter
        List<jakarta.persistence.criteria.Predicate> predicates = getPredicatesByPriceFilter(criteriaBuilder, root,
                priceFilter);

        // Add filters to criteriaQuery
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0])));

        // Create query
        TypedQuery<PriceEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        CriteriaUtils.addPagination(typedQuery, priceFilter.getPageFilter());

        // Execute query
        List<PriceEntity> pricesEntities = typedQuery.getResultList();

        return Optional.ofNullable(pricesEntities.isEmpty() ? null : pricesEntities);

    }

    private List<jakarta.persistence.criteria.Predicate> getPredicatesByPriceFilter(CriteriaBuilder criteriaBuilder,
        Root<PriceEntity> root, PriceFilter priceFilter) {
        List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();

        // Filter of product
        if (priceFilter.getIdProduct() != null) {
            predicates.add(criteriaBuilder.equal(root.get("productEntity").get("id"), priceFilter.getIdProduct()));
        }

        // Filter date range
        if (priceFilter.getStartDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), priceFilter.getStartDate()));
        }
        if (priceFilter.getEndDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), priceFilter.getEndDate()));
        }

        //Filter specific date
        if (priceFilter.getDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), priceFilter.getDate()));
        }

        if (priceFilter.getDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), priceFilter.getDate()));
        }
        return predicates;
    }

}
