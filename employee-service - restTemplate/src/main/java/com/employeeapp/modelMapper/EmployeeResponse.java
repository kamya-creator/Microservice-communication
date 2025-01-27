package com.employeeapp.modelMapper;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeeResponse {

    int id;
    String name;
    String email;
    String bloodgroup;
    AddressResponse addressResponse;


}
