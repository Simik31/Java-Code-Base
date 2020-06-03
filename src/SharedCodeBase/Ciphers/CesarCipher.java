package SharedCodeBase.Ciphers;

public class CesarCipher {
    private final int key;
    private final String alphabet;

    public CesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        this.key = key % alphabet.length();
    }

    public String encode(String message){
        char[] characters = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char character : characters) {
            if (alphabet.contains(String.valueOf(character))) sb.append(alphabet.charAt((alphabet.indexOf(character) + key) % alphabet.length()));
            else sb.append(character);
        }
        return sb.toString();
    }

    public String decode(String encodedMessage){
        char[] characters = encodedMessage.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char character : characters) {
            if (alphabet.contains(String.valueOf(character))) sb.append(alphabet.charAt((alphabet.indexOf(character) - key + alphabet.length()) % alphabet.length()));
            else sb.append(character);
        }
        return sb.toString();
    }
}
