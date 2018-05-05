package com.fsg.it.drivercheckinsystem.Controllers;

import com.fsg.it.drivercheckinsystem.Beans.CheckinRequest;
import com.fsg.it.drivercheckinsystem.Beans.StatusResponse;
import com.fsg.it.drivercheckinsystem.Services.CheckinDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/checkin")
public class CheckinDriverController {

    @Autowired
    CheckinDriverService checkinDriverService;

    private final static Logger LOG = Logger.getLogger(CheckinDriverController.class.getName());

    @RequestMapping(value = "/driverBriefing", method= RequestMethod.POST, consumes = "application/json")
    private @ResponseBody
    StatusResponse checkinDriverBriefing(@RequestBody CheckinRequest checkinRequest) {
        LOG.info(">> Driver Checkin Controller <<");
        StatusResponse status  = checkinDriverService.checkinDriverBriefing(checkinRequest);
        return status;
    }

}
