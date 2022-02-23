public class MyClass {
    
    static final int maxElements = 4;
    
    static class Node {
        int numElements;
        int array[] = new int[maxElements];
        Node next;
    }
    public static void main(String args[]) {
        
        Node head = null;
        Node second = null;
        Node third = null;
        
        head = new Node();
        second = new Node();
        third = new Node();
        
        head.numElements = 4;
        head.array[0] = 3;
        head.array[1] = 6;
        head.array[2] = 9;
        head.array[3] = 43;
        
        head.next = second;
        second.numElements = 4;
        second.array[0] = 32;
        second.array[1] = 8;
        second.array[2] = 21;
        second.array[3] = 40;
        
        second.next = third;
        third.numElements = 4;
        third.array[0] = 58;
        third.array[1] = 18;
        third.array[2] = 68;
        third.array[3] = 77;
        third.next = null;
        
        printUnrolledList(head);
      
    }
    
    public static void printUnrolledList(Node n) {
        while(n != null) {
            for(int i = 0; i < n.numElements; i++) {
                System.out.print(n.array[i] + "->");
            }
                n = n.next;
            
            System.out.print("--->");
        }
    }
}