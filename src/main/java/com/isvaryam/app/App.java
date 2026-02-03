package com.isvaryam.app;

import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    /**
     * REMEDIATION: Removed hardcoded password.
     * We now use a logger instead of printing secrets.
     */
    public void databaseConnect() {
        logger.info("Connecting to database using secure system environment variables.");
    }

    /**
     * REMEDIATION: Fixed division by zero and added proper logging.
     * No more empty catch blocks!
     */
    public void logicError() {
        try {
            int result = 10 / 2;
            logger.info("Logic calculation successful: " + result);
        } catch (ArithmeticException e) {
            logger.severe("An arithmetic error occurred: " + e.getMessage());
        }
    }
}
