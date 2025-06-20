package in.harshaunkhehra.billingsoftware.service;

import com.razorpay.RazorpayException;

import in.harshaunkhehra.billingsoftware.io.RazorpayOrderResponse;

public interface RazorpayService {

    RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;
    
}
