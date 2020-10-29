package math;

public class P593 {
	public static void main(String[] args) {
//		int[] p1= {0,0};
//		int[] p2= {1,1};
//		int[] p3= {1,0};
//		int[] p4= {0,1};
//		int[] p1= {1,1};
//		int[] p2= {5,3};
//		int[] p3= {3,5};
//		int[] p4= {7,7};
		int[] p1= {0,0};
		int[] p2= {0,0};
		int[] p3= {0,0};
		int[] p4= {0,0};
		P593 p=new P593();
		System.out.println(p.validSquare(p1, p2, p3, p4));
	}
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		if((Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2)!=0)&&
				(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2))==
				(Math.pow(p2[0]-p3[0],2)+Math.pow(p2[1]-p3[1],2))&&
				(Math.pow(p2[0]-p3[0],2)+Math.pow(p2[1]-p3[1],2))==
				(Math.pow(p3[0]-p4[0],2)+Math.pow(p3[1]-p4[1],2))&&
				(Math.pow(p3[0]-p4[0],2)+Math.pow(p3[1]-p4[1],2))==
				(Math.pow(p4[0]-p1[0],2)+Math.pow(p4[1]-p1[1],2))&&
				(Math.pow(p1[0]-p3[0],2)+Math.pow(p1[1]-p3[1],2))==
				(Math.pow(p2[0]-p4[0],2)+Math.pow(p2[1]-p4[1],2))
				) {
			return true;
		}else if((Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2)!=0)&&
				(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2))==
				(Math.pow(p2[0]-p4[0],2)+Math.pow(p2[1]-p4[1],2))&&
				(Math.pow(p2[0]-p4[0],2)+Math.pow(p2[1]-p4[1],2))==
				(Math.pow(p4[0]-p3[0],2)+Math.pow(p4[1]-p3[1],2))&&
				(Math.pow(p4[0]-p3[0],2)+Math.pow(p4[1]-p3[1],2))==
				(Math.pow(p3[0]-p1[0],2)+Math.pow(p3[1]-p1[1],2))&&
				(Math.pow(p1[0]-p4[0],2)+Math.pow(p1[1]-p4[1],2))==
				(Math.pow(p2[0]-p3[0],2)+Math.pow(p2[1]-p3[1],2))) {
			return true;
		}else if((Math.pow(p1[0]-p4[0],2)+Math.pow(p1[1]-p4[1],2)!=0)&&
				(Math.pow(p1[0]-p4[0],2)+Math.pow(p1[1]-p4[1],2))==
				(Math.pow(p4[0]-p2[0],2)+Math.pow(p4[1]-p2[1],2))&&
				(Math.pow(p4[0]-p2[0],2)+Math.pow(p4[1]-p2[1],2))==
				(Math.pow(p2[0]-p3[0],2)+Math.pow(p2[1]-p3[1],2))&&
				(Math.pow(p2[0]-p3[0],2)+Math.pow(p2[1]-p3[1],2))==
				(Math.pow(p3[0]-p1[0],2)+Math.pow(p3[1]-p1[1],2))&&
				(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2))==
				(Math.pow(p3[0]-p4[0],2)+Math.pow(p3[1]-p4[1],2))) {
			return true;
		}
		return false;
    }
}
