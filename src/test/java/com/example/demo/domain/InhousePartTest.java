package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InhousePartTest {
    InhousePart ip;
    @BeforeEach
    void setUp() {
        ip= new InhousePart();
    }

    @Test
    void getPartId() {
        int idValue=4;
        ip.setPartId(idValue);
        assertEquals(ip.getPartId(), idValue);
    }

    @Test
    void setPartId() {
        int idValue=4;
        ip.setPartId(idValue);
        assertEquals(ip.getPartId(), idValue);
    }
}