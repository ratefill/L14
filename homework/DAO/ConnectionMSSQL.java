package by.epam.l14.homework.DAO;

public class ConnectionMSSQL
{
	public static final String server = "localhost:1433";
	public static final String database = "test";
	public static final String user = "test";
	public static final String password = "test";
	
	public static final String SProc_rent = "{call dbo.rent(?, ?)}";
	public static final String SProc_getBack = "{call dbo.getBack(?, ?)}";
	public static final String SProc_find = "{call dbo.find(?)}";

	public static String ConnectionStr()
	{
		String constr = "jdbc:sqlserver://" + server + ";database=" + database + ";user=" + user + ";password="	+ password + ";";
		return constr;

	}
}
