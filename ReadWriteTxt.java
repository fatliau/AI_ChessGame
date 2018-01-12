package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.Path;
import java.util.Scanner;

public class ReadWriteTxt {

	
	public static void main(String[] args){
		//Path file=Paths.get("/Users/JC/Documents/UTD CS/CS6364_Artificial Intelligence/AI_Project1/board1.txt");
		//byte[] fileArray;
		//fileArray=Files.readAllBytes(file);
		
		//System.out.print(fileArray);
		
		
		System.out.println(readFile("/Users/JC/Documents/UTD CS/CS6364_Artificial Intelligence/AI_Project1/board1.txt"));
		writeFile("text2","/Users/JC/Documents/UTD CS/CS6364_Artificial Intelligence/AI_Project1/board2.txt");
		System.out.println(readFile("/Users/JC/Documents/UTD CS/CS6364_Artificial Intelligence/AI_Project1/board2.txt"));

		
		
	}
	public static String readFile(String address){
		Scanner in;
		String content="";
		try{
			in = new Scanner( new File(address));
			
			while(in.hasNext()){
				content+=in.next();
			}		
		}
		catch(FileNotFoundException e){
		
		}
		return content;
	}
	public static void writeFile(String content, String address){
		try{
			PrintWriter output= new PrintWriter( new File(address));
			output.print(content);
			
			output.close();
		}
		catch(FileNotFoundException e){

		}
	}
}
