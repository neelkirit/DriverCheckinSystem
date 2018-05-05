package com.fsg.it.drivercheckinsystem.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GenericGenerator(name="id", strategy="increment")
    @GeneratedValue(generator = "id")
    @Column(name = "id", insertable = true, unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "event_team_id")
    private String eventTeamId;

    @Column(name = "base_team_id")
    private String baseTeamId;

    @Column(name = "univesity_id")
    private String universityId;

    @CreationTimestamp
    @Column(name = "created_at", insertable = true, nullable = true, updatable = false )
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", insertable = true, nullable = true, updatable = true)
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getEventTeamId() {
        return eventTeamId;
    }

    public void setEventTeamId(String eventTeamId) {
        this.eventTeamId = eventTeamId;
    }

    public String getBaseTeamId() {
        return baseTeamId;
    }

    public void setBaseTeamId(String baseTeamId) {
        this.baseTeamId = baseTeamId;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
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
