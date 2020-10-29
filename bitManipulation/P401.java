package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class P401 {
	public static void main(String[] args) {
		int num=1;
		P401 p=new P401();
		List<String> ans=p.readBinaryWatch(num);
		for(String s:ans)
			System.out.println(s);
	}
	public ArrayList<String> hour(int h) {
		ArrayList<String> alist=new ArrayList<>();
		if(h==0||h>3)
			alist.add("0");
		else {
			if(h==1) {
				alist.add("1");alist.add("2");
				alist.add("4");alist.add("8");
			}
			else if(h==2) {
				alist.add("3");alist.add("5");
				alist.add("6");alist.add("9");
				alist.add("10");
			}else if(h==3) {
				alist.add("7");
				alist.add("11");
			}
		}
		
		return alist;
			
	}
	public ArrayList<String> minute(int m) {
		ArrayList<String> alist=new ArrayList<>();
		if(m==0||m>6) {
			alist.add("00");
		}else {
			if(m==1) {
				alist.add("01");alist.add("02");
				alist.add("04");alist.add("08");
				alist.add("16");alist.add("32");
			}
			else if(m==2) {
				
			}
		}
		return alist;
	}
	public List<String> readBinaryWatch(int num) {
		if(num<=0||num>10)
			return null;
		List<String> ans=new ArrayList<String>();
		for(int i=0;i<num;i++) {
			StringBuffer sb=new StringBuffer();
			sb.append(hour(i));
			sb.append(":");
			sb.append(minute(num-i));
			ans.add(sb.toString());
		}
		return ans;
    }
}
