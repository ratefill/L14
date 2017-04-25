package by.epam.l14.homework.Controller;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider
{
	private final Map<CommandList, Command> repository = new HashMap<>();

	CommandProvider()
	{
		repository.put(CommandList.ITEM_RENT, new Rent());
		repository.put(CommandList.ITEM_GETBACK, new GetBack());
		repository.put(CommandList.ITEM_FIND, new Find());
		repository.put(CommandList.WRONG_REQUEST, new WrongRequest());

	}

	public Command getCommand(String name)
	{
		CommandList com = null;
		Command exec = null;
		try
		{
			com = CommandList.valueOf(name.toUpperCase());
			exec = repository.get(com);
		}
		catch (IllegalArgumentException | NullPointerException e)
		{
			exec = repository.get(CommandList.WRONG_REQUEST);
		}
		return exec;
	}

}