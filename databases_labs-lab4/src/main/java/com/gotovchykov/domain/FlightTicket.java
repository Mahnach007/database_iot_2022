package com.gotovchykov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightTicket {
    private Integer id;
    private String type;
    private Double price;
    private Integer avaiability;
    private Integer buyingHistoryId;
    private Integer flightInfoId;
    private Integer connectedFlightId;
    
}