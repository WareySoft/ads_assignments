public class MyBST {

    private Node root;

    private class Node {
        private int key;
        private int value;
        private Node left, right;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    MyBST(){
        root = null;
    }

    void deleteKey(int key) {
        int val = getValue(root, key);
        root = deleteNode(root, val);
    }



    Node deleteNode(Node root, int value)  {
        if (root == null){
            return root;
        }

        if (value < root.value){
            root.left = deleteNode(root.left, value);
        }

        else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        }

        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minKey(root.right);
            root.value = minValue(root.right);

            root.right = deleteNode(root.right, root.value);
        }
        return root;
    }

    int minValue(Node root)  {
        int minval = root.value;
        while (root.left != null)  {
            minval = root.left.value;
            root = root.left;
        }
        return minval;
    }

    int minKey(Node root)  {
        int minkey = root.key;
        while (root.left != null)  {
            minkey = root.left.key;
            root = root.left;
        }
        return minkey;
    }

    public void insert(int key, int value )  {
        root = insertNode(root, key, value);
    }

    private Node insertNode(Node root, int key, int value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }
        if (value < root.value) {
            root.left = insertNode(root.left, key, value);
        }

        else if (value > root.value){
            root.right = insertNode(root.right, key, value);
        }
        return root;
    }

    void iterator() {
        tirator(root);
    }

    void tirator(Node root) {
        if (root != null) {
            tirator(root.left);
            System.out.print(root.value + " ");
            tirator(root.right);
        }
    }

    public int getValue(Node node, int key) {
        if(node.key == key){
            return node.value;
        }
        if(node.left != null) {
            return getValue(node.left, key);
        }
        return getValue(node.right, key);
    }

    public void get( int key) {
        System.out.println(getValue(root,key));
    }


}
