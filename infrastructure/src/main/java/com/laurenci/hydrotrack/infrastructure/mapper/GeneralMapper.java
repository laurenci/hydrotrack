package com.laurenci.hydrotrack.infrastructure.mapper;

public interface GeneralMapper<M, E> {
    E fromModelToEntity(M model);
    M fromEntityToModel(E entity);
}
