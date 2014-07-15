package twotree.huffman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rongzm
 * @data 2014年7月14日
 * @version 1.0
 */

public class HuffTree {
	HuffNode root;
	
	public HuffTree(HuffNode root){
		this.root = root;
	}
	
	public Map<Integer,String> getCodeMap(){
		Map<Integer,String> result = new HashMap<Integer,String>();
		inorder(root,"",result);
		return result;
	}
	
	public String parse(String code){
		StringBuilder result = new StringBuilder();
		char[] cs = code.toCharArray();
//		System.out.println(Arrays.toString(cs));
		HuffNode current = root;
		for(char c:cs){
			if(c=='0'){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if(current.leftChild == null && current.rightChild == null){
//				System.out.println(current.c);
				result.append((char)current.c);
				current = root;
			}
		}
		return result.toString();
	}
	
	public void inorder(HuffNode node,String path,Map<Integer,String> result){
		if(node!=null){
			inorder(node.leftChild,path+"0",result);
			if(node.leftChild==null && node.rightChild == null){
				result.put(node.c, path);
				System.out.println(node.c + " " + path);
			}
			inorder(node.rightChild,path+"1",result);
		}
	}
	
	public static HuffTree merge(HuffTree t1,HuffTree t2){
		int count = t1.root.count + t2.root.count;
		HuffNode newRoot = new HuffNode(-1,count);
		newRoot.leftChild = t1.root;
		newRoot.rightChild = t2.root;
		return new HuffTree(newRoot);
	}

	@Override
	public String toString() {
		return String.format("[%s]", root);
	}
	
	
}
