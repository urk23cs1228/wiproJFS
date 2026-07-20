import java.util.*;
public class wiproLC2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>0) {
			int digit = n%10;
			System.out.print(digit);
			n = n/10;	
		}
		
	}

}
