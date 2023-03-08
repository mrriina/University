package com.example.spp_lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void substringBetweenTest() throws NullPointerException {
        System.out.println("substringBetweenTest");

        assertNull(StringUtils.substringBetween(null , "*" , "*"));
        assertNull(StringUtils.substringBetween("*", null, "*"));
        assertNull(StringUtils.substringBetween("*", "*", null ));
        assertEquals(StringUtils.substringBetween("", "", ""), "");
        assertNull(StringUtils.substringBetween("", "", "]"));
        assertNull(StringUtils.substringBetween("", "[", "]"));
        assertEquals(StringUtils.substringBetween(" yabcz ", "", ""), "");
        assertEquals(StringUtils.substringBetween(" yabcz ", "y", "z"), "abc");
        assertEquals(StringUtils.substringBetween(" yabczyabcz ", "y", "z"), "abc");
        assertEquals(StringUtils.substringBetween("wx[b]yz", "[", "]"), "b");

        try {
            StringUtils.substringBetween (null, null, null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException thrown");
        }
    }
}