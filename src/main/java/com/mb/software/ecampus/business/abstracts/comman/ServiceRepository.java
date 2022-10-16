package com.mb.software.ecampus.business.abstracts.comman;

import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.data.DataResult;

import java.util.List;

public interface ServiceRepository<T> {
    DataResult<T> add(T entity);
    DataResult<T> update(T entity);
    Result delete(int id);
    DataResult<T> getById(int id);
    DataResult<List<T>> getAll();
}
