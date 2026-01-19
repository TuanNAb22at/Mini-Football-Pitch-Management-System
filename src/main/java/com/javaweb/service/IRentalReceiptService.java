package com.javaweb.service;

import com.javaweb.model.request.BookingRequest;
import com.javaweb.model.request.PitchRentalReceiptRequest;
import com.javaweb.model.response.RentalReceiptResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IRentalReceiptService {
    List<RentalReceiptResponse> createBooking(@RequestBody BookingRequest request);
    public List<PitchRentalReceiptRequest> saveBooKing(@RequestBody PitchRentalReceiptRequest request);
}
