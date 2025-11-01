package com.javaweb.service;

import com.javaweb.model.request.BookingRequest;
import com.javaweb.model.response.RentalReceiptResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IRentalReceiptService {
    List<RentalReceiptResponse> createBooking(@RequestBody BookingRequest request);
}
