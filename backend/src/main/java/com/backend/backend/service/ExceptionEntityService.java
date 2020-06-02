package com.backend.backend.service;

import com.backend.backend.entities.ExceptionEntity;
import com.backend.backend.repository.ExceptionRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExceptionEntityService {

    private final ExceptionRepo exceptionRepo;

    public String healthCheck() {
        return "here";
    }

    public void createEntity(ExceptionEntity entity) {
        exceptionRepo.save(entity);
    }

    public Long count() {
        return exceptionRepo.count();
    }

    public void deleteEntityById(Long userId) {
        exceptionRepo.deleteById(userId);
    }



    public Iterable<ExceptionEntity> findAll() {
        Iterable<ExceptionEntity> retrievedEx = exceptionRepo.findAll();
        System.out.println(retrievedEx);
        return null;
    }

    public ExceptionEntity getExceptionById(String id) {
        Optional<ExceptionEntity> retrievedEx = exceptionRepo.findById(Long.valueOf(id));
        System.out.println(retrievedEx);
        return null;
    }

    public HttpStatus saveException(ExceptionEntity newEx) {
        ExceptionEntity savedEx = exceptionRepo.save(newEx);
        return HttpStatus.OK;
    }

}

