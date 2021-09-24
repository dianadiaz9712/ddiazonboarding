package com.prototype.sales.service;

import com.prototype.sales.dto.MessageResponse;
import com.prototype.sales.dto.RefundRequestDTO;
import com.prototype.sales.dto.SalesRequestDTO;


public interface SalesService {

     MessageResponse createPayment(SalesRequestDTO salesRequestDTO);

    MessageResponse createRefund( RefundRequestDTO refundRequestDTO);
}
