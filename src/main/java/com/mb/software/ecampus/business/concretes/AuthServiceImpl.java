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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
                DataResult<List<UserOperationClaim>> roleResult = userOperationClaimService.getByUserId(existingUserResult.getData().getId());
                List<String> roles = roleResult.getData().stream().map(t -> t.getOperationClaim().getName()).toList();
                Token token = jwtHelper.createToken(existingUserResult.getData(),  roles.stream().toArray(String[]::new),"" );
                return new SuccessDataResult<>(token, "User has been logged in successfully");
            } else {
                return new ErrorDataResult<>(null, "Wrong Credentials");
            }
        }
        return new ErrorDataResult<>(null, "User not found");

    }

    @Override
    public DataResult<Token> register(User user) throws Exception {
        DataResult<User> checkUser = userService.getByEmail(user.getEmail());
        if (checkUser.isSuccess()) {
            return new ErrorDataResult<>(null, "User exists");
        }
        user.setPassword(PasswordHelper.hashPassword(user.getPassword()));
        DataResult<User> createdUserResult = userService.add(user);
        DataResult<UserOperationClaim> operationClaimDataResult = userOperationClaimService.add(new UserOperationClaim(0, createdUserResult.getData(), new OperationClaim(1, "")));
        String[] roles = new String[]{operationClaimDataResult.getData().getOperationClaim().getName()};
        Token token = jwtHelper.createToken(createdUserResult.getData(), roles, "");
        token.setUser(createdUserResult.getData());
        return new SuccessDataResult<>(token);


    }
}
