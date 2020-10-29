package array;

public class P16dot13 {
	public static void main(String[] args) {
		int[] square1 = {-28,186,65};
		int[] square2 = {-211,-182,178};
		double[] coords=cutSquares(square1, square2);
		for(int i=0;i<coords.length;i++)
			System.out.println(coords[i]);
	}
	public static double[] cutSquares(int[] square1, int[] square2) {
		double[] coords=new double[4];
		double[] center1= {square1[0]+square1[2]/2.0,square1[1]+square1[2]/2.0};
		double[] center2= {square2[0]+square2[2]/2.0,square2[1]+square2[2]/2.0};
		if(center1[0]==center2[0]) {
			coords[0]=center1[0];
			coords[1]=square1[1]<square2[1]?square1[1]:square2[1];
			coords[2]=center1[0];
			coords[3]=(square1[1]+square1[2])>(square2[1]+square2[2])?(square1[1]+square1[2]):(square2[1]+square2[2]);
		}
		else if(center1[1]==center2[1]) {
			coords[1]=center1[1];
			coords[0]=square1[0]<square2[0]?square1[0]:square2[0];
			coords[3]=center1[1];
			coords[2]=(square1[0]+square1[2])>(square2[0]+square2[2])?(square1[0]+square1[2]):(square2[0]+square2[2]);
		} 
		else {
			double slope=(center2[1]-center1[1])/(center2[0]-center1[0]);
			if(slope>0&&slope<=1) {
				coords[0]=square1[0]<square2[0]?square1[0]:square2[0];
				coords[1]=(center1[1]-slope*square1[2]/2.0)<(center2[1]-slope*square2[2]/2.0)?(center1[1]-slope*square1[2]/2.0):(center2[1]-slope*square2[2]/2.0);
				coords[2]=(square1[0]+square1[2])>(square2[0]+square2[2])?(square1[0]+square1[2]):(square2[0]+square2[2]);
				coords[3]=(center1[1]+slope*square1[2]/2.0)>(center2[1]+slope*square2[2]/2.0)?(center1[1]+slope*square1[2]/2.0):(center2[1]+slope*square2[2]/2.0);
			}
			else if(slope<0&&slope>=-1){
				coords[0]=square1[0]<square2[0]?square1[0]:square2[0];
				coords[1]=(center1[1]-slope*square1[2]/2.0)>(center2[1]-slope*square2[2]/2.0)?(center1[1]-slope*square1[2]/2.0):(center2[1]-slope*square2[2]/2.0);
				coords[2]=(square1[0]+square1[2])>(square2[0]+square2[2])?(square1[0]+square1[2]):(square2[0]+square2[2]);
				coords[3]=(center1[1]+slope*square1[2]/2.0)<(center2[1]+slope*square2[2]/2.0)?(center1[1]+slope*square1[2]/2.0):(center2[1]+slope*square2[2]/2.0);
			}
			else if(slope>1) {
				coords[0]=(center1[0]-square1[2]/2.0/slope)<(center2[0]-square2[2]/2.0/slope)?(center1[0]-square1[2]/2.0/slope):(center2[0]-square2[2]/2.0/slope);
				coords[1]=square1[1]<square2[1]?square1[1]:square2[1];
				coords[2]=(center1[0]+square1[2]/2.0/slope)>(center2[0]+square2[2]/2.0/slope)?(center1[0]+square1[2]/2.0/slope):(center2[0]+square2[2]/2.0/slope);
				coords[3]=(square1[1]+square1[2])>(square2[1]+square2[2])?(square1[1]+square1[2]):(square2[1]+square2[2]);
			}else {
				coords[0]=(center1[0]+square1[2]/2.0/slope)<(center2[0]+square2[2]/2.0/slope)?(center1[0]+square1[2]/2.0/slope):(center2[0]+square2[2]/2.0/slope);
				coords[1]=(square1[1]+square1[2])>(square2[1]+square2[2])?(square1[1]+square1[2]):(square2[1]+square2[2]);
				coords[2]=(center1[0]-square1[2]/2.0/slope)>(center2[0]-square2[2]/2.0/slope)?(center1[0]-square1[2]/2.0/slope):(center2[0]-square2[2]/2.0/slope);
				coords[3]=square1[1]<square2[1]?square1[1]:square2[1];
			}
		}
		
		
		return coords;
    }
}
