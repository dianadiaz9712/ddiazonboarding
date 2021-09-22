package com.prototype.payments.thirdyparty.payu.api;


import com.prototype.payments.thirdyparty.payu.dto.Refund;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prototype.payments.thirdyparty.payu.dto.Payment;
import com.prototype.payments.thirdyparty.payu.dto.PaymentResponse;

@FeignClient(name = "paymentService", url = "${feign.url}")
public interface PayUClient {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentResponse authorizationCaptureClient(@RequestBody Payment payment);


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentResponse refundClient(@RequestBody Refund refund);

}
