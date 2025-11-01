package com.javaweb.entity;
import javax.persistence.*;
@Entity
@Table(name = "pitch_rental_detail")
public class PitchRentalDetailEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    private String stDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "note")
    private String note;
    @Override
    public Long getId() { return id; }
    @Override
    public void setId(Long id) { this.id = id; }
    public String getStDate() {
        return stDate;
    }
    public void setStDate(String stDate) {
        this.stDate = stDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public PitchEntity getPitch() {
        return pitch;
    }
    public void setPitch(PitchEntity pitch) {
        this.pitch = pitch;
    }
    public RentalReceiptEntity getRentalReceipt() {
        return rentalReceipt;
    }
    public void setRentalReceipt(RentalReceiptEntity rentalReceipt) {
        this.rentalReceipt = rentalReceipt;
    }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pitch_id")
    private PitchEntity pitch;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_receipt_id")
    private RentalReceiptEntity rentalReceipt;

}
