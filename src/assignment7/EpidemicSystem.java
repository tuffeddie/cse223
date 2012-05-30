package assignment7;

public class EpidemicSystem {
	Node root = null;

	static class Node {
		Node left;
		Node right;
		double patient;
	
		public Node( double value ) {
			this.patient = value;
		}
	
		public double getPatient() {
			return patient;
		}
	
		public void setLeftChild(Node root) {
			this.left = root;
		}
	
		public boolean delete(double value, Node parent) {
			if (value < this.patient) {
				if (left != null)
					return left.delete(value, this);
				else
					return false;
			} else if (value > this.patient) {
				if (right != null)
					return right.delete(value, this);
				else
					return false;
			} else {
				if (left != null && right != null) {
					this.patient = right.minValue();
					right.delete(this.patient, this);
				} else if (parent.left == this) {
					parent.left = (left != null) ? left : right;
				} else if (parent.right == this) {
					parent.right = (left != null) ? left : right;
				}
				return true;
			}
		}
	
		private double minValue() {
			if ( left == null)
				return patient;
			else
				return left.minValue();
		}
	
		public Node getLeft() {
			return this.left;
		}
	}
	
	public void insert( Node node, double patient) {
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

	public Node search( Node node, double patient ) {
		while( node.patient != patient && node != null ) {
			if( patient < node.patient ) node = node.left;
			else if( patient > node.patient ) node = node.right;
			else node = node.right;
		}
		return node;
	}
	
	public boolean inTree( Node node, double patient ) {
		if( search(node, patient) != null) return true;
		return false;
	}
	
	public boolean delete(double value) {
		if (root == null)
			return false;
		else {
			if (root.getPatient() == value) {
				Node auxRoot = new Node(0);
				auxRoot.setLeftChild(root);
				boolean result = root.delete(value, auxRoot);
				root = auxRoot.getLeft();
				return result;
			} else {
				return root.delete(value, null);
			}
		}
	}
	
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(" Traversed " + node.patient);
			printInOrder(node.right);
		}
	}
	
	public static void main( String[] agrs) {
		new EpidemicSystem().run();
	}
	
	public void run() {
		Node root = new Node(10);
		this.root = root;
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
		delete(15);
		printInOrder(root);
	}
}
