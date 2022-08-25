package com.example.springbootlearn.transaction.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user1
 * @author 
 */
@Data
public class User1 implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}