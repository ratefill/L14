package by.epam.l14.homework.Service;

public class ServiceException extends Exception
{

	private static final long serialVersionUID = 5191045216664309726L;

	public ServiceException(String message)
	{
		super(message);
	}

	public ServiceException()
	{
		super();
	}

	public ServiceException(Exception e)
	{
		super(e);
	}
}