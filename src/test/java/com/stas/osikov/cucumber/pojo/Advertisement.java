package com.stas.osikov.cucumber.pojo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class Advertisement {
    String name;
    String price;
}
