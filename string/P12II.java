package string;

public class P12II {
	public static void main(String[] args) {
		int num=58;
		System.out.println(intToRoman(num));
	}
	public static String intToRoman(int num) {
		StringBuilder sb=new StringBuilder();
		int[] values= {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		for(int i=0;i<values.length&&values.length>=0;i++) {
			while(values[i]<=num) {
				num-=values[i];
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}
}
