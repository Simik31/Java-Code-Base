package SharedCodeBase.Ciphers;

import java.util.ArrayList;
import java.util.Arrays;

public class MorseCode {
    private final String letters;
    private final ArrayList<String> morseLetters;

    public MorseCode() {
        letters = "abcdefghijklmnopqrstuvwxyz1234567890";
        morseLetters = new ArrayList<>(Arrays.asList(".-","-...","-.-.","-..",".",
                "..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...",
                "-","..-","...-",".--","-..-","-.--","--..",
                ".----","..---","...--","....-",".....",
                "-....","--...","---..","----.","-----"));
    }

    public String encode(String message){
        StringBuilder sb = new StringBuilder();
        for (char c :  message.toLowerCase().toCharArray()) {
            if(letters.contains(String.valueOf(c))) sb.append(morseLetters.get(letters.indexOf(c))).append("/");
            else sb.append(c).append("/");
        }
        return sb.toString();
    }

    public String decode(String encodedMessage){
        StringBuilder sb = new StringBuilder();
        for(String letter : encodedMessage.split("/")){
            if(morseLetters.contains(letter))sb.append(letters.charAt(morseLetters.indexOf(letter)));
            else sb.append(letter);
        }
        return sb.toString();
    }
}
