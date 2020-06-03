package SharedCodeBase.Ciphers;

import java.util.Random;

public class Transposition {

    private final int key;

    public Transposition(int key) {
        this.key = key;
    }

    public String encode(String message){
        StringBuilder sb = new StringBuilder(message);
        Random rnd = new Random(key);

        for (int i = 0; i < sb.length(); i++) {
            int rndIndex = rnd.nextInt(sb.length());
            char currentChar = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(rndIndex));
            sb.setCharAt(rndIndex, currentChar);
        }
        return sb.toString();
    }

    public String decode(String encodedMessage){
        StringBuilder sb = new StringBuilder(encodedMessage);
        int[] indexes = new int[encodedMessage.length()];
        Random rnd = new Random(key);
        for (int i = 0; i < indexes.length; i++) indexes[i] = rnd.nextInt(encodedMessage.length());
        for (int i = sb.length()-1; i >= 0; i--) {
            char currentChar = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(indexes[i]));
            sb.setCharAt(indexes[i], currentChar);
        }
        return sb.toString();
    }

}
