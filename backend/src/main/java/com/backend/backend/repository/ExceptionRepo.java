package com.backend.backend.repository;

import com.backend.backend.entities.ExceptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ExceptionRepo extends CrudRepository<ExceptionEntity, Long> {
//
//    @Override
//    List<ExceptionEntity> findAll();
}
