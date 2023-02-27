class Node {
    private int data;
    Node(int data){
        this.data = data;
    }
}
public class Graph{
    private int numOfNodes;
    private Node[][] matrix;
    private boolean isDirected;

    Graph(int numOfNodes, boolean isDirected){
        this.numOfNodes = numOfNodes;
        this.matrix = new Node[numOfNodes][numOfNodes];
        this.isDirected = isDirected;
    }

    void addEdge(int source , int destination){
        if(!isDirected){
            matrix[source][destination] = new Node(1);
            matrix[destination][source] = new Node(1);
        }
        else matrix[source][destination] = new Node(1); /*  for now we are considering for all edges 1, later can add weights too */
    }

    /* this is no traversal only displaying Graph */
    void displayGraph(){
        for(int i=0; i < numOfNodes; i++){
            for(int j=0; j < numOfNodes; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Graph graph = new Graph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.displayGraph();
    }
}