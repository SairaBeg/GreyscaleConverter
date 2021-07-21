package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class GreyscaleMain {

	public static void main(String[] args) {
		
		try {
			//Debugging
//Taking in a new file, uncomment to try different images
//Scanner in = new Scanner(new File("/Users/Saira/Desktop/Eclipse Workspace 2021/340 Data Structures and Algorithms/src/Assignment1/snow.ppm"));
//Scanner in = new Scanner(new File("/Users/Saira/Desktop/Eclipse Workspace 2021/340 Data Structures and Algorithms/src/Assignment1/farmer.ppm"));
//Scanner in = new Scanner(new File("/Users/Saira/Desktop/Eclipse Workspace 2021/340 Data Structures and Algorithms/src/Assignment1/eagle.ppm"));
			//Debugging
			
			
//To use Command Line Arguments for the file path, uncomment the following lines
	//String filename= args[0];
	//Scanner in = new Scanner(new File(filename));
			
//To enter your file path through the scanner
			System.out.println("Please enter path to a ppm image:");
			Scanner in1 = new Scanner(System.in);
			String dictionaryFile = in1.nextLine();
			Scanner in = new Scanner(new File(dictionaryFile));
			
			String p3 = in.nextLine();
			int numPix1 = in.nextInt();
			int numPix2 = in.nextInt();
			int colorDepth = in.nextInt();
		
	Pixel[][] array = new Pixel[numPix1] [numPix2];
		
					 
//Parsing the color values into Red, Green, and Blue					
					if (in.hasNextLine() == true) {
					 for(int i = 0; i < numPix1; i++) {
						 for(int j = 0; j < numPix2; j++) {
//Composing the new Pixel
	Pixel pix = new Pixel();
					 pix.setRed(in.nextInt());
					 pix.setGreen(in.nextInt());
					 pix.setBlue(in.nextInt());
							 
//Adding new Pixel into the 2D array
					array[i][j]=pix;
						 }
					 }
					}
					
//Initializing a new gray 2D Array					
	Pixel[][] grayArray = new Pixel[numPix1] [numPix2];			
			
	for(int i = 0; i < numPix1; i++) {
		 for(int j = 0; j < numPix2; j++) {
			 
//Averaging the original image's Red, Green and Blue
			 int total = array[i][j].getRed()+array[i][j].getGreen()+array[i][j].getBlue();
			 int average = total/3;

//Adding to the new gray Array
			 Pixel pix2 = new Pixel();
			 pix2.setRed(average);
			 pix2.setGreen(average);
			 pix2.setBlue(average);
			 
			 grayArray[i][j]=pix2;
		 }
	}
	
//Exporting and writing the new Greyscale file					
	 try {
	      FileWriter myWriter = new FileWriter("greyscale.ppm");
	      myWriter.write("P3\n");
	      myWriter.write(numPix1 + " "+numPix2+"\n");
	      myWriter.write(colorDepth+"\n");
	      
	      for(int i = 0; i < numPix1; i++) {
				 for(int j = 0; j < numPix2; j++) {
					 
					 int red = grayArray[i][j].getRed();
					 int green =grayArray[i][j].getGreen();
					int blue = grayArray[i][j].getBlue();
					
					myWriter.write(String.valueOf(red+ " "));
					 myWriter.write(String.valueOf(green+ " "));
					 myWriter.write(String.valueOf(blue+ " "));
				 }
				}    
	      myWriter.close();
	      
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred writing the file.");
	      e.printStackTrace();
	    }		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
			System.out.println("File not found.");
		}
	}
}
