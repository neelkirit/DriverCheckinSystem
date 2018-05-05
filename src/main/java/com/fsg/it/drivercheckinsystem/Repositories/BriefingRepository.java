package com.fsg.it.drivercheckinsystem.Repositories;

import com.fsg.it.drivercheckinsystem.Entities.BriefingDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BriefingRepository extends CrudRepository<BriefingDetails, String> {

    @Transactional
    BriefingDetails findById(@Param("id") Integer id);
}
