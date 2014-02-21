/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewencryption;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class InterviewEncryption2Test {
    
    public InterviewEncryption2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUrl method, of class InterviewEncryption2.
     */
    @Test
    public void testGetUrl() throws Exception {
        System.out.println("getUrl");
        String url = "http://www.google.com";
        String out = "key";
        
        String result = InterviewEncryption2.getUrl(url, out);
        
        assertTrue(result != "");
       
    }

    /**
     * Test of wereIn method, of class InterviewEncryption2.
     */
    @Test
    public void testWereIn() {
        System.out.println("wereIn");
        String inputLine = "KEY DENIED";
        String inputLine1 = "SOMETHING ELSE";
        String out = "KEY";
        boolean expResult = false;
        boolean result = InterviewEncryption2.wereIn(inputLine, out);
        assertFalse(result);
        result = InterviewEncryption2.wereIn(inputLine1, out);
        assertTrue(result);
        
    }
    
}
