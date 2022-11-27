package com.gotovchykov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProfile {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
}