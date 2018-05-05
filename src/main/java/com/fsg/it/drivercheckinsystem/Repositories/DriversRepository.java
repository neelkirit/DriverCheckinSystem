package com.fsg.it.drivercheckinsystem.Repositories;

import com.fsg.it.drivercheckinsystem.Entities.DriverDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface DriversRepository extends CrudRepository<DriverDetails, String> {

    @Transactional
    DriverDetails findById(@Param("id") Integer id);

    @Transactional
    DriverDetails findByTagId(@Param("tagId") String tagId);

    @Transactional
    @Query(value = "SELECT d FROM DriverDetails d WHERE d.userDetails.universityName LIKE :universityName")
    ArrayList<DriverDetails> findByUniversity(@Param("universityName") String universityName);
}
