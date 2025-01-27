package com.employeeapp.services;

import com.employeeapp.entity.Employee;
import com.employeeapp.modelMapper.EmployeeResponse;

import java.util.Optional;

public interface EmpService {
    public EmployeeResponse getEmployeeByID(Integer id);
}
