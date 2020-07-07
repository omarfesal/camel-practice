package com.orange.collector_poc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "msisdns")
public class Msisdn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "status", nullable = false)
    private Enum status;

    @Column(nullable = false)
    private String type;

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
