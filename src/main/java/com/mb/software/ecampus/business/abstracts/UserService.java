package com.mb.software.ecampus.business.abstracts;

import com.mb.software.ecampus.business.abstracts.common.ServiceRepository;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;

public interface UserService extends ServiceRepository<User> {

    DataResult<User> getByEmail(String email);
}
