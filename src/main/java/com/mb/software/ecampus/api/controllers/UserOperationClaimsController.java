package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.UserOperationClaimService;
import com.mb.software.ecampus.core.entities.UserOperationClaim;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("api/user_operation_claims")
public class UserOperationClaimsController {

    public final UserOperationClaimService userOperationClaimService;

    public UserOperationClaimsController(UserOperationClaimService userOperationClaimService) {
        this.userOperationClaimService = userOperationClaimService;
    }

    @PostMapping
    public ResponseEntity<DataResult<UserOperationClaim>> add(@RequestBody UserOperationClaim userOperationClaim) throws Exception {
        DataResult result = userOperationClaimService.add(userOperationClaim);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<DataResult<List<UserOperationClaim>>> getByUserId(@PathVariable int userId) {
        DataResult result = userOperationClaimService.getByUserId(userId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }


}
