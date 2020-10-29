package array;

public class P11 {
	public static void main(String[] args) {
		int[] height= {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea2(height));
	}
	public static int maxArea1(int[] height) {
		int max=0;
		for(int i=1;i<height.length;i++) {
			for(int j=0;j<i;j++) {
				int min=Math.min(height[j], height[i]);
				if(min*(i-j)>max)
					max=min*(i-j);
			}
		}
		
		return max; 
    }
	public static int maxArea2(int[] height) {
		int max=0;
		for(int i=0,j=height.length-1;i<j;) {
			if(height[i]<height[j]) {
				if(height[i]*(j-i)>max){
					max=height[i]*(j-i);
				}
				i++;
			}else {
				if(height[j]*(j-i)>max){
					max=height[j]*(j-i);
				}
				j--;
			}
		}
		
		return max; 
    }
}
