package com.employeeapp.modelMapper;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AddressResponse {

    private int id;

    private String lane1;
    private String lane2;

    private String zip;

}
