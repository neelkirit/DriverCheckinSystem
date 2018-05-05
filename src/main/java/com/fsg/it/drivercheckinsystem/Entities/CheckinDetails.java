package com.fsg.it.drivercheckinsystem.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "checkin_details")
public class CheckinDetails {

    @Id
    @GenericGenerator(name="id", strategy="increment")
    @GeneratedValue(generator = "id")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "checkin_time")
    private String checkinTime;

    @Column(name = "checkin_date")
    private String checkinDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private DriverDetails driverDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "briefing_id")
    private BriefingDetails briefingDetails;

    @Column(name = "volunteer_name")
    private String volunteerName;

    @Column(name = "device_id")
    private String deviceId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public DriverDetails getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(DriverDetails driverDetails) {
        this.driverDetails = driverDetails;
    }

    public BriefingDetails getBriefingDetails() {
        return briefingDetails;
    }

    public void setBriefingDetails(BriefingDetails briefingDetails) {
        this.briefingDetails = briefingDetails;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
