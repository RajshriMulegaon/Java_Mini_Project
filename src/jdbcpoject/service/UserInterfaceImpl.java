package jdbcpoject.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbcpoject.entity.User;
import jdbcpojectrepository.UserRepositoryInterface;
import jdbcpojectrepository.UserRepository;

public class UserInterfaceImpl implements UserInterface 
{
	private Connection connection;
    static Scanner scanner=new Scanner(System.in);
    PreparedStatement preparedStatement=null;
	private UserRepositoryInterface userRepositoryInterface;
	
	public UserInterfaceImpl()
	{
		this.userRepositoryInterface= new UserRepository();
	}
	
	 @Override
	 public User registerUser(User user) throws SQLException 
	 {
	        if (user.getPassword() == null || user.getPassword().isEmpty()) 
	        {
	            System.out.println("Password cannot be empty.");
	            return null;
	        }

	        else if (user.getPassword().length() < 8) {
	            System.out.println("Password should be at least 8 characters.");
	            return null;
	        }

	        boolean containsUppercase = false;
	        boolean containsLowercase = false;
	        boolean containsDigit = false;
	        boolean containsSpecialCharacter = false;
	        String specialCharacters = "@$!%*?&";

	        for (char ch : user.getPassword().toCharArray())
	        {
	            if (Character.isUpperCase(ch))
	            {
	                containsUppercase = true;
	            } else if (Character.isLowerCase(ch))
	            {
	                containsLowercase = true;
	            } else if (Character.isDigit(ch)) 
	            {
	                containsDigit = true;
	            } else if (specialCharacters.indexOf(ch) != -1)
	            {
	                containsSpecialCharacter = true;
	            }
	        }

	        if (!(containsUppercase && containsLowercase && containsDigit && containsSpecialCharacter))
	        {
	            System.out.println("Password should contain at least one uppercase,lowercase,digit,special character(@ $ ! * &).");
	            return null;
	        }

	        else if (user.getPassword().equals(user.getConfPassword()))
	        {
	            System.out.println("Password and confirm password don't match.");
	            return null;
	        }

	
	        try {
	            return userRepositoryInterface.registerUser(user);
	        } catch (SQLException e) {
	            System.out.println("Registration failed. Please try again.");
	            return null;
	        }
	    }

		@Override
	public User loginUser(User user) throws SQLException
	{
			String s1=user.getUserName();
			String s2=user.getPassword();
			preparedStatement=connection.prepareStatement("select * from registration where username=? and passsword=?");
			preparedStatement.setString(1,s1);
			preparedStatement.setString(2,s2);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				return user;
				}

			 if(user.getUserName().equals(s1))
					 {
					 
					 }
		        else if (user.getPassword().equals(user.getConfPassword()))
		        {
		            System.out.println("Password and confirm password don't match.");
		            return null;
		        }

		try 
		{
			return userRepositoryInterface.loginUser(user);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Override
	public User readDonorsFromFile(User user) throws SQLException
	{
		return null;
	}

	

	@Override
	public User checkDonorEligibility(User dummyUser5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteDonor(User dummyUser4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getDonorById(User user) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveDonorsToFile(User dummyUser2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showDonorsFromDatabase(User dummyUser)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addDonor(User dummyUser1) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerAdmin(User user) throws SQLException 
	{
        if (user.getPassword() == null || user.getPassword().isEmpty()) 
        {
            System.out.println("Password cannot be empty.");
            return null;
        }

        else if (user.getPassword().length() < 8) {
            System.out.println("Password should be at least 8 characters.");
            return null;
        }

        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsDigit = false;
        boolean containsSpecialCharacter = false;
        String specialCharacters = "@$!%*?&";

        for (char ch : user.getPassword().toCharArray())
        {
            if (Character.isUpperCase(ch))
            {
                containsUppercase = true;
            } else if (Character.isLowerCase(ch))
            {
                containsLowercase = true;
            } else if (Character.isDigit(ch)) 
            {
                containsDigit = true;
            } else if (specialCharacters.indexOf(ch) != -1)
            {
                containsSpecialCharacter = true;
            }
        }

        if (!(containsUppercase && containsLowercase && containsDigit && containsSpecialCharacter))
        {
            System.out.println("Password should contain at least one uppercase,lowercase,digit,special character(@ $ ! * &).");
            return null;
        }

        else if (user.getPassword().equals(user.getConfPassword()))
        {
            System.out.println("Password and confirm password don't match.");
            return null;
        }

        try {
            return userRepositoryInterface.registerAdmin(user);
        } catch (SQLException e) {
            System.out.println("Registration failed. Please try again.");
            return null;
        }
	}
}