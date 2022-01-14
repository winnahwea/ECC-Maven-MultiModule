package com.exercise.five;

import java.util.Scanner;
import java.io.*;

public class GetSetInput {
	Scanner scan = new Scanner(System.in);
	private static String rowInput;
	private static String colInput;
	private static String outputFilePath;
	private static String menu;
	private static String searchString;
	private static int rowEdit;
	private static int colEdit;
	private static String editOption;
	private static String editValue;
	private static String editKeyString;
	private static String editKey;
	private static String editValueString;
	private static String sortOrder;
	private static String addRow;

	// --table dimension--
	// row input
	public void setRowInput()  {
		System.out.print("\nEnter number of rows: ");
		this.rowInput = scan.nextLine();

	}
	public String getRowInput() {
		return rowInput;
	}
	// col input
	public void setColInput() {
		System.out.print("Enter number of columns: "); 
		this.colInput = scan.nextLine();
	}
	public String getColInput() {
		return colInput;
	}

	// --menu--
	public void setMenu() {
		System.out.print("\n\nMenu:\n1. Search\n2. Edit\n3. Print\n4. Add Row\n5. Sort\n6. Reset\n7. Exit\n\n");
		System.out.print("Choose an option: ");
		this.menu = scan.nextLine();
	}
	public String getMenu() {
		return menu;
	}

	//--file path--
	public void setFilePath() throws FileNotFoundException{
	
		try{  
		Scanner inScanner = new Scanner(System.in);
		System.out.print("\nEnter input file path and name:");
		String inFile = inScanner.nextLine();
		System.out.println("You entered: " + inFile);       
		File f= new File(inFile);
		f.createNewFile();
		this.outputFilePath = f. getAbsolutePath();	
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
    
	}
	public String getFilePath() {
		return outputFilePath;
	}

	// --Search--
	// search string
	public void setSearchString() {
		System.out.print("Input search character/s: ");
		this.searchString = scan.nextLine();
		if (searchString.isEmpty()) invalidInput();
	}
	public String getSearchString() {
		return searchString;
	}
	public void addRow()  {
		System.out.print("\nEnter number of rows to add: ");
		this.addRow = scan.nextLine();
	}
	public String getAddRow() {
		return addRow;
	}

	// choose to edit either key or value
	public void setEditOption() {
		System.out.print("1. Edit Key\n2. Edit Value");
		System.out.print("\nSelect: ");
		scan.nextLine();
		this.editOption = scan.nextLine();
		if (editOption.isEmpty()) invalidInput();
	}
	public String getEditOption() {
		return editOption;
	}

	// edit row index
	public void setRowEdit() {
		do {
		System.out.printf("Specify row index (0:%d) to update: ", Integer.parseInt(rowInput)-1);
		this.rowEdit = scan.nextInt();
		}
		while (rowEdit > Integer.parseInt(rowInput)-1 || rowEdit < 0);
	}
	public int getRowEdit() {
		return rowEdit;
	}
	// edit col index
	public void setColEdit() {
		do {
		System.out.printf("Specify column index (0:%d) to update: ", Integer.parseInt(colInput)-1);
		this.colEdit = scan.nextInt();
		} while (colEdit > Integer.parseInt(colInput)-1 || colEdit < 0);
	}
	public int getColEdit() {
		return colEdit;
	}
	
	// replace Key
	public void setEditValue(String editValue) {
		this.editValue = editValue;
	}
	public String getEditValue() {
		return editValue;
	}
	public void setEditKeyString() {
		this.editKeyString = scan.nextLine();
		if (editKeyString.isEmpty()) invalidInput();
	}
	public String getEditKeyString() {
		return editKeyString;
	}

	// replace Value
	public void setEditKey(String editKey) {
		this.editKey = editKey;
	}
	public String getEditKey() {
		return editKey;
	}
	public void setEditValueString() {
		this.editValueString = scan.nextLine();
		if (editValueString.isEmpty()) invalidInput();
	}
	public String getEditValueString() {
		return editValueString;
	}

	// sort order
	public void setSortOrder() {
		System.out.print("1. Ascending Order\n2. Descending Order");
		System.out.print("\nSelect Sort Order: ");
		this.sortOrder = scan.nextLine();
	}
	public  String getSortOrder() {
		return sortOrder;
	}

	// invalid input
	public void invalidInput() {
		System.out.println("Invalid input.");
	}
}
