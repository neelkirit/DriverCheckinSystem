package com.fsg.it.drivercheckinsystem.Services;

import com.fsg.it.drivercheckinsystem.Beans.StatusResponse;
import com.fsg.it.drivercheckinsystem.Entities.UserDetails;
import com.fsg.it.drivercheckinsystem.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public ArrayList<UserDetails> fetchAllUsers(){
        ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
        int itr = 0;
        for (UserDetails user: usersRepository.findAll()
             ) {
            userList.add(itr++,user);
        }
        return userList;
    }

    public StatusResponse addUser(UserDetails userDetails) {
        usersRepository.save(userDetails);
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setMessage("Success");
        return statusResponse;
    }

    public ArrayList<UserDetails> findByBaseTeamId(String baseTeamId) {
        return usersRepository.findByBaseTeamId(baseTeamId);
    }

    public ArrayList<UserDetails> findByEventTeamId(String baseTeamId) {
        return usersRepository.findByEventTeamId(baseTeamId);
    }

    public ArrayList<UserDetails> findByCarNumber(String baseTeamId) {
        return usersRepository.findByCarNumber(baseTeamId);
    }

    public UserDetails findByUserid(String userId) {
        return usersRepository.findByUserId(userId);
    }
}
