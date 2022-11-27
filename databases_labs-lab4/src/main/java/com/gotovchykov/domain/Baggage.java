package com.gotovchykov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Baggage {
    private Integer id;
    private String type;
    private Float height;
    private Float width;
    private Float weight;
}