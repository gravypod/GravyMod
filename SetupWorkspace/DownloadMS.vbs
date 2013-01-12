
'Found on stack over flow. Credit does not belong to us!

'Set your settings

 strFileURL = "https://s3.amazonaws.com/MinecraftDownload/launcher/minecraft_server.jar"
 strHDLocation = ".\mcp\jars\minecraft_server.jar"

' Fetch the file

 Set objXMLHTTP = CreateObject("MSXML2.XMLHTTP")

 objXMLHTTP.open "GET", strFileURL, false
 objXMLHTTP.send()

 If objXMLHTTP.Status = 200 Then
   Set objADOStream = CreateObject("ADODB.Stream")
   objADOStream.Open
   objADOStream.Type = 1 'adTypeBinary

   objADOStream.Write objXMLHTTP.ResponseBody
   objADOStream.Position = 0    'Set the stream position to the start

   Set objFSO = Createobject("Scripting.FileSystemObject")
     If objFSO.Fileexists(strHDLocation) Then objFSO.DeleteFile strHDLocation
   Set objFSO = Nothing

   objADOStream.SaveToFile strHDLocation
   objADOStream.Close
   Set objADOStream = Nothing
 End if

 Set objXMLHTTP = Nothing