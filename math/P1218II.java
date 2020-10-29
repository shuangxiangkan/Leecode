package math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class P1218II {
	public static void main(String[] args) {
//		int[] arr= {-6,6,-8,0,7,-8,5,-7,10,-10};
//		int difference=-6;
		int[] arr= {1,5,7,8,5,3,4,2,1};
		int difference=-2;
		P1218II p=new P1218II();
		System.out.println(p.longestSubsequence(arr, difference));
	}
	public int longestSubsequence(int[] arr, int difference) {
		int ans=0;
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i : arr) {
			int k=i-difference;
			int temp=map.getOrDefault(k, 0)+1;
			map.put(i, temp);
			ans=Math.max(ans, temp);
		}
		return ans;
	}
	
//	public int longestSubsequence(int[] arr, int difference) {
//		int ans = 1;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i: arr) {
//            int temp = map.getOrDefault(i - difference, 0) + 1;
//            map.put(i, temp);
//            ans = Math.max(ans, temp);
//        }
//        return ans;
//	}
}
