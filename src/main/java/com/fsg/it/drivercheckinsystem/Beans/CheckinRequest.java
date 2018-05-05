package com.fsg.it.drivercheckinsystem.Beans;

import com.fsg.it.drivercheckinsystem.Entities.BriefingDetails;

public class CheckinRequest {


    private NFCTag nfcTag;

    private BriefingDetails briefingDetails;

    private String deviceId;

    private String volunteerName;

    public NFCTag getNfcTag() {
        return nfcTag;
    }

    public void setNfcTag(NFCTag nfcTag) {
        this.nfcTag = nfcTag;
    }

    public BriefingDetails getBriefingDetails() {
        return briefingDetails;
    }

    public void setBriefingDetails(BriefingDetails briefingDetails) {
        this.briefingDetails = briefingDetails;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }
}
