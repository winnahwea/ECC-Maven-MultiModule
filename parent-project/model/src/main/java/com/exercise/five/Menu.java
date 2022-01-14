package com.exercise.five;

import java.io.*;
import java.util.*;
import javax.swing.*;
import org.apache.commons.lang3.RandomStringUtils;

public class Menu {
	GetSetInput get = new GetSetInput();
	GetSetInput set = new GetSetInput();
	String outputFilePath = get.getFilePath();
	
	int row = Integer.parseInt(get.getRowInput());
	int col = Integer.parseInt(get.getColInput());
	String menu = get.getMenu();
	String searchString = get.getSearchString();

	TableData newTable = new TableData();
	LinkedHashMap<String, String> table = newTable.getTable();
	
	public void menuSearch() throws FileNotFoundException {
		set.setSearchString();
		newTable.splitTable();
		newTable.searchArray();
	}

	public void menuEdit() throws FileNotFoundException {
		set.setRowEdit();
		set.setColEdit();
		set.setEditOption();

		Scanner scan = new Scanner(newTable.getFile());
		// find cell to replace
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				if (rowCount == get.getRowEdit() && colCount == get.getColEdit()) {
					set.setEditKey(scan.nextLine().substring(0,3)); // get key from index
					break;
				} else scan.nextLine();
	  		}
	  		if (rowCount == get.getRowEdit()) break;			
		}
	
		switch (get.getEditOption()) {
			case "1":
				newTable.splitTable();
				newTable.editKey();
				newTable.writeToTableNewKey();
				break;
			case "2":
				newTable.editValue();
				break;
			default:
				menuDefault();
				menuExit();
				break;
		}
		newTable.writeToFile();

	}

	public void menuAddRow() throws FileNotFoundException {
		 Utility util= new Utility();
		 util.validateAddRow();
		int addRowValue = Integer.parseInt(get.getAddRow());

		// generate and append additional row to hashmap
		for (int rowCount = 0; rowCount < addRowValue; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				table.put(RandomStringUtils.randomAscii(3), RandomStringUtils.randomAscii(3));
			}
		}
		// rewrite table to file
		newTable.writeToFile();
		
	}

	public void menuSortRow() throws FileNotFoundException {
		// concatenate and sort
		newTable.concatTable();
		newTable.sortTable();
		newTable.writeToTable(); // rewrite sorted data to 

		// reprint table
		newTable.writeToFile();
	
	}
	public void menuReset() throws FileNotFoundException {
		Utility util= new Utility();
		newTable.resetTable();
		set.setFilePath();
		util.validateRowInput();
		util.validateColInput();
	
	}

	public void menuExit() {
		System.exit(0);
	}

	public void menuDefault(){
		System.out.println("Not a valid option.");
		menu = "6";
	}
}