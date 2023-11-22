package LLRB.src;

public class LLRB<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
            this.color = RED;
        }
    }

    public Value search(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x.value;
            else if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
        }
        return null;
    }

    public void insert(Key key, Value value){
        root = insert(root, key, value);
        root.color = BLACK;
    }

    private Node insert(Node node, Key key, Value value){

        if(node == null){
            return new Node(key, value);
        }

        if(isRed(node.left) && isRed(node.right)){
            colorFlip(node);
        }

        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            node.value = value;
        }else if(cmp < 0){
            node.left =  insert(node.left, key, value);
        }else{
            node.right =  insert(node.right, key, value);
        }

        if(isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }

        return node;
    }

    private Node rotateLeft(Node node){
        Node copyNode = node.right;
        node.right = copyNode.left;
        copyNode.left = node;
        copyNode.color = node.color;
        node.color = RED;
        return copyNode;
    }
    
    private Node rotateRight(Node node){
        Node copyNode = node.left;
        node.left = node.right;
        copyNode.right = node;
        copyNode.color = node.color;
        node.color = RED;
        return copyNode;
    }

    private void colorFlip(Node node){
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private boolean isRed(Node node){
        return node != null && node.color == RED;
    }

}
