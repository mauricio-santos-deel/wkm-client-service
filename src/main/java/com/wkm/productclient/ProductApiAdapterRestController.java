package com.wkm.productclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by mauri on 17/08/2017.
 */
@RestController("/products")
public class ProductApiAdapterRestController {

    private final ProductReader productReader;

    public ProductApiAdapterRestController(ProductReader productReader) {
        this.productReader = productReader;
    }

    // todo not working
    public Collection<String> fallback(){
        return new ArrayList<>();
    }

    @GetMapping("names")
    @HystrixCommand(fallbackMethod = "fallback") // todo not working
    public Collection<String> names() {
        return this.productReader.read()
                .getContent()
                .stream()
                .map(ProductDTO::getName)
                .collect(Collectors.toList());
    }
}
