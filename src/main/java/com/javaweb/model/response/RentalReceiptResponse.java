package com.javaweb.model.response;

import com.javaweb.model.dto.AbstractDTO;

import java.time.LocalDate;

public class RentalReceiptResponse extends AbstractDTO {
    private Long idKH,idPitch;
    private Double deposit;
    private Double totalPrice;
    private String tenKH;
    private String customerPhone;
    private String pitchName;
    private String pitchType;
    private Long totalDay;
    private LocalDate ngayBD;
    private LocalDate ngayKT;

    public Long getIdKH() {
        return idKH;
    }

    public void setIdKH(Long idKH) {
        this.idKH = idKH;
    }

    public Long getIdPitch() {
        return idPitch;
    }

    public void setIdPitch(Long idPitch) {
        this.idPitch = idPitch;
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

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getPitchName() {
        return pitchName;
    }

    public void setPitchName(String pitchName) {
        this.pitchName = pitchName;
    }

    public String getPitchType() {
        return pitchType;
    }

    public void setPitchType(String pitchType) {
        this.pitchType = pitchType;
    }

    public Long getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Long totalDay) {
        this.totalDay = totalDay;
    }

    public LocalDate getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(LocalDate ngayBD) {
        this.ngayBD = ngayBD;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.ngayKT = ngayKT;
    }
}
