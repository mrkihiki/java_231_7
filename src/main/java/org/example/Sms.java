package org.example;

import lombok.Data;
import java.util.List;

@Data
public class Sms {
    private String phone;
    private String mas;

    public Sms(String phone, String mas) {
        this.phone = phone;
        this.mas = mas;
    }
}
