package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import com.bcnc.alejandrotest.domain.PageFilter;

import jakarta.persistence.TypedQuery;

/**
 * This util class contains all reusable criteria login in project.
 * @author Alejandro Martin Marques
 */
public class CriteriaUtils {
   
    /**
     * Static method to apply pagination in typedQuery by PageFilter (domain object).
     * @param typedQuery
     * @param pageFilter
     */
    public static void addPagination(TypedQuery<?> typedQuery, PageFilter pageFilter){
        //Check page info
        Integer page = pageFilter.getPage()!=null ? pageFilter.getPage() : 1;
        Integer pageSize = pageFilter.getPageSize() != null && pageFilter.getPageSize() < 500 ? pageFilter.getPageSize() : 10;

        //Add pagination to query
        typedQuery.setFirstResult(page * pageSize);
        typedQuery.setMaxResults(pageSize);
    }
}
