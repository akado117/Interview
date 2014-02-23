/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewencryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/**
 *
 * @author apprentice
 */
public class InterviewEncryption2 {

    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        InterviewEncryption2 iE2 = new InterviewEncryption2();

        String[] chars = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int l = chars.length;
        ArrayList<String> charList = new ArrayList<>();
        ArrayList<String> key = new ArrayList<>();
        String initialValue ="Q";
        String out = initialValue;
        String inputLine ="";
        String isEqual="";

        //creates a list of Strings which the key could possibly be made of
        for (String string1 : chars) {

            out = "Q" + string1;

            if (iE2.getKeyDeniedValue(iE2.getUrl(out), 1).equals("01") || iE2.getKeyDeniedValue(iE2.getUrl(out), 1).equals("11")) {
                //System.out.println("added to array: "+string1);//test
                charList.add(string1);
            }

        }
        //reset out to initial value
        out = initialValue;
        
        for (int i = 1; i < 10; i++) {
            //run through the possible Strings for the key possition
            for (int j = 0; j < charList.size(); j++){
                
                //get a part of the key to test
                String string1 = charList.get(j);
                
                //add part of key to current key
                out += string1;
                
                //make the key editable
                StringBuilder sb = new StringBuilder(out);
                
               
                //check to see if the String is in the right spot
                inputLine = iE2.getUrl(out);
                isEqual=iE2.getKeyDeniedValue(inputLine, i);
                if (isEqual.equals("11")) {
                    //System.out.println("key is: " + out);//test
                    out = sb.toString();
                    //move to next position
                    break;
                    
                    
                    
                }else{
                    //if the key part was not successful then delete it and return out to its prior value
                    out = sb.deleteCharAt(sb.length()-1).toString();
                    
                }
                //if the phrase key denied isn't found pause the program and wait for user input
                if (iE2.wereIn(inputLine, out)) {
                    System.exit(0);
                }

            }
            

        }

        

    }

    //used to get the return statement that dictates how successful the key attempt was
    //the offset dictates what character in the key the sequence pertains to
    public String getKeyDeniedValue(String html, int offset) {
        if (html.length() > 10) {

            int startOfCode = html.indexOf("1");
            return Character.toString(html.charAt(startOfCode + offset * 2)) + Character.toString(html.charAt(startOfCode + 1 + offset * 2));
        } else {
            return "error";
        }

    }

    public String getUrl(String out) throws MalformedURLException, IOException {
        String url = "http://simple-snow-3171.herokuapp.com/?key=" + out; //declares a new url object
        URL oracle = new URL(url);
        //creates a reader to read in html from page
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        //sets the first line in the file to inputline
        String inputLine = in.readLine();

        //closes the reader
        in.close();

        return inputLine;

    }

    public boolean wereIn(String inputLine, String out) {
        if (!inputLine.contains("KEY DENIED")) {
            System.out.println("The key was: " + out);
            return true;
        }
        return false;
    }

}
