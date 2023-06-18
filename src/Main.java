public class Main {
    public static void main(String[] args) {
        FibHeap FH = new FibHeap();
        FH.insert(9);
        FH.insert(8);
        FH.insert(7);
        FH.insert(6);
        FH.insert(5);
        FH.insert(4);
        FH.insert(3);
        FH.insert(2);
        FH.insert(1);
        FH.extractMin();
        FH.extractMin();
        FH.insert(1);
        FH.insert(2);
        FH.extractMin();
        FH.display();
    }
}