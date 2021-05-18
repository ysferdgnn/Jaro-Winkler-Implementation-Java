package mainPackage;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.jar.JarOutputStream;

import jaroWinkler.JaroWinklerImp;

public class MainClass {

	
	public static void main(String[] args) {
		
		
	try {
	
		JaroWinklerImp jaroWinklerImp= new JaroWinklerImp();
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		
		
			System.out.println("Enter first String:");
			String firstString = reader.readLine();
			
			System.out.println("Enter second String:");
			String secondString = reader.readLine();
			
			
			
			
			System.out.println("Jaro Similarity : "+jaroWinklerImp.Jaro(firstString,secondString));
			System.out.println("Jaro-Winkler Distance : "+jaroWinklerImp.JaroWinkler(firstString,secondString));
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}
	
	
	
	
	
}
