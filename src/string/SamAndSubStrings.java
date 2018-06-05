package string;

import java.util.Scanner;

public class SamAndSubStrings {

	 static int substrings(String balls) {
	        long total =0l;
	       for(int i =0 ; i < balls.length() ; i++){
	           for(int j =i ; j<balls.length() ; j++){
	               
	               total+= Integer.parseInt(balls.substring(i ,j+1));
	           }
	        }
	        return (int) ((int)total%(Math.pow(2,10)+7));
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String balls = in.next();
	        int result = substrings(balls);
	        System.out.println(result);
	        in.close();
	    }}
