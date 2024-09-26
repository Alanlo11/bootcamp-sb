package com.bootcamp.demo.demo_sb_calculator.model;

import java.util.Arrays;

public class Database {

  // final 係 [] object，入面既野可以換
  private static String[] strings = new String[] {"abc", "def", "ijk"};

  public static String getString(int index){
    return strings[Integer.valueOf(index)];
  }

  public static int size(){
    return strings.length;
  }

  public static String addString(String newString){
    String[] newArray = Arrays.copyOf(strings, strings.length + 1);
    newArray[newArray.length - 1] = newString;
    strings = newArray;
    return newString;
  }

  public static String[] getData(){
    return strings;
  }

  public static int getSize(){
    return strings.length;
  }

}