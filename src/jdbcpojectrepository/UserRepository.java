package jdbcpojectrepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Scanner;
import jdbcpoject.dbconfig.DatabaseConnection;
import jdbcpoject.entity.User;
import mainpack.BloodBank;

public class UserRepository implements UserRepositoryInterface
{
	//private static final
	User user = null;
		private Connection connection;
	    static Scanner scanner=new Scanner(System.in);
	    PreparedStatement preparedStatement=null;
	    BloodBank bloodbank=new BloodBank();
    	String[] validBloodGroups = {"A+","A-","B+","B-","AB+","AB-","O+","O-" };
	    public UserRepository()
	    {
	        this.connection = DatabaseConnection.getConnection();
	    }
	    @Override
	     public User adminActivities(UserRepository userRepository) throws SQLException 
	     {
	    	while(true){
	    		try {
	    	        System.out.println("\t1. Sign Up");
	    	        System.out.println("\t2. Sign In");
	    	        int op1=scanner.nextInt();
	    	        if(op1==1)
	    	        {
	                     User regAdmin= new User();
	    	        	System.out.println("\t Enter The User Id:");
	    	        	regAdmin.setUserId(scanner.nextInt());
                        System.out.println("\tUsername:");
                        regAdmin.setUserName(scanner.next());
                        System.out.println("\tPassword:");
                        regAdmin.setPassword(scanner.next());
                        System.out.println("\tConfirm Password:");
                        regAdmin.setConfPassword(scanner.next());
                        System.out.println("\tFirstname:");
                        regAdmin.setFirstName(scanner.next());
                        System.out.println("\tLastname:");
                        regAdmin.setLastName(scanner.next());
                        System.out.println("\tEnter Mobile Number:");
                        regAdmin.setMobileNo(scanner.next());
                        User registeredUser = userRepository.registerAdmin(regAdmin);
                        if (registeredUser != null) 
                        {
                            System.out.println("\tRegistered Successfully");
                            
                        } else {
                            System.out.println("\tRegistration Failed");
                        }
	    	        }
	    	        else {
	    	        System.out.println("\tEnter Username");
	    	        String email = scanner.next();
	    	        System.out.println("\tEnter Password");
	    	        String password = scanner.next();
                    User loginUser = new User();
                    loginUser.setUserName(email);
                    loginUser.setPassword(password);
                    User loggedInUser = userRepository.loginAdmin(loginUser);
                    if (loggedInUser != null) {
                        System.out.println("\tLogin Is Successful :)");
                        break;
                    } else {
                        System.out.println("\tLogin Failed, Check The Credentials :(");
                    }
                }
            } catch (SQLException e)
	    		{
                System.out.println("\tError executing SQL query: " + e.getMessage());
            }catch (InputMismatchException e) 
	    		{
                System.out.println("\tInvalid input. Please enter a valid option.");
            } 
	    	}
        
	         System.out.println("\t 1. Show Donors from Database");
	         System.out.println("\t 2. Read Donors from File");
	         System.out.println("\t 3. Save Donors to File");
	         System.out.println("\t 4. Search Donor By Id");
	         System.out.println("\t 5. Delete Donor By Id");
	         System.out.println("\t 6. Exit");

	         int choice;
	         do {
	             System.out.print("\tEnter your choice (1-6):");
	            
	             choice = scanner.nextInt();
	             scanner.nextLine(); 
	             switch (choice) {
	                 case 1:
	                     User showDonors = new User();
	                     userRepository.showDonorsFromDatabase(showDonors);
	                     break;
	                 case 2:
	                     User readDonorsDetails = new User();
	                     userRepository.readDonorsFromFile(readDonorsDetails);
	                     break;
	                 case 3:
	                     User saveDonorsDetails = new User();
	                     userRepository.saveDonorsToFile(saveDonorsDetails);
	                     break;
	                 case 4:
	                     User donorById = new User();
	                     userRepository.getDonorById(donorById);
	                     break;
	                 case 5:
	                     User deleteDonor= new User();
	                     userRepository.deleteDonor(deleteDonor);
	                     break;
	                 case 6:
	                     System.out.println("\tExiting Admin Section...");
	                     break;
	                 default:
	                     System.out.println("\tInvalid choice. Please try again.");
	                     break;
	             }
	         } while (choice !=6);

	         return user;
			
	     }
	 
