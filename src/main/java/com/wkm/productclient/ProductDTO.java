package com.wkm.productclient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by mauri on 17/08/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
