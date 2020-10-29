package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P10dot02 {
	public static void main(String[] args) {
		String[] s= {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> resutlts=groupAnagrams(s);
		for (List<String> list : resutlts) {
			for (String string : list) {
				System.out.print(string+" ");
			}
			System.out.println();
		}
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results=new ArrayList<List<String>>();
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		for(String s:strs) {
			char[] array=s.toCharArray();
			Arrays.sort(array);
			String str=String.copyValueOf(array);
			if(map.containsKey(str)) {
				List<String> list=map.get(str);
				list.add(s);
				map.put(str, list);
			}else {
				List<String> list=new ArrayList<>();
				list.add(s);
				map.put(str, list);
			}
				
		}
		for (String key : map.keySet()) {
			results.add(map.get(key));
		}
		
		return results;
    }
}
