/*
 * Binary search tree data structure
 * @author :
 */

public class BST<T extends Comparable<T>>
{
    /*
     * The root of the BST
     */
    Node<T> root;

    // constructor for BST
    public BST()
    {
        root = null;
    }


    /*
     * Node class for a BST
     */
    public static class Node<T>
    {
        Comparable<T> data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(Comparable<T> item)
        {
            data = item;
            instance = 1;
        }

        Node(Node<T> left, Node<T> right, Comparable<T> item) {
            this.data = item;
            this.left = left;
            this.right = right;
        }


    }

    /*
     * Find function that finds an item in the BST
     * @param item to be found
     * @return boolean if the item was found
     */
    public boolean find(Comparable<T> item)
    {
        return find(root, item);
    }

    /*
     * Function override of the find function
     * @param item to be found
     * @param node the current node you are at
     * @return boolean if the item was found
     */
    private boolean find(Node<T> node, Comparable<T> item)
    {
        if (node == null) {
            return false;
        }
        if (item == node.data) {
            return true;
        }
        else if (item.compareTo((T) node.data) < 0) {
            return find(node.left, item);
        }
        else {
            return find(node.right, item);
        }
    }

    /*
     * Insert an item to the tree
     * @param item to insert
     */
    public void insert(Comparable<T> item)
    {
        root = insert(root, item);
    }

    /*
     * Helper function for insert
     * @param item to add
     * @param node you are at
     * @return node you traverse to
     */
    protected Node<T> insert(Node<T> node, Comparable<T> item)
    {
        // if current root has not been previously instantiated
        // instantiate a new Node with item added as the data
        if (node == null) {
            return new Node<T>(item); // when your node is null, insert at leaf
        }
        if (item.compareTo((T) node.data) < 0) {
            node.left = insert(node.left,item);
        }
        else {
            node.right = insert(node.right,item);
        }
        return node; // re-link the nodes
    }

    /*
     * Function for deletion of a node
     * @param item to delete
     */
    public void delete(Comparable<T> item)
    {
        root = delete(root,item);
    }

    /*
     * Helper function for deletion of a node
     * @param item to delete
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> delete(Node<T> node,Comparable<T> item) {
        if (node == null) { // this is the base case
            return null;
        }
        if (node.data.compareTo((T) item) < 0) {
            node.right = delete(node.right, item);
            return node;
        }
        else if (node.data.compareTo((T) item) > 0) {
            node.left = delete(node.left, item);
            return node;
        }
        else { // the item == node.data
            if (node.left == null) {       // no left child
                return node.right;
            }
            else if (node.right == null) { // no right child
                return node.left;
            }
            else {                              // 2 children: find in-order successor
                if (node.right.left == null) {  // if right child does not have a left child of its own
                    node.data = node.right.data;
                    node.right = node.right.right;
                }
                else {
                    node.data = (Comparable<T>) removeSmallest(node.right); // if the right child has two children, or has a left subtree
                }
                return node;
            }
        }
    }

    Node<T> removeSmallest(Node<T> node) {
        if (node.left.left == null) { // if we have nothing to the left of that left, then that left is the smallest
            Node<T> smallest = (Node<T>) node.left.data;
            node.left = node.left.right; // promote its grandchild
            return smallest;
        }
        else {
            return removeSmallest(node.left); // recursively call removeSmallest on its left side
        }
    }

    /*
     * Function to find the range sum of the binary tree.
     * @param L the left bound
     * @param R the right bound
     * @return The sum of the range in the binary tree
     */
    public int rangeSum(int L, int R)
    {
        int sum;
        return sum = rangeSum(root, L, R);

    }

    protected int rangeSum(Node<T> node, int L, int R) {
        if (node == null) {
            return 0;
        }
        if ((Integer) node.data < L ) {
            return rangeSum(node.right, L, R);
        }
        if ((Integer) node.data > R) {
            return rangeSum(node.left, L, R);
        }
        return (Integer) node.data + rangeSum(node.right, L, R) + rangeSum(node.left, L, R);
    }


    /*
     * Function to print the Binary tree
     */
    public void print()
    {
        print(root);
    }

    /*
     * Helper Function to print the Binary tree
     * @param root the root of the tree
     */
    protected void print(Node<T> root)
    {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }
}