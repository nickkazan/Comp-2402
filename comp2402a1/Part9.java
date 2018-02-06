package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part9 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    // List<String> words = new ArrayList<>();
    // for (String line = r.readLine(); line != null; line = r.readLine()){
    //   boolean flag = false;
    //   for(int i = 0; i < words.size(); i++){
    //     if(words.get(i).startsWith(line)){
    //       flag = true;
    //     }
    //   }
    //   if(flag == false){
    //     words.add(line);
    //   }
    // }
    // for (int j = 0; j < words.size(); j++){
    //   w.println(words.get(j));
    // }


Set<String> words = new LinkedHashSet<>();
List<String> words2 = new ArrayList<>();
boolean flag;
String pre;

for (String line = r.readLine(); line != null; line = r.readLine()) {
  words.add(line);
}
words2.addAll(words);

for(int i = 0; i < words2.size(); i++){
  pre = words2.get(i);
  flag = false;

  for(int j = 0; j < i; j++){
    if(words2.get(j).contains(pre)){
      flag = true;
    }
  }

  if(flag == true){
    continue;
  }

  else{
    w.println(pre);
  }
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
