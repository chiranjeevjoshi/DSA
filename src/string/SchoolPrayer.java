package string;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class SchoolPrayer {
    public static void main(String args[] ) throws Exception {
	try (final PrintWriter writer = new PrintWriter(System.out);
		        final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
		      solve(input, writer);
		    }
	}
	
	private static void solve(final Input input, final PrintWriter writer) throws Exception {
	    StringBuilder sb = new StringBuilder();
		int t = input.nextInt();
		for (int i = 0; i < t; i++) {
			int n = input.nextInt();
			int total = 0;
			TreeSet<Integer> treeSet = new TreeSet<>();
			for(int j=0 ;j <n ; j++){
				int result = -1;
				int roll = input.nextInt();
				if(treeSet.isEmpty() || treeSet.lower(roll) == null){
						treeSet.add(roll);
				}else{
					result = treeSet.lower(roll);
					treeSet.add(roll);
				}
				total = total+result;
			}
			sb.append(total+"\n");
		}
	    writer.println(sb.toString());
	    
	  }
	  
	  private static final class Input implements Closeable {
		 
	    private final BufferedReader bufferedReader;
	    private final static StringBuilder stringBuilder = new StringBuilder();
	    private final static String SEPERATOR = " \n\r\t";
	 
	    public Input(final BufferedReader bufferedReader) {
	      this.bufferedReader = bufferedReader;
	    }
	 
	    public String next() throws IOException {
	      stringBuilder.setLength(0);
	      while (true) {
	        int c = bufferedReader.read();
	        if (c == -1) {
	          return null;
	        }
	        if (SEPERATOR.indexOf(c) == -1) {
	          stringBuilder.append((char) c);
	          break;
	        }
	      }
	      while (true) {
	        int c = bufferedReader.read();
	        if (c == -1 || SEPERATOR.indexOf(c) != -1) {
	          break;
	        }
	        stringBuilder.append((char) c);
	      }
	      return stringBuilder.toString();
	    }
	 
	    public int nextInt() throws IOException {
	      return Integer.parseInt(next(), 10);
	    }
	 
	    @Override
	    public void close() throws IOException {
	      bufferedReader.close();
	    }
	  }
}
