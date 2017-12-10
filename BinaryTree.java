/*
 * This class defines a binary tree data structure along with utility methods
 * to make it useful.
 */
public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	/*
	 * Methods to insert a new node into the tree.
	 * 
	 * insertNode inserts a new node into the subtree with root
	 * node topNode and returns the new tree structure back with the
	 * same root node.
	 * 
	 * insert is the public interface to the subtreeInsert method and will
	 * be the method actually invoked by the calling program.  Methods like
	 * it are often called "wrapper" methods because they "wrap" the private
	 * methods that do all of the work in a more convenient interface.
	 */
	public void insert(int newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, int newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord < topNode.record) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	
	/*
	 * Methods to perform an in-order tree traversal.
	 * 
	 * The inOrderSubtree method does all of the work, with inOrder
	 * serving as a wrapper method (see above).
	 */
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a pre-order traversal.
	 */
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a post-order traversal.
	 */
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {	
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	
	/*
	 * Methods to calculate the size (number of nodes) in a tree.
	 */
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			return subtreeSize(topNode.left) + subtreeSize(topNode.right) + 1;
		}
	
	}
	
	
	/*
	 * Methods to calculate the maximum depth of a tree.
	 */
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			if ((subtreeMaxDepth(topNode.left) + 1) < (subtreeMaxDepth(topNode.right) + 1)) {
				return subtreeMaxDepth(topNode.right) + 1;
		}	else {
				return subtreeMaxDepth(topNode.left) + 1;
		}
	 }
	}
	
	/*
	 * Methods to calculate the minimum depth of a tree.
	 */
	
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	
	private int subtreeMinDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			if ((subtreeMinDepth(topNode.left) + 1) <= (subtreeMinDepth(topNode.right) + 1)) {
				return subtreeMinDepth(topNode.left) + 1;
			} else {
				return subtreeMinDepth(topNode.right) + 1;
			}
		}
	}
	
	/*
	 * Methods to calculate the number of times key occurs in the tree
	 */
	public int countMatches(int key) {
		return subtreeCountMatches(root, key);
	}
	
	private int subtreeCountMatches(Node topNode, int key) {
		if (topNode == null) {
			return 0;
		} else {
			if (key == topNode.record) {
				return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key) + 1;
			} else {
				return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key);
			}
		}
	}
	
	/*
	 * Methods to calculate the value of the largest record in the tree
	 */
	public int maxRecord() {
		return treeMaxRecord(root);
	}
	
	private int treeMaxRecord(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			if (topNode.record < (treeMaxRecord(topNode.left) + 1) && (treeMaxRecord(topNode.right) + 1) < treeMaxRecord(topNode.left) + 1) {
				return treeMaxRecord(topNode.left);
			} else if ((treeMaxRecord(topNode.left) + 1) < topNode.record && (treeMaxRecord(topNode.right) + 1) < topNode.record)  {
				return topNode.record;
			} else if (topNode.record < (treeMaxRecord(topNode.right) + 1) && (treeMaxRecord(topNode.left) + 1) < (treeMaxRecord(topNode.right) + 1)) {
				return treeMaxRecord(topNode.right);
			} 
		}
		return 0;
	}
	
	/*
	 * Methods to calculate the value of the smallest record in the tree
	 */
	public int minRecord() {
		return treeMinRecord(root);
	}
	
	private int treeMinRecord(Node topNode) {
		// checks if the top of the node is null, if so, returns a value of 0
		if (topNode == null) {
			return 0;
		} else {
			if (topNode.record < (treeMinRecord(topNode.right) + 1) && topNode.record < (treeMinRecord(topNode.left) + 1)) {
				return topNode.record;
			} else if ((treeMinRecord(topNode.left) + 1) < (treeMinRecord(topNode.right) + 1) && (treeMinRecord(topNode.left) + 1) < topNode.record) {
				return treeMinRecord(topNode.left);
			} else if ((treeMinRecord(topNode.right) + 1) < topNode.record && (treeMinRecord(topNode.right) + 1) < (treeMinRecord(topNode.left) + 1)) {
				return treeMinRecord(topNode.right);
			}
		}
		return 0;
	}
	
	public void removeNode(int key) {
		root = subtreeRemoveNode(root, key);
	}
	
	/*
	 * Method to remove the node with the specified search key and returns the top node of the updated subtree
	 */
	private Node subtreeRemoveNode(Node topNode, int key) {
		if (topNode == null) {
			return null;
		  // searches for node to delete
		} else if (key < topNode.record) {
			topNode.left = subtreeRemoveNode(topNode.left, key);
		} else if (key > topNode.record) {
			topNode.right = subtreeRemoveNode(topNode.right, key);
		} else  {
			// checks if node is a leaf
			if (topNode.left == null && topNode.right == null) {
				topNode = null; 
			} else if (topNode.right == null) {
				Node currentNode = topNode;
				topNode = topNode.left;
				currentNode = null;
			} else if (topNode.left == null) {
				Node currentNode = topNode;
				topNode = topNode.right;
				currentNode = null;
			} else {
				int rightMin = treeMinRecord(topNode.right);
				topNode.record = rightMin;
				topNode.right = subtreeRemoveNode(topNode.right, key);
		}
	}
		return topNode;
 }
	
}
	
