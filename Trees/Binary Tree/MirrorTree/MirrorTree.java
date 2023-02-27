class Node {
    int data;
    Node left;
    Node right;

    Node(int item){
        data = item;
        left = right = null;
    }
}

public class MirrorTree {
    
    Node root;

    void createRoot(Node obj) {
        root = obj;
    }

    void addNodeToLeft(Node rootObj, Node currentObj){
        rootObj.left = currentObj;
    }

    void addNodeToRight(Node rootObj, Node currentObj){
        rootObj.right = currentObj;
    }

    void MirrorTree(Node rootObj){
        if(rootObj == null){
            return;
        }
        Node left_temp = rootObj.left;
        Node right_temp = rootObj.right;
        rootObj.left = right_temp;
        rootObj.right = left_temp;
        MirrorTree(rootObj.left);
        MirrorTree(rootObj.right);
    }

    void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        MirrorTree mt = new MirrorTree();
        mt.createRoot(new Node(1));
        mt.addNodeToLeft(mt.root, new Node(2));
        mt.addNodeToRight(mt.root, new Node(3));
        mt.addNodeToLeft(mt.root.left, new Node(4));
        mt.addNodeToRight(mt.root.left, new Node(5));
        mt.addNodeToLeft(mt.root.right, new Node(6));
        mt.preOrder(mt.root);
        mt.MirrorTree(mt.root);
        mt.preOrder(mt.root);

    }
}
