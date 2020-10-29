package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P809 {
	public static void main(String[] args) {
//		String S="heeellooo";
//		String[] words= {"hello", "hi", "helo"};
//		String S="heeellooo";
//		String[] words= {"axxxrrzzz"};
		String S="dddiiiinnssssssoooo";
		String[] words= {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"};
//		String S="yyrrrrrjaappoooyybbbebbbbriiiiiyyynnnvvwtwwwwwooeeexxxxxkkkkkaaaaauuuu";
//		String[] words=	{"yrrjjappooybbebriiyynvvwtwwoeexkauu","yrjjappooybbebrriyynnvwwttwoeexkaauu","yyrrjapoybbebriiynnvvwwtwoeexkaauu","yyrjappooyybebbrriyynnvwttwwooeexxkkau","yrjaapooybbebrriyynnvvwwttwooexkaau","yyrjjapooyybeebbrriiyynvwwttwoexxkau","yrrjaappoyybbeebbriynnvwwtwooexxkauu","yrrjjaapooybebriynnvvwwttwwooexkaau","yyrrjjappooyybebriiyynvvwttwoeexxkkaau","yrrjaappooybbebrriynvwwtwooeexkau","yyrjjaapooyybebrriiynvvwttwwooeexxkkaau","yyrrjappooyybbebriyynnvwwttwwoeexkkauu","yyrrjjaapoyybbeebriiyynnvwwtwwooexkkaau","yrjjaappooybbeebriiyynnvwwtwwoexkau","yrrjjappoyybbeebbrriiyynnvwttwwooexxkkaauu","yyrrjjapooyybbebbrriyynvwtwoexxkkaauu","yyrrjappoybebrriynvwwttwooeexkkauu","yrrjaappooybbeebriiyynnvvwwttwoexxkauu","yrrjapoybebbrriyynvvwwttwwoexkaau","yyrrjjapoybbeebbrriynnvwwtwwooexkaauu","yyrrjjapooyybbeebbriyynnvwtwwoexkaau","yrjjaapooyybebriynnvwwttwooeexxkkaauu","yyrjjaapooybbebbriiynvvwttwwoexxkkauu","yrjjaapooyybeebbriiyynvvwwttwoeexxkau","yrjjappooyybbebbrriiynvvwtwooeexxkkau","yyrrjjapoyybbebbrriiyynvwwtwwoexxkkaau","yrjjapooyybbeebriyynnvvwwtwoeexkkau","yrjapooyybebriiynnvvwwtwwooeexkauu","yyrjaapoyybbebbrriynnvwtwwoeexkauu","yrrjjappoybeebrriiynvvwwtwwoeexxkkaau","yrrjjapoybbeebrriiyynnvwwttwwoexxkaau","yyrrjaapoybeebrriiyynvwttwwooeexkauu","yyrjapoybbeebbrriyynnvvwwttwwooeexkaauu","yyrjappooybebrriiynvwtwwoeexxkaauu","yrrjjappooybebrriynnvvwttwooexkau","yrjjaapoybbeebbriiynnvvwttwooexkauu","yyrrjapooyybbeebriiyynnvvwtwwoeexxkaauu","yyrjjaappooybeebbrriiyynnvvwwtwwoeexkkau","yrrjappoyybbeebrriiynvvwwtwwoeexxkauu","yrjapooyybeebriiyynvvwttwwooeexxkaauu","yrjjappooyybbebbriiynnvwwtwooeexxkauu","yyrrjjappooybbeebbriyynnvwtwwooexxkkau","yyrrjjaapooybebriiyynvwwtwooeexxkkaauu","yrjjappooyybbeebbriiyynvwwtwwoeexkkau","yrrjjappooybbebrriiynvvwwtwwoexxkkaau","yrjjapooybebbriyynnvvwwttwwooeexxkkaau","yyrjjapoyybebbrriynvvwwttwoexkauu","yyrjappoyybebriiynnvvwttwwoexxkaauu","yyrjaapoybbeebriyynvvwwttwoeexkau","yrjjaappooyybbebbriiynnvvwtwooexxkau","yyrjjaappooyybbebrriiyynvvwttwooexkau","yrjjappoybbeebriyynnvvwwttwwooexxkkaau","yyrrjaapooybbebbriiyynnvwwtwwooexxkkaauu","yrrjaapooybbeebrriynnvvwwtwoeexxkkauu","yrjjaappooyybeebbrriyynnvvwttwwoexxkkauu","yrrjapooyybebriyynnvwwttwooeexkau","yyrjjaapooyybeebrriiynnvvwwttwoeexxkkau","yrjappooybebriyynnvvwttwwooeexkau","yrrjjaappoyybebbrriiyynvwwtwooexxkauu","yrjjappooybeebriynnvwwtwoeexkaauu","yrjaappoybbebbriiynnvwwttwooexxkaau","yyrrjappooyybeebbriiyynvwwttwwoexxkau","yyrjappoyybbeebrriynvwtwoeexkaau","yrrjjaapooybbeebbriyynvwwtwooeexkkaau","yrjapoybebbrriiynvwttwwoeexxkaau","yrjapooybebbrriiynnvwwtwwoexxkaau","yrrjjaappoybeebbriiyynvwwtwooexxkkaauu","yrjappooybeebrriynvwwtwooeexkaauu","yrrjaapooybeebbriiynvvwtwwoexxkkaauu","yyrrjaappooyybebbrriiyynvwwtwwooexxkkau","yyrjaappoybbeebriynnvvwwtwwooeexkaauu","yyrjaappooyybbebbriynvvwwttwwooexkauu","yrjappooybeebbrriiynnvwttwwooexkkau","yrrjjappooyybebbriiyynnvvwttwwoexkkau","yrrjjaapooybeebbriynnvvwwtwooexkaau","yyrjjappoybeebbrriiynnvwtwwoexkaauu","yyrjjaapoybbebbrriiyynnvvwtwwoexkaau","yyrrjjaappoyybbebbriyynvwwtwwooeexkkaau","yrrjjaappooybbebriiyynvvwttwwooexxkau","yyrjjaapoyybebriiynnvwtwwooeexkauu","yrrjjappoyybeebbriiyynnvwttwoexkkau","yrjjappoyybbebbrriynnvvwttwwooeexkkaauu","yyrjappooybeebrriiynnvwwttwwooexxkkaauu","yrrjaappoybbeebrriyynnvvwwtwwooeexxkaauu","yyrjaappooybeebbriiynvwttwoexxkkauu","yyrrjjapooyybbeebbrriyynvwttwwooeexxkkau","yrrjapoybbebbrriiynvwtwwoeexxkaau","yyrrjapoybbeebbriiyynnvvwttwooexkkauu","yyrjaapooyybebbrriiyynnvvwwtwooeexkkauu","yyrrjjaappoybbeebrriyynnvwwtwwoexkkaauu","yyrjappooybbeebrriiyynvwwttwwoexkkau","yyrjaapooyybebbriiyynnvvwwtwoeexkkaau","yyrrjjappoyybbeebbriiyynvwtwooexxkaauu","yrrjjaapoyybbeebriynvvwtwwoexxkaau","yyrrjjapoybbebbrriyynnvwwtwoeexxkkaau","yyrrjapooyybebrriiyynvwttwwooeexxkkauu","yrjappooyybebriiynnvwwtwoeexkkaauu","yrjjaapooyybeebriiynvwtwooexkauu","yyrrjjapoybeebbrriiynnvwttwwoexkaau","yyrrjaappoyybebbrriiyynvwwtwooeexkaau"};
//		String S="aaa";
//		String[] words=	{"aaaa"};
		P809 p=new P809();
		System.out.println(p.expressiveWords(S, words));
	}
	
	public int expressiveWords(String S, String[] words) {
		int result=0;
		ArrayList<Character> sc=new ArrayList<>();
		ArrayList<Integer> sn=new ArrayList<>();
		char[] arr=S.toCharArray();
		int count=1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				sc.add(arr[i]);
				sn.add(count);
				count=1;
			}else
				count++;
		}
		sc.add(arr[arr.length-1]);
		sn.add(count);
			
		for (String word : words) {
			
			ArrayList<Character> wc=new ArrayList<>();
			ArrayList<Integer> wn=new ArrayList<>();
			char[] warr=word.toCharArray();
			int num=1;
			for(int i=0;i<warr.length-1;i++) {
				if(warr[i]!=warr[i+1]) {
					wc.add(warr[i]);
					wn.add(num);
					num=1;
				}else
					num++;
			}
			wc.add(warr[warr.length-1]);
			wn.add(num);
			
			boolean flag=true;
			if(sc.size()==wc.size()) {
				for(int j=0;j<sc.size();j++) {
					if(!(sc.get(j)==wc.get(j)&&(sn.get(j)==wn.get(j)||sn.get(j)>=3&&sn.get(j)>=wn.get(j)))) {
						flag=false;
						break;
					}
				}
				if(flag) {
//					System.out.println(word);
					result++;
				}
					
			}
		}
		
		return result;
    }
}
