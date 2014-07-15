package twotree.huffman;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author rongzm
 * @data 2014年7月14日
 * @version 1.0
 */

public class HuffTreeApp {
	public HuffTree build(Map<Integer,Integer> charFreq){
		//优先级队列
		PriorityQueue<HuffTree> priorityQueue = new PriorityQueue<HuffTree>(10,new Comparator<HuffTree>() {
			@Override
			public int compare(HuffTree o1, HuffTree o2) {
				return o1.root.count - o2.root.count;
			}
		});
		
		for(Entry<Integer,Integer> entry:charFreq.entrySet()){
//			System.out.println(entry.getKey()+" "+entry.getValue());
			HuffNode root = new HuffNode(entry.getKey(),entry.getValue());
			HuffTree huffTree = new HuffTree(root);
			priorityQueue.add(huffTree);
		}
		
		while(priorityQueue.size() > 1){
			HuffTree tree1 = priorityQueue.poll();
			HuffTree tree2 = priorityQueue.poll();
			HuffTree newTree = HuffTree.merge(tree1, tree2);
			priorityQueue.offer(newTree);
		}
		
		return priorityQueue.poll();
	}
	
	public static void main(String[] args) throws Exception {
		//SUSIESAYSITISEASY
		Map<Integer,Integer> basicCharFreq = new HashMap<Integer,Integer>();
		basicCharFreq.put((int)'A', 2);
		basicCharFreq.put((int)'E', 2);
		basicCharFreq.put((int)'I', 3);
		basicCharFreq.put((int)'S', 6);
		basicCharFreq.put((int)'T', 1);
		basicCharFreq.put((int)'U', 1);
		basicCharFreq.put((int)'Y', 2);
		
		HuffTreeApp huffTreeApp = new HuffTreeApp();
		HuffTree huffTree = huffTreeApp.build(basicCharFreq);
		Map<Integer,String> codeMap = huffTree.getCodeMap();
		
		String s = "SUSIESAYSITISEASY";
		char[] cs = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c: cs){
			sb.append(codeMap.get( (int)c) );
		}
		String code = sb.toString();
		
		//11101011000111101010011001011001101101011100
		System.out.println("[code]" +code);
		
		String src = huffTree.parse(code);
		System.out.println("[src]" + src);
		
		
		String fileContent = FileUtils.readFileToString(new File("c:/english.txt"), Charset.forName("utf8"));
//		System.out.println(fileContent);
		System.out.println("[filelen]"+fileContent.length());
		
		Map<Integer,Integer> fileCharFreq = new HashMap<Integer,Integer>();
		for(char c:fileContent.toCharArray()){
			Integer freq = fileCharFreq.get((int)c);
			if(freq == null){
				fileCharFreq.put((int)c, 1);
			}else{
				fileCharFreq.put((int)c, ++freq);
			}
		}
//		System.out.println(fileCharFreq.size());
		System.out.println(fileCharFreq);
		huffTree = huffTreeApp.build(fileCharFreq);
		codeMap = huffTree.getCodeMap();
		sb = new StringBuilder();
		for(char c: fileContent.toCharArray()){
			sb.append(codeMap.get( (int)c) );
		}
		code = sb.toString();
		System.out.println(code.length()/8);
		System.out.println("[code]" +code.substring(0,1000));
		src = huffTree.parse(code);
//		System.out.println("[src]\r\n" + src);
		System.out.println((char)32);
	}
}
