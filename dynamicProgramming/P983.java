package dynamicProgramming;

public class P983 {
	public static void main(String[] args) {
		int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
		int[] costs = {2,7,15};
		System.out.println(mincostTickets(days, costs));
	}
	public static int mincostTickets(int[] days, int[] costs) {
		int[] labels=new int[days[days.length-1]+1];
		int[] tickets=new int[days[days.length-1]+1];
		for(int i=0;i<days.length;i++)
			labels[days[i]]=1;
		for(int i=1;i<tickets.length;i++) {
			if(labels[i]==0) {
				tickets[i]=tickets[i-1];
			}else {
				int min=tickets[i-1]+costs[0];
				if(((i-7))<=0&&(min>tickets[0]+costs[1]))
					min=tickets[0]+costs[1];
				if(((i-7))>0&&(min>tickets[i-7]+costs[1]))
					min=tickets[i-7]+costs[1];
				if(((i-30))<=0&&(min>tickets[0]+costs[2]))
					min=tickets[0]+costs[2];
				if(((i-30))>0&&(min>tickets[i-30]+costs[2]))
					min=tickets[i-30]+costs[2];
				tickets[i]=min;
			}
			
		}
		return tickets[tickets.length-1];
    }
}
