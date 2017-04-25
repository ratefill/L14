package by.epam.l14.homework.DAO;

import by.epam.l14.homework.Beans.SportItem;

public interface SportItemDAO
{

	boolean rent(int id) throws DAOException;

	boolean getBack(int id) throws DAOException;
	
	SportItem find(int id) throws DAOException;

}