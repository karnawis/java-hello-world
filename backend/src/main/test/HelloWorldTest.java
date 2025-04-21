package com.helloworld;

import com.helloworld.HelloWorld;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    /**
     * Test that verifies the output has correct capitalization
     * "Hello World", not
     * "hello world" or "HELLO WORLD"
     */

    @Test
    public void testCapitalization() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Call the main method
            HelloWorld.main(new String[] {});

            // Get the captured output and trim whitespace
            String output = outputStream.toString().trim();

            // Assert the proper capitalization
            assertEquals("Hello World!", output);
            assertNotEquals("hello world!", output);
            assertNotEquals("HELLO WORLD!", output);
        } finally {
            // Restore the original System.out
            System.setOut(originalOut);
        }
    }

    /**
     * Test that verifies the program handles null arguments
     */
    @Test
    public void testNullArguments() {
        // This should not throw an exception
        assertDoesNotThrow(() -> {
            // Redirect output to avoid console pollution
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(new ByteArrayOutputStream()));

            try {
                HelloWorld.main(null);
            } finally {
                System.setOut(originalOut);
            }
        });
    }

    /**
     * Test that verifies the program handles empty arguments
     */
    @Test
    public void testEmptyArguments() {
        // This should not throw an exception
        assertDoesNotThrow(() -> {
            // Redirect output to avoid console pollution
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(new ByteArrayOutputStream()));

            try {
                HelloWorld.main(new String[] {});
            } finally {
                System.setOut(originalOut);
            }
        });
    }
}