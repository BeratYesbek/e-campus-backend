package com.mb.software.ecampus.api.controllers;


import com.mb.software.ecampus.business.abstracts.UserService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.entities.dto.UserReadDto;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.ErrorDataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import org.apache.tomcat.util.digester.ArrayStack;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<UserReadDto>>> getAll() {
        DataResult<List<User>> result = userService.getAll();
        if (result.isSuccess()) {
            List<UserReadDto> userReadDtoList = List.of(modelMapper.map(result.getData(), UserReadDto[].class));
            return ResponseEntity.ok(new SuccessDataResult<>(userReadDtoList, result.getMessage()));
        }
        return new ResponseEntity<>(new ErrorDataResult<>(null, result.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
