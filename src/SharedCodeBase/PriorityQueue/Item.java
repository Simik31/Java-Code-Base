package SharedCodeBase.PriorityQueue;

public class Item {

    private String name;
    // private int fuel; řadící podminka

    public Item(String name, int fuel) {
        this.name = name;
        //this.fuel = fuel; řadící podminka
    }

    public String getName() {
        return name;
    }
/*
    public int getFuel() { řadící podminka
        return fuel;
    }*/

    @Override
    public String toString() {
        return name ;//+ " | fuel: " + fuel;
    }

}
