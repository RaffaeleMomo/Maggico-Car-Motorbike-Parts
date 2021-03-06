package test.testManager;



import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.CarrelloManager;
import model.ProductManager;
import bean.CartBean;
import bean.ClientBean;
import bean.ProductBean;
import bean.UserBean;

public class CarrelloManagerTest {

	private CartBean cart;
	private ProductManager model;
	private UserBean user;
	private ClientBean client;
	private ProductBean prod;
	private CarrelloManager modelCart;
	
	@Before
	public void setUp() throws SQLException
	{
		modelCart = CarrelloManager.getCarrelloManager();
		model = ProductManager.getProductManager();
		cart = new CartBean();
		user = new UserBean();
		prod = new ProductBean();
		
		user.setUsername("Raff93");
		client = new ClientBean();
		client.setUsername("Raff93");
		
		prod = model.doRetrieveByKey(4);
		prod.setQtprod(5);
		
		cart.addItem(prod);
		
	}
	
	@Test
	public void pasteInDbTest() throws SQLException
	{
		CarrelloManager.updateTable(cart, client);
	}
	
	@Test
	public void doRetriveAllTest() throws SQLException
	{
		cart = CarrelloManager.doRetrieveAll(user);
	}
	
	@Test
	public void doSaveTest() throws SQLException
	{
		CarrelloManager.doSave(client, 5, 3);
	}
	
	@Test
	public void doUpdateTest() throws SQLException
	{
		CarrelloManager.doUpdate(5, 2, client);
	}
	
}
