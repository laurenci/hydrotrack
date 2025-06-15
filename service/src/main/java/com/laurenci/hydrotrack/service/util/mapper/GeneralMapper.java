package com.laurenci.hydrotrack.service.util.mapper;

public interface GeneralMapper<D, M> {
    M fromDtoToModel(D dto);
    D fromModelToDto(M model);
}
