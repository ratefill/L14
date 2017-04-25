package by.epam.l14.homework.Controller;

import by.epam.l14.homework.Beans.SportItem;
import by.epam.l14.homework.Service.ServiceException;
import by.epam.l14.homework.Service.ServiceFactory;
import by.epam.l14.homework.Service.SportItemService;

public class Find implements Command
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
			SportItem si = item.find(id);
			
			if (si !=null)
			{
				response = si.toString();
			}
			else
			{
				response = "Товар не найден.";
			}
			;
		}
		catch (ServiceException | NumberFormatException e)
		{
			response = "В процессе поиска возникла проблема. Товар не найден.";
		}
		return response;
	}

}

