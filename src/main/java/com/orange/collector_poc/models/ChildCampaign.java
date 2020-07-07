package com.orange.collector_poc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "campaigns_ids")
public class ChildCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "campaign_id", nullable = false)
    private String campaignId;

    @Column(name = "bot_id")
    private String botId;

    @Column(name = "trigger_id" , nullable = false)
    private String triggerId;

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
