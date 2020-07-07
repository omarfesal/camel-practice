package com.orange.collector_poc.models;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bots")
public class Bot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bot_id", nullable = false)
    private String botId;

    @Column(nullable = false)
    private String type;

    @OneToMany(targetEntity = Campaign.class)
    private List<Campaign> campaigns;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;


    @PrePersist
    void preCreateBot() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}
