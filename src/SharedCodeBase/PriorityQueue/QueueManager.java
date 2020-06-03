package SharedCodeBase.PriorityQueue;

public class QueueManager {

    Node head;

    public QueueManager(){
        head = null;
    }/*

    public void addAirplane(Object object){

        Node newNode = new Node(object, null);

        if(head == null){

            head = newNode;
            return;
        }

        if(řadící podminka head > řadící podminka newNode){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node start = head;

        while (start.next != null && řadící podminka next < řadící podminka newNode) {
            start = start.next;
        }

        newNode.next = start.next;
        start.next = newNode;

    }

    public Object peek(){

        if(head == null) return null;

        return head.data;
    }

    public Object pop(){

        if(head == null) return null;

        object temp = head.data;
        head = head.next;

        return temp;
    }

    public void printAll(){

        System.out.println(head);

        System.out.println("----------------");
    }*/

}
