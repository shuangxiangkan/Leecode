package dynamicProgramming;

public class P808 {
	public static void main(String[] args) {
		int N=10000;
		System.out.println(soupServings(N));
	}
	public static double soupServings(int N) {
		if (N >= 4800){//N超过了4800，结果与1分厂接近
            return 1;
        }
		int num=(int)Math.ceil(N/25.0);
		double[][] labels=new double[num+1][num+1];
		labels[0][0]=0.5;
		for(int i=1;i<num+1;i++) {
			labels[0][i]=1;
			labels[i][0]=0;
		}
		for(int i=1;i<num+1;i++) {
			int a1=Math.max(i-4, 0);
			int a2=Math.max(i-3, 0);
			int a3=Math.max(i-2, 0);
			int a4=Math.max(i-1, 0);
			for(int j=1;j<num+1;j++) {
				int b1=j;
				int b2=Math.max(j-1, 0);
				int b3=Math.max(j-2, 0);
				int b4=Math.max(j-3, 0);
				labels[i][j]=0.25*(labels[a1][b1]+labels[a2][b2]+labels[a3][b3]+labels[a4][b4]);
			}
		}
		return labels[num][num];
    }
}
