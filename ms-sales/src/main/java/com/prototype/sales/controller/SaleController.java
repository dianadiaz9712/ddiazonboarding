package com.prototype.sales.controller;

import com.prototype.sales.dto.MessageResponse;
import com.prototype.sales.dto.RefundRequestDTO;
import com.prototype.sales.dto.SalesRequestDTO;
import com.prototype.sales.service.SalesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SalesService salesService;

    public SaleController(SalesService salesService) {
        this.salesService = salesService;
    }


    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Operación para realizar reembolso de pago", httpMethod = "POST", response = MessageResponse.class)
    @ApiResponses({ @ApiResponse(code = 201, message = "Se registro con exito el pago."),
            @ApiResponse(code = 400, message = "Se produjo una excepción en la creacion de pago"),
            @ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createRefund(@Valid @RequestBody RefundRequestDTO refundRequestDTO) {

        return null;
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Operación para realizar autorizacion y captura de pagos", httpMethod = "POST", response = MessageResponse.class)
    @ApiResponses({ @ApiResponse(code = 201, message = "Se registro con exito el pago."),
            @ApiResponse(code = 400, message = "Se produjo una excepción en la creacion de pago"),
            @ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createPayment(@Valid @RequestBody SalesRequestDTO salesRequestDTO) {

        return null;
    }
}
