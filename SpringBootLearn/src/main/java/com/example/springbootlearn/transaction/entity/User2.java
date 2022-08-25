package com.example.springbootlearn.transaction.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user2
 * @author 
 */
@Data
public class User2 implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}