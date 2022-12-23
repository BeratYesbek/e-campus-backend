package com.mb.software.ecampus.controllers;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.api.controllers.UserOperationClaimsController;
import com.mb.software.ecampus.business.abstracts.UserOperationClaimService;
import com.mb.software.ecampus.core.entities.OperationClaim;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.entities.UserOperationClaim;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ExtendWith(SpringExtension.class)
public class UserOperationClaimsControllerTest {
    @Mock
    private UserOperationClaimService service;

    @InjectMocks
    private UserOperationClaimsController userOperationClaimsController;

    @Test
    public void testGetByIdIsWorkingProperly(){
        when(service.getByUserId(userOperationClaimId)).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<UserOperationClaim>>> response = userOperationClaimsController.getByUserId(userOperationClaimId);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareDataList().getData());
    }

    private DataResult<List<UserOperationClaim>> prepareDataList() {
        List<UserOperationClaim> operationClaims = new ArrayList<>();
        operationClaims.add(1,new UserOperationClaim());
        return new SuccessDataResult<>(operationClaims);
    }

    private static final int userOperationClaimId = 0;
}
