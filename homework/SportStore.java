package by.epam.l14.homework;

import by.epam.l14.homework.Controller.Controller;


/*Предметная область: Магазин проката спортивных товаров
Напишите приложение, позволяющее магазину, предоставляющему спортивные
товары в прокат вести учет.
*/


public class SportStore
{
	public static void main(String[] args)
	{
		
		Controller c = new Controller();
		//	ITEM_RENT, ITEM_GETBACK, ITEM_FIND, WRONG_REQUEST
		System.out.println(c.executeTask("ITEM_FIND 4"));
		System.out.println(c.executeTask("ITEM_RENT 4"));
		System.out.println(c.executeTask("ITEM_RENT 4"));		
		System.out.println(c.executeTask("ITEM_RENT 4"));
		System.out.println(c.executeTask("ITEM_RENT 4"));
		System.out.println(c.executeTask("ITEM_FIND 4"));
		System.out.println(c.executeTask("ITEM_RENT 4"));
		System.out.println(c.executeTask("ITEM_RENT 4"));
		System.out.println(c.executeTask("ITEM_GETBACK 4"));
		System.out.println(c.executeTask("ITEM_GETBACK 4"));		
		System.out.println(c.executeTask("ITEM_GETBACK 4"));
		System.out.println(c.executeTask("ITEM_FIND 4"));
		System.out.println(c.executeTask("ITEM_GETBACK 4"));
		System.out.println(c.executeTask("ITEM_GETBACK 4"));
		System.out.println(c.executeTask("ITEM_FIND 4"));
		
		System.out.println(c.executeTask("ITEM_FIND 7"));
		System.out.println(c.executeTask("ITEM_GETBACK 7"));
		System.out.println(c.executeTask("ITEM_FIND 7"));
		

	}
}
