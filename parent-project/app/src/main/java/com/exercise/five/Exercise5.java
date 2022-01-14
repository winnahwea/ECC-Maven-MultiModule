package com.exercise.five;


import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Exercise5 {
	public static void main(String[] args) throws FileNotFoundException {
		Utility util= new Utility();
		String menu;
		GetSetInput set = new GetSetInput();
		GetSetInput get = new GetSetInput();

		boolean menuLoop = true;

		set.setFilePath();

		util.validateRowInput();
		util.validateColInput();
		
		while(menuLoop){ 
		TableData table = new TableData();
		System.out.println();
		table.printTable();	 

		util.validateMenuInput();	
		Menu choose = new Menu();
		menu = get.getMenu();

		switch (menu){
			case "1":
				choose.menuSearch();
				table.resetTable();
				break;

			case "2":
				choose.menuEdit();
				break;

			case "3":
				break;

			case "4":
				choose.menuAddRow();
				break;

			case "5":
				choose.menuSortRow();
				break;

			case "6":
				choose.menuReset();
				break;

			case "7":
				choose.menuExit();
				break;
			default:
				choose.menuDefault();
		}
		}
		
}
}