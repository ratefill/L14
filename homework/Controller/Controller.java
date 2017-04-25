package by.epam.l14.homework.Controller;

public final class Controller
{

	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';

	public String executeTask(String request)
	{
		String commandName;
		String paramsList;
		Command executionCommand;
		int index;
		String response;
		
		index=request.indexOf(paramDelimeter);
		commandName = request.substring(0, index);
		paramsList = request.substring(index+1, request.length());
		executionCommand = provider.getCommand(commandName);
		
		response = executionCommand.execute(paramsList);
		return response;
	}
}