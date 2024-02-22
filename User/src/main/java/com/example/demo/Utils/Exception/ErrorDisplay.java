package com.example.demo.Utils.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorDisplay implements Serializable {
    private String error;
    private long status;
    private Date timestamp;
}
