package jdbcpojectrepository;
import java.sql.SQLException;
import java.util.Scanner;

import jdbcpoject.entity.User;

public  interface UserRepositoryInterface
{
	public  User registerUser(User user) throws SQLException ;
	public  User loginUser(User loginUser) throws SQLException;
	public User addDonor(User dummyUser1) throws SQLException;
    public User readDonorsFromFile(User user)throws SQLException;
	public User checkDonorEligibility(User user);
	public User deleteDonor(User user);
	public User getDonorById(User user);
	public User saveDonorsToFile(User user);
	public User showDonorsFromDatabase(User user);
	public User adminActivities(UserRepository userRepository) throws SQLException;
	public User userActivities(UserRepository userRepository) throws SQLException;
	public User registerAdmin(User user) throws SQLException;
	public User getDonorByBloodGroup(User user)throws SQLException;
	public User loginAdmin(User user) throws SQLException;



}
