package com.company;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtility {
	
	//1. donwload from NSE website.
	//2. unzip and extract csv
	
	private static final int S_BYTE_SIZE = 4096;
	public static List<String> downloadAndUnzip(String urlString, String zipFilePath, String destDirectory)
	throws IOException{
		
		URL tariff = new URL(urlString);
		
		//figure out the user agent.
		String myUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";
		java.net.URLConnection c = tariff.openConnection();
		c.setRequestProperty("User-Agent", myUserAgent);
		
		//save the downloaded url to our local hard disk.
		ReadableByteChannel zipByteChannel = Channels.newChannel(c.getInputStream());
		FileOutputStream fos = new FileOutputStream(zipFilePath);
		fos.getChannel().transferFrom(zipByteChannel, 0, Long.MAX_VALUE);
		
		return unzip(destDirectory,zipFilePath);
		
	}
	
	public static List<String> unzip(String zipFilePath, String destDirectory) throws IOException {
		
		List<String> unzippedFileList = new ArrayList<>();
		
		File destDir = new File(destDirectory);
		
		if(destDir.exists()){
			destDir.mkdir();
		}
		
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
		
		ZipEntry zipEntry = zipIn.getNextEntry();
		while(zipEntry!=null){
			String filePath = destDirectory+File.separator+zipEntry.getName();
			
			if(!zipEntry.isDirectory()){
				String oneUnzippedFile = extractFile(zipIn, filePath);
				unzippedFileList.add(oneUnzippedFile);
				} else {				
				File dir = new File(filePath);
				dir.mkdir();
			}
			
			zipEntry = zipIn.getNextEntry();
		}
		
		return unzippedFileList;		
	}
	
	public static String extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		
		// standard boiler-plate for anytime we need to save to a file i.e write to disk.
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		
		//create (binary) files in chunks of bytes. These chunks need to be in powers of 2.
		byte[] bytesIn = new byte[S_BYTE_SIZE];
		
		//extract one file from inside the zip file and save it byte-by-byte to corresponding unzipped file.
		int read =0;
		while((read = zipIn.read(bytesIn)) != -1){
			bos.write(bytesIn,0,read);
		}
		
		bos.close();
		
		return filePath;
	}

}
