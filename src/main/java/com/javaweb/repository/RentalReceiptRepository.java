package com.javaweb.repository;

import com.javaweb.entity.RentalReceiptEntity;
import com.javaweb.repository.custom.RentalReceiptRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalReceiptRepository extends JpaRepository<RentalReceiptEntity, Long> , RentalReceiptRepositoryCustom {
    RentalReceiptEntity findByStartDateAndEndDateAndTotalPriceContaining(String starDate, String endDate,Double totalPrice);
}
