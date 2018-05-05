package com.fsg.it.drivercheckinsystem.Services;

import com.fsg.it.drivercheckinsystem.Beans.NFCTag;
import com.fsg.it.drivercheckinsystem.Entities.DriverDetails;
import com.fsg.it.drivercheckinsystem.Entities.UserDetails;
import com.fsg.it.drivercheckinsystem.Repositories.DriversRepository;
import com.fsg.it.drivercheckinsystem.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class DriverService {

    @Autowired
    DriversRepository driversRepository;

    @Autowired
    UserService userService;

    @Autowired
    UsersRepository usersRepository;

    private final static Logger LOG = Logger.getLogger(DriverService.class.getName());

    public ArrayList<DriverDetails> fetchAll() {
        ArrayList<DriverDetails> driverList = new ArrayList<DriverDetails>();
        int itr = 0;
        for( DriverDetails driver: driversRepository.findAll()) {
            driverList.add(itr++,driver);
        }
        return driverList;
    }

    public DriverDetails addDriver(DriverDetails driverDetails) {
        String userId = driverDetails.getUserDetails().getUserId();
        userService.findByUserid(userId);
        UserDetails userDetails = usersRepository.findByUserId(userId);

        String carNumber = driverDetails.getUserDetails().getCarNumber();
        String university = driverDetails.getUserDetails().getUniversityName();
        NFCTag nfcTag = new NFCTag();

        nfcTag.setTagID(userId+carNumber+university);
        driverDetails.setTagId(nfcTag.getTagID());
        driverDetails.setUserDetails(userDetails);

        driversRepository.save(driverDetails);
        return driverDetails;
    }

    public ArrayList<DriverDetails> findByUniversity(String universityName) {
        LOG.info(">> Find Driver By University : "+universityName);
        ArrayList<DriverDetails> driverList = new ArrayList<DriverDetails>();
        int itr = 0;
        for( DriverDetails driver: driversRepository.findByUniversity(universityName)) {
            driverList.add(itr++,driver);
            LOG.info("Driver found "+driver.getUserDetails().getFullName());
        }
        LOG.info("<< Find Driver By University, Total: "+itr);
        return driverList;
    }
}
