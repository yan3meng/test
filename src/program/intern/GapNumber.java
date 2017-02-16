package program.intern;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？
 * input:
6
45 12 45 32 5 6

output:
1 2
 * @author myan
 * 2016年9月5日 上午9:52:45
 * 
 */
public class GapNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int len = in.nextInt();
			int[] arr = new int[len];
			for(int i =0; i < len; i++){
				arr[i] = in.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
//			MaxMinGapNumber(arr, len);
			MaxMinGapNumberImpv(arr, len);
		}

	}
	
	public static void MaxMinGapNumberImpv(int[] arr, int len){
//		if(arr == null || arr.length == 0){
//			return;
//		}
		Arrays.sort(arr);
		if(arr[0] == arr[len - 1]){
			int res = ((len) * (len - 1))/2;
			System.out.println(res + " " + res);
			return;
		}
//		int maxGap = Integer.MIN_VALUE;
		int maxNum = 0;
		int minGap = Integer.MAX_VALUE;
		int minNum = 0;
		// statistical the maxNum of maxGap
//		maxGap = arr[len - 1] - arr[0];
		int i = len - 1;
		while(i >= 0 && arr[i] == arr[len - 1]){
//			++maxNum;
			int j = 0;
			while(j < len && arr[j] == arr[0]){
				++maxNum;
				++j;
			}
			--i;
		}
		// statistical the minNum of maxGap
		for(i = 1; i < len; i++){ // initial gap arrays ,override the original arr
			arr[i - 1] = arr[i] - arr[i - 1];
		}
		for(i = 0; i < len; i++){
			if(arr[i] < minGap){
				minGap = arr[i];
				minNum = 1;
			}else if(arr[i] == minGap){
				++minNum;
			}
		}
		if(minGap == 0){
			for(i = 0; i < len; i++){
				int zeroCount = 0;
				while(arr[i] == 0){
					++zeroCount;
					++i;
				}
				minNum += ((zeroCount) * (zeroCount - 1))/2;
			}
		}
		
		System.out.println(minNum + " " + maxNum);
	}
	
	public static void MaxMinGapNumber(int[] arr, int len){
//		if(arr == null || arr.length == 0){
//			return;
//		}
		Arrays.sort(arr);
		if(arr[0] == arr[len - 1]){
			int res = ((len) * (len - 1))/2;
			System.out.println(res + " " + res);
			return;
		}
//		int maxGap = Integer.MIN_VALUE;
		int maxNum = 0;
		int minGap = Integer.MAX_VALUE;
		int minNum = 0;
		// statistical the maxNum of maxGap
//		maxGap = arr[len - 1] - arr[0];
		int i = len - 1;
		while(i >= 0 && arr[i] == arr[len - 1]){
//			++maxNum;
			int j = 0;
			while(j < len && arr[j] == arr[0]){
				++maxNum;
				++j;
			}
			--i;
		}
		// statistical the minNum of maxGap
		// timeout
		for(i = 1; i < len; i++){
			int j = 0;
			while(j >=0 && j < i){
				if(arr[i] - arr[j] < minGap){
					minGap = arr[i] - arr[j];
					minNum = 1;
				}else if(arr[i] - arr[j] == minGap){
					++minNum;
				}
				++j;
			}
		}
		
		
		System.out.println(minNum + " " + maxNum);
	}

}
