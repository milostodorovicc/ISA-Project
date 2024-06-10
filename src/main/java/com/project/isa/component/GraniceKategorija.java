package com.project.isa.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class GraniceKategorija {
    private MyMutableData data;
    @PostConstruct
    public void init() {
        // Initialize your data here
        data = new MyMutableData(0, 0, 0, 0);
    }

    public MyMutableData getData() {
        return data;
    }
}


