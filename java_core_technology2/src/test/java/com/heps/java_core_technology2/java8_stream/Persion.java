package com.heps.java_core_technology2.java8_stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persion {

    private Integer id ;
    private String name;
    private String sex;


}
