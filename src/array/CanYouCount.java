package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
//incomplete
public class CanYouCount {
	public static void main(String[] args) throws Exception {

	       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> charSet =  new HashSet<>();
        int test = Integer.parseInt(br.readLine());   
        for(int i = 0 ; i<test ;i++){
            long count = 0;
            String input[] = br.readLine().split("_");
            if(input.length > 1){
                for(int j = 0 ;j<input.length;j++){
                    char [] charString = input[j].toCharArray();
                    for(int k =0 ; k<charString.length ; k++){
                        if(isVowel(charString[k])){
                        	charSet.add(charString[k]);
                        }
                    }
                    if(charSet.size() > 1)
                    count = count + charSet.size();
                }
               
            }else{
                count++;
            }
            System.out.println(count);
        }
       

    
	}
	static boolean isVowel(char c){
        if(c == 'a' || c == 'i' || c == 'o' || c == 'e' || c == 'u'){
            return true;
        }
        return false;
    }

}
