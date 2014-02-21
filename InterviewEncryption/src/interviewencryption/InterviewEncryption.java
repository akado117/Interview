/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewencryption;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class InterviewEncryption {
    //contains all the possibilities a slot can have
    private String[] chars= {"a","i","9"};
    ArrayList<String> key = new ArrayList<String>();
    
    
    int charsIterator=1;
    boolean secondTime = false;
    
    //initialize the key
    public InterviewEncryption(){
        key.add("Q");
        key.add("9");
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
        InterviewEncryption keys = new InterviewEncryption();
        String key= "Q9";
        int counter=0;
        
        
        do{
            
            System.out.println(key);
            
            key = keys.doIt();
            
            
            
            counter++;
        }while(counter<15);
        
        
    }
    
    
    public String doIt(){
        String ret= "";
        
        
        //for the initial condition
        if(key.get(key.size()-1).equals("9") && key.get(key.size()-2).equals("Q")){
            key.add(chars[0]);
        } 
        //for when the second from last place is 9 iterate through the chars array
        else if(key.get(key.size()-2).equals("9") && !key.get(key.size()-1).equals("9") && !secondTime ){
            //selects the last element in the list and changes it to the next char in the array
            key.remove(key.size()-1);//removes the last element of the list
            key.add(chars[charsIterator]);//replaces it with the new string
            //increments the chars iterator
            charsIterator++;
        }
        //when all the stars have been tried (9*) and it's back to 99
        //reset iterator, change second to last value and update second time to true
        else if (key.get(key.size()-2).equals("9") && key.get(key.size()-1).equals("9") && !secondTime){
            charsIterator = 1;//reset charsIterator
            secondTime=true;//this is the second time running through with this number of elements in the string
            key.remove(key.size()-2);//removes the second to last value
            key.add(key.size()-1, chars[0]);//replaces removed value with new value
        }
        //will iterate until the last 2 values are 99 again
        else if (!key.get(key.size()-2).equals("9") && key.get(key.size()-1).equals("9") && secondTime ){
            key.remove(key.size()-2);//removes the second to last value
            key.add(key.size()-1, chars[charsIterator]);//replaces removed value with new value   
            charsIterator++;//increments so we can move through the chars array
        }
        //reset everything so the process can repeat again
        else if(key.get(key.size()-2).equals("9") && key.get(key.size()-1).equals("9") && secondTime){
            secondTime = false; //reset secondtime
            charsIterator = 1; //resete the chars iterator
            key.add(chars[0]);//add a new value to the end of the array so (9*) can occur
            
        }
        
        
        
        
        for(int i = 0; i < key.size(); i++){
            ret+=key.get(i);
        }
        return ret;
    }
}
