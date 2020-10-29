package greedy;

public class P1247 {
	public static void main(String[] args) {
//		String s1 = "xx";
//		String s2 = "xy";
		String s1 = "xxyyxyxyxx";
		String s2 = "xyyxyxxxyx";
		P1247 p=new P1247();
		System.out.println(p.minimumSwap(s1, s2));
	}
	public int minimumSwap(String s1, String s2) {
		int xNum=0;
		int yNum=0;
		int[] xArray=new int[s1.length()];
		int[] yArray=new int[s2.length()];
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)=='x') {
				xArray[i]=1;
				xNum++;
			}else {
				yArray[i]=0;
				yNum++;
			}
		}
		for(int j=0;j<s2.length();j++) {
			if(s2.charAt(j)=='x') {
				yArray[j]=1;
				xNum++;
			}else {
				yArray[j]=0;
				yNum++;
			}
		}
		if(xNum%2==1||yNum%2==1)
			return -1;
		int n10=0;
		int n01=0;
		for(int i=0;i<xArray.length;i++) {
			if(xArray[i]==1&&yArray[i]==0)
				n10++;
			else if(xArray[i]==0&&yArray[i]==1)
				n01++;
		}
		return n10/2+n10%2+n01/2+n01%2;
    }
}
