import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class NewsPicker{
	
	static boolean fileContainsCategory(String file ,String[][]tokens) throws FileNotFoundException {
		
		File fl = new File(file);
		FileReader fileName = new FileReader(fl);
		Scanner sc  = new Scanner(fileName);
		boolean flag = false;
		String str =""; 
		while(sc.hasNextLine()) {
			str += sc.nextLine();
		}
		
		for(int i=0;i<tokens.length;i++) {
			String []token = tokens[i];
		 if(Arrays.stream(token).parallel().anyMatch(str::contains)) {   //checks if any of token exists in string str
	    	 System.out.println(fl.getName() + ": " + token[0] +"\t"  );
	    	 flag = true;
	     }
		} 
		 return flag;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String files[]= new String[args.length];
		for(int i=0;i<args.length;i++) {
			files[i] = args[i];
		}
		String []sports = {"sport","cricket","football","goal","bat","ball"}; 
		String []politics = {"politics","president","prime minister","minister","election"};
		String []technology = {"technology","mobile","devices","computer","processor"};
		String []business = {"business","economy","gdp","profit","quarter","tax"};


		String[][] arr = new String[args.length][];
		arr[0] = sports;
		arr[1] = politics;
		arr[2]= technology;
		arr[3] =business;

		
		for(int i=0;i<args.length;i++) {
			try {
				boolean flag = fileContainsCategory(files[i],arr);
				if(flag==true) {
					System.out.println("in main " +arr[i][0]+ " category found");
					continue;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int j=0;j<args.length;j++) {
			

		}
		

		
		

	}

}
