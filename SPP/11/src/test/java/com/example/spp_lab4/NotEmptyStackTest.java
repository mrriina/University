package com.example.spp_lab4;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotEmptyStackTest {
    Stack<String> s = new Stack<String>();

    @Before
    public void initBefore() {
        s.clear();
        s.push("7");
        s.push("1");
        s.push("4");
    }

    @After
    public void initAfter() {

    }

    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void clearTest() {
        System.out.println("clearTest");

        s.clear();

        assertTrue(s.isEmpty());
        assertEquals(s.size(), 0);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void isEmptyTest() {
        System.out.println("isEmptyTest");

        assertFalse(s.isEmpty());
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void sizeTest() {
        System.out.println("sizeTest");

        assertEquals(s.size(), 3);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void pushTest() {
        System.out.println("push");

        s.push("0");

        assertEquals(s.size(), 4);
        assertEquals(s.search("1"), 2);
        assertEquals(s.peek(), "0");
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void popTest() {
        System.out.println("popTest");

        assertEquals(s.pop(), "4");
        assertEquals(s.size(), 2);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void peekTest() {
        System.out.println("peekTest");

        assertEquals(s.peek(), "4");
    }

    /**
     * Test of search method, of class Stack.
     */
    @Test
    public void searchTest() {
        System.out.println("searchTest");

        assertEquals(s.search("7"), 2);
        assertEquals(s.search("1"), 1);
        assertEquals(s.search("4"), 0);
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void toStringTest() {
        System.out.println("toStringTest");

        assertEquals(s.toString(), "4 1 7 ");
    }
}
