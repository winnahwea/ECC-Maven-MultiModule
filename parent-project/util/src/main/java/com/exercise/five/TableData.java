package com.exercise.five;


import java.io.*;
import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;


public class TableData {
	GetSetInput get = new GetSetInput();
	GetSetInput set = new GetSetInput();

	int row = Integer.parseInt(get.getRowInput());
	int col = Integer.parseInt(get.getColInput());
	
	String outputFilePath = get.getFilePath();
	private File file = new File(outputFilePath);
	BufferedWriter bw = null;

	private static LinkedHashMap<String, String> table = new LinkedHashMap<String, String>(); // key value storage
	private static ArrayList<String> concat = new ArrayList<String>(); // concatenated data storage (key+value)
	private static ArrayList<String> splitKey = new ArrayList<String>(); // key data storage
	private static ArrayList<String> splitValue = new ArrayList<String>(); // value data storage

	// generate key-value pairs
	public void keyValue() {
		// key value pairs
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				table.put(RandomStringUtils.randomAscii(3), RandomStringUtils.randomAscii(3));
			}			
		}
	}
	// split key and value into different arrayLists
	
	 public void splitTable() throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		// concatenante table entries
		for (Map.Entry<String, String> entry : table.entrySet()) {
			splitKey.add(entry.getKey());
			splitValue.add(entry.getValue());
		}
		scan.close();
	}

	// search and count instances indicating location
	public void searchArray() {
		String searchString = get.getSearchString();
		int keyOccurs = 0;
		int valueOccurs = 0;
		int cellOccurs = 0;
		int inArray = 0;
		int arrayCounter = 0;
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				if (splitKey.get(arrayCounter).contains(searchString)) {
					keyOccurs = 1;
					inArray = 1;
					if (keyOccurs > 0) {
						System.out.printf("Found %s on key of index (%d,%d)", searchString, rowCount, colCount);
						keyOccurs = 0;

						int lastIndex = 0;
						while  (lastIndex != -1) {
							lastIndex = splitKey.get(arrayCounter).indexOf(searchString, lastIndex);

							if (lastIndex != -1) {
								cellOccurs++;
								lastIndex += searchString.length();
							}
						}
						System.out.println(" with " + cellOccurs + " instance/s.");
						cellOccurs = 0;
					}
				}
				if (splitValue.get(arrayCounter).contains(searchString)) {
					valueOccurs = 1;
					inArray = 1;
					if (valueOccurs > 0) {
						System.out.printf("Found %s on value of index (%d,%d)", searchString, rowCount, colCount);
						valueOccurs = 0;

						int lastIndex = 0;
						while  (lastIndex != -1) {
							lastIndex = splitValue.get(arrayCounter).indexOf(searchString, lastIndex);

							if (lastIndex != -1) {
								cellOccurs++;
								lastIndex += searchString.length();
							}
						}
						System.out.println(" with " + cellOccurs + " instance/s.");
						cellOccurs = 0;
					}
				}
				arrayCounter++;
			}
		}	
		if (inArray != 1) System.out.println("Search String not found.\n");
	}

	// update key
	public void editKey() {
		System.out.print("Set updated key: ");
		set.setEditKeyString();

		int counter = 0;
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				if (rowCount == get.getRowEdit() && colCount == get.getColEdit()) {
					splitKey.set(counter, get.getEditKeyString()); // replace key
					break;
				} 
				counter++;
	  		}
	  		if (rowCount == get.getRowEdit()) break;			
		}		
	}

	// update value
	public void editValue() {
		System.out.print("Set updated value: ");
		set.setEditValueString();
		table.put(get.getEditKey(), get.getEditValueString()); // update value using key
	}

	// return table
	public LinkedHashMap<String, String> getTable() {
		return table;
	}

	// return filename
	public File getFile() {
		return file;
	}

	// write table to file
	public void writeToFile() {
		// new file object 
		try {
			// create new BufferedWriter for the output file
			bw = new BufferedWriter(new FileWriter(file));
			
			// iterate map entries
			for (Map.Entry<String, String> entry : table.entrySet()) {

				// put key and value separated by a colon
				bw.write(entry.getKey() + " : " + entry.getValue());
				bw.newLine();
			}
			bw.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try{
				// close writer
				bw.close();
			}
			catch (Exception e) {

			}
		}
	}

	// concatenate key+value before sorting
	public void concatTable() throws FileNotFoundException {
		Scanner scan = new Scanner(file);

		// concatenante table entries
		for (Map.Entry<String, String> entry : table.entrySet()) {
			concat.add(entry.getKey() + entry.getValue());
		}
		scan.close();
	}	

	// sort concatenated data
	public void sortTable() {
		set.setSortOrder();	
		// sort arrayList
		switch (get.getSortOrder()) {
			case "1":
				Collections.sort(concat);
				break;
			case "2":
				Collections.sort(concat, Collections.reverseOrder());
				break;
			default:
				System.out.println("Not a valid option.");
				break;
		}
	}

	// write sorted data from concatenated table to hashmap
	public void writeToTable() {	
		// clear and reinput to table
		resetTable();
		for (String str : concat) {
			table.put(str.substring(0,3), str.substring(3,6));
		}
	}

	// rewrite table with updated key
	public void writeToTableNewKey() {
		int count = 0;
		resetTable();
		for (String str : splitValue) {
			table.put(splitKey.get(count), str);
			count++;
		}
	}

	// clear table
	public void resetTable() {
		table.clear();
	}

	// print table
	public void printTable() throws FileNotFoundException {	
		Scanner scan = new Scanner(file);
		int counter = 0;
		while(scan.hasNextLine()) {			
			if (counter == col) {
				System.out.println();
				counter = 0;
			} else {
				System.out.print("|" + scan.nextLine() + "|" + "    ");
				counter++;
			}
		} 	
	}

}