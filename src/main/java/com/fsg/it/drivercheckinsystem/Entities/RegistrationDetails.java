package com.fsg.it.drivercheckinsystem.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registration_details")
public class RegistrationDetails {

    @Id
    @GenericGenerator(name="id", strategy="increment")
    @GeneratedValue(generator = "id")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private DriverDetails driverDetails;

    @Column(name = "registration_time")
    private String registrarionTime;

    @Column(name = "registration_date")
    private String registrarionDate;

    @Column(name = "registration_counter")
    private String registrarionCounter;

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

    public DriverDetails getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(DriverDetails driverDetails) {
        this.driverDetails = driverDetails;
    }

    public String getRegistrarionTime() {
        return registrarionTime;
    }

    public void setRegistrarionTime(String registrarionTime) {
        this.registrarionTime = registrarionTime;
    }

    public String getRegistrarionDate() {
        return registrarionDate;
    }

    public void setRegistrarionDate(String registrarionDate) {
        this.registrarionDate = registrarionDate;
    }

    public String getRegistrarionCounter() {
        return registrarionCounter;
    }

    public void setRegistrarionCounter(String registrarionCounter) {
        this.registrarionCounter = registrarionCounter;
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
