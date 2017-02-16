package program.intern;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，
 * 使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * input:
abcda
google

output:
2
2
 * details:
 * abcda  -->  aca
 * google --> gool
 * @author myan
 * 2016年9月4日 下午9:22:06
 * 
 */
public class ConstructPlalindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			int res = remElementNum(str);
			System.out.println(res);
		}
		
	}
	
	public static int remElementNum(String str){
		int lcsCnt = 0, len = str.length();
		String str2 = new StringBuffer(str).reverse().toString();
		lcsCnt = lcs(str, str2);
		return len - lcsCnt;
	}
	
	/**
	 * 动态规划
	 * 
	 * @param str
	 * @param str2
	 * @return
	 */
	public static int lcs(String str,String str2){
		if(str == null || str2 == null){
			return 0;
		}
		int len = str.length(), len2 = str2.length();
		int[][] nums = new int[len+1][len2+1];
		for(int i = 0; i <= len; i++){
			nums[i][0] = 0;
		}
		for(int j = 0; j <= len2; j++){
			nums[0][j] = 0;
		}
		for(int i = 1; i <= len; i++){
			for(int j = 1; j <= len2; j++){
				if(str.charAt(i-1) == str2.charAt(j-1)){
					nums[i][j] = nums[i - 1][j - 1] + 1;
				}else {
					nums[i][j] = nums[i][j - 1] > nums[i - 1][j] ? nums[i][j - 1]:nums[i - 1][j];
				}
			}
		}
		
		return nums[len][len2];
	}
	

}
