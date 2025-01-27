package com.employeeapp.repository;

import com.employeeapp.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepo extends CrudRepository<Employee, Integer> {
}
