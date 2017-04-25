package by.epam.l14.homework.Controller;


import by.epam.l14.homework.Service.ServiceException;
import by.epam.l14.homework.Service.ServiceFactory;
import by.epam.l14.homework.Service.SportItemService;

public class GetBack implements Command
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
			if (item.getBack(id))
			{
				response = "Одна единица товара успешно возвращена на склад";
			}
			else
			{
				response = "Возврат не произведен. Попробуйте позже";
			}
			;
		}
		catch (ServiceException | NumberFormatException e)
		{
			response = "В процессе возврата возникла проблема. Возврат не произведен.";
		}
		return response;
	}

}
