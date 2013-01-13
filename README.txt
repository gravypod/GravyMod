Q/A:
	Q:  What is this project?
	A: This project automatically patches minecraft's jar files to allow loading of plugins/mods using it's API. It can be updated very quickly and easily. The primary goal is to achieve a faster method of doing this than current other Mod Loaders/API's.
	
	Q: Does it have an Event system?
	A: Yes! ... TODO: Elaborate.
	
	Q: Is it easy to use?
	A: Yes! The process is very simple for patching the jar files, and loading a server uses the exact same process as with vanilla minecraft's minecraft_server.jar!


How to setup workspace:
	1. Download the newest version of MCP from their website: http://mcp.ocean-labs.de
	2. Extract the patch to the mcp subfolder
	3. Run SetupWorkspace.bat
	4. Wait for everything to finish
	5. Check log.txt for errors
	6. If there are errors, read the Error Fixing/Commiting section

How QuickPatch works:
	1. Make a change
	2. After the change is made, tag your edit with // GravyMod
	3. Make a patch file, Sample patch files are within the "Samples" folder

Bug Fixing/Commiting:
	1. If you fix a bug that is inside NMS code, you must make a patch file
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
