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
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterviewEncryption2 {

    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        String[] chars = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int l = chars.length;
        Scanner input = new Scanner(System.in);

        for (int a = 0; a < l; a++) {
            for (int b = 0; b < l; b++) {
                for (int c = 0; c < l; c++) {
                    for (int d = 0; d < l; d++) {
                        for (int e = 0; e < l; e++) {
                            for (int f = 0; f < l; f++) {
                                for (int g = 0; g < l; g++) {
                                    for (int h = 0; h < l; h++) {
                                        //creates a key
                                        String out = "Q" + chars[a] + chars[b] + chars[c] + chars[d] + chars[e] + chars[f] + chars[g] + chars[h];
                                        //
                                        if (out.contains("9")) {
                                            String url = "http://simple-snow-3171.herokuapp.com/?key=" + out;
                                            //connects to the website
                                            String inputLine = InterviewEncryption2.getUrl(url, out);

                                            //if the phrase key denied isn't found pause the program and wait for user input
                                            if(InterviewEncryption2.wereIn(inputLine, out)){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static String getUrl(String url, String out) throws MalformedURLException, IOException {
        //declares a new url object
        URL oracle = new URL(url);
        //creates a reader to read in html from page
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        //sets the first line in the file to inputline
        String inputLine = in.readLine();

        System.out.println(inputLine + " with " + out + " as a key");
        //closes the reader
        in.close();

        return inputLine;

    }

    public static boolean wereIn(String inputLine, String out) {
        if (!inputLine.contains("KEY DENIED")) {
            System.out.println("The key was: " + out);
            return true;
        }
        return false;
    }

}
