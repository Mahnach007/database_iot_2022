package com.gotovchykov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightInfo {
    private Integer id;
    private Integer airlineId;
    private Integer airportId;
    private Integer baggageId;
    private String date;
    private String time;
    
}