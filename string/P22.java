package string;

import java.util.ArrayList;
import java.util.List;

public class P22 {
	List<String> list=new ArrayList<String>();
	public static void main(String[] args) {
//		int n=3;
		P22 p=new P22();
		
		List<String> list=p.generateParenthesis(3);
		for (String string : list) {
			System.out.println(string);
		}
	}
	private void DFS(int left,int right, String s) {
		if(left==0&&right==0) {
			list.add(s);
		}
		if(left>0)
			DFS(left-1,right,s+"(");
		if(left<right)
			DFS(left,right-1,s+")");
	}
	public List<String> generateParenthesis(int n) {
//        List<String> list=new ArrayList<String>();
        DFS(n,n,"");
        return list;
    }
}
