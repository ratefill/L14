package by.epam.l14.homework.DAO;

public class DAOException extends Exception
{

	private static final long serialVersionUID = 2079375677487953938L;

	public DAOException(String message)
	{
		super(message);
	}

	public DAOException()
	{
		super();
	}

	public DAOException(Exception e)
	{
		super(e);
	}
}