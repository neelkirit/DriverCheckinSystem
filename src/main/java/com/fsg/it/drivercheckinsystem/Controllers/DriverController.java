package com.fsg.it.drivercheckinsystem.Controllers;

import com.fsg.it.drivercheckinsystem.Entities.DriverDetails;
import com.fsg.it.drivercheckinsystem.Entities.UserDetails;
import com.fsg.it.drivercheckinsystem.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    /**
     *
     * @return List of Drivers
     *
     * Call this function to get list of all drivers
     *
     */
    @RequestMapping(value = "/fetchAll", method= RequestMethod.GET)
    public ArrayList<DriverDetails> fetchAll(){
        return driverService.fetchAll();
    }//API TESTED

    /**
     *
     * @param driverDetails
     * @return driverDetails with NFCTag
     *
     * Call this function to add a new driver or to rewrite existing NFC Tag
     *
     */
    @RequestMapping(value = "/add", method= RequestMethod.POST, consumes = "application/json")
    private @ResponseBody
    DriverDetails addDriver(@RequestBody DriverDetails driverDetails) {
        return driverService.addDriver(driverDetails);
    }//API TESTED

    /**
     *
     * @param userDetails
     * @return List of Drivers from a university
     *
     * Call this function to fetch List of all drivers from a specific University
     *
     */
    @RequestMapping(value = "/findByUniversity", method= RequestMethod.POST, consumes = "application/json")
    private @ResponseBody
    ArrayList<DriverDetails> findByUniversity(@RequestBody UserDetails userDetails) {
        return driverService.findByUniversity(userDetails.getUniversityName());
    }//API TESTED


}
