package com.fsg.it.drivercheckinsystem.Repositories;

import com.fsg.it.drivercheckinsystem.Entities.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface UsersRepository extends CrudRepository<UserDetails, String> {

    @Transactional
    public UserDetails findById(@Param("id") Integer id);

    @Transactional
    public UserDetails findByUserId(@Param("userId") String userId);

    @Transactional
    @Query(value = "SELECT u FROM UserDetails u WHERE u.baseTeamId = :baseTeamId")
    public ArrayList<UserDetails> findByBaseTeamId(@Param("baseTeamId") String baseTeamId);

    @Transactional
    @Query(value = "SELECT u FROM UserDetails u WHERE u.eventTeamId = :eventTeamId")
    public ArrayList<UserDetails> findByEventTeamId(@Param("eventTeamId") String eventTeamId);

    @Transactional
    @Query(value = "SELECT u FROM UserDetails u WHERE u.carNumber = :carNumber")
    public ArrayList<UserDetails> findByCarNumber(@Param("carNumber") String carNumber);
}
