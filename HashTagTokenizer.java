import java.util.Arrays;

public class HashTagTokenizer {

	public static void main(String[] args) {
		//String[] dictionary = readDictionary("dictionary.txt");
		//String s = "Yes";
		//System.out.println(existInDictionary(s, dictionary));
		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In infile = new In(fileName);
		for (int i = 0; i<dictionary.length; i++){
			String line = infile.readLine();
			dictionary[i] = line;
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		word = lowerCase(word);
		for (int i=0; i<dictionary.length; i++){
			if (word.equals(dictionary[i])){
				return true;
			} 

		} return false;

	}

	public static String lowerCase(String s) {
        int i =0; //will run from the first char ti the last
        String out = "";
        for(i=0; i<s.length(); i++){
            char n = s.charAt(i);
            if((n <= 'Z') && n >= 'A'){ // Uppercase
            n = (char) (n+32);
            } 
        out += n;
        }

        return out;
    }
	

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		String SS = "";
        for (int i = 1; i <= N; i++) {
			SS = hashtag.substring(0, i);
			if (existInDictionary(SS, dictionary)){
				System.out.println(SS);
				breakHashTag(hashtag.substring(SS.length(), N), dictionary);
			} 
				
			}
		
        }
    }


