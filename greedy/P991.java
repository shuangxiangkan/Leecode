package greedy;

public class P991 {
	public static void main(String[] args) {
		P991 p=new P991();
		int X = 3;
		int Y = 10;
		System.out.println(p.brokenCalc(X, Y));
	}
	public int brokenCalc(int X, int Y) {
		if(X==Y)
			return 0;
		if(X>Y)
			return X-Y;
		int count=0;
		while(X!=Y) {
			if(Y%2==1) {
				Y=Y+1;
				count++;
			}
			Y=Y/2;
			count++;
			if(Y/X>=1)
				continue;
			else {
				count+=X-Y;
				break;
			}
		}
		return count;
    }
}
