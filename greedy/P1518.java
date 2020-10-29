package greedy;

public class P1518 {
	public static void main(String[] args) {
		int numBottles=2;
		int numExchange=3;
		P1518 p=new P1518();
		System.out.println(p.numWaterBottles(numBottles, numExchange));
	}
	public int numWaterBottles(int numBottles, int numExchange) {
		int sum=numBottles;
		int s=numBottles;
		while(s>=numExchange) {
			int amount=s/numExchange;
			sum+=amount;
			s=amount+s%numExchange;
		}
		return sum;
    }
}
