class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node root ;  
    
    void createRoot(Node obj) {
        root = obj;
    }

    void addNodeToLeft(Node rootObj, Node currentObj) {
        rootObj.left = currentObj;
    }

    void addNodeToRight(Node rootObj, Node currentObj) {
        rootObj.right = currentObj;
    }

    void displayTree(Node root) {
        System.out.print("\n");
        inOrder(root);
        System.out.print("\n");
        preOrder(root);
        System.out.print("\n");
        postOrder(root);
    }

    void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }

    public static void main(String[] args) {
        BinarySearchTree mt = new BinarySearchTree();
        mt.createRoot(new Node(1));
        mt.addNodeToLeft(mt.root, new Node(2));
        mt.addNodeToRight(mt.root, new Node(3));
        mt.addNodeToLeft(mt.root.left, new Node(4));
        mt.addNodeToRight(mt.root.left, new Node(5));
        mt.addNodeToLeft(mt.root.right, new Node(6));
        mt.displayTree(mt.root);
    }
}
