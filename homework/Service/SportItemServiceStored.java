package by.epam.l14.homework.Service;

import by.epam.l14.homework.Beans.SportItem;
import by.epam.l14.homework.DAO.DAOfactory;
import by.epam.l14.homework.DAO.SportItemDAO;
import by.epam.l14.homework.DAO.DAOException;

public class SportItemServiceStored implements SportItemService
{
	private SportItemDAO check(int id) throws ServiceException
	{
		SportItemDAO result = null;

		if (id <= 0)
		{
			throw new ServiceException("Неверный входной параметр");
		}

		DAOfactory factory = DAOfactory.getInstance();
		result = factory.getSportShop();

		return result;
	}

	@Override
	public boolean rent(int id) throws ServiceException
	{
		Boolean result = false;

		try
		{
			SportItemDAO Item = check(id);
			result = Item.rent(id);
		}
		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage());
		}

		return result;
	}

	@Override
	public boolean getBack(int id) throws ServiceException
	{
		Boolean result = false;

		try
		{
			SportItemDAO Item = check(id);
			result = Item.getBack(id);
		}
		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage());
		}

		return result;
	}

	@Override
	public SportItem find(int id) throws ServiceException
	{
		SportItem result = null;

		try
		{
			SportItemDAO Item = check(id);
			result = Item.find(id);
		}
		catch (DAOException e)
		{
			throw new ServiceException(e.getMessage());
		}

		return result;
	}

}
