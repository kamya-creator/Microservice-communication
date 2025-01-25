package com.employeeapp.services.impl;

import com.employeeapp.entity.Employee;
import com.employeeapp.modelMapper.AddressResponse;
import com.employeeapp.modelMapper.EmployeeResponse;
import com.employeeapp.repository.EmpRepo;
import com.employeeapp.services.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
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


    RestTemplate restTemplate ;

    // read value from application.prop
   // @Value("${address.service.baseURL}")
    //private String BaseURL;

    public EmpServiceImpl(@Value("${address.service.baseURL}") String BaseURL, RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate =restTemplateBuilder
                                    .rootUri(BaseURL)
                                    .build();

    }

    @Override
    public EmployeeResponse getEmployeeByID(Integer id)
    {
        Optional<Employee> employee = repo.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        addressResponse=restTemplate.getForObject("/address/{id}",AddressResponse.class,id);

        employeeResponse.setAddressResponse(addressResponse);
        return  employeeResponse;
    }
}
