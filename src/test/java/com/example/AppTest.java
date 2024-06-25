package com.example;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(AppTest.class) {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }
        };
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
