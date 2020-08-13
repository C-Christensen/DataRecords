package test;

import java.io.File;
import java.io.FileNotFoundException;
import utility.Filter;


public class DataClient {

	public static void main(String[] args) throws FileNotFoundException{
		
		String location1 =  
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "Students_Min.txt";
		
		String location2 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "All_Students.txt";
		
		String location3 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "AlphaOrder.txt";
		
		String location4 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "Over25.txt";
		
		String location5 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "Under25.txt";
		
		String location6 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "FreshAndShops.txt";
		
		String location7 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "DeansList.txt";
		
		String location8 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "Probation.txt";
		
		String location9 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "StudentsAll.txt";
		
		String location10 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "AgeSorted.txt";
		
		String location11 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "GPASorted.txt";
		
		String location12 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "Fresh.txt";
		
		String location13 =
				File.separator + "C:"      + File.separator + "Users" +
				File.separator + "camil" + File.separator + "CSC_142" + 
				File.separator + "F19" + File.separator + "Sophs.txt";
		
		
		Filter filter = new Filter();
		
		filter.read(location1);
		
		filter.write(location2);
		
		filter.sortAlphabeticalOrder(location3);
		
//		filter.filterOver25(location4);
//		
//		filter.filterUnder25(location5);
//		
//		filter.isOnDeansList(location7);
//		
//		filter.isOnProbation(location8);
//		
		filter.writeCS(location9);
//		
		filter.sortAge(location10);
//		
		filter.sortGPAOrder(location11);
//		
//		filter.isFreshman(location12);
//		
		filter.isSophomore(location13);
//		
		
		
	}

}
