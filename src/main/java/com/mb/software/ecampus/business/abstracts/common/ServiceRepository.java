package com.mb.software.ecampus.business.abstracts.common;

import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;

import java.util.List;

/**
 * contains common methods for services. If each service has CRUD operation. This interface can implement by concretes
 * @author Berat Yesbek (Feanor)
 */
public interface ServiceRepository<T> {
    DataResult<T> add(T entity) throws Exception;

    DataResult<T> update(T entity);

    Result delete(int id) throws Exception;

    DataResult<T> getById(int id);

    DataResult<List<T>> getAll();
}
