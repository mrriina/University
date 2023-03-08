package com.example.spp_lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    public void accumTest() {
        int[] values = {5, 6, 3};
        int expecteds = 14;
        int result = Sum.accum(values);
        System.out.println("accumTest");
        assertEquals(expecteds, result);
    }


    @Test
    public void accumLongTest() {
        int[] values = {599999999, 699999999, 399999999};
        long expecteds = 1699999997L;
        long result = Sum.accum(values);
        System.out.println("accumLongTest");
        assertEquals(expecteds, result);
    }
}