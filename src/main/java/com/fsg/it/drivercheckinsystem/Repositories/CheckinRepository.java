package com.fsg.it.drivercheckinsystem.Repositories;

import com.fsg.it.drivercheckinsystem.Entities.CheckinDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CheckinRepository extends CrudRepository<CheckinDetails, String> {

    @Transactional
    public CheckinDetails findById(@Param("id") Integer id);

}
