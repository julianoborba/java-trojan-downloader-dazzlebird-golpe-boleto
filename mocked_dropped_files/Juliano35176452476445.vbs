On Error Resume Next
with CreateObject("Scripting.FileSystemObject")
 appScr = Replace(Wscript.ScriptFullName,chr(35),chr(32))
     .DeleteFile appScr
 while .Fileexists("C:\Users\Rosana\workspace\Dazzlebird\bin")
      with CreateObject("Shell.Application")
          .run "taskkill /f /im java.exe" ,0
          Wscript.Sleep 2000
      End With
          .DeleteFile "C:\Users\Rosana\workspace\Dazzlebird\bin"
    Wend
end with
