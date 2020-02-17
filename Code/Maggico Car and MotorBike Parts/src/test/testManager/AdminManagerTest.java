package test.testManager;


import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.AdminManager;
import model.UserManager;
import bean.AdminBean;

public class AdminManagerTest extends Mockito{
	boolean booleanRes;
	AdminManager modelAdmin;
	UserManager modelUser;
	AdminBean admin;
	AdminBean admin1;
	String userAdmin;
	String otherUser;
	
	Collection<AdminBean> admins;
	
	@Before
	public void setUp()
	{
		modelAdmin = new AdminManager();
		modelUser = new UserManager();
		
		userAdmin = "Vincenzo";
		otherUser = "Raff93";
		
		admin = new AdminBean();
		admin.setUsername("RaffaeleBreak9");
		admin.setPassword("Password1");
		admin.setEmail("raffaeleBreak9@gmail.com");
		
		admin1 = new AdminBean();
		admin1.setUsername("Raffaele");
		admin1.setPassword("Password1e");
		admin1.setEmail("raffaeleB9e@gmail.com");
	}
	
	@Test
	public void isAdminTest() throws SQLException
	{
		booleanRes = modelAdmin.isAdmin(userAdmin);
		assertEquals(true, booleanRes);
	}
	
	@Test
	public void isNotAdminTest() throws SQLException
	{
		booleanRes = modelAdmin.isAdmin(otherUser);
		assertEquals(false, booleanRes);
	}
	
	@Test
	public void doSaveTest() throws SQLException
	{
		modelUser.doSave(admin1);
		modelAdmin.doSave(admin1);
	}
	
	@Test
	public void doDeleteTest() throws SQLException
	{
		modelUser.doDelete(admin1);
	}
	

}
