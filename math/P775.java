package math;

import java.util.HashMap;
import java.util.Map;

public class P775 {
	public static void main(String[] args) {
		int[] A = {1,2,0};
//		int[] A= {2,0,1};
		P775 p=new P775();
//		System.out.println(p.isIdealPermutation(A));
	}
	
//	public boolean isIdealPermutation(int[] A) {
//		if(A.length==0||A.length==1)
//			return true;
//		int local=0;
//		int overall=0;
//		
//		for(int i=A.length-2;i>=0;i--) {
//			if(A[i]>A[i+1])
//				local++;
//			for(int j=i+1;j<A.length;j++)
//				if(A[i]>A[j])
//					overall++;
//		}
//		if(local==overall)
//			return true;
//		return false;
//		
//		
//		
////		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
////		map.put(A[A.length-1], 0);
////		for(int i=A.length-2;i>=0;i--) {
////			if(A[i]>A[i+1]) {
////				local++;
////				int num=map.get(A[i+1]);
////				map.put(A[i], num+1);
////				overall+=num+1;
////			}else {
////				boolean a=false; 
////				for(int key:map.keySet()) {
////					if(key<A[i]) {
////						int num=map.get(key);
////						map.put(A[i], num+1);
////						overall+=num+1;
////						a=true;
////						break;
////					}
////				}
////				if(!a) {
////					map.put(A[i], 0);
////				}
////			}
////		}
////		if(local==overall)
////			return true;
////		return false;
//    }
}
