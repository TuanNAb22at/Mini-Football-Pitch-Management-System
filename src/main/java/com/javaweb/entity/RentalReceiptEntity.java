package com.javaweb.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "rental_receipt")
public class RentalReceiptEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_rental_price")
    private Double sessionRentalPrice;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "deposit")
    private Double deposit;

    @Column(name = "total_price")
    private Double totalPrice;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getSessionRentalPrice() {
        return sessionRentalPrice;
    }

    public void setSessionRentalPrice(Double sessionRentalPrice) {
        this.sessionRentalPrice = sessionRentalPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_invoice_id")
    private PaymentInvoiceEntity paymentInvoice;
    @OneToMany(mappedBy = "rentalReceipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsedItemEntity> usedItems = new ArrayList<>();

    @OneToMany(mappedBy = "rentalReceipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PitchRentalDetailEntity> pitchRentalDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    public PaymentInvoiceEntity getPaymentInvoice() {
        return paymentInvoice;
    }

    public void setPaymentInvoice(PaymentInvoiceEntity paymentInvoice) {
        this.paymentInvoice = paymentInvoice;
    }

    public List<UsedItemEntity> getUsedItems() {
        return usedItems;
    }

    public void setUsedItems(List<UsedItemEntity> usedItems) {
        this.usedItems = usedItems;
    }

    public List<PitchRentalDetailEntity> getPitchRentalDetails() {
        return pitchRentalDetails;
    }

    public void setPitchRentalDetails(List<PitchRentalDetailEntity> pitchRentalDetails) {
        this.pitchRentalDetails = pitchRentalDetails;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}