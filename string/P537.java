package string;

public class P537 {
	public static void main(String[] args) {
		String a="1+1i";
		String b="1+1i";
		System.out.println(complexNumberMultiply(a, b));
	}
	public static String complexNumberMultiply(String a, String b) {
		StringBuilder sb=new StringBuilder();
		String[] arr=a.split("\\+");
		String[] brr=b.split("\\+");
		int a1=Integer.parseInt(arr[0]);
		int a2=Integer.parseInt(arr[1].substring(0, arr[1].length()-1));
		int b1=Integer.parseInt(brr[0]);
		int b2=Integer.parseInt(brr[1].substring(0, brr[1].length()-1));
		
		int result1=a1*b1-a2*b2;
		int result2=a1*b2+a2*b1;
		
		sb.append(String.valueOf(result1)+"+");
		sb.append(String.valueOf(result2)+"i");
		

		return sb.toString();
    }
}
//System.out.println(result1);
//System.out.println(result2);
//System.out.println(b1);
//System.out.println(b2);
