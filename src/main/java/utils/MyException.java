package utils;

public class MyException extends Exception{

	public MyException(String s ,String s1) 
    { 
        System.out.println( s +" & "+ s1 +" both should be not null");
    } 
}
