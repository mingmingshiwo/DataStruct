package recursion;

/**
 *
 * @author rongzm
 * @data 2014年8月1日
 * @version 1.0
 */

public class ResFind {
	private Long[] array;
	
	public ResFind(Long[] array){
		this.array = array;
	}
	
	public boolean find(Long val){
		int result = orderFind(val,0,array.length-1);
		System.out.println(result);
		if(result >= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean findNoOrder(Long val){
		int result = disorderFind(val,0,array.length-1);
		System.out.println(result);
		if(result >= 0){
			return true;
		}else{
			return false;
		}
	}
	
	private int orderFind(Long val, int start, int end){
		if(end < start){
			return -1;
		}
		
		int cur = (start+end)/2;
		Long curVal = array[cur];
		if(curVal == val){
			return cur;
		}
		
		if(val < curVal){
			return orderFind(val,start,cur-1);
		}else{
			return orderFind(val,cur+1,end);
		}
	}
	
	private int disorderFind(Long val, int start, int end){
		if(end < start){
			return -1;
		}
		
		int cur = (start+end)/2;
		Long curVal = array[cur];
		if(curVal == val){
			return cur;
		}
		
		int less = orderFind(val,start,cur-1);
		if(less >= 0){
			return less;
		}
		int more = orderFind(val,cur+1,end);
		if(more >=0){
			return more;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		Long[] array = new Long[]{2l,4l,5l,7l,8l,9l,15l,17l,19l,20l};
		ResFind find1 = new ResFind(array);
		System.out.println(find1.find(17l));
		System.out.println(find1.find(12l));
		System.out.println(find1.findNoOrder(17l));
		
		Long[] array2 = new Long[]{2l,44l,58l,73l,8l,9l,158l,17l,19l,20l};
		ResFind find2 = new ResFind(array2);
		System.out.println(find2.findNoOrder(8l));
		System.out.println(find2.findNoOrder(12l));
	}
}
