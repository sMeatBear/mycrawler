package pers.jianfeic.util.csvio;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVResultWrite {
	
	/**
	 * Create a csv file with designated file path and header
	 * @param outputPath output file name with suffix
	 * @param header table's head
	 */
	public static void createCSV(String outputPath, String[] header) {
		try {
			CSVWriter cw = new CSVWriter(new FileWriter(outputPath));
			cw.writeNext(header);
			cw.close();
		} catch (IOException e) {
			System.err.println("Write file faied");
			e.printStackTrace();
		}
	}
	
	/**
	 * Append one line data to a csv file
	 * @param outputPath path and target file name with suffix
	 * @param oneline one line data corresponding with the header
	 */
	public static void appendCSV(String outputPath, String[] oneline) {
		try {
			CSVWriter cw = new CSVWriter(new FileWriter(outputPath, true));
			cw.writeNext(oneline);
			cw.close();
		} catch (IOException e) {
			System.err.println("Append file failed");
			e.printStackTrace();
		}
	}
}