		@Override
	    public User userActivities(UserRepository userRepository) throws SQLException 
	    {
			while(true){
	    		try {
	    	        System.out.println("\t1. Sign Up");
	    	        System.out.println("\t2. Sign In");
	    	        int op1=scanner.nextInt();
	    	        if(op1==1)
	    	        {
	                     User regUser= new User();
	    	        	System.out.println("\t Enter The User Id:");
	    	        	regUser.setUserId(scanner.nextInt());
                        System.out.println("\tUsername:");
                        regUser.setUserName(scanner.next());
                        System.out.println("\tPassword:");
                        regUser.setPassword(scanner.next());
                        System.out.println("\tConfirm Password:");
                        regUser.setConfPassword(scanner.next());
                        System.out.println("\tFirstname:");
                        regUser.setFirstName(scanner.next());
                        System.out.println("\tLastname:");
                        regUser.setLastName(scanner.next());
                        System.out.println("\tEnter Mobile Number:");
                        regUser.setMobileNo(scanner.next());
                        User registeredUser = userRepository.registerAdmin(regUser);
                        if (registeredUser != null) 
                        {
                            System.out.println("\tRegistered Successfully");
                            
                        } else {
                            System.out.println("\tRegistration Failed");
                        }
	    	        }
	    	        else {
	    	        System.out.println("\tEnter Username");
	    	        String email = scanner.next();
	    	        System.out.println("\tEnter Password");
	    	        String password = scanner.next();
                    User loginUser = new User();
                    loginUser.setUserName(email);
                    loginUser.setPassword(password);
                    User loggedInUser = userRepository.loginUser(loginUser);
                    if (loggedInUser != null) {
                    	
                        System.out.println("\tLogin Is Successful :)");
                        break;
                    } else {
                        System.out.println("\tLogin Failed, Check The Credentials :(");
                    }
                }
            } catch (SQLException e)
	    		{
                System.out.println("\tError executing SQL query: " + e.getMessage());
            }catch (InputMismatchException e) 
	    		{
                System.out.println("\tInvalid input. Please enter a valid option.");
            } 
	    	}
        
	            System.out.println("\t1. Check U Medically Fit For Donate Blood");
	            System.out.println("\t2. Add Donor ");
                System.out.println("\t3. Check Donor By Blood Group:");
	            System.out.println("\t4. Exit");

	            int choice1;
	            do {
	                System.out.print("\tEnter your choice (1-4):");
	                choice1= scanner.nextInt(); 

	                switch (choice1) {
	                    case 1:
	                        User checkMedicallyFit = new User();
	                        userRepository.checkDonorEligibility(checkMedicallyFit);
	                        break;
	                    case 2:
	                    	User addDonor1 = new User();
	                        userRepository.addDonor(addDonor1);
	                    	break;
	                    case 3:
	                        User searchByBloodGroup = new User();
	                        userRepository.getDonorByBloodGroup(searchByBloodGroup);
	                        break;
	                    case 4:
	                        System.out.println("\tExiting User Section...");
	                    	break;
	                    default:
	                        System.out.println("\tInvalid choice. Please try again.");
	                        break;
	                }
	            } while (choice1!=4);
			return user;			
	    
		}

@Override
public User registerAdmin(User user) throws SQLException {
    preparedStatement = connection.prepareStatement("INSERT INTO registrationadmin VALUES (?, ?, ?, ?, ?, ?, ?);");
    preparedStatement.setInt(1, user.getUserId());
    preparedStatement.setString(2, user.getUserName());
    preparedStatement.setString(3, user.getPassword());
    preparedStatement.setString(4, user.getConfPassword());
//    if(user.getPassword().length()<8)
//    {
//       System.out.println("Password should be 8 character");
//       }
    preparedStatement.setString(5, user.getFirstName());
    preparedStatement.setString(6, user.getLastName());
    preparedStatement.setString(7, user.getMobileNo());
    int res = preparedStatement.executeUpdate();
    if (res == 1) {
        return user;
    } else {
        return null;
    }
}

@Override
public User registerUser(User user) throws SQLException {
    preparedStatement = connection.prepareStatement("INSERT INTO registration VALUES (?, ?, ?, ?, ?, ?);");
    preparedStatement.setInt(1, user.getUserId());
    preparedStatement.setString(2, user.getUserName());
    preparedStatement.setString(3, user.getPassword());
    if(user.getPassword().length()<8)
    {
       System.out.println("Password should be 8 character");
       }
    
    preparedStatement.setString(4, user.getFirstName());
    preparedStatement.setString(5, user.getLastName());
    preparedStatement.setString(6, user.getMobileNo());
    int res = preparedStatement.executeUpdate();
    if (res == 1) {
        return user;
    } else {
        return null;
    }
}
@Override
public User loginAdmin(User user) throws SQLException
{
String s= "select * from registrationadmin where username=? and password=?;";
preparedStatement=connection.prepareStatement(s);
String s1=user.getUserName();
String s2=user.getPassword();
preparedStatement.setString(1,s1);
preparedStatement.setString(2,s2);
ResultSet rs=preparedStatement.executeQuery();

if(rs.next())
{
	return user;
}
 return null;
}
@Override
public User loginUser(User user) throws SQLException 
{
	preparedStatement=connection.prepareStatement("select * from registration where username=? and passsword=?");
	preparedStatement.setString(1,user.getUserName());
	preparedStatement.setString(2, user.getPassword());
	ResultSet rs=preparedStatement.executeQuery();
	if(rs.next()) {
		return user;
		}else {
            System.out.println("Invalid username or password.");
            return null;
		}
}
@Override
public User checkDonorEligibility(User user) 
{

	System.out.println("\tEnter Your Age:");
	int age=scanner.nextInt();
	System.out.println("\tDo U Have Any Medical Issues?");
	String option = scanner.next();
    if(age>65||age<18||option.equalsIgnoreCase("yes"))
    {
    	System.out.println("\tU Are Not Eligible To Donate");
    	return exit();
    } 
    else if(age>18&&option.equalsIgnoreCase("no"))
    {
    	System.out.println("\tU Are Eligible To Donate");
    	return addDonor(user);
    } 
	
	else if (age>65||age<18||option.equalsIgnoreCase("no")) 
	{
	    System.out.println("\tYou Cannot Donate Blood");
	    return exit();
	    } else
	    System.out.println("\tInvalid input. Please enter 'yes' or 'no'.");
	    return user;
	}
	
private User exit() {
	return user;
	// TODO Auto-generated method stub
	
}

@Override
public User addDonor(User user) {
    System.out.print("\tEnter donor's name: ");
    String name = scanner.next();
    System.out.print("\tEnter donor's blood group: ");
    String bloodGroup = scanner.next();
    System.out.print("\tEnter donor's age: ");
    int age = scanner.nextInt();
    System.out.print("\tEnter donor's contact number: ");
    String contactNumber = scanner.next();
    try {
        if (contactNumber.length() >= 10 && contactNumber.length() <= 13) {
            if (isValidBloodGroup(bloodGroup, validBloodGroups)) {
                if (age > 18 && age < 70) {
                    String query = "INSERT INTO donors(name, blood_group, age, contact_number) VALUES (?, ?, ?, ?)";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, bloodGroup);
                    preparedStatement.setInt(3, age);
                    preparedStatement.setString(4, contactNumber);
                    preparedStatement.executeUpdate();
                    System.out.println("\tDonor added successfully.");
                } else {
                    System.out.println("Invalid age. Donor's age should be greater than 18 and less than 70.");
                }
            } else {
                System.out.println("Invalid blood group. Blood group should be from the following: A+, A-, B+, B-, AB+, AB-, O+, O-");
            }
        } else {
            System.out.println("Invalid contact number length. Contact number should be between 10 to 13 digits. Please enter valid.");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return user;
}
@Override 
public User showDonorsFromDatabase(User user) {
        try {
            String query = "SELECT * FROM donors";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\tDonors (from database):");
            System.out.println("\tID\tName\t\tBlood Group\tAge\tContact Number");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String bloodGroup = resultSet.getString("blood_group");
                int age = resultSet.getInt("age");
                String contactNumber = resultSet.getString("contact_number");
                System.out.println("\t"+id + "\t" + name + "\t\t" + bloodGroup + "\t\t" + age + "\t" + contactNumber);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return user;
    }
  
    public User saveDonorsToFile(User user) {
        try {
            File file = new File("donors.txt");
            FileWriter writer = new FileWriter(file);

            String query = "SELECT * FROM donors";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String bloodGroup = resultSet.getString("blood_group");
                int age = resultSet.getInt("age");
                String contactNumber = resultSet.getString("contact_number");
                writer.write(id + "," + name + "," + bloodGroup + "," + age + "," + contactNumber + "\n");
            }

            writer.close();
            System.out.println("\tDonor data saved to donors.txt");
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
		return user;
    }
    @Override
    public User readDonorsFromFile(User user) throws SQLException {

        try {
            File file = new File("donors.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("\tDonors (from file):");
            System.out.println("\tID\tName\t\tBlood Group\tAge\tContact Number");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String bloodGroup = data[2];
                int age = Integer.parseInt(data[3]);
                String contactNumber = data[4];
                System.out.println("\t"+id + "\t" + name + "\t\t" + bloodGroup + "\t\t" + age + "\t" + contactNumber);
            }

            scanner.close();
        } catch (NumberFormatException | IOException e) {
        	System.out.println(e.getMessage());
        }
		return user;
    }

    public User getDonorById(User user) {
        System.out.print("\tEnter donor ID To Search: ");
        int donorId = scanner.nextInt();
         if (donorId <= 0) {
            System.out.println("\tInvalid donor ID. Donor ID must be a positive integer.");
            return null;
        }

        try {
            String query = "SELECT * FROM donors WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, donorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String bloodGroup = resultSet.getString("blood_group");
                int age = resultSet.getInt("age");
                String contactNumber = resultSet.getString("contact_number");
                System.out.println("\tDonor found:");
                System.out.println("\tID:" + id + "\tName:" + name + "\tBlood Group:" + bloodGroup + "  " + "\tAge:" + age + "  " + "\tContact Number:" + contactNumber);

            } else {
                System.out.println("\tDonor with ID " + donorId + " not found.");
            }
        } catch (InputMismatchException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
    
//    private boolean isValidBloodGroup(String bloodGroup, String[] validBloodGroups) {
//        for (String validGroup : validBloodGroups) {
//            System.out.println("Checking: " + validGroup);
//            if (validGroup.equalsIgnoreCase(bloodGroup)) {
//                return true;
//            }
//        }
//        return false;
//    }
    private boolean isValidBloodGroup(String bloodGroup, String[] validBloodGroups) {
        if (bloodGroup == null) {
            return false;
        }
        for (String validGroup : validBloodGroups) {
            if (bloodGroup.equalsIgnoreCase(validGroup) && !bloodGroup.isBlank()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getDonorByBloodGroup(User user) {
        String donorBloodGroup = "";
        while (true) {
            System.out.print("\tEnter donor Blood Group: ");
            donorBloodGroup = scanner.next();
            if (isValidBloodGroup(donorBloodGroup, validBloodGroups)) {
                break; // Valid blood group, exit the loop
            } else {
                System.out.println("Invalid blood group. Blood group should be one of the following: A+, A-, B+, B-, AB+, AB-, O+, O-");
            }
        }

        try {
            String query = "SELECT * FROM donors WHERE blood_group = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, donorBloodGroup);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String bloodGroup = resultSet.getString("blood_group");
                int age = resultSet.getInt("age");
                String contactNumber = resultSet.getString("contact_number");
                System.out.println("\tDonor found With" + " " + bloodGroup + " Blood Group");
                System.out.println("\tID:" + id + "\tName:" + name + "\tBlood Group:" + bloodGroup + "  " + "\tAge:" + age + "  " + "\tContact Number:" + contactNumber);
            } else {
                System.out.println("\tDonor with BloodGroup " + donorBloodGroup + " not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


public User deleteDonor(User user) {
    System.out.print("\tEnter donor ID to delete: ");
    int donorId = scanner.nextInt();
    scanner.nextLine(); 
    if (donorId <= 0) {
        System.out.println("\tInvalid donor ID. Donor ID must be a positive integer.");
        return null;
    }
    try {
        String query = "DELETE FROM donors WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, donorId);
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("\tDonor with ID "+donorId + " "+"deleted successfully.");
        } else {
            System.out.println("\tDonor with ID "+donorId+" not found.");
        }
    } catch (InputMismatchException|SQLException e) 
    {
        System.out.println(e.getMessage());
    }
	return user;
}


}

