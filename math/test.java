package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		test t=new test();
//		int n=1000000000;
//		int a=2;
//		int b=217983653;
//		int c=336916467;
		int n=1000000000;
		int a=2;
		int b=168079517;
		int c=403313907;
		System.out.println(t.nthUglyNumber(n, a, b, c));
	}
	public int nthUglyNumber(int n, int a, int b, int c) {
        if (n < 1 || a < 1 || b < 1 || c < 1) throw new IllegalArgumentException("invalid param");
        
        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        // 三个数的最小公倍数
        long lcm = lcm(lcmAB, c);
        
        // lcm之内的数字数目，即一个周期内的元素数
        long m = lcm / a + lcm / b + lcm / c - lcm / lcmAB - lcm / lcmAC - lcm / lcmBC + 1;

        long epoch = n / m;
        long r = n % m;
        long result = epoch * lcm;
		
        if (r > 0) {
            // 二分查找，范围缩小为1～lcm
            long left = 1, right = lcm;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcm;
                if (count >= r) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 最后left就是要查找的值
            result += left;
        }

        return (int)result;
    }
    
    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    
    // 最大公因数
    private long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

	
}
