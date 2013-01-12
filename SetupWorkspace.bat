@echo off

REM Get MC Server

echo Downloading Minecraft_Server.jar

.\SetupWorkspace\DownloadMS.vbs

PAUSE

REM Decompile

echo Decompile Minecraft_Server.jar

cd mcp

call decompile.bat

PAUSE

REM Patching Minecraft_Server.jar

echo Patching Minecraft_Server.jar

cd ..

PatchGM.bat

PAUSE