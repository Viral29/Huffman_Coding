/* Viral Sharadkumar Patel cs610 5446 prp */
import java.io.*;
import java.util.*;
import java.io.File;
import java.lang.Object;  
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


 class Node5446 implements Serializable
	  {
      public int v;
		  public int f;
      Node5446 left,right;
      public Node5446(int value, int freq)
      {
        this.v = value;									                
        this.f = freq;
        this.left = null;
        this.right = null;
      }
    }
    class datalength5446 implements Serializable
     {
       public long length;
       public datalength5446(long length)
       {
         this.length = length;
       }
       public long getlength5446()
       {
         return length;
       } 
     }
     
     class objectlen5446 implements Serializable
     {
       public long length;
       public objectlen5446(long length)
       {
         this.length = length;
       }
       public long getoblength5446()
       {
         return length;
       } 
     } 
     class dataobject5446 implements Serializable
    {
      public byte[] data_obj;
      public dataobject5446(byte[] data_obj)
        {
          this.data_obj = data_obj;
        }
       public byte[] getbytes5446() {
        return data_obj;
    }
      
    }
class hdec5446
{    
public static void decompress5446(String arg)
{
  File inputfile = new File(arg);
  System.out.println(inputfile.length());
    Node5446 read = null;
    dataobject5446 []data_read = null;
    datalength5446 l = null;
    objectlen5446 len = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;
     
     FileOutputStream fout = null;
    if (arg.indexOf(".") > 0)
    arg = arg.substring(0, arg.lastIndexOf("."));  
		try 
    {
     File outfile = new File(arg);
     if (outfile.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("Error");
	      } 
      fout = new FileOutputStream(outfile);
			fin = new FileInputStream(inputfile);
			ois = new ObjectInputStream(fin);
    	read = (Node5446) ois.readObject();
     l =(datalength5446) ois.readObject();
      len = (objectlen5446) ois.readObject();
      long end_len = l.getlength5446();
      long obj_len = len.getoblength5446();
      data_read = new dataobject5446[(int)obj_len]; 
      System.out.println(end_len);
      System.out.println(obj_len);
      Node5446 t = null;
       t = read;
       long end_count=0;  
       int i =0;    
       for(long ij=0;ij<obj_len;ij++)
      {  
        data_read[(int)ij] = (dataobject5446) ois.readObject();  
        byte[] b =  data_read[(int)ij].getbytes5446();
         StringBuilder sb = new StringBuilder();
         String[] temp1 = new String[b.length];
         for(int p=0;p<b.length;p++)
       {
          sb.append(String.format("%8s", Integer.toBinaryString(b[p] & 0xFF)).replace(' ', '0'));
       }
       String rdata = sb.toString();
       char[] ch = rdata.toCharArray();            
        if(end_count == end_len)
        break;

       for(int q=0;q<ch.length;q++)
       {
         
         if(end_count == end_len)
         break;
         
         if(ch[q]=='0')
         {  
           t = t.left;  
           if(t.left != null)
           {
               end_count++;
           }
           else if(t.left == null && t.right == null)
           {
             fout.write(t.v);
             fout.flush();
            // q++;
             end_count++;
             t = null;
             t =read;
           }
         }
        else if(ch[q]=='1')
         {    
            t = t.right; 
           if(t.right != null)
           {
             // q++; 
             end_count++;
           }
           else if(t.left == null && t.right == null)
           {
             fout.write(t.v);
             fout.flush();
            // q++;
             end_count++;
             t = null;
             t =read;
           }
         }
        }  
     } 
       System.out.println(end_count);
       inputfile.delete();  
		} catch (Exception ex) 
    {
			ex.printStackTrace();
		} finally 
  {
			if (fout != null) 
      {
				try 
        {
					fout.close();
				} catch (IOException e) 
        {
					e.printStackTrace();
				}
			}
			if (fin != null) 
      {
				try 
        {
					fin.close();
				} catch (IOException e) 
        {
					e.printStackTrace();
				}
			}
			if (ois != null) 
      {
				try 
        {
					ois.close();
				} catch (IOException e) 
        {
					e.printStackTrace();
				}
			}
      }
}
public static void main(String args[])
	{
   if(args.length == 1)
   {
     System.out.println(args[0]); 
     System.out.println("decoding");
     decompress5446(args[0]);
   }
   else
   System.out.println("Please provide proper argument");
   
}


}