public class LinkedList {
    private int nodeCount = 0;
    private Linked_Node root;
    private Linked_Node pointer;
    private class Linked_Node{
        private Node data;
        private Linked_Node tail_Address;
        private Linked_Node head_Address;

        private Linked_Node(Node data){
            this.data = data;
        }
    }
    public void push(Node node){
        Linked_Node New_Node = new Linked_Node(node);
        if(nodeCount == 0){
            pointer = New_Node;
        }
        root = insertHelper(root, New_Node, null);
    }
    public Linked_Node insertHelper(Linked_Node root, Linked_Node node, Linked_Node previous_Node){
        if(root == null){
            if(node.data.value < pointer.data.value){
                pointer = node;
            }
            nodeCount++;
            root = node;
            root.tail_Address = previous_Node;
            return root;
        }
        root.head_Address = insertHelper(root.head_Address, node, root);
        return root;
    }
    public Node poll(){
        if(nodeCount == 0){
            return null;
        }
        Linked_Node sn_Head = pointer.head_Address;
        Linked_Node selected_Node = pointer;
        Linked_Node sn_Tail = pointer.tail_Address;
        Node valuable_data = pointer.data;
        if(sn_Tail == null && sn_Head == null){
            pointer = null;
            root = null;
            newPointer();
            nodeCount--;
            return valuable_data;
        }

        if(sn_Tail == null){
            sn_Head.tail_Address = null;
            selected_Node.head_Address = null;
            root = sn_Head;
            pointer = null;
            newPointer();
            nodeCount--;
            return valuable_data;
        }
        sn_Tail.head_Address = sn_Head;
        if(sn_Head != null){
            sn_Head.tail_Address = sn_Tail;
        }
        pointer = null;
        newPointer();
        nodeCount--;
        return valuable_data;
    }
    public void newPointer(){
        if(pointer == null){
            pointer = root;
        }
        root = pointerHelper(root);
    }
    private Linked_Node pointerHelper(Linked_Node root){
        if(root == null){
            return null;
        }
        if(pointer.data.value > root.data.value){
            pointer = root;
        }
        root.head_Address = pointerHelper(root.head_Address);
        return root;
    }
    public Node peek(){
        if(nodeCount == 0){
            return null;
        }
        return pointer.data;
    }
    public int length(){
        return nodeCount;
    }
    public void display(){
        displayHelper(root);
    }
    private void displayHelper(Linked_Node root){
        if(root != null){
            System.out.print(root.data.value + " ");
            System.out.println("Degree: " + root.data.getDegree());
            displayHelper(root.head_Address);
            if(0 < root.data.getDegree()) {
                displayChild(root.data);
            }
        }
    }
    private void displayChild(Node node){
        System.out.println("^");
        node.nodesLinked.display();
    }
}