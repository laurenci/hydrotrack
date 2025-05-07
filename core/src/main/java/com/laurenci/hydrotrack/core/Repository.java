package com.laurenci.hydrotrack.core;

public interface Repository<T, ID> {
    T create(T t);
    T readById(ID id);
    T update(T t);
    T deleteById(ID id);
}
