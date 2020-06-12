package Code2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	
	private Map<String, String> dictionary;
	
	public Dictionary(String readPath) {
		dictionary = new HashMap<String, String>();
		try {
			loadDictionary(new File(readPath));
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Map<String, String> getTranslate(){
		return dictionary;
	}
	
	private void loadDictionary(File file) throws FileNotFoundException{
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String key = null;
			String value = null;
			key = scan.next();
			value = scan.next();
			dictionary.put(key, value);
		}
		scan.close();
	}
	
	public String translate(String text, String spaceChar) {
		String translated = "";
		for(int i = 0; i < text.length(); i++) {
			String ch = (text.charAt(i)+"").toUpperCase();
			
			if(dictionary.containsKey(ch)) {
				translated += ((String)dictionary.get(ch));
				if(i < text.length()-1) {
					if(text.charAt(i+1) != ' ') {
						translated += ' ';
					}
				}
			}
			else if(ch.equals(" ")) {
				translated += spaceChar;
			}
			else {
				translated = "Invalid Charactor \""+ch+"\"";
				break;
			}
		}
		return translated;
	}

}
