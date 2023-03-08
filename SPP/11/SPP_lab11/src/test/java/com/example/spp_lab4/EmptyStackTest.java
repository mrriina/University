package com.example.spp_lab4;

import java.util.NoSuchElementException;
import org.junit.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyStackTest {
    Stack<String> s = new Stack<String>();

    @Before
    public void initBefore() {
        s.clear();
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

        assertTrue(s.isEmpty());
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void sizeTest() {
        System.out.println("sizeTest");

        assertEquals(s.size(), 0);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void pushTest() {
        System.out.println("pushTest");

        s.push("1");

        assertEquals(s.size(), 1);
        assertEquals(s.search("1"), 0);
        assertEquals(s.peek(), "1");
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void popTest() throws NoSuchElementException {
        System.out.println("popTest");

        try {
            s.pop();
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void peekTest() throws NoSuchElementException {
        System.out.println("peekTest");

        try {
            s.peek();
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }
    }

    /**
     * Test of search method, of class Stack.
     */
    @Test
    public void searchTest() {
        System.out.println("searchTest");

        assertEquals(s.search("1"), -1);
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void toStringTest() {
        System.out.println("toStringTest");

        assertEquals(s.toString(), "");
    }
}
