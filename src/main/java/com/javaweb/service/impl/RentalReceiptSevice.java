package com.javaweb.service.impl;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.converter.pitchConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.PitchEntity;
import com.javaweb.entity.PitchRentalDetailEntity;
import com.javaweb.entity.RentalReceiptEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.PitchDTO;
import com.javaweb.model.request.BookingRequest;
import com.javaweb.model.response.RentalReceiptResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.PitchRentalDetailRepository;
import com.javaweb.repository.PitchRepository;
import com.javaweb.repository.RentalReceiptRepository;
import com.javaweb.service.IRentalReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RentalReceiptSevice implements IRentalReceiptService {
    @Autowired
    private PitchRepository pitchRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private pitchConverter pitchDTOConverter;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private RentalReceiptRepository rentalReceiptRepository;
    @Autowired
    private PitchRentalDetailRepository pitchRentalDetailRepository;
    @Override
    public List<RentalReceiptResponse> createBooking(BookingRequest request) {

        Long pitchId = request.getPitchId();
        Long customerId = request.getCustomerId();
        LocalDate startDate = LocalDate.parse(request.getStartDate());
        LocalDate endDate = LocalDate.parse(request.getEndDate());

        // find pitch and customer by id
        PitchEntity pitchEntity = pitchRepository.findById(pitchId).orElse(null);
        PitchDTO pitchDTO = pitchDTOConverter.toPitchDTO(pitchEntity);
        CustomerEntity customerEntity =  customerRepository.findById(customerId).orElse(null);
        CustomerDTO  customerDTO = customerConverter.toCustomerDTO(customerEntity);

        // tinh ngay va tong gia tien
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        Double totalPrice = daysBetween * pitchDTO.getPrice();

        //save rentalReceiptEntity
        RentalReceiptEntity rentalReceiptEntity = new RentalReceiptEntity();
        rentalReceiptEntity.setCustomer(customerEntity);
        rentalReceiptEntity.setStartDate(request.getStartDate());
        rentalReceiptEntity.setEndDate(request.getEndDate());
        rentalReceiptEntity.setTotalPrice(totalPrice);
        rentalReceiptEntity.setDeposit(totalPrice*0.1);
        rentalReceiptRepository.save(rentalReceiptEntity);

        //get rentalReciept and save pitchRentalDetailRepository
        RentalReceiptEntity rentalReceiptEntity1 = rentalReceiptRepository.findRentalReceipt(request.getStartDate(),request.getEndDate(),customerId);
        PitchRentalDetailEntity pitchRentalDetailEntity = new PitchRentalDetailEntity();
        pitchRentalDetailEntity.setRentalReceipt(rentalReceiptEntity1);
        pitchRentalDetailEntity.setPitch(pitchEntity);
        pitchRentalDetailEntity.setStDate(request.getStartDate());
        pitchRentalDetailEntity.setEndDate(request.getEndDate());
        pitchRentalDetailRepository.save(pitchRentalDetailEntity);

        //getCreate booking
        RentalReceiptResponse rentalReceiptResponse  = new RentalReceiptResponse();
        rentalReceiptResponse.setCustomerName(customerDTO.getFullname());
        rentalReceiptResponse.setTotalPrice(totalPrice);
        rentalReceiptResponse.setDeposit(totalPrice*0.1);
        rentalReceiptResponse.setPitchName(pitchDTO.getPitchName());
        rentalReceiptResponse.setPitchType(pitchDTO.getDescription());
        rentalReceiptResponse.setTotalDay(daysBetween);
        rentalReceiptResponse.setCustomerPhone(customerDTO.getPhone());
        List<RentalReceiptResponse> RentalReceiptResponses = new ArrayList<>();
        RentalReceiptResponses.add(rentalReceiptResponse);
        return RentalReceiptResponses;
    }
}
