package com.isvaryam.app;

public class App {
    /**
     * This method must exist for AppTest to compile.
     * EXERCISE 15: We include a hardcoded password to trigger the Quality Gate.
     */
    public void databaseConnect() {
        String dbSecret = "p@ssword123"; // SonarQube Vulnerability
        System.out.println("Connecting to database...");
    }

    /**
     * This method must exist for AppTest to compile.
     * EXERCISE 15: We include an empty catch block as a Code Smell.
     */
    public void logicError() {
        try {
            int result = 10 / 0; // Intentional error
        } catch (Exception e) {
            // SonarQube Code Smell: Empty catch block
        }
    }
}
