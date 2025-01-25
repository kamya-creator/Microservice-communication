package com.addressapp.service;

import com.addressapp.entity.Address;
import com.addressapp.modelwrapperresponse.AddressResponse;
import com.addressapp.repositry.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AddressResponse addressResponse;
    private final ModelMapper modelMapper = new ModelMapper();

   // Address address = ;

   public AddressResponse getAddressByEmpID(Integer empId)
    {
        Optional<Address> address = Optional.ofNullable(addressRepository.findAddressByEmployeeId(empId));

        addressResponse = modelMapper.map(address, AddressResponse.class);
        return addressResponse;
    }


}
