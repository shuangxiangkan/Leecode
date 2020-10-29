package array;

public class P1343 {
	public static void main(String[] args) {
		int[] arr= {4,4,4,4};
		int k=4;
		int threshold=1;
		System.out.println(numOfSubarrays(arr, k, threshold));
	}
	public static int numOfSubarrays(int[] arr, int k, int threshold) {
		int number=0;
		for(int i=0;i<=arr.length-k;i++) {
			int sum=0;
			for(int j=i;j<i+k;j++) {
				sum+=arr[j];
			}
			if((sum/k)>=threshold) {
				number++;
			}
		}
		
		
		return number;
    }
}
