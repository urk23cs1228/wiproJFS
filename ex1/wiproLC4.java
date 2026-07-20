import java.util.*;
public class wiproLC4 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string of less than 50 characters: ");
	        String inputStr = sc.nextLine();

	        int i = 0;
	        int strLength = 0;

	        while (i < inputStr.length()) {
	            strLength++;
	            i++;
	        }

	        System.out.println("String length: " + strLength);

	        sc.close();
	    }
	}

