package by.epam.l14.homework.DAO;

public final class DAOfactory
{
	private static final DAOfactory instance = new DAOfactory();	
	private final SportItemDAO shop = new SportItemDAOStored();

	private DAOfactory()
	{
	}

	public static DAOfactory getInstance()
	{
		return instance;
	}

	public SportItemDAO getSportShop()
	{
		return shop;
	}

}
