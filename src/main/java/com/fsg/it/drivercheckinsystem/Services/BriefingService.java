package com.fsg.it.drivercheckinsystem.Services;

import com.fsg.it.drivercheckinsystem.Beans.StatusResponse;
import com.fsg.it.drivercheckinsystem.Entities.BriefingDetails;
import com.fsg.it.drivercheckinsystem.Repositories.BriefingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BriefingService {

    @Autowired
    BriefingRepository briefingRepository;

    public StatusResponse addBriefing(BriefingDetails briefingDetails) {
        briefingRepository.save(briefingDetails);
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setMessage("Success");
        return statusResponse;
    }
}
