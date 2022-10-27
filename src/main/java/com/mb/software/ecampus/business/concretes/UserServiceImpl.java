package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.UserService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.ErrorDataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.UserDao;
import com.mb.software.ecampus.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> add(User entity) {
        return new SuccessDataResult<>(userDao.save(entity));
    }

    @Override
    public DataResult<User> update(User entity) {
        return new SuccessDataResult<>(userDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        userDao.deleteById(id);
        return new SuccessResult("User has been deleted");
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<>(userDao.findById(id).get());
    }


    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userDao.findAll());
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            return new SuccessDataResult<>(user);
        }
        return new ErrorDataResult<>(null,"User not found!!!");
    }
}
