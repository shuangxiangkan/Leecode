package bitManipulation;

public class P461 {
	public static void main(String[] args) {
		int x=1;
		int y=4;
		P461 p=new P461();
		System.out.println(p.hammingDistance(x, y));
	}
	public int hammingDistance(int x, int y) {
		String binaryX=Integer.toBinaryString(x);
		String binaryY=Integer.toBinaryString(y);
		int length=Math.max(binaryX.length(), binaryY.length());
		if(binaryX.length()<binaryY.length()) {
			int n=binaryY.length()-binaryX.length();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append("0");
			}
			sb.append(binaryX);
			binaryX=sb.toString();
		}else {
			int n=binaryX.length()-binaryY.length();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append("0");
			}
			sb.append(binaryY);
			binaryY=sb.toString();
		}
		int ans=0;
		for(int i=0;i<length;i++) {
			if(binaryX.charAt(i)!=binaryY.charAt(i))
				ans++;
		}
		return ans;
    }
}
