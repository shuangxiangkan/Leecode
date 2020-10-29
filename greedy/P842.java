package greedy;

import java.util.ArrayList;
import java.util.List;

public class P842 {
	public static void main(String[] args) {
		String S="5511816597";
		P842 p=new P842();
		System.out.println(p.splitIntoFibonacci(S));
	}
	public boolean split(String S,int start,List<Integer> list) {
		if(start==S.length()&&list.size()>2)
			return true;
		for(int i=start;i<S.length();i++) {
			String s=S.substring(start, i+1);
			if(s.length()>1&&s.startsWith("0"))
				break;
			if(Long.parseLong(s)>Integer.MAX_VALUE)
				break;
			int num=Integer.parseInt(s);
			if(isFibonacciSequence(num, list)) {
				if(split(S, i+1, list))
					return true;
				list.remove(list.size()-1);
			}
		}
		return false;
	}
	public boolean isFibonacciSequence(int num,List<Integer> list) {
		if(list.size()<2) {
			list.add(num);
			return true;
		}
		else {
			int first=list.get(list.size()-1);
			int second=list.get(list.size()-2);
			if(num==first+second) {
				list.add(num);
				return true;
			}else
				return false;
		}
	}
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> list=new ArrayList<>();
		split(S, 0, list);
		return list;
    }
}
