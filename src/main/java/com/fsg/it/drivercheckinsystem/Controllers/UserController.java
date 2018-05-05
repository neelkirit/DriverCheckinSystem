package com.fsg.it.drivercheckinsystem.Controllers;

import com.fsg.it.drivercheckinsystem.Beans.StatusResponse;
import com.fsg.it.drivercheckinsystem.Entities.UserDetails;
import com.fsg.it.drivercheckinsystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/fetchAll", method= RequestMethod.GET)
    public ArrayList<UserDetails> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @RequestMapping(value = "/addUser", method= RequestMethod.POST, consumes = "application/json")
    private @ResponseBody
    StatusResponse addUser(@RequestBody UserDetails userDetails) {
        StatusResponse status  = userService.addUser(userDetails);
        return status;
    }

    @RequestMapping(value = "/findByBaseTeamId", method= RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ArrayList<UserDetails> findByBaseTeamId(@RequestBody UserDetails userDetails) {
        return userService.findByBaseTeamId(userDetails.getBaseTeamId());
    }

    @RequestMapping(value = "/findByEventTeamId", method= RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ArrayList<UserDetails> findByEventTeamId(@RequestBody UserDetails userDetails) {
        return userService.findByEventTeamId(userDetails.getEventTeamId());
    }

    @RequestMapping(value = "/findByCarNumber", method= RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ArrayList<UserDetails> findByCarNumber(@RequestBody UserDetails userDetails) {
        return userService.findByCarNumber(userDetails.getCarNumber());
    }

}
