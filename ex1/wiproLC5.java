import java.util.*;
public class wiproLC5 {
	  public static void main(String[] args) {
	int[] a = {15, 18, 42, 51};
    int[] b = {8, 11, 16, 17, 44, 58, 71, 74};

    int[] c = new int[a.length + b.length];

    int i = 0, j = 0, k = 0;

    while (i < a.length && j < b.length) {
        if (a[i] < b[j]) {
            c[k] = a[i];
            i++;
        } else {
            c[k] = b[j];
            j++;
        }
        k++;
    }

    while (i < a.length) {
        c[k] = a[i];
        i++;
        k++;
    }

    while (j < b.length) {
        c[k] = b[j];
        j++;
        k++;
    }

    System.out.print("Merged Array: ");
    for (int x : c) {
        System.out.print(x + " ");
    }
}
}
	


