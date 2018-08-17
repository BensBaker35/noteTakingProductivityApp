package application.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLDecoder;

public class FileManager {
	
	
	public static void openFile(String fileName) {
		
		String line = null;
		//fileName = "C:\\Users\\Ben\\Documents\\NoteTakingApp\\test3\\src\\Courses\\TestFile.txt";
        try {
            // FileReader reads text files in the default encoding.
            File file = new File(fileName);
        	FileReader fileReader = 
                new FileReader(file);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
           
        	System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    
		
		
	}
	
	public static Course readCourse(File file) {
		try {
			FileInputStream fs = new FileInputStream(file);
			ObjectInputStream os = new ObjectInputStream(fs);
			Course course = (Course)os.readObject();
			System.out.println(course);
			return course;
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	  public static String getMediaDirectory() 
	  {
	    String directory = null;
	    
	    File dirFile = null;
	    
	    // try to find the Courses directory
	      try {
	        // get the URL for where we loaded this class 
	        Class currClass = Class.forName("FileManager");
	        URL classURL = currClass.getResource("FileManager.class");
	        URL fileURL = new URL(classURL,"../Courses/");
	        
	        directory = fileURL.getPath();
	        directory = URLDecoder.decode(directory, "UTF-8");
	        dirFile = new File(directory);
	        if (dirFile.exists()) {
	          System.out.println(dirFile.getAbsolutePath());
	          return directory;
	        }
	      } catch (Exception ex) {
	    	  ex.printStackTrace();
	      }
	      
	      return directory;
	  }
	  //Credit to https://www.mkyong.com/java/how-to-construct-a-file-path-in-java/
	  public static String getFile(String fileName) {
		  String fullFileName = fileName + ".txt";
		  String absoluteFilePath = "";
		  try {
			  	String defaultLocation = "src\\Courses\\";
				
				String workingDirectory = System.getProperty("user.dir");
					
				//****************//
					
				
					
				//absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
				absoluteFilePath = workingDirectory + File.separator + defaultLocation + fullFileName;

				System.out.println("Final filepath : " + absoluteFilePath);
					
				//****************//
					
				File file = new File(absoluteFilePath);

				if (file.createNewFile()) {
					System.out.println("File is created!");
				} else {
					System.out.println("File is already existed!");
				}

			  } catch (IOException e) {
				e.printStackTrace();
			  }
		  	return absoluteFilePath;
	  }
	  
	  public static void saveCourseData(Course course) {
		  String filePath = getFile(course.getName());
		  
		  File file = new File(filePath);
		  try {
			FileOutputStream fop = new FileOutputStream(file,true);
			ObjectOutputStream oop = new ObjectOutputStream(fop);
			//FileWriter fileWriter = new FileWriter(filePath,true);
			//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			oop.writeObject(course);
			fop.close();
			oop.close();
			System.out.println(course.getName() + " Saved");
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
		  
	  }
	  
	  public static File[] getAllCourses() {
		  
		  String defaultLocation = "src\\Courses\\";
		  String workingDirectory = System.getProperty("user.dir");
		  
		  
		  String directory = workingDirectory + File.separator + defaultLocation;
		  File courseFolder = new File(directory);
		  File[] courseFiles = courseFolder.listFiles();
		  
		  return courseFiles;
	  }
	  
	  public static void saveTransferCourse(Course course) {
		
		 try {
			 String filePath = System.getProperty("user.dir") + File.separator + "src\\transfer.txt";
			 //String transferFilePath = FileManager.getFile("transfer");
			 File file = new File(filePath);
			 FileOutputStream fop = new FileOutputStream(file);
			 ObjectOutputStream oop = new ObjectOutputStream(fop);
			 oop.writeObject(course);
			 fop.close();
			 oop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	  }
	  public static Course readTransferCourse() {
		  String filePath = System.getProperty("user.dir") + File.separator + "src\\transfer.txt";
		  File file = new File(filePath);
		  return FileManager.readCourse(file);
	  }
}
