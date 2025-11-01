package com.javaweb.repository.custom.impl;
import com.javaweb.entity.RentalReceiptEntity;
import com.javaweb.repository.custom.RentalReceiptRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RentalReceiptRepositoryImpl implements RentalReceiptRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    public RentalReceiptEntity findRentalReceipt(String startDate, String endDate, Long customerId){
        String jpql = "SELECT r FROM RentalReceiptEntity r WHERE r.startDate = :startDate AND r.endDate = :endDate AND r.customer.id = :customerId";
        List<RentalReceiptEntity> results = entityManager.createQuery(jpql, RentalReceiptEntity.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("customerId", customerId)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}
