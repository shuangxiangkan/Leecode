package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1233 {
	public static void main(String[] args) {
//		String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
//		String[] folder = {"/a","/a/b/c","/a/b/d"};
		String[] folder= {"/a/b/c","/a/b/d","/a/b/ca"};
		List<String> results=removeSubfolders(folder);
		for (String string : results) {
			System.out.println(string);
		}
	}
	public static List<String> removeSubfolders(String[] folder) {
		List<String> results=new ArrayList<String>();
		Arrays.sort(folder);
		results.add(folder[0]);
		for(int i=1;i<folder.length;i++) {
			String father=results.get(results.size()-1);
			if(!folder[i].contains(father+"/"))
				results.add(folder[i]);
		}
		return results;
	}
	
//	public static List<String> removeSubfolders(String[] folder) {
//		List<String> results=new ArrayList<String>();
//		for(int i=0;i<folder.length;i++) {
//			boolean flag=true;
//			for(int j=0;j<folder.length;j++) {
//				if(i!=j) {
//					if(folder[i].length()>folder[j].length()&&folder[i].contains(folder[j])&&folder[i].charAt(folder[j].length())=='/') {
//						flag=false;
//						break;
//					}
//				}
//			}
//			if(flag){
//				results.add(folder[i]);
//			}
//		}
//		return results;
//    }
}
