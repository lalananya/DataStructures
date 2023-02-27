import java.util.List;
import java.util.ArrayList;


class Node {
    int data;
    ArrayList<Node> subtrees;

    Node(int data){
        this.data = data;
        this.subtrees = new ArrayList<Node>();
    }

}

public class CheckIfBST {
    Node root ;  
    
    void createRoot(Node obj) {
        root = obj;
    }

    void addSubtreeNodes(Node rootObj, Node subtreeObj) {
        rootObj.subtrees.add(subtreeObj);
    }

    void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(" " + root.data + " ");
        for(int i = 0; i< root.subtrees.size(); i++){
            preOrder(root.subtrees.get(i));
        }    
    }

    void bfsSearch(Node rootobj, int data){
        /* Queue */
        Queue<Node> queue = new ArrayList<Node>();
        queue.add(rootobj)

    }

    void dfsSearch(Node rootobj, int data){

    }

    String checkIfBST(Node root){
        if(root != null){
            if(root.subtrees.size() <= 2) {
                for(int i = 0; i< root.subtrees.size(); i++){
                     checkIfBST(root.subtrees.get(i));
                } 
            }
            else {
                return "Not a BST";
            }
        }
        return "BST";
    }

    public static void main(String[] args) {
        CheckIfBST mt = new CheckIfBST();
        CheckIfBST mt_new = new CheckIfBST();
        mt.createRoot(new Node(1));
        mt.addSubtreeNodes(mt.root, new Node(2));
        mt.addSubtreeNodes(mt.root, new Node(3));
        mt.addSubtreeNodes(mt.root, new Node(4));
        mt.addSubtreeNodes(mt.root.subtrees.get(0), new Node(5));
        mt.addSubtreeNodes(mt.root.subtrees.get(0), new Node(6));
        mt.addSubtreeNodes(mt.root.subtrees.get(0), new Node(7));
        mt.addSubtreeNodes(mt.root.subtrees.get(1), new Node(8));
        mt.addSubtreeNodes(mt.root.subtrees.get(2), new Node(9));
        mt.addSubtreeNodes(mt.root.subtrees.get(2), new Node(10));
        mt.addSubtreeNodes(mt.root.subtrees.get(2), new Node(11));
        mt.preOrder(mt.root);

        System.out.println(mt.checkIfBST(mt.root));
        
        mt_new.createRoot(new Node(1));
        mt_new.addSubtreeNodes(mt_new.root, new Node(2));
        mt_new.addSubtreeNodes(mt_new.root, new Node(3));
        mt_new.addSubtreeNodes(mt_new.root.subtrees.get(0), new Node(5));
        mt_new.addSubtreeNodes(mt_new.root.subtrees.get(0), new Node(6));
        mt_new.addSubtreeNodes(mt_new.root.subtrees.get(1), new Node(8));
        mt.preOrder(mt_new.root);

        System.out.println(mt.checkIfBST(mt_new.root));
    }
}
