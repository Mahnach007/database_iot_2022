package com.gotovchykov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Airport {
    private Integer id;
    private String name;
    private String contry;
    private String city;
    private String address;
}