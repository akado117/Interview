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
    InterviewEncryption2 iE2 = new InterviewEncryption2();
    
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
        
        String result = iE2.getUrl( out);
        
        assertTrue(!result.equals(""));
       
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
        boolean result = iE2.wereIn(inputLine, out);
        assertFalse(result);
        result = iE2.wereIn(inputLine1, out);
        assertTrue(result);
        
    }
    
    @Test
    public void testgetKeyDeniedValue(){
        
        String html = "<html><body>KEY DENIED: 110100</body></html>";
        int offset0=0;
        int offset1=1;
        int offset2=2;
        
        assertEquals(iE2.getKeyDeniedValue(html, offset0),"11");
        assertEquals(iE2.getKeyDeniedValue(html, offset1),"01");
        assertEquals(iE2.getKeyDeniedValue(html, offset2),"00");
        
        
    }
    
}
