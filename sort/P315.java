package sort;

import java.util.*;

public class P315 {
	public static void main(String[] args) {
		int[] nums= {1,1,1,2,2,3};
		int k=2;
		P315 p=new P315();
		System.out.println(p.topKFrequent(nums, k));
//		Map<Integer,Integer> map=new HashMap<>();
//		map.put(1, 3);
//		map.put(2, 2);
//		map.put(3, 1);
//		System.out.println(map.getOrDefault(1, 0)+1);
//		System.out.println(map.getOrDefault(5, 0)+1);
		
//		ArrayList<Integer> c=(ArrayList<Integer>) map.values();
//		Collection c=map.values();
//		Collections.sort((List<Integer>) c);
//		System.out.println(c);
		
	}
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int value=map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],value);
        }
        int[] values=new int[map.size()];
        int i=0;
        for(int key:map.keySet()){
            values[i++]=map.get(key);
        }
        Arrays.sort(values);
        int[] ans=new int[k];
        int r=0;
        for(int j=0;j<k;j++){
            int max=values[k-j-1];
            for(int key:map.keySet()){
                if(max==map.get(key)){
                    ans[r++]=key;
//                    map.remove(key)
                    break;
                }
            }
        }
        return ans;
    }
}
