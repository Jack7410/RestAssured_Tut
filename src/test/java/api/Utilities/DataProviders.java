package api.Utilities;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.PayLoad.UserPayLoad;

public class DataProviders {
	
	ExcelRead read;


	@DataProvider(name="UserData")
	public String[][]setData() throws Exception {

		read = new ExcelRead();
		
		
		int rownum=read.getRowCount(".//UsersData.xlsx", "Sheet1");
		int cellnum=read.getCellCount(".//UsersData.xlsx", "Sheet1");
		
		String data[][] =new String [rownum][cellnum];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<cellnum;j++) {
				data[i-1][j]=read.getData(".//UsersData.xlsx", "Sheet1", i,j);
			}
		}
		
		return data;
		

	}
	
	@DataProvider(name="UserName")
	public String [] getUserName() throws Throwable {
		read=new ExcelRead();
		
		int rowcount=read.getRowCount(".//UsersData.xlsx", "Sheet1");
		
		String[] username=new String[rowcount];
		
		for(int i=0;i<rowcount;i++) {
			username[i]=read.getData(".//UsersData.xlsx", "Sheet1", i, 1);
		}
		
		return username;
		
	}

}
