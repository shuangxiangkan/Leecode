package greedy;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String S="123456579";
		P842 p=new P842();
		System.out.println(p.splitIntoFibonacci(S));
	}
	private boolean backtracking(String S,int start,List<Integer> ans) {
		if (start == S.length() && ans.size() > 2) {
            return true;
		}
		for(int i=start;i<S.length();i++) {
			String segment=S.substring(start,i+1);
			//剪枝
			//数值超过范围
			if(Long.parseLong(segment)>Integer.MAX_VALUE)
				break;
			//防止“0”开头
			if(!"0".equals(segment)&&segment.startsWith("0"))
				break;
			if(isFibonacciSequence(Integer.valueOf(segment), ans)) {
				ans.add(Integer.valueOf(segment));
				if(backtracking(S, i+1, ans))
					return true;
				ans.remove(ans.size()-1);
			}	
		}
		return false;
	}
	//判断是否能组成斐波那契数列
	private boolean isFibonacciSequence(int num,List<Integer> ans) {
		int size=ans.size();
		if(size<2)
			return true;
		return (ans.get(size-2)+ans.get(size-1)==num);
	}
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> ans=new ArrayList<Integer>();
		backtracking(S,0,ans);
		return ans;
    }
}
