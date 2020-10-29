package array;

public class P16dot04 {
	public static void main(String[] args) {
		String[] board= {"OOX","XXO","OX "};
		System.out.println(tictactoe(board));
	}
	public static String tictactoe(String[] board) {
		boolean flag=false;
		int empty=0;
		if(board.length==1&&(board[0].charAt(0)!=' '))
			return String.valueOf(board[0].charAt(0));
		if(board.length==1&&(board[0].charAt(0)==' '))
			return "Pending";
		// 判断行
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length-1;j++) {
				if((board[i].charAt(j)==' ')||(board[i].charAt(j)!=board[i].charAt(j+1))) {
					break;
				}
				if(j==board.length-2)
				{
					return String.valueOf(board[i].charAt(j));
				}
			}
		}
		//判断列
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length-1;j++) {
				if((board[j].charAt(i)==' ')||(board[j].charAt(i)!=board[j+1].charAt(i))) {
					break;
				}
				if(j==board.length-2)
				{
					return String.valueOf(board[j].charAt(i));
				}
			}
		}
		//判断正对角线
		for(int i=0;i<board.length-1;i++) {
			if((board[i].charAt(i)==' ')||(board[i].charAt(i)!=board[i+1].charAt(i+1))) {
				break;
			}
			if(i==board.length-2) {
				return String.valueOf(board[0].charAt(0));
			}
		}
		//判断反对角线
		int length=board.length-1;
		for(int i=0;i<board.length-1;i++) {
			if((board[i].charAt(length-i)==' ')||(board[i].charAt(length-i)!=board[i+1].charAt(length-(i+1)))) {
				break;
			}
			if(i==board.length-2) {
				return String.valueOf(board[0].charAt(length));
			}
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length();j++) {
				if(board[i].charAt(j)==' ')
					empty++;
			}
		}
		if(empty==0)
			return "Draw";
		else
			return "Pending";
    }
}
