package com.employeeapp.services.impl;

import com.employeeapp.entity.Employee;
import com.employeeapp.feignClient.AddressFeignClient;
import com.employeeapp.modelMapper.AddressResponse;
import com.employeeapp.modelMapper.EmployeeResponse;
import com.employeeapp.repository.EmpRepo;
import com.employeeapp.services.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private  EmpRepo repo;
     AddressResponse addressResponse;

     @Autowired
    private ModelMapper modelMapper;
     @Autowired
    AddressFeignClient addressFeignClient;

    @Override
    public EmployeeResponse getEmployeeByID(Integer id)
    {
        Optional<Employee> employee = repo.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        // calling address-service through FeignClient
        addressResponse= addressFeignClient.getAddressByEmployeeId(id).getBody();

        employeeResponse.setAddressResponse(addressResponse);
        return  employeeResponse;
    }
}
