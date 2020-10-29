package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1104 {
	public static void main(String[] args) {
		int label=26;
		P1104 p=new P1104();
		System.out.println(p.pathInZigZagTree(label));
	}
	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> list=new ArrayList<Integer>();
		int level=0;
		if((Math.log(label)/Math.log(2))==(int)(Math.log(label)/Math.log(2)))
			level=(int)(Math.log(label)/Math.log(2))+1;
		else 
			level=(int) Math.ceil(Math.log(label)/Math.log(2));
		int[][] labels=new int[level][2];
		labels[0][0]=1;
		labels[0][1]=1;
		for(int i=1;i<labels.length;i++) {
			labels[i][0]=(int) Math.pow(2, i);
			labels[i][1]=(int) Math.pow(2, i+1)-1;
		}
		int[] numbers=new int[level];
		numbers[level-1]=label;
		
		for(int i=level-2;i>=0;i--) {
			label=label/2;
			int start=labels[i][0];
			int end=labels[i][1];
			numbers[i]=start+end-label;
			label=numbers[i];
		}
		for(int i=0;i<numbers.length;i++)
			list.add(numbers[i]);
		return list;
    }
}
