package by.epam.l14.homework.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import by.epam.l14.homework.Beans.SportItem;
import by.epam.l14.homework.Beans.SportItemStored;
import by.epam.l14.homework.DAO.DAOException;

public class SportItemDAOStored implements SportItemDAO
{
	public SportItemDAOStored()
	{
		super();

	}

	private boolean exec(int id, String Sproc) throws DAOException
	{
		// Declare the JDBC objects.
		Connection con = null;
		CallableStatement cstmt = null;	

		Boolean result = false;
		int sproc = 0;// sproc result
		try
		{
			// Establish the connection.

			con = DriverManager.getConnection(ConnectionMSSQL.ConnectionStr());

			// Query test data by using a stored procedure.
			cstmt = con.prepareCall(Sproc);
			cstmt.setInt(1, id);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);

			cstmt.execute();
			sproc = cstmt.getInt(2);

			result = sproc > 0 ? true : false;

		}
		// Handle any errors that may have occurred.
		catch (Exception e)
		{
			throw new DAOException(e.getMessage());
		}
		finally
		{
			try
			{
				if (cstmt != null)
				{
					cstmt.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				throw new DAOException(e.getMessage());
			}
		}
		return result;
	}

	@Override
	public boolean rent(int id) throws DAOException
	{
		return exec(id, ConnectionMSSQL.SProc_rent);
	}

	@Override
	public boolean getBack(int id) throws DAOException
	{
		return exec(id, ConnectionMSSQL.SProc_getBack);
	};
	
	


	@Override
	public SportItem find(int id) throws DAOException
	{
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		SportItem result = null;

		try
		{
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectionMSSQL.ConnectionStr());

			
			CallableStatement cstmt = con.prepareCall(ConnectionMSSQL.SProc_find);
			cstmt.setInt(1, id);

			rs = cstmt.executeQuery();
			
			if (rs.next())
			{
				//int id, String name, double price, int countInStock, int countTotal 
				result = new SportItemStored(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),rs.getInt("countInStock"),rs.getInt("countTotal"));
			}
		}
		// Handle any errors that may have occurred.
		catch (Exception e)
		{
			throw new DAOException(e.getMessage());
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (stmt != null)
				{
					stmt.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				throw new DAOException(e.getMessage());
			}
		}

		return result;
	}
}
