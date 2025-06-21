package in.harshaunkhehra.billingsoftware.service.impl;

import com.razorpay.RazorpayException;

import in.harshaunkhehra.billingsoftware.io.RazorpayOrderResponse;
import in.harshaunkhehra.billingsoftware.service.RazorpayService;

public class RazorpayServiceImpl implements RazorpayService {

    @Override
    public RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException {
        return null;
        
    }
    
}
