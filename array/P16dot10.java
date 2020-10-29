package array;

public class P16dot10 {
	public static void main(String[] args) {
		int[] birth = {1900, 1901, 1950};
		int[] death = {1948, 1951, 2000};
		System.out.println(maxAliveYear(birth, death));
	}
	public static int maxAliveYear(int[] birth, int[] death) {
		int max=0;
		int[] range=new int[102];
		for(int i=0;i<birth.length;i++) {
			range[birth[i]-1900]++;
			range[death[i]-1900+1]--;
		}
		int result=0;
		int temp=0;
		for(int i=0;i<range.length;i++) {
			result+=range[i];
			if(result>max) {
				max=result;
				temp=i;
			}
		}
		return temp+1900;
    }
}
