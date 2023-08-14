package mainpack;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import jdbcpojectrepository.UserRepository;

public class BloodBank {

    public static void main(String[] args) throws SQLException {

        UserRepository userRepository = new UserRepository();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("\n \t        \t       \t***********Welcome To Bloodbank System************ \t      \t      \t");
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        try {
        do {
            System.out.println("\t1.Admin");
            System.out.println("\t2.User");
            System.out.println("\t3.Exit");

            System.out.print("\tEnter your choice (1-3): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("***********Admin Section**********");
                    userRepository.adminActivities(userRepository);
                    break;
                case 2:
                    System.out.println("***********User Section***********");
                    userRepository.userActivities(userRepository);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 3);
        }catch(InputMismatchException e)
        {
    	System.out.println(e.getMessage());
         }

    }
}
