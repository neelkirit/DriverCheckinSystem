package com.fsg.it.drivercheckinsystem.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "briefing_details")
public class BriefingDetails {

    @Id
    @GenericGenerator(name="id", strategy="increment")
    @GeneratedValue(generator = "id")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "briefing_time")
    private String briefingTime;

    @Column(name = "briefing_date")
    private String briefingDate;

    @Column(name = "location")
    private String Location;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "duration")
    private Integer duration;

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

    public String getBriefingTime() {
        return briefingTime;
    }

    public void setBriefingTime(String briefingTime) {
        this.briefingTime = briefingTime;
    }

    public String getBriefingDate() {
        return briefingDate;
    }

    public void setBriefingDate(String briefingDate) {
        this.briefingDate = briefingDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
