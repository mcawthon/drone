package helpers;

public class DBTest
{
	public static void main(String[] args)
	{
		LoginHelper ldb = new LoginHelper();
		System.out.println(ldb.validateUser("admin", "admin"));
		System.out.println(ldb.validateUser("not", "auser"));
	}
}
