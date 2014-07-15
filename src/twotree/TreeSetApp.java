package twotree;

import java.util.TreeSet;

/**
 *
 * @author rongzm
 * @data 2014年7月14日
 * @version 1.0
 */

public class TreeSetApp {
	public static void main(String[] args) throws Exception {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(50);
		treeSet.add(20);
		treeSet.add(70);
		treeSet.add(10);
		treeSet.add(35);
		treeSet.add(65);
		treeSet.add(100);
		treeSet.add(4);
		treeSet.add(17);
		treeSet.add(40);
		treeSet.add(150);
		System.out.println(treeSet);
	}
}
