package twotree;

/**
 *
 * @author rongzm
 * @data 2014年7月11日
 * @version 1.0
 */

public class TreeApp {
	public static void main(String[] args) throws Exception{
		Tree tree = new Tree();
		tree.insert(50, 1.5);
		tree.insert(20, 3.4);
		tree.insert(70, 2.4);
		tree.insert(10, 160.0);
		tree.insert(35, 170.0);
		tree.insert(65, 10.0);
		tree.insert(100, 8.9);
		tree.insert(4, 4.0);
		tree.insert(17,17.0);
		tree.insert(40, 40.0);
		tree.insert(150, 150.0);
		
		
		Node found = tree.find(65);
		System.out.println(found);
		System.out.println(tree.find(20));
		
//		System.out.println(tree.root);
		tree.inOrder();
		System.out.println();
		tree.preOrder();
		System.out.println();
		tree.postOrder();
		System.out.println();
		
		System.out.println(tree.min());
		System.out.println(tree.max());
	}
}
