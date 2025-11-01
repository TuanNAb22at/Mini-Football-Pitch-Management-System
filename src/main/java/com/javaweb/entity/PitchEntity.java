package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "pitch")
public class PitchEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pitch_name")
    private String pitchName;
    @Column(name = "price")
    private Double price;
    @Column(name = "pitch_type")
    private String type;
    @Column(name = "description")
    private String description;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPitchName() {
        return pitchName;
    }

    public void setPitchName(String pitchName) {
        this.pitchName = pitchName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "big_pitch_id")
    private BigPitchEntity bigPitch;

}
