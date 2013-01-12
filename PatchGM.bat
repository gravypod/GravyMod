@echo off

java -jar QuickPatch.jar patches 

IF %ERRORLEVEL% NEQ 0 exit /b %ERRORLEVEL%

echo Patching done correctly! Making Workspace

PAUSE

set mcpDir=.\mcp

set workspacePath=.\WorkSpace\

set langPath=.\WorkSpace\lang

set achievementPath=.\WorkSpace\achievement

set fontPath=.\WorkSpace\font.txt

mkdir %workspacePath%

mkdir %langPath%

mkdir %achievementPath%

# Copy Minecraft source
xcopy /y /s/e %mcpDir%\src\minecraft_server %workspacePath%

# Copy GravyMod Source
xcopy /y /s/e ".\GravyModSource\*" %workspacePath%

# Copy MinecraftServer resources
xcopy /y /s/e "%mcpDir%\temp\bin\minecraft_server\achievement" %achievementPath%
              
xcopy /y /s/e "%mcpDir%\temp\bin\minecraft_server\lang" %langPath%

xcopy /y "%mcpDir%\temp\bin\minecraft_server\font.txt" %fontPath%

PAUSE
