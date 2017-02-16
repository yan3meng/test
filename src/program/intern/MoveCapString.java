package program.intern;

import java.util.Scanner;

/**
 * 
input:
AkleBiCeilD

output:
kleieilABCD
 * @author myan
 * 2016年9月4日 下午9:25:38
 * 
 */
public class MoveCapString {

	public static void main(String[] args) {
//		System.out.println('a' - 0);
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
//			String res = transString(str);
			String res = transStringPriority(str);
			System.out.println(res);
		}
		
	}
	
	public static String transStringPriority(String str){
        char[] chs = str.toCharArray();
        int len = chs.length;
	    int count = 0;
        for(int i = len - 1 - count; i >= 0; i--){
            if(chs[i] > 64 && chs[i] < 91 ){
                char temp = chs[i];
                for(int j=i; j < len -1 - count; j++){
                    chs[j] = chs[j + 1];
                }
                chs[len - 1 - count] = temp;
                ++count;
            }
        }
        return new String(chs);
    }
	
	public static String transString(String str){
		char[] chs = str.toCharArray();
		int len = chs.length;
		int count = 0; // 终止条件 terminal condition
		for(int i = 0; i <= len -1 - count; i++){
			if(chs[i] > 64 && chs[i] < 91 ){
				char temp = chs[i];
				for(int j = i; j < len - 1; j++){
					chs[j] = chs[j + 1];
				}
				chs[len - 1] = temp;
				++count;
				--i;
			}
		}
		return new String(chs);
	}

}
