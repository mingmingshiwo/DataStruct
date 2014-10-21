package recursion;

/**
 *
 * @author rongzm
 * @data 2014年8月1日
 * @version 1.0
 */

public class Recursion {
	public static int triangel(int n){
		if(n==1){
			return 1;
		}
		return triangel(n-1) + n;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(triangel(3));
		System.out.println(triangel(6));
		
	}
}
