package com.sayiamfun.mytestdemo.equals;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class User implements Serializable {
    private String name;
}
