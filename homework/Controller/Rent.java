package by.epam.l14.homework.Controller;

import by.epam.l14.homework.Service.ServiceException;
import by.epam.l14.homework.Service.ServiceFactory;
import by.epam.l14.homework.Service.SportItemService;

public class Rent implements Command
{

	@Override
	public String execute(String request)
	{
		String response;

		ServiceFactory factory = ServiceFactory.getInstance();
		SportItemService item = factory.getSportShop();
		try
		{
			int id = Integer.parseInt(request);
			if (item.rent(id))
			{
				response = "Одна единица товара спешно взята в аренду";
			}
			else
			{
				response = "Аренда не произведена. Попробуйте позже";
			}
			;
		}
		catch (ServiceException | NumberFormatException e)
		{
			response = "В процессе аренды возникла проблема. Аренда не произведена.";
		}
		return response;
	}

}
