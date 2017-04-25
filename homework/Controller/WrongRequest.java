package by.epam.l14.homework.Controller;


public class WrongRequest implements Command{

	@Override
	public String execute(String request) {
		String response;
		response = "Неверный формат запроса. Попробуйте еще раз";
		return response;
	}

}