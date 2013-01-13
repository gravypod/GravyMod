/*
 * This file is a component of QuickPatch utility for GravyMod, and was written by ElgarL.
 * Distributed under the The Attribution-NonCommercial-ShareAlike License 3.0 (CC BY-NC-SA)
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package com.gravypalmer.QuickPatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickPatch {

	static PrintWriter pw;
	static int error;

	static {
		error = 0;
		try {
			pw = new PrintWriter(new File("./log.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length != 1) {
			flagPatch("ERROR: Invalid number of arguments! You must provide a single patch folder!");
			System.exit(1);
		}

		File patchFolder = new File(args[0]);

		for (File patchTXT : patchFolder.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File arg0, String arg1) {

				return arg1.endsWith(".txt");
			}
		})) {

			QuickPatch.start(patchTXT);

		}

		System.exit(error);

	}

	public static void start(File patchFile) throws FileNotFoundException {

		int lineCount = 0;
		Scanner instructions = new Scanner(new FileInputStream(patchFile));

		/*
		 * Parse the patch file.
		 */

		StringBuilder stringMatch = new StringBuilder();
		StringBuilder stringReplace = new StringBuilder();

		String fileName = "";
		String line = "";
		File srcFile = null;
		String foundFile = "";

		int fileLine = 0, matchLine = 0, replaceLine = 0;

		/*
		 * Find the next instruction
		 */
		while (instructions.hasNextLine()) {

			line = instructions.nextLine();
			lineCount++;

			/*
			 * Ignore comments.
			 */
			if (line.trim().startsWith("#"))
				continue;

			/*
			 * Look for a source file name for patching
			 */
			if (line.trim().startsWith("@@file")) {

				fileLine = lineCount;

				/*
				 * Read the filename.
				 */
				fileName = line.trim().replace("@@file ", "");
				srcFile = new File(fileName);
				foundFile = FileMgmt.convertFileToString(srcFile);

			} else if (line.trim().startsWith("@@match")) {

				matchLine = lineCount;

				while (instructions.hasNextLine()) {
					line = instructions.nextLine();
					lineCount++;

					/*
					 * exit this while loop as we have come to the end of the
					 * section.
					 */
					if (line.trim().equalsIgnoreCase("@@end")) {
						stringMatch.setLength(stringMatch.length() - (System.getProperty("line.separator").length()));
						break;
					}

					stringMatch.append(line);
					stringMatch.append(System.getProperty("line.separator"));

				}

			} else if (line.trim().startsWith("@@replace")) {

				replaceLine = lineCount;

				while (instructions.hasNextLine()) {
					line = instructions.nextLine();
					lineCount++;

					/*
					 * exit this while loop as we have come to the end of the
					 * section.
					 */
					if (line.trim().equalsIgnoreCase("@@end")) {
						if (stringReplace.length() > 0)
							stringReplace.setLength(stringReplace.length() - (System.getProperty("line.separator").length()));
						break;
					}

					stringReplace.append(line);
					stringReplace.append(System.getProperty("line.separator"));

				}

			}

			/*
			 * If we filled both the match and replace buffers
			 */
			if ((matchLine != 0) && (replaceLine != 0)) {

				/*
				 * Abort as this file doesn't exist
				 */
				if ((foundFile == "") || (foundFile == null)) {

					flagPatch("ERROR: Source file not found - " + fileName + " @ (" + patchFile + ":" + fileLine + ").");
					error = 1;

				} else if ((stringReplace.length() > 0) && foundFile.contains(stringReplace.toString())) {

					flagPatch("ERROR: Patch already installed for line " + matchLine + " in " + patchFile);

				} else if (!foundFile.contains(stringMatch.toString())) {

					flagPatch("ERROR: Signature not found for line " + matchLine + " in " + patchFile);
					error = 1;

					flagPatch("-------------------------------");
					flagPatch(stringMatch.toString());
					flagPatch("-------------------------------");

				} else {

					/*
					 * Apply the patch
					 */
					foundFile = foundFile.replace(stringMatch.toString(), stringReplace.toString());

					try {
						FileMgmt.stringToFile(foundFile, srcFile);
						flagPatch("Patched line (" + matchLine + ") from [" + patchFile + "] to [" + fileName + "]");
					} catch (IOException e) {
						flagPatch("ERROR: on saving file - " + fileName);
						error = 1;
						e.printStackTrace();
					}

				}

				/*
				 * Reset to look for the next match.
				 */
				matchLine = 0;
				replaceLine = 0;
				stringMatch = new StringBuilder();
				stringReplace = new StringBuilder();
			}

		}

	}

	public static void flagPatch(String message) {

		System.out.println(message);
		pw.println(message);
		pw.flush();

	}

}
