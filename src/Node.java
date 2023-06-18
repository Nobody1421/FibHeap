public class Node {
    LinkedList nodesLinked = new LinkedList();;
    int value;

    public Node(int value){
        this.value = value;
    }
    public int getDegree(){
        if(nodesLinked == null){
            return 0;
        }
        return nodesLinked.length();
    }
}
