import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class VotingFileIO {
	
		String first;
		String last;
		String filename;
		String choice;
	 
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw;
		String line;
	
	public VotingFileIO(String firstName, String lastName, String candChoice){
		first = firstName;
		last = lastName;
		
		filename = lastName + "_" + firstName + "_ballot.txt";
		choice = candChoice;	
		
	}
	
	private void createFile()  throws IOException {

		fw = new FileWriter(filename);
		bw = new BufferedWriter(fw);
		
		System.out.println("attempting to create file");
		
		bw.write(choice);
		bw.close();
		
	}
	
	private boolean checkForFile() throws IOException{
		
	    boolean fileFound = false;

	    File checkFile = new File(filename);
		//System.out.println("tried to make new file object");

		if(checkFile.exists()){
			//System.out.println("checking if file exists");
			fileFound = true;
		}
		//System.out.println(fileFound);
		return fileFound;
		
		
	}
		
    public String logBallot() throws IOException {

    	//System.out.println("filename is " + filename);
    	//System.out.println("choice is " + choice);
    	
    	String success = "";
    	
    	if(!checkForFile()){
    		createFile();
    		success = first + " " + last + "'s vote for Candidate " + choice + " processed!";
    	} else {
    		success = first + " " + last + " has already cast their ballot!";
    	}
    	return success;

    	
    }
}