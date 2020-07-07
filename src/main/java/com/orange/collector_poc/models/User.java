package com.orange.collector_poc.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

//    @Column(name = "trustedPartnerID", nullable = false)
//    private long trustedPartnerID;

//    @OneToMany(targetEntity = Bot.class)
//    private List<Bot> bots;
//
//    @OneToMany(targetEntity = Campaign.class)
//    private List<Campaign> campaigns;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;


    @PrePersist
    void preCreateCampaign() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}
