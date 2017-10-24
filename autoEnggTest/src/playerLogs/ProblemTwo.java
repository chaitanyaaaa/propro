package playerLogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ProblemTwo
{
	public static void main (String [] args)throws Exception
	{
		String filename = "C:\\java\\Player1_Assassin.txt";
		String line = null;
		String output = "C:\\java\\output.txt";
		String detail = "C:\\java\\detail.txt";
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);

		try {
	           
	            FileReader fileReader = new FileReader(filename);
	            BufferedReader bufferedReader =new BufferedReader(fileReader);
	            while((line = bufferedReader.readLine()) != null)
	            {
	            	if(line.contains("[Scoring]:") && line.contains("from"))
	            	{
	            		bw.write(line);
						bw.newLine();
						//System.out.println();	
	            	}            	
	            
	            }
	            FileReader fr = new FileReader(output);
	            BufferedReader br = new BufferedReader(fr);
	            FileWriter fwx = new FileWriter(detail);
	            BufferedWriter bwx = new BufferedWriter(fwx);
	            line = null;
	            while((line=br.readLine())!=null)
	            {
	            	String cl = line;
	            	String[] tokens = cl.split("\\[Scoring]: |\\ got |\\ bounty from |\\[(.*?)|\\](.*?)"); //******NEED HELP HERE********
	            	for (String token : tokens) 
	            	{
	            		bwx.write(token);
	                    bwx.newLine();
	            	}
	            	bwx.newLine();
	            	bwx.write("***************************************");
	            	bwx.newLine();
	            }
	          bwx.close();  
	          bufferedReader.close(); 
	          br.close();
	          bw.close();
	            }
		
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                filename + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + filename + "'");                  
	            
	        }
		
	    }
	
	}