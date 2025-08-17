package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelReader {
	static XSSFWorkbook workbook;
	static FileInputStream file;
	static XSSFSheet sheet;
	static Row row;
	WebElement webelement;
	By by;

	public static void ReadRow(String filePath, String sheetName) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		if (sheet != null) {
			System.out.println("Excel file is read sucessfully");
		}
	}

	public static By rowOutput(int rowCount) {
		row = sheet.getRow(rowCount);
		Map<String, String> map = new HashMap<String, String>();
		List<String> header = new ArrayList<>();
		List<String> value = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			if (row.getCell(i)!= null) {
				if(row.getCell(i).toString().length()>0) {
				header.add(sheet.getRow(0).getCell(i).toString());
				value.add(row.getCell(i).toString());
				}
				
			}
		}
		System.out.println(header);
		System.out.println(value);

		String locator = header.get(1);
		switch (locator) {
		case "id":
			return By.id(value.get(1));
		case "name":
			return By.name(value.get(1));
		case "xpath":
			return By.xpath(value.get(1));
		case "tagName":
			return By.tagName(value.get(1));
		case "linkText":
			return By.linkText(value.get(1));
		case "cssSelector":
			return By.cssSelector(value.get(1));
		case "className	":
			return By.className(value.get(1));

		default:
			return null;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\UtilityData\\TestData.xlsx";
		ReadRow(filePath, "SignUpPage");
		System.out.println(rowOutput(1));
	}
}
