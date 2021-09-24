package com.prototype.sales.thirdyparty.payments.api;

import com.prototype.sales.thirdyparty.payments.dto.PaymentRequestDTO;
import com.prototype.sales.thirdyparty.payments.dto.RefundDTO;
import com.prototype.sales.thirdyparty.payments.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "paymentService", url = "${feign.url.payment}")
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDTO createRefund(RefundDTO refundRequestDTO);

}
