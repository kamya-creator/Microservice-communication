package com.employeeapp.controller;

import com.employeeapp.entity.Employee;
import com.employeeapp.modelMapper.EmployeeResponse;
import com.employeeapp.services.impl.EmpServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmpServiceImpl empServiceImpl;
    private final EmployeeResponse employeeResponse;


    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmpDetails(@PathVariable("id") Integer id)
    {
        EmployeeResponse employee = empServiceImpl.getEmployeeByID(id);
        return ResponseEntity.status(HttpStatus.OK).header("KrishnaRadhe", "Radhe").body(employee);
    }
}
