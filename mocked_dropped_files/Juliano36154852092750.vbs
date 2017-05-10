On Error Resume Next
with CreateObject("Scripting.FileSystemObject")
	appScr = Replace(Wscript.ScriptFullName,chr(35),chr(32))
			.DeleteFile appScr
	appUAC = "C:\Users\Rosana\AppData\Local\Temp\UAC.YES"
	while not .Fileexists(appUAC) 
    with CreateObject("Shell.Application")
          .ShellExecute "C:\Program Files\Java\jre1.8.0_121\bin\java.exe","-jar ""C:\Users\Rosana\workspace\Dazzlebird\bin"" 0",,"runas",0
    End With
      Wscript.Sleep 3000
    Wend
		if .Fileexists(appUAC) then
                  Wscript.Sleep 1500
			.DeleteFile appUAC
		end If
End With
