package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Part8 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */

	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    Map<String, Integer> words = new HashMap<String, Integer>();

    for (String line = r.readLine(); line != null; line = r.readLine()){
      if(words.containsKey(line)){
        words.put(line, words.get(line) + 1);
      }
      else{
        words.put(line, 1);
      }
    }
    List<Map.Entry<String, Integer>> final1 = new ArrayList<>();
    final1.addAll(words.entrySet());
    Collections.sort(final1, new Comparator<Map.Entry<String, Integer>>(){
      public int compare(Map.Entry<String, Integer> string1, Map.Entry<String, Integer> string2){
        if(string1.getValue() - string2.getValue() == 0){
          return string1.getKey().compareTo(string2.getKey());
        }
        else{
          //This can easily be switched to ascending order by swapping the terms
          return string2.getValue() - string1.getValue();
        }
      }
	  });
    for(Map.Entry<String, Integer> test : final1){
      w.println(test.getKey());
    }
}
	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
