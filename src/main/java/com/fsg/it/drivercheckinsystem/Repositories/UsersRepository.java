package com.fsg.it.drivercheckinsystem.Repositories;

import com.fsg.it.drivercheckinsystem.Entities.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface UsersRepository extends CrudRepository<UserDetails, String> {

    @Transactional
    UserDetails findById(@Param("id") Integer id);

    @Transactional
    UserDetails findByUserId(@Param("userId") String userId);

    @Transactional
    @Query(value = "SELECT u FROM UserDetails u WHERE u.baseTeamId = :baseTeamId")
    ArrayList<UserDetails> findByBaseTeamId(@Param("baseTeamId") String baseTeamId);

    @Transactional
    @Query(value = "SELECT u FROM UserDetails u WHERE u.eventTeamId = :eventTeamId")
    ArrayList<UserDetails> findByEventTeamId(@Param("eventTeamId") String eventTeamId);

    @Transactional
    @Query(value = "SELECT u FROM UserDetails u WHERE u.carNumber = :carNumber")
    ArrayList<UserDetails> findByCarNumber(@Param("carNumber") String carNumber);
}
