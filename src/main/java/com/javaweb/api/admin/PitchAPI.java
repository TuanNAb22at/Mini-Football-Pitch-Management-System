package com.javaweb.api.admin;
import com.javaweb.model.dto.PitchDTO;
import com.javaweb.model.request.BookingRequest;
import com.javaweb.model.request.PitchRentalReceiptRequest;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.model.response.RentalReceiptResponse;
import com.javaweb.service.CustomerService;
import com.javaweb.service.IPitchService;
import com.javaweb.service.IRentalReceiptService;
import com.javaweb.service.impl.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "pitchAPIOfAdmin")
public class PitchAPI {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private IRentalReceiptService rentalReceiptService;

    @Autowired
    private IPitchService pitchService;

    @GetMapping("/admin/pitch/searchCustomer")
    @ResponseBody
    public List<CustomerResponse> searchCustomer(@RequestParam("name") String name) {
        return customerService.findCustomerByName(name);
    }

    @PostMapping("/admin/pitch/createBooking")
    @ResponseBody
    public List<RentalReceiptResponse> createBooking(@RequestBody BookingRequest request) {
        return rentalReceiptService.createBooking(request);
    }

    @PostMapping("/admin/pitch/confirmbooking")
    public List<PitchRentalReceiptRequest> saveBooKing(@RequestBody PitchRentalReceiptRequest request) {
        return rentalReceiptService.saveBooKing(request);
    }

    @DeleteMapping("/admin/pitch/delete/{id}")
    @ResponseBody
    public void deletePitch(@PathVariable Long id) {
        pitchService.deletePitch(id);
    }



}
