
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		if (str.length()<= 1){
			return "";
		}
		
		return str.substring(1);
	} 

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word2.length() == 0){
			return word1.length();
		}
		if (word1.length() == 0){
			return word2.length();
		}
		if (word1.charAt(0)==word2.charAt(0)){
			return levenshtein(tail(word1),tail(word2));
		}
		return 1+Math.min(Math.min(levenshtein(tail(word1),word2), levenshtein(word1, tail(word2))), levenshtein(tail(word1), tail(word2)));
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

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int MinRef = 20;
		int thresholdRef;
		String CloseWord = "";

		for (int i=0; i<dictionary.length;i++){
			thresholdRef = levenshtein(word, dictionary[i]);
			if (thresholdRef <= MinRef){
				MinRef = thresholdRef;
				if (thresholdRef <= threshold){
					CloseWord = dictionary[i];
				} else { 
					CloseWord = word;
				}
				
		} 
	} return CloseWord;
} 

}
