package com.fsg.it.drivercheckinsystem.Controllers;

import com.fsg.it.drivercheckinsystem.Beans.StatusResponse;
import com.fsg.it.drivercheckinsystem.Entities.BriefingDetails;
import com.fsg.it.drivercheckinsystem.Services.BriefingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/briefing")
public class BriefingController {

    @Autowired
    BriefingService briefingService;

    @RequestMapping(value = "/add", method= RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    StatusResponse addBriefing(@RequestBody BriefingDetails briefingDetails) {
        return briefingService.addBriefing(briefingDetails);
    }//API TESTED
}
