package assignment7;

public class EpidemicSystem {
	
	static class Node {
		Node left;
		Node right;
		int patient;
		
		public Node( int value ) {
			this.patient = value;
		}
	}

	public void insert( Node node, int patient) {
		if ( patient < node.patient) {
			if ( node.left != null ) {
				insert( node.left, patient );
			} else {
				node.left = new Node(patient);
			}
		} else if ( patient > node.patient) {
			if ( node.right != null ) {
				insert( node.right, patient );
			} else {
				node.right = new Node(patient);
			}
		}
	}
	
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println("  Traversed " + node.patient);
			printInOrder(node.right);
		}
	}
	
	public static void main( String[] agrs) {
		new EpidemicSystem().run();
	}
	
	public void run() {
		Node root = new Node(10);
		insert(root, 6);
		insert(root, 9);
		insert(root, 15);
		insert(root, 20);
		insert(root, 2);
		insert(root, 5);
		insert(root, 9);
		insert(root, 18);
		insert(root, 19);
		printInOrder(root);
		
	}
}
