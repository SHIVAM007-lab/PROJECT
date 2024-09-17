package LOGINTEST;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BASE.base;
import BASE.excellreader;
import LOGINPAGE.loginpage;

public class logintest extends base {

	@Test (dataProvider="dp")
	public void Logintest(String uname,String pass,String expected)
	{
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.accept();
			assertEquals(expected, text);
			
			driver = connect();
		} catch (IOException e) {
			String actualTitle = driver.getTitle();
			assertEquals(expected, actualTitle);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginpage log = new loginpage(driver);
		log.enterusername("uname");
		log.enterpassword("pass");
		log.login();
	
	}

	@DataProvider(name="dp")
	public Object[][] dataprovider()
	{
		excellreader rd=new excellreader("C:\\Users\\HP\\Documents\\file\\test.xlsx","Guru99");
		int row = rd.rowCount();
		int col = rd.colCount();
		Object obj[][]= new Object[row-1][col];
		
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				String data = rd.getdata(i, j);
				obj[i-1][j]=data;
			}
		}
		
	return obj;
	}
	}