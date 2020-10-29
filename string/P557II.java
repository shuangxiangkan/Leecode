package string;

public class P557II {
	public static void main(String[] args) {
		String s="Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
	public static String reverseWords(String s) {
		String[] words=s.split(" ");
		StringBuilder sb=new StringBuilder();
		for (String word : words) {
			sb.append(new StringBuilder(word).reverse().toString()+" ");
		}
		return sb.toString().trim();
	}
}
