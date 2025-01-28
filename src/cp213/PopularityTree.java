package cp213;

/**
 * Implements a Popularity Tree. Extends BST.
 *
 * @author your name here
 * @author David Brown
 * @version 2024-10-15
 */
public class PopularityTree<T extends Comparable<T>> extends BST<T> {

    /**
     * Auxiliary method for valid. May force node rotation if the retrieval count of
     * the located node data is incremented.
     *
     * @param node The node to examine for key.
     * @param key  The data to search for. Count is updated to count in matching
     *             node data if key is found.
     * @return The updated node.
     */
    private TreeNode<T> retrieveAux(TreeNode<T> node, final CountedData<T> key) {

	// your code here
    if(node == null) {
    	return null;
    }
    
    int comparison = key.compareTo(node.getData());

    if (comparison < 0) {
        node.setLeft(retrieveAux(node.getLeft(), key));
    } else if (comparison > 0) {
        node.setRight(retrieveAux(node.getRight(), key));
    } else {
        // Key matches node data; increment count
        node.getData().incrementCount();

        // Rotate if needed based on count comparisons
        if (node.getLeft() != null && node.getData().getCount() < node.getLeft().getData().getCount()) {
            node = rotateRight(node);
        } else if (node.getRight() != null && node.getData().getCount() < node.getRight().getData().getCount()) {
            node = rotateLeft(node);
        }
    }
    return node;
    }

    /**
     * Performs a left rotation around node.
     *
     * @param parent The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> parent) {

	// your code here
    TreeNode<T> right = parent.getRight();
    parent.setRight(right.getLeft());
    right.setLeft(parent);
    
    
	return right;
    }

    /**
     * Performs a right rotation around {@code node}.
     *
     * @param parent The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> parent) {

	// your code here
    TreeNode<T> left = parent.getLeft();
    parent.setLeft(left.getRight());
    left.setRight(parent);
    
	return left;
    }

    /**
     * Replaces BST insertAux - does not increment count on repeated insertion.
     * Counts are incremented only on retrieve.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedData<T> data) {

	// your code here
    if(node == null) {
    	return new TreeNode<>(data);
    }
    
    int temp = data.compareTo(node.getData());
    
    if(temp < 0) {
    	node.setLeft(insertAux(node.getLeft(), data));
    	
    } else if(temp > 0) {
    	node.setRight(insertAux(node.getRight(), data));
    }

	return node;
    }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An Popularity Tree must meet the BST validation conditions, and
     * additionally the counts of any node data must be greater than or equal to the
     * counts of its children.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {

	// your code here
    if(node == null) {
    	return true;
    }
    boolean bstTest = (minNode == null || node.getData().compareTo(minNode.getData()) > 0) &&
    		(maxNode == null || node.getData().compareTo(maxNode.getData()) < 0);
    
    boolean popTest = (node.getLeft() == null || node.getData().getCount() >= node.getLeft().getData().getCount()) &&
            (node.getRight() == null || node.getData().getCount() >= node.getRight().getData().getCount());
    

	return bstTest && popTest && isValidAux(node.getLeft(), minNode, node) && isValidAux(node.getRight(), node, maxNode);
    }

    /**
     * Determines whether two PopularityTrees are identical.
     *
     * @param target The PopularityTree to compare this PopularityTree against.
     * @return true if this PopularityTree and target contain nodes that match in
     *         position, data, count, and height, false otherwise.
     */
    public boolean equals(final PopularityTree<T> target) {
	return super.equals(target);
    }

    /**
     * Very similar to the BST retrieve, but increments the data count here instead
     * of in the insertion.
     *
     * @param key The key to search for.
     */
    @Override
    public CountedData<T> retrieve(CountedData<T> key) {

	// your code here
	TreeNode<T> foundNode = retrieveAux(root, key);
	return (foundNode != null && foundNode.getData().compareTo(key) == 0) ? foundNode.getData() : null;

    }

}
