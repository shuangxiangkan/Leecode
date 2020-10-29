package array;

public class P1011 {
	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10}; 
		int D = 5;
		System.out.println(shipWithinDays(weights, D));
	}
	public static int shipWithinDays(int[] weights, int D) {
		int max=weights[0];
		int sum=0;
		for(int i=0;i<weights.length;i++) {
			if(max<weights[i]) {
				max=weights[i];	
			}
			sum+=weights[i];
		}
		
		int start=max;
		int end=sum;
		while(start<end) {
			int mid=(start+end)/2;
			if(canShip(weights, D, mid)) {
				end=mid;
			}else {
				start=mid+1;
			}
		}

		return start;
    }
	private static boolean canShip(int[] weights, int D, int capacity) {
		int temp=0;
		for (int w : weights) {
			if(temp+w>capacity) {
				temp=w;
				D--;
			}else
				temp+=w;
			
		}
		return D>0;
	}
}
