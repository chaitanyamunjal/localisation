package com.languagePoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanguageCheck {

static WebDriver driver;
	
	// Invoke the Browser
	public void invokeBrowser(String url){
		try {
			System.setProperty("webdriver.chrome.driver", "d:\\Userfiles\\cmunjal\\Desktop\\Selenium\\chrome driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.get(url);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Close the Browser
	public void closeBrowser(){
		try {
			Thread.sleep(5000);	
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// READ - Data from Excel Sheet
	public String[] readExcel() throws BiffException, IOException {
		String FilePath = "d:\\Userfiles\\cmunjal\\Desktop\\language1.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		int col1 = 0;
		int col2 = 1;
		int col3 = 2;
		
		String label[] = new String[totalNoOfRows-1];
		String value[] = new String[totalNoOfRows-1];
		String translate[] = new String[totalNoOfRows-1];
		
		for (int row = 1; row < totalNoOfRows; row++) {
			
			label[row-1] = sh.getCell(col1, row).getContents();
			translate[row-1] = sh.getCell(col2, row).getContents();
			value[row-1] = sh.getCell(col3, row).getContents();
		}
		
		for(int i=0;i<value.length;i++){
			System.out.println(translate[i]+"  and  "+value[i]);
		}
		
		// Get results from Check Language
		String results[] = checkLanguage(translate,value);
		
		// Write data to HTML file
		writeHTML(results,translate,label);
		return results;
	}

	// Check Language Function
	public String[] checkLanguage(String translate[],String value[]){
		String results[] = new String[value.length];
		
		try {
			
			invokeBrowser("http://localhost:8080/LanguagePOC/home");
			
			int i = 1;
			for(; i <= value.length-2; i++)
			{
				if(translate[i-1].equals("Yes"))
				{
					if(driver.findElement(By.id("L"+i)).getText().equals("XXXX"))
					{
						results[i-1] = "Passed";	
					}
					else{
						results[i-1] = "Failed";
					}
				
				}
				else{
					if(driver.findElement(By.id("L"+i)).getText().equals("XXXX"))
					{
						results[i-1] = "Failed";	
					}
					else{
						results[i-1] = "Passed";
					}
				}
			
			}
			
			for(; i <= value.length; i++)
			{
				if(translate[i-1].equals("Yes"))
				{
					if(driver.findElement(By.id("L"+i)).getAttribute("value").equals("XXXX"))
					{
						results[i-1] = "Passed";	
					}
					else{
						results[i-1] = "Failed";
					}
					
					
				
				}
				else{
					if(driver.findElement(By.id("L"+i)).getAttribute("value").equals("XXXX"))
					{
						results[i-1] = "Failed";	
					}
					else{
						results[i-1] = "Passed";
					}
					
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
		
	}
	
	// WRITE - Results to a New HTML Page
	public void writeHTML(String results[],String translate[],String label[]) throws BiffException, IOException{
		
		
		CreateHtmlDocument obj = new CreateHtmlDocument();
		obj.createHTML(results, translate, label);

		System.out.println(" Results have been written in the Excel Sheet");
	}
	
	
	// MAIN 
	public static void main(String[] args) throws BiffException, IOException {
	
		LanguageCheck obj = new LanguageCheck();
		
		// Get the Results -> by comparing values from Excel Sheet
		String results[] = obj.readExcel();
		
		for(int i=0;i<results.length;i++){
			System.out.println(i+" = "+results[i]);
		}
	
		// Close the Browser
		obj.closeBrowser();
	
		obj.invokeBrowser("file:///D:/Java/workspace/LanguagePOC/testfile.html");
		
	
	}

}
