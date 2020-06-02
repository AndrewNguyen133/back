package com.backend.backend.repository;

import com.backend.backend.entities.ExceptionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionPagingAndSorting extends PagingAndSortingRepository<ExceptionEntity, Integer> {

}
