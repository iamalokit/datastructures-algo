package com.amazon.core.compression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public class ObjectCompression {
	public static void main(String[] args) {
		Bill b1 = new Bill("176BU", "Abhishek Gupta");
		Bill b2 = new Bill("176DA", "Sushant Singh");
		
		FileOutputStream f = null;
		GZIPOutputStream g = null;
		
		ObjectOutputStream o = null;
		
		File newFile = new File("File.dat");
		
		try {
			f = new FileOutputStream(newFile);
			g = new GZIPOutputStream(f);
			
			o = new ObjectOutputStream(g);
			
			o.writeObject(b1);
			o.writeObject(b2);
			
			o.flush();
			
			System.out.println("Process done.");
			
			System.out.println("Objects are compressed.");
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(o != null)
					o.close();
				if(g != null)
					g.close();
			}catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
