/*
 * This file is a component of QuickPatch utility for GravyMod, borrowed from the
 * Towny Advanced project which is maintained by by ElgarL.
 * Distributed under the The Attribution-NonCommercial-ShareAlike License 3.0 (CC BY-NC-SA)
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package com.gravypalmer.QuickPatch; // elgar says its ok!

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class FileMgmt {
	
	public static String fileSeparator() {
	
		return System.getProperty("file.separator");
	}
	
	// pass a resource name and it will return it's contents as a string
	public static String convertStreamToString(String name) throws IOException {
	
		if (name != null) {
			Writer writer = new StringWriter();
			InputStream is = FileMgmt.class.getResourceAsStream(name);
			
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "US-ASCII")); // should
																						   // be
																						   // UTF-8
				int n;
				while((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} catch (IOException e) {
				System.out.println("Exception ");
			} finally {
				try {
					is.close();
				} catch (NullPointerException e) {
					// Failed to open a stream
					throw new IOException();
				}
			}
			return writer.toString();
		} else {
			return "";
		}
	}
	
	/**
	 * Pass a file and it will return it's contents as a string.
	 * 
	 * @param file
	 *            File to read.
	 * @return Contents of file. String will be empty in case of any errors.
	 */
	public static String convertFileToString(File file) {
	
		if (file != null && file.exists() && file.canRead() && !file.isDirectory()) {
			Writer writer = new StringWriter();
			InputStream is = null;
			
			char[] buffer = new char[1024];
			try {
				is = new FileInputStream(file);
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} catch (IOException e) {
				System.out.println("Exception ");
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException ignore) {
					}
				}
			}
			return writer.toString();
		} else {
			return "";
		}
	}
	
	// writes a string to a file making all newline codes platform specific
	public static boolean stringToFile(String source, String FileName) {
	
		if (source != null) {
			// Save the string to file (*.yml)
			try {
				return stringToFile(source, new File(FileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
	
	/**
	 * Writes the contents of a string to a file.
	 * 
	 * @param source
	 *            String to write.
	 * @param file
	 *            File to write to.
	 * @return True on success.
	 * @throws IOException
	 */
	public static boolean stringToFile(String source, File file) throws IOException {
	
		try {
			
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			
			// BufferedWriter out = new BufferedWriter(new
			// FileWriter(FileName));
			
			source.replaceAll("\n", System.getProperty("line.separator"));
			
			out.write(source);
			out.close();
			return true;
			
		} catch (IOException e) {
			System.out.println("Exception ");
			return false;
		}
	}
	
}
