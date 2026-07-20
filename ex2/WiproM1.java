import java.util.Scanner;

public class WiproM1 {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int[] empNo = {1001, 1002, 1003, 1004, 1005, 1006, 1007};

    String[] empName = {"Ashish", "Sushma", "Rahul","Chahat", "Ranjan", "Suman", "Tanmay"};

    char[] desCode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};

    String[] dept = {"R&D", "PM", "Acct","Front Desk", "Engg","Manufacturing", "PM"};

        int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};

        int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};

        int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        int index = -1;

        for (int i = 0; i < empNo.length; i++) {
            if (empNo[i] == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("There is no employee with empid: " + id);
            return;
        }

        String designation = "";
        int da = 0;

        switch (desCode[index]) {
            case 'e':
                designation = "Engineer";
                da = 20000;
                break;

            case 'c':
                designation = "Consultant";
                da = 32000;
                break;

            case 'k':
                designation = "Clerk";
                da = 12000;
                break;

            case 'r':
                designation = "Receptionist";
                da = 15000;
                break;

            case 'm':
                designation = "Manager";
                da = 40000;
                break;
        }

        int salary = basic[index] + hra[index] + da - it[index];

        System.out.println("\nEmployee Details");
        System.out.println(" ");
        System.out.println("Emp No: " + empNo[index]);
        System.out.println("Emp Name: " + empName[index]);
        System.out.println("Department: " + dept[index]);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);

        sc.close();
    }
}