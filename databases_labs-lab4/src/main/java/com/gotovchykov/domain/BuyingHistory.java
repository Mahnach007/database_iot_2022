package com.gotovchykov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyingHistory {
    private Integer id;
    private String dateTime;
    private Integer userProfileId;
    
}