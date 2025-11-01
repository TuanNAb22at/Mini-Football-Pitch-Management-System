package com.javaweb.repository.custom;

import com.javaweb.entity.RentalReceiptEntity;

public interface RentalReceiptRepositoryCustom {
    RentalReceiptEntity findRentalReceipt(String startDate, String endDate, Long customerId);
}
