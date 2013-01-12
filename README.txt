Q/A:
	Q:  What is this project?
	A: This project is a Plugin/Mod loader that is auto patched into minecraft and can be updated very quickly. Its main goal is speed.
	
	Q: Does it have an Event system?
	A: Yes!
	
	Q: Is it easy to use?
	A: If you have uses Minecraft_Server.jar before, its the same exact thing.


How to setup workspace:
	1. Download the newest version of MCP: http://mcp.ocean-labs.de/index.php/MCP_Releases#Releases
	2. Extract it to the subfolder, mcp
	3. run SetupWorkspace.bat
	4. Wait for everything to finish
	5. Check log.txt for errors
	6. If there are errors, read the Error fixing/Commiting section

How QuickPatch works:
	1. Make a change
	2. After the change is made, tag your edit with // GravyMod
	3. make a patch file, Sample patch files are within the "Samples" folder

BugFixing/Commiting:
	1. if you fix a bug that is inside NMS code, you must make a patch file
	2. You must tag changes with // GravyMod 
	3. If you create a file, add an @author statment at the class definition
	4. If you create a method/class please JavaDoc it.... Please!
	5. Any commits must sign off as Open Source and free to use.

License:
	Attribution-NonCommercial-ShareAlike 
	CC BY-NC-SA

	This license lets others remix, tweak, and build upon your work non-commercially, as long as they credit you and license their new creations under the identical terms.
	Links:
		http://creativecommons.org/licenses/by-nc-sa/3.0/legalcode
		http://creativecommons.org/licenses/by-nc-sa/3.0/