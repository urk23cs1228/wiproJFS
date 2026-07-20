import java.util.*;
public class wiproLC3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 10;
		int a[] = new int[n];
		int sum = 0;
		for(int i =0;i<n;i++) {
			a[i] = sc.nextInt();
				sum = sum + a[i];
				
	}
		double avg = sum/10.0;
		int count = 0;
		for(int i =0;i<n;i++) {
			if(a[i] < avg) {
				count++;
			}
			
		}
		System.out.println("Total average:" +avg);
		System.out.println("number less than average:" + count);
		
  
}
}
