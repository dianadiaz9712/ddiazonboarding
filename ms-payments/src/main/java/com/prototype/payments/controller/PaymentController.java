package com.prototype.payments.controller;

import javax.validation.Valid;

import com.prototype.payments.service.RefundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.payments.dto.PaymentRequestDTO;
import com.prototype.payments.dto.RefundDTO;
import com.prototype.payments.dto.ResponseDTO;
import com.prototype.payments.dto.mapper.PaymentMapperDTO;
import com.prototype.payments.service.PaymentService;
import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.RefundEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapperDTO paymentMapperDTO;
    private final RefundService refundService;

    public PaymentController(PaymentService paymentService, PaymentMapperDTO paymentMapperDTO, RefundService refundService) {
        this.paymentService = paymentService;
        this.paymentMapperDTO = paymentMapperDTO;
        this.refundService = refundService;
    }


    @PostMapping(value = "/autorization-capture", produces = { MediaType.APPLICATION_JSON_VALUE })
        @ApiOperation(value = "Operación para realizar autorizacion y captura de pagos", httpMethod = "POST", response = ResponseDTO.class)
        @ApiResponses({ @ApiResponse(code = 201, message = "Se registro con exito el pago."),
                @ApiResponse(code = 400, message = "Se produjo una excepción en la creacion de pago"),
                @ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseDTO createPayment(@Valid @RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentEntity paymentEntity =paymentMapperDTO.paymentDtoToPaymentEntity(paymentRequestDTO);
        return paymentMapperDTO.responseEntityToResponseDTO(paymentService.createPayment(paymentEntity));
        }

    @PostMapping(value = "/refund", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Operación para realizar reembolso de pago", httpMethod = "POST", response = ResponseDTO.class)
    @ApiResponses({ @ApiResponse(code = 201, message = "Se registro con exito el reembolso."),
            @ApiResponse(code = 400, message = "Se produjo una excepción en la creacion de reembolso"),
            @ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO createRefund(@Valid @RequestBody RefundDTO refundRequestDTO) {
        RefundEntity refundEntity = paymentMapperDTO.refundDTOtoRefundEntity(refundRequestDTO);
        return paymentMapperDTO.responseEntityToResponseDTO(refundService.createRefund(refundEntity));
    }


}
