package com.company;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			String urlString = "https://www.nseindia.com/archives/sme/bhavcopy/sme061017.csv";
			String zipFilePath = "C:\\Users\\I339637\\Documents\\004-gitrepos\\Sap\\JPA-MysqlBackend\\TutorialJPAProject\boo.zip";
			String destinationDirectory = "C:\\Users\\I339637\\Documents\\004-gitrepos\\Sap\\JPA-MysqlBackend\\TutorialJPAProject";
			
			List<String> unzippedFileList = UnzipUtility.downloadAndUnzip(urlString, zipFilePath, destinationDirectory);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
