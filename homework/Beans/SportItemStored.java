package by.epam.l14.homework.Beans;

public class SportItemStored implements SportItem
{
	private int id;
	private String name;
	private double price;
	private int countInStock;
	private int countTotal;

	public SportItemStored(int id, String name, double price, int countInStock, int countTotal)
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.countInStock = countInStock;
		this.countTotal = countTotal;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public double getPrice()
	{
		return price;
	}

	@Override
	public void setPrice(double price)
	{
		this.price = price;
	}

	@Override
	public int getCountInStock()
	{
		return countInStock;
	}

	@Override
	public void setCountInStock(int countInStock)
	{
		this.countInStock = countInStock;
	}

	@Override
	public int getCountTotal()
	{
		return countTotal;
	}

	@Override
	public void setCountTotal(int countTotal)
	{
		this.countTotal = countTotal;
	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "id=" + id + ", name=" + name + ", price=" + price + ", countInStock=" + countInStock
				+ ", countTotal=" + countTotal;
	}
}
