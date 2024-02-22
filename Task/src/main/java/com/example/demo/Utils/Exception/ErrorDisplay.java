package com.example.demo.Utils.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorDisplay implements Serializable {
    private String error;
    private long status;
    private Date timestamp;
}
