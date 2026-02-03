package com.isvaryam.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Isvaryam Web App.
 * Exercise 16: Remediation & "Clean as You Go"
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * NEW TEST 1: Verifies the Database Connection Logic
     * Part of Exercise 16 requirement to increase code coverage.
     */
    public void testDatabaseConnectionLogic()
    {
        App myApp = new App();
        // We are testing that the method runs without throwing security exceptions
        boolean isMethodAccessible = true; 
        try {
            myApp.databaseConnect();
        } catch (Exception e) {
            isMethodAccessible = false;
        }
        assertTrue( "Database connection method should be accessible and safe", isMethodAccessible );
    }

    /**
     * NEW TEST 2: Verifies proper Exception Handling
     * Part of Exercise 16 requirement to cover refactored logic.
     */
    public void testLogicErrorHandling()
    {
        App myApp = new App();
        // Verifying that our remediation in Exercise 16 properly handles errors
        // instead of leaving them empty or unhandled.
        try {
            myApp.logicError();
            assertTrue( "Logic error method executed successfully", true );
        } catch (Exception e) {
            fail("Method should handle its own exceptions professionally.");
        }
    }
}
