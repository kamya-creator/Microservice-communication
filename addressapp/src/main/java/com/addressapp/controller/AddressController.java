package com.addressapp.controller;

import com.addressapp.modelwrapperresponse.AddressResponse;
import com.addressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id)
    {
        AddressResponse addressByEmpID = addressService.getAddressByEmpID(id);
        return ResponseEntity.ok().body(addressByEmpID);
    }
}
