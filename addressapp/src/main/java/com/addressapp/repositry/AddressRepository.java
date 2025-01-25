package com.addressapp.repositry;

import com.addressapp.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface AddressRepository extends CrudRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "select a.id, a.lane1, a.lane2, a.zip from address a Join employee e on a.empid =:empId;")
    Address findAddressByEmployeeId(@Param("empId") Integer empId);
}
