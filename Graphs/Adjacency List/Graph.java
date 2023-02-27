import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node {
    private int data;
    private String name;
    Node(int data, String name){
        this.data = data;
        this.name = name;
    }
}
public class Graph{
    
    private HashMap<Integer, ArrayList<Integer>> adjacencyList;

    Graph(){
        adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    }

    void addEdge(int source, int destination){
        ArrayList<Integer> temp = adjacencyList.get(source);
        if(temp == null){
            temp = new ArrayList<Integer>();
        }   
        temp.add(destination);
        adjacencyList.put(source, temp);
    }

    /* this is not traversal, only displaying graph */
    void displayGraph(){
        
        for(HashMap.Entry<Integer,ArrayList<Integer>> entry : adjacencyList.entrySet()){
            System.out.println("Key = " +  entry.getKey() + entry.getValue());
        }
    }

    void dfsTraversal(){
        
    }

    public static void main(String args[]){
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        System.out.println(graph);
        graph.displayGraph();
        
    }
}