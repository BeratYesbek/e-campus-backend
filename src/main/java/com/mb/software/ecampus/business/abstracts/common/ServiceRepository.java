package com.mb.software.ecampus.business.abstracts.common;

import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;

import java.util.List;

public interface ServiceRepository<T> {
    DataResult<T> add(T entity);
    DataResult<T> update(T entity);
    Result delete(int id);
    DataResult<T> getById(int id);
    DataResult<List<T>> getAll();
}
