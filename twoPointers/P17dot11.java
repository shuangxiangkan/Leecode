package twoPointers;

public class P17dot11 {
	public static void main(String[] args) {
		String[] words = {"I","am","a","student","from","a","university","in","a","city"};
		String word1 = "a";
		String word2 = "student";
		P17dot11 p=new P17dot11();
		System.out.println(p.findClosest(words, word1, word2));

	}
	public int findClosest(String[] words, String word1, String word2) {
		int first=-1;
		int second=-1;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(word1)) {
				first=i;
				if(second!=-1) {
					int dis=Math.abs(second-first);
					if(min>dis)
						min=dis;
				}
			}
			if(words[i].equals(word2)) {
				second=i;
				if(first!=-1) {
					int dis=Math.abs(second-first);
					if(min>dis)
						min=dis;
				}
			}
		}
		return min;
    }
}
