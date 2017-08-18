package com.wkm.productclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mauri on 17/08/2017.
 */
@FeignClient("product-service")
interface ProductReader {
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    Resources<ProductDTO> read();
}
