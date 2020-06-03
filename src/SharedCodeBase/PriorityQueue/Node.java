package SharedCodeBase.PriorityQueue;

public class Node {

    public Object data;
    public Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {

        if(next != null) return data + "\n" + next;

        return data.toString();
    }

}
