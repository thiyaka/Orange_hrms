package dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class Login_Dataprovider {

	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException{
		
		String path="./src/test/resources/testData/Orangehrms_LoginData.xlsx";
		///Orange_hrms/src/test/resources/testData/Orangehrms_LoginData.xlsx
		
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcells=xlutil.getCellCount("Sheet1", totalrows);
		
		String logindata [][] =new String[totalrows][totalcells];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcells;j++) {
				logindata [i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}
}
