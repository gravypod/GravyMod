package net.minecraft.server.Plugins;

import java.util.Collection;

/**
 * Various string utilitys
 * @author gravypod
 *
 */
public class StringUtil {
	
	
	/**
	 * Turn a collection into a readable list.
	 * @param list - {@link Collection}
	 * @param lineDelimiter - {@link String} 
	 * @return - Readable list
	 */
	public static String toReadableList(Collection<String> list, String lineDelimiter) {

	    StringBuilder sb = new StringBuilder();

	    String delimiter = "";

	    for(String s : list) {

	        sb.append(delimiter);
	        sb.append(s);            

	        delimiter = lineDelimiter;
	    }

	    return sb.toString();
	}
	
}
