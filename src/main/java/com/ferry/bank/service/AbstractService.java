package com.ferry.bank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<T, D, ID> {

    protected final JpaRepository<T, ID> repository;

    private final Class<D> dtoClass;
    private final Class<T> entityClass;

    protected AbstractService(JpaRepository<T, ID> repository, Class<D> dtoClass, Class<T> entityClass) {
        this.repository = repository;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    protected abstract D toDTO(T entity);

    protected abstract T toEntity(D dto);

    @Transactional(readOnly = true)
    public Page<D> findAll(Pageable page) {
        return repository.findAll(page)
                .map(this::toDTO);
    }

    @Transactional(readOnly = true)
    public D findById(ID id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public D save(D dto) {
        T entity = toEntity(dto);
        T savedEntity = repository.save(entity);
        return toDTO(savedEntity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
