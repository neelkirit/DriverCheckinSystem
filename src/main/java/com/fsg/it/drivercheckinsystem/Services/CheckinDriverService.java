package com.fsg.it.drivercheckinsystem.Services;

import com.fsg.it.drivercheckinsystem.Beans.CheckinRequest;
import com.fsg.it.drivercheckinsystem.Beans.StatusResponse;
import com.fsg.it.drivercheckinsystem.Entities.BriefingDetails;
import com.fsg.it.drivercheckinsystem.Entities.CheckinDetails;
import com.fsg.it.drivercheckinsystem.Entities.DriverDetails;
import com.fsg.it.drivercheckinsystem.Repositories.BriefingRepository;
import com.fsg.it.drivercheckinsystem.Repositories.CheckinRepository;
import com.fsg.it.drivercheckinsystem.Repositories.DriversRepository;
import com.fsg.it.drivercheckinsystem.Repositories.UsersRepository;
import com.fsg.it.drivercheckinsystem.Utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CheckinDriverService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DriversRepository driversRepository;

    @Autowired
    CheckinRepository checkinRepository;

    @Autowired
    DateUtil dateUtil;

    @Autowired
    BriefingRepository briefingRepository;

    private final static Logger LOG = Logger.getLogger(CheckinDriverService.class.getName());

    public StatusResponse checkinDriverBriefing(CheckinRequest checkinRequest) {
        LOG.info(">> Driver Checkin Service. TAG: "+checkinRequest.getNfcTag().getTagID());
        String msg = "Success";
        String tagId = checkinRequest.getNfcTag().getTagID();
        // Find driver id by tag ID
        DriverDetails driverDetails = driversRepository.findByTagId(tagId);
        CheckinDetails checkinDetails = new CheckinDetails();

        try {
            checkinDetails.setDriverDetails(driverDetails);
            String dateTime[] = dateUtil.getCurrentDateTime().split(" ");
            checkinDetails.setCheckinDate(dateTime[0]);
            checkinDetails.setCheckinTime(dateTime[1]);
        } catch(Exception e) {
            msg = "Exception in Setting Date Time Details to Check-in: "+e.getMessage();
            LOG.severe(msg+" "+e.getMessage());
        }


        try{
            int briefingId = checkinRequest.getBriefingDetails().getId();
            BriefingDetails briefingDetails = briefingRepository.findById(briefingId);
            checkinDetails.setBriefingDetails(briefingDetails);
        }catch (Exception e) {
            msg = "Exception in Setting Brieing Details to Check-in: "+e.getMessage();
            LOG.severe(msg+" "+e.getMessage());

        }

        checkinDetails.setVolunteerName(checkinRequest.getVolunteerName());
        checkinDetails.setDeviceId(checkinRequest.getDeviceId());

        // Checkin driver
        checkinRepository.save(checkinDetails);

        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setMessage(msg);
        LOG.info("<< Driver Checkin Service. ");
        return statusResponse;
    }
}
