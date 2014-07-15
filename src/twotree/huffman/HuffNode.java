package twotree.huffman;

/**
 *
 * @author rongzm
 * @data 2014年7月14日
 * @version 1.0
 */

public class HuffNode {
	int c;
	int count;
	HuffNode leftChild;
	HuffNode rightChild;
	public HuffNode(int c, int count) {
		super();
		this.c = c;
		this.count = count;
	}
	@Override
	public String toString() {
		return String.format("[%s,%s]", c, count);
	}
}
