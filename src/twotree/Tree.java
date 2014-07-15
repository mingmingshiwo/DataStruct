package twotree;

/**
 *
 * @author rongzm
 * @data 2014年7月11日
 * @version 1.0
 */

public class Tree {
	Node root;
	
//	public Node find(int key){
//		if(root == null){
//			return null;
//		}
//		Node current = root;
//		while(key != current.iData){
//			if(key<current.iData){
//				current = current.leftChild;
//			}else{
//				current = current.rightChild;
//			}
//			if(current == null){
//				return null;
//			}
//		}
//		return current;
//	}
	
	public Node find(int key){
		Node current = root;
		while(current != null){
			if(current.iData == key){
				break;//get it
			}else if(key < current.iData){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
		}
		return current;
	}
	
//	public void insert(int key,double data){
//		Node node = new Node(key,data);
//		if(root == null){
//			root = node;
//		}else{
//			Node current = root;
//			while(true){
//				if(key < current.iData){
//					if(current.leftChild == null){
//						current.leftChild = node;
//						return;//开始忘记加return了
//					}else{
//						current = current.leftChild;
//					}
//				}else{
//					if(current.rightChild == null){
//						current.rightChild = node;
//						return;
//					}else{
//						current = current.rightChild;
//					}
//				}
//			}
//		}
//	}
	
	public void insert(int key,double data){
		Node node = new Node(key,data);
		if(root == null){
			root = node;
		}else{
			Node current = root;
			Node parent = root;
			boolean isLeftChild = false;
			while(current != null){
				parent = current;
				if(key < current.iData){
					isLeftChild = true;
					current = current.leftChild;
				}else{
					isLeftChild = false;
					current = current.rightChild;
				}
			}
			if(isLeftChild){
				parent.leftChild = node;
			}else{
				parent.rightChild = node;
			}
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	public void preOrder(){
		preOrder(root);
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	public void inOrder(Node node){
		if(node != null){
			inOrder(node.leftChild);
			System.out.printf("[%s] ", node.iData);
			inOrder(node.rightChild);
		}
	}
	
	public void preOrder(Node node){
		if(node != null){
			System.out.printf("[%s] ", node.iData);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	public void postOrder(Node node){
		if(node!=null){
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.printf("[%s] ", node.iData);
		}
	}
	
	public int min(){
		if(root == null){
			return -1;
		}
		Node current = root;
		while(current.leftChild != null){
			current = current.leftChild;
		}
		return current.iData;
	}
	
	public int max(){
		if(root == null){
			return -1;
		}
		Node current = root;
		while(current.rightChild != null){
			current = current.rightChild;
		}
		return current.iData;
	}
	
//	铭记啊，指针的指针 和 指针的区别
//	或者说是 引用复制 和 引用的 区别
//	public void insert(int key, double data){
//		Node node = new Node(key,data);
//		if(root == null){
//			root = node;
//		}else{
//			Node current = root;
//			while(current != null){
//				if(key < current.iData){
//					current = current.leftChild;
//				}else{
//					current = current.rightChild;
//				}
//			}
//			current = node;
//		}
//	}
	
	public boolean delete(int key){
		if(root==null){
			return false;
		}
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		while(key != current.iData){
			parent = current;
			if(key<current.iData){
				isLeftChild = true;
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if(current == null){
				return false;
			}
		}
		//find node to delete
		
		//no children,simple delete it
		if(current.leftChild==null && current.rightChild==null){
			if(current == root){
				root = null;
			}else if(isLeftChild){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}else if(current.rightChild == null){
			if(current == root){
				current.leftChild = root;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.leftChild;
			}
		}else if(current.leftChild == null){
			if(current == root){
				current.rightChild = root;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}
		
		return false;
	};
	
	private Node getSuccessor(Node delNode){
		return null;
	}
}
