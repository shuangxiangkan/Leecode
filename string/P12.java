package string;

import java.util.HashMap;
import java.util.Map;

public class P12 {
	public static void main(String[] args) {
		int num=1994;
		System.out.println(intToRoman(num));
	}
	public static String intToRoman(int num) {
		StringBuilder sb=new StringBuilder();
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");	
		map.put(4, "IV");
		map.put(9, "IX");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");
		
		while(num!=0) {
			if(num/1000!=0) {
				int n=num/1000;
				num=num-n*1000;
				for(int i=0;i<n;i++)
					sb.append(map.get(1000));
			}else if(num/900==1) {
				num=num-900;
				sb.append(map.get(900));
			}else if(num/500==1) {
				num=num-500;
				sb.append(map.get(500));
			}else if(num/400==1) {
				num=num-400;
				sb.append(map.get(400));
			}else if(num/100!=0) {
				int n=num/100;
				num=num-n*100;
				for(int i=0;i<n;i++)
					sb.append(map.get(100));
			}else if(num/90==1) {
				num=num-90;
				sb.append(map.get(90));
			}else if(num/50==1) {
				num=num-50;
				sb.append(map.get(50));
			}else if(num/40==1) {
				num=num-40;
				sb.append(map.get(40));
			}else if(num/10!=0) {
				int n=num/10;
				num=num-n*10;
				for(int i=0;i<n;i++)
					sb.append(map.get(10));
			}else if(num/9==1) {
				num=num-9;
				sb.append(map.get(9));
			}else if(num/5==1) {
				num=num-5;
				sb.append(map.get(5));
			}else if(num/4==1) {
				num=num-4;
				sb.append(map.get(4));
			}else if(num!=0) {
				int n=num;
				num=0;
				for(int i=0;i<n;i++)
					sb.append(map.get(1));
			}
		}
		
		return sb.toString();
    }
}
