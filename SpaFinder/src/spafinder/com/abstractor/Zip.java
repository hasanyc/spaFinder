package spafinder.com.abstractor;
import java.io.*;
import java.util.zip.*;
 
 
 public class Zip  {


	  public static void addFilesToZip(File source, File[] files)
	  {
	      try
	      {

	          File tmpZip = File.createTempFile(source.getName(), null);
	          tmpZip.delete();
	          if(!source.renameTo(tmpZip))
	          {
	              throw new Exception("Could not make temp file (" + source.getName() + ")");
	          }
	          byte[] buffer = new byte[1024];
	          ZipInputStream zin = new ZipInputStream(new FileInputStream(tmpZip));
	          ZipOutputStream out = new ZipOutputStream(new FileOutputStream(source));

	          for(int i = 0; i < files.length; i++)
	          {
	              InputStream in = new FileInputStream(files[i]);
	              out.putNextEntry(new ZipEntry(files[i].getName()));
	              for(int read = in.read(buffer); read > -1; read = in.read(buffer))
	              {
	                  out.write(buffer, 0, read);
	              }
	              out.closeEntry();
	              in.close();
	          }

	          for(ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
	          {
	              out.putNextEntry(ze);
	              for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
	              {
	                  out.write(buffer, 0, read);
	              }
	              out.closeEntry();
	          }

	          out.close();
	          tmpZip.delete();
	          zin.close();
	      }
	      catch(Exception e)
	      {
	          e.printStackTrace();
	      }
	  }
	
	public static void zipIt (){
			  {
				  try
				  	{
					  File inFolder=new File(System.getProperty("user.dir")+"\\XSLT_Reports\\output");
					  File outFolder=new File("Reports.zip");
					  ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
					  BufferedInputStream in = null;
					  byte[] data  = new byte[1000];
					  String files[] = inFolder.list();
					 for (int i=0; i<files.length; i++)
					  {
					  in = new BufferedInputStream(new FileInputStream
					(inFolder.getPath() + "/" + files[i]), 1000);
					out.putNextEntry(new ZipEntry(files[i]));
					  int count;
					  while((count = in.read(data,0,1000)) != -1)
					  {
					 out.write(data, 0, count);
					  }
					  out.closeEntry();
					  }
					  out.flush();
					  out.close();
					  }
					  catch(Exception e)
					 {
					  e.printStackTrace();
					  }
			  		}
			  	}
			 }