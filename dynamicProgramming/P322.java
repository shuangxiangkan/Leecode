package dynamicProgramming;

import java.util.Arrays;

public class P322 {
	public static void main(String[] args) {
//		int[] coins = {186,419,83,408};
//		int amount = 6249;
		int[] coins = {2};
		int amount = 3;
		System.out.println(coinChange(coins, amount));
	}
	public static int coinChange(int[] coins, int amount) {
		if(amount==0)
            return 0;
		Arrays.sort(coins);
		int[] labels=new int[amount+1];
		for(int i=1;i<=amount;i++) {
			int min=amount+1;
			for(int j=0;j<coins.length&&i>=coins[j];j++) {		
				if(amount==coins[j]) {
					return 1;
				}
				if(i==coins[j]) {
					min=1;
				}
				if(labels[coins[j]]>0&&labels[i-coins[j]]>0) {
					min=Math.min(min, labels[coins[j]]+labels[i-coins[j]]);
				}
			}
			if(min<=amount)
				labels[i]=min;
			else
				labels[i]=-1;
		}
		return labels[amount];
    }
}
