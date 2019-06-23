package com.example.ssmspringboot.domain;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
由于Lombok插件的原因只需要
@Data：生成所有，getter() setter() toString()等等方法
@Setter ：生成setter()方法
@Getter：生成getter()方法
*/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6515261573146253923L;
    private  Integer id;
    private String username;

    private String password;
    private String role;


}
