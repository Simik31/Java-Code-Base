package SharedCodeBase.Ciphers;

public class Vigenere {

    private final String password;
    private final String alphabet;

    public Vigenere(String password) {
        this.password = password;
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
    }

    public String encode(String message){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int passwordIndex = alphabet.indexOf(password.charAt(i % password.length())) + 1;
            int messageIndex = alphabet.indexOf(message.charAt(i));
            if(passwordIndex >= 1 && messageIndex >= 0) sb.append(alphabet.charAt((messageIndex + passwordIndex) % alphabet.length()));
            else sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public String decode(String encodedMessage){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedMessage.length(); i++) {
            int passwordIndex = alphabet.indexOf(password.charAt(i % password.length())) + 1;
            int messageIndex = alphabet.indexOf(encodedMessage.charAt(i));
            if(passwordIndex >= 1 && messageIndex >= 0) sb.append(alphabet.charAt((messageIndex - passwordIndex + alphabet.length()) % alphabet.length()));
            else sb.append(encodedMessage.charAt(i));
        }
        return sb.toString();
    }

}
