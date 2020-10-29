package bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P187 {
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		P187 p=new P187();
		List<String> ans=p.findRepeatedDnaSequences(s);
		System.out.println(ans);
	}
	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<=s.length()-10;i++) {
			String sub=s.substring(i, i+10);
			if(map.containsKey(sub))
				map.put(sub, map.get(sub)+1);
			else
				map.put(sub, 1);
		}
		List<String> ans=new ArrayList<String>();
		for(String str:map.keySet()) {
			if(map.get(str)>1)
				ans.add(str);
		}
		return ans;
    }
}
