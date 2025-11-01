package com.javaweb.api.admin;
import com.javaweb.model.request.BookingRequest;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.model.response.RentalReceiptResponse;
import com.javaweb.service.CustomerService;
import com.javaweb.service.IRentalReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "pitchAPIOfAdmin")
public class PitchAPI {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private IRentalReceiptService rentalReceiptService;

    @GetMapping("/tim-khach-hang")
    @ResponseBody
    public List<CustomerResponse> searchCustomer(@RequestParam("name") String name) {
        return customerService.findCustomerByName(name);
    }

    @PostMapping("/create")
    @ResponseBody
    public List<RentalReceiptResponse> createBooking(@RequestBody BookingRequest request) {
        return rentalReceiptService.createBooking(request);
    }
}
