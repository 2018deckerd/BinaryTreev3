/**
 * This is a tester program for the BinaryTree class
 * @author Michael Ida
 *
 */
public class BinaryTreeTester {
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		int[] inputData = {20, 15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
		
		for (int elem : inputData) {
			tree.insert(elem);
		}
		
		System.out.println("In-Order Traversal");
		tree.inOrder();
		System.out.println("\n\n");
		// should be: -150, -5, 0, 12, 15, 20, 20, 25, 100, 126, 200, 1000
		
		System.out.println("Pre-Order Traversal");
		tree.preOrder();
		System.out.println("\n\n");
		// should be: 20, 15, -5, -150, 0, 12, 200, 25, 20, 100, 126, 1000
		
		System.out.println("Post-Order Traversal");
		tree.postOrder();
		System.out.println("\n\n");
		// should be: -150, 12, 0, -5, 15, 20, 126, 100, 25, 1000, 200, 20
		
		System.out.println("Size: " + tree.size());
		// should be: 12
		
		System.out.println("Maximum Depth: " + tree.maxDepth());
		//should be: 5
		
		System.out.println("Minimum Depth: " + tree.minDepth());
		System.out.println("\n");
		// should be: 2
		
		System.out.println("Tests for the number of appearances of specific numbers");
		System.out.println("Appearances of number 20: " + tree.countMatches(20));
		// should be: 2
		System.out.println("Appearances of number 100: " + tree.countMatches(100));
		// should be: 1
		System.out.println("\n");
		
		System.out.println("Largest value of tree");
		System.out.println("Maximum: " + tree.maxRecord());
		// should be: 1000
		System.out.println("\n");
		
		System.out.println("Smallest value (record) of tree");
		System.out.println("Minimum: " + tree.minRecord());
		// should be: -150
		System.out.println("\n");
		
		/*
		 * Test #2 (Made by Dylan)
		 */
		System.out.println("TEST 2");
		System.out.println("-----------------------");
		
		BinaryTree tree2 = new BinaryTree();
		int[] inputData2 = {50, 37, 100, -50, 41, -1000, 43, 65, 53, 123, 111};
		
		for (int elem : inputData2) {
			tree2.insert(elem);
		}
		
		System.out.println("In-Order Traversal");
		tree2.inOrder();
		System.out.println("\n\n");
		// should be: -1000, -50, 37, 41, 43, 50, 53, 65, 100, 111, 123
		
		System.out.println("Pre-Order Traversal");
		tree2.preOrder();
		System.out.println("\n\n");
		// should be: 50, 37, -50, -1000, 41, 43, 100, 65, 53, 123, 111
		
		System.out.println("Post-Order Traversal");
		tree2.postOrder();
		System.out.println("\n\n");
		// should be: -1000, -50, 43, 41, 37, 53, 65, 111, 123, 100, 50
		
		System.out.println("Size: " + tree2.size());
		// should be: 11
		
		System.out.println("Maximum Depth: " + tree2.maxDepth());
		//should be: 4
		
		System.out.println("Minimum Depth: " + tree2.minDepth());
		System.out.println("\n");
		// should be: 3
		
		System.out.println("Tests for the number of appearances of specific numbers");
		System.out.println("Appearances of number 37: " + tree2.countMatches(37));
		// should be: 1
		System.out.println("Appearances of number 123: " + tree2.countMatches(123));
		// should be: 1
		System.out.println("Appearances of number 57: " + tree2.countMatches(57));
		// should be: 0
		System.out.println("\n");
		
		System.out.println("Largest value of tree");
		System.out.println("Maximum: " + tree2.maxRecord());
		// should be: 123
		System.out.println("\n");
		
		System.out.println("Smallest value (record) of tree");
		System.out.println("Minimum: " + tree2.minRecord());
		// should be: -1000
		System.out.println("\n");
		
		System.out.println("In-Order Traversal with deleted element -1000.");
		tree2.removeNode(-1000);
		tree2.inOrder();
		System.out.println("\n");
		// node with record -1000 should be deleted
		
		System.out.println("Pre-Order Traversal with deleted element -1000.");
		tree2.removeNode(-1000);
		tree2.preOrder();
		System.out.println("\n");
		// node with record -1000 should be deleted
		
		System.out.println("Post-Order Traversal with deleted element -1000.");
		tree2.removeNode(-1000);
		tree2.postOrder();
		// node with record -1000 should be deleted
		
		
	
	}

}
