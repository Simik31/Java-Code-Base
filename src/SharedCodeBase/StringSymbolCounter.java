package SharedCodeBase;

public class StringSymbolCounter {

    public static int count(String data, String to_search) {
        int counter = 0;
        for(int i = 0; i < data.length() - to_search.length() + 1; i++) if(data.startsWith(to_search, i)) counter++;
        return counter;
    }

}
