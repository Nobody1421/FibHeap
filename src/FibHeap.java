public class FibHeap{
    LinkedList rootLinked = new LinkedList();

    public void insert(int data){
        Node new_Node = new Node(data);
        rootLinked.push(new_Node);
        cleanup();
    }
    public void extractMin(){
        Node min_Node = rootLinked.peek();
        int degree = min_Node.getDegree();
        if(0 < degree){
            LinkedList nodes_LL = min_Node.nodesLinked;
            for(int i = 0; i < degree; i++){
                Node polledNode = nodes_LL.poll();
                rootLinked.push(polledNode);
                min_Node.nodesLinked = null;
            }
        }
        rootLinked.poll();
        cleanup();
    }
    public void cleanup() {
        LinkedList[] tempStorage = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            tempStorage[i] = new LinkedList();
        }
        int length = rootLinked.length();
        for (int i = 0; i < length; i++) {
            Node temp = rootLinked.poll();
            int nodesDegree = temp.getDegree();
            tempStorage[nodesDegree].push(temp);

            //checks if temp Storage is holding 2 nodes of the same degree to merge them
            if (tempStorage[nodesDegree].length() == 2) {
                Node min_Temp = tempStorage[nodesDegree].poll();
                Node child_Node = tempStorage[nodesDegree].poll();

                min_Temp.nodesLinked.push(child_Node);
                tempStorage[min_Temp.getDegree()].push(min_Temp);
                nodesDegree += 1;

                //in case if the next position in temp storage has 2 positions
                while (tempStorage[nodesDegree].length() == 2) {
                    min_Temp = tempStorage[nodesDegree].poll();
                    child_Node = tempStorage[nodesDegree].poll();

                    min_Temp.nodesLinked.push(child_Node);
                    tempStorage[min_Temp.getDegree()].push(min_Temp);
                    nodesDegree += 1;
                }
            }
        }
        for(int i = 0; i < tempStorage.length;i++){
            if(0 < tempStorage[i].length()){
                rootLinked.push(tempStorage[i].poll());
            }
        }
    }
    public void display(){
        rootLinked.display();
    }
}