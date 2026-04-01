package com.example.notification.dtos.request;

import lombok.Data;

@Data
public class FranchiseRegisterEmailRequestDTO {

    private String franchiseEmail;
    private String franchiseName;
    private String country;
    private String city;

}
