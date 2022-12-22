package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.UserService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.entities.dto.UserReadDto;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {
    @Mock
    private UserService service;

    @InjectMocks
    private UsersController usersController;

    @Test
    public void testGetAllMethodIsWorkingProperly(){
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<UserReadDto>>> response = usersController.getAll();
        assertEquals(response.getBody().getData(),prepareDataList().getData());

    }

    private DataResult<List<User>> prepareDataList() {
        List<User> users = new ArrayList<>();
        users.add(1,new User());
        return new SuccessDataResult<>(users);
    }
}
