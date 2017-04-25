package by.epam.l14.homework.Service;

public final class ServiceFactory
{
	private static final ServiceFactory instance = new ServiceFactory();	
	private final SportItemService shop = new SportItemServiceStored();

	private ServiceFactory()
	{
	}

	public static ServiceFactory getInstance()
	{
		return instance;
	}

	public SportItemService getSportShop()
	{
		return shop;
	}

}
