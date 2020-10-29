package hashTable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P350 {
	public static void main(String[] args) {
//		int[] nums1 = {1,2,2,1};
//		int[] nums2 = {2,2};
		
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		P350 p=new P350();
		int[] results=p.intersect(nums1, nums2);
		for (int i : results) {
			System.out.println(i);
		}
		
	}
	public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
	
	
//	public int[] intersect(int[] nums1, int[] nums2) {
//		Map<Integer, Integer> num1Map=new HashMap<Integer, Integer>();
//		Map<Integer, Integer> num2Map=new HashMap<Integer, Integer>();
//		ArrayList<Integer> list=new ArrayList<>();
//		for(int i:nums1) {
//			if(!num1Map.keySet().contains(i)){
//				num1Map.put(i, 1);
//			}else {
//				int temp=num1Map.get(i);
//				temp+=1;
//				num1Map.put(i, temp);
//			}
//		}
//		for(int i:nums2) {
//			if(!num2Map.keySet().contains(i)){
//				num2Map.put(i, 1);
//			}else {
//				int temp=num2Map.get(i);
//				temp+=1;
//				num2Map.put(i, temp);
//			}
//		}
//		for(int i:num1Map.keySet()) {
//			if(num2Map.keySet().contains(i)) {
//				int small=Math.min(num1Map.get(i),num2Map.get(i));
//				for(int j=0;j<small;j++) {
//					list.add(i);
//				}
//			}
//		}
//		int[] results=new int[list.size()];
//		for(int i=0;i<list.size();i++)
//			results[i]=list.get(i);
//		return results;
//    }
}
