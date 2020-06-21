package com.meamei.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mm013
 * @create 2020-06-19 11:28:14
 * @description:
 */
@Data
public class Payment implements Serializable {

    private Long id;

    private String serial;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
