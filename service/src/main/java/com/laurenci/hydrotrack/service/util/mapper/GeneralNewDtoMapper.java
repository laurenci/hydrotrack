package com.laurenci.hydrotrack.service.util.mapper;

public interface GeneralNewDtoMapper<N, D, M> extends GeneralMapper<D, M> {
    M fromNewDtoToModel(N newDto);
}
