package com.prototype.sales.thirdyparty.product.api;

import com.prototype.sales.thirdyparty.product.dto.MessageResponse;
import com.prototype.sales.thirdyparty.product.dto.ProductRequestUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@FeignClient(name = "productService", url = "${feign.url.product}")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MessageResponse updateProduct(@Valid @RequestBody ProductRequestUpdateDTO productResquestUpdate);
}
