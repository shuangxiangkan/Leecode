package array;

public class P1014 {
	public static void main(String[] args) {
		int[] A= {8,1,5,2,6};
		System.out.println(maxScoreSightseeingPair(A));
	}
	public static int maxScoreSightseeingPair(int[] A) {
		int preMax=A[0]+0;
		int max=0;
		for(int i=1;i<A.length;i++) {
			max=Math.max(max, preMax+A[i]-i);
			preMax=Math.max(preMax, A[i]+i);
		}
		return max;
    }
}
