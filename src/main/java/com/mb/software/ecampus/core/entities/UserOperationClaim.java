package com.mb.software.ecampus.core.entities;

import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import com.mb.software.ecampus.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_operation_claims")
public class UserOperationClaim extends DbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_operation_claim_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "operation_claim_id")
    private OperationClaim operationClaim;

}
