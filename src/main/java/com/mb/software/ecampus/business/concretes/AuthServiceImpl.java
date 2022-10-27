package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.AuthService;
import com.mb.software.ecampus.business.abstracts.UserOperationClaimService;
import com.mb.software.ecampus.business.abstracts.UserService;
import com.mb.software.ecampus.core.entities.OperationClaim;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.entities.UserOperationClaim;
import com.mb.software.ecampus.core.security.encryption.PasswordHelper;
import com.mb.software.ecampus.core.security.jwt.JwtHelper;
import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.ErrorDataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.dtos.UserLoginDto;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final UserOperationClaimService userOperationClaimService;
    private final JwtHelper jwtHelper;


    public AuthServiceImpl(UserService userService, UserOperationClaimService userOperationClaimService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.userOperationClaimService = userOperationClaimService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public DataResult<Token> login(UserLoginDto userLoginDto) {
        DataResult<User> existingUserResult = userService.getByEmail(userLoginDto.getEmail());
        if (existingUserResult.isSuccess()) {
            boolean result = PasswordHelper.verifyPassword(userLoginDto.getPassword(), existingUserResult.getData().getPassword());
            if (result) {
                Token token = jwtHelper.createToken(existingUserResult.getData(), "");
                return new SuccessDataResult<>(token, "User has been logged in successfully");
            } else {
                return new ErrorDataResult<>(null, "Wrong Credentials");
            }
        }
        return new ErrorDataResult<>(null, "User not found");

    }

    @Override
    public DataResult<Token> register(User user) {
        DataResult<User> checkUser = userService.getByEmail(user.getEmail());
        if (checkUser.isSuccess()) {
            return new ErrorDataResult<>(null, "User exists");
        }
        user.setPassword(PasswordHelper.hashPassword(user.getPassword()));
        DataResult<User> createdUserResult = userService.add(user);
        Token token = jwtHelper.createToken(createdUserResult.getData(), "");
        token.setUser(createdUserResult.getData());
        return new SuccessDataResult<>(token);
        //userOperationClaimService.add(new UserOperationClaim());


    }
}
