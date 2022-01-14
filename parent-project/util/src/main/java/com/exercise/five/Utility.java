package com.exercise.five;

import java.util.Scanner;

public final class Utility {

   GetSetInput get = new GetSetInput();
   GetSetInput set = new GetSetInput();

  public void validateRowInput() {
   
    boolean isRowCorrect = false;
    int rowinput;
    do{
      set.setRowInput();
      try{
      
      rowinput = Integer.parseInt(get.getRowInput());
      isRowCorrect = true;

    }catch(NumberFormatException e){
      System.out.println("Input should only be an integer. ");
    }
  }while(isRowCorrect == false );
  }

  public void validateColInput(){
    boolean isColCorrect = false;
      int colInput;

  do{
    set.setColInput();
    try{
    TableData table = new TableData();
    table.resetTable();
    table.keyValue();
    table.writeToFile();

      colInput = Integer.parseInt(get.getColInput());
      isColCorrect = true; 

    }catch(NumberFormatException e){
      System.out.println("Input should only be an integer. ");
    }
  }while(isColCorrect == false);
  }
  public void validateMenuInput(){
    boolean isCorrect = false;
    int menu;
    do{
      try{
      set.setMenu();
      menu = Integer.parseInt(get.getMenu());
      isCorrect = true;
    }catch(NumberFormatException e){
      System.out.println("Input should only be an integer. ");
    }
  }while(isCorrect == false);
  }

  public void validateAddRow(){
    boolean isCorrect = false;
    int addRow;
    do{
      set.addRow();
      try{
      addRow = Integer.parseInt(get.getAddRow());
      isCorrect = true;
    }catch(NumberFormatException e){
      System.out.println("Input should only be an integer. ");
    }
  }while(isCorrect == false);
  }
}

