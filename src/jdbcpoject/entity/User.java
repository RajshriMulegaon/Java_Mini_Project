package jdbcpoject.entity;
public class User
{
	private int userId;
	private String userName;
	private String password;
	private String confPassword;
	private String firstName;
	private String LastName;
	private String mobileNo;
	public String getAge;
	public User()
	{
		
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", confPassword="
				+ confPassword + ", firstName=" + firstName + ", LastName=" + LastName + ", mobileNo=" + mobileNo + "]";
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGetAge() {
		return getAge;
	}
	public void setGetAge(String getAge) {
		this.getAge = getAge;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
