package by.epam.l14.homework.Service;

import by.epam.l14.homework.Beans.SportItem;

public interface SportItemService
{

	boolean rent(int id) throws ServiceException;

	boolean getBack(int id) throws ServiceException;
	
	SportItem find(int id) throws ServiceException;

}
