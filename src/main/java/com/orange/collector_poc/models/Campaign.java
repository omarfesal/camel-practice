package com.orange.collector_poc.models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "did_trigger", nullable = false)
    private Boolean didTrigger;

    @Column(name = "bot_id", nullable = false)
    private long botId;

    @Column(name = "is_activated")
    private Boolean isActivated;

    @Column(name = "date_from", nullable = false)
    private Date dateFrom;

    @Column(name = "date_to", nullable = false)
    private Date dateTo;

    @Column(name = "time_from", nullable = false)
    private Date timeFrom;

    @Column(name = "time_to", nullable = false)
    private Date timeTo;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

//    @OneToMany(targetEntity = Msisdn.class)
//    private List<Msisdn> msisdns;

    @PrePersist
    void preCreateCampaign() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

}