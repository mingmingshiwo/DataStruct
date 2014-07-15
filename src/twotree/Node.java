package twotree;

/**
 *
 * @author rongzm
 * @data 2014年7月11日
 * @version 1.0
 */

public class Node {
	int iData;
	double otherData;
	Node leftChild;
	Node rightChild;
	
	public Node(int idata,double otherData){
		this.iData = idata;
		this.otherData = otherData;
	}

	@Override
	public String toString() {
		return String.format(
				"Node [iData=%s, leftChild=%s, rightChild=%s]",
				iData,leftChild, rightChild);
	}
}
