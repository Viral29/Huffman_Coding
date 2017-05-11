/* Viral Sharadkumar Patel cs610 5446 prp */
import java.io.*;
import java.util.*;
import java.io.File;
import java.lang.Object;  
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
      public byte[] getbytes5446() 
      {
        return data_obj;
      } 
    }
  class heap5446 
  {  
     public int size;
     public int capacity;
     Node5446 []node;
     heap5446(int size)
     {
       this.size = 0;
       this.capacity = size;
       this.node = new Node5446[size];
     }  
  }
class henc5446
{
public static void swapNode5446(heap5446 minheap,int p, int m)
{
    Node5446 temp = minheap.node[p];
    minheap.node[p] = minheap.node[m];
    minheap.node[m] = temp;
}    
public static Node5446 extractmin5446(heap5446 minheap)
{
  Node5446 temp = minheap.node[0];
  swapNode5446(minheap,0,minheap.size-1);
  minheap.size=minheap.size-1;
  minheapify5446(minheap,0);
  return temp;
}
public static void insertNode5446(heap5446 minheap, Node5446 temp)
{
  minheap.size = minheap.size+1;
  int h = minheap.size-1;
  while(h!=0 && temp.f < minheap.node[(h-1)/2].f)
  {
    minheap.node[h]= minheap.node[(h-1)/2];
    h = (h-1)/2;
  }
    minheap.node[h] = temp;
}
public static void minheapify5446(heap5446 minheap, int pos)
{
  int min = pos;
  int left = 2*pos+1;
  int right = 2*pos+2;
  if(left<minheap.size && minheap.node[left].f < minheap.node[min].f)
   { 
     min = left;
   }
  if(right<minheap.size && minheap.node[right].f < minheap.node[min].f)
    { 
      min = right;
    } 
  if(min != pos)
    {  
      swapNode5446(minheap,pos,min);
      minheapify5446(minheap,min);
    }  
}
public static void buildheap5446(heap5446 minheap)
{
  int n = minheap.size - 1;
  for(int k=(n-1)/2;k>=0;--k)
  {
    minheapify5446(minheap,k);
  }
}
public static heap5446 buildminheap5446(List<Integer> l1, List<Integer> l2, int size)
{
  heap5446 minheap = new heap5446(size);
  for(int h=0;h<size;h++)
  {
    minheap.node[h] = new Node5446(l1.get(h),l2.get(h));
  }
  minheap.size = size;
  buildheap5446(minheap);
  return minheap;
}
public static int height5446(Node5446 temp)
{
  if(temp == null)
  {
    return 0;
  }
  else
  {
    return 1+ Math.max(height5446(temp.left),height5446(temp.right));
  }
}
public static heap5446 buildhuffmanTree5446(heap5446 minheap)
{
  while(minheap.size !=1)
  {
    Node5446 left,right,temp;
    left = extractmin5446(minheap);
    right = extractmin5446(minheap);
    int t = (int) '#';
    temp = new Node5446(t,left.f+right.f);
    temp.left = left;
    temp.right = right;
    insertNode5446(minheap,temp);
  } 
  return minheap;
}
 public static void codegeneration5446(Node5446 n, int array[], int index,ArrayList<Integer> a, ArrayList<String> c, String s)
{
   if(n.left !=null)
  {
    array[index]=0;
    Node5446 temp;
    temp = n.left;
    codegeneration5446(temp,array,index+1,a,c,s+"0");
  } 
  if(n.right != null)
  {
    array[index]=1;
    Node5446 temp;
    temp = n.right;
    codegeneration5446(temp,array,index+1,a,c,s+"1");
  } 
  if(n.left==null && n.right==null)
  {
      a.add(n.v);
     c.add(s);
  }
  }
	public static int sum5446(List<Integer> list)
	{
		int s = 0;
		for(int i : list)
		s = s+i;
		return s;	
	}

 public static void compress5446(String arg)
{

File inputfile = new File(arg);
  System.out.println("in function");
int byteread=0;
try
	{
    RandomAccessFile aFile = new RandomAccessFile(inputfile, "r");
    FileChannel inChannel = aFile.getChannel();
    long size = inputfile.length();
    int s = (int) size;
    ByteBuffer buf = ByteBuffer.allocate(100);
    int[] b = new int[s];
    int read_i=0;
    int bytesRead = inChannel.read(buf);
  while (bytesRead != -1) 
  {
  buf.flip();  
  while(buf.hasRemaining())
  {
    b[read_i] = buf.get();
    read_i++;
  }
  buf.clear();
  bytesRead = inChannel.read(buf);
}
aFile.close();
		InputStream ips = new FileInputStream(inputfile);
		int sum=0;
		ArrayList<Integer> value = new ArrayList<Integer>();
		ArrayList<Integer> freq = new ArrayList<Integer>();
		int temp = 0,temp2=0;
		String line = null;
    int start_count =0;
		for(int i=0;i<b.length;i++)
		{			
       start_count++;
		  if(value.contains(b[i]))
		  {
				temp = value.indexOf(b[i]);
				temp2 = (int) freq.get(temp);
				freq.set(temp,temp2+1);
		  }
		  else
		  {
				value.add(b[i]);
				freq.add(1);
      }
		}
    System.out.println(start_count);
    sum = sum5446(freq);
	  System.out.println(Arrays.toString(value.toArray()));
    System.out.println(Arrays.toString(freq.toArray())); 
	  System.out.println("File original length"+size+"File length according to freq count"+sum);
    heap5446 minheap = buildminheap5446(value,freq,value.size());
    heap5446 heaptree = buildhuffmanTree5446(minheap);
    Node5446 test;
    test = heaptree.node[0];
    int[] arr = new int[height5446(test)];
    String s1 = new String();
    ArrayList<Integer> ascii = new ArrayList<Integer>();
    ArrayList<String> code = new ArrayList<String>();
    codegeneration5446(test,arr,0, ascii, code, s1);
    System.out.println(height5446(test));
    long count=0;
    int ne_count=0;
    String data="";
    int co_temp=0;
    StringBuffer sb = new StringBuffer();
   
   long in_count=0;
    for(int i=0;i<b.length;i++)
    {
      temp = ascii.indexOf(b[i]);
      String a = code.get(temp);
      count += a.length();
   } 
   in_count = count;
    
    System.out.println(count);
    while(count%(1024*16) !=0)
    {
      count++;
    }  
    System.out.println(count+"  "+"NO of Objects"+count/(1024*16));
    long no_ob = count/(1024*16);
    dataobject5446 []ob = new dataobject5446[(int)no_ob];
    count=0;
    int splitSize = 8;
    byte[] resultByteArray =null;
    int index = 0;
    int position = 0;
    StringBuilder text=null;
    String binaryStringChunk =""; 
    Integer byteAsInt=0;    
    for(int i=0;i<b.length;i++)
    {
      temp = ascii.indexOf(b[i]);
      String a = code.get(temp);
      count += a.length();
      sb.append(a); 
     if(sb.length()>=16384)
     {
       data = sb.substring(0,16384);
       sb.delete(0,16384);
       splitSize = 8;
       resultByteArray = null;
     if(data.length() % splitSize == 0)
     {
         index = 0;
         position = 0;
         resultByteArray = new byte[data.length()/splitSize];
         text = new StringBuilder(data);
       while (index < text.length()) 
       {
         binaryStringChunk = text.substring(index, Math.min(index + splitSize, text.length()));
         byteAsInt = Integer.parseInt(binaryStringChunk,2);
         resultByteArray[position] = byteAsInt.byteValue();
         index += splitSize;
         position ++;
       }    
    }
      data="";       
      ob[co_temp] = new dataobject5446(resultByteArray);
      co_temp++;
      count=0;
  }
  }
    System.out.println("remaning"+sb.length());
    System.out.println("ob_number"+co_temp);
      if(sb.length()>0)
      {
      while(sb.length()!=16384)
      {
        data = sb.append("0").toString();
      }
    data = sb.substring(0,16384); 
    splitSize = 8;
         resultByteArray = null;
        if(data.length() % splitSize == 0){
         index = 0;
         position = 0;
        resultByteArray = new byte[data.length()/splitSize];
        text = new StringBuilder(data);
        while (index < text.length()) 
        {
             binaryStringChunk = text.substring(index, Math.min(index + splitSize, text.length()));
             byteAsInt = Integer.parseInt(binaryStringChunk,2);
            resultByteArray[position] = byteAsInt.byteValue();
            index += splitSize;
            position ++;
        }       
    }
    
    ob[co_temp] = new dataobject5446(resultByteArray);
       co_temp++;
       data=""; 
    }
    
        System.out.println(count);
          System.out.println("No of ob after"+co_temp);
          System.out.println("No of ob after"+no_ob);
  System.out.println(data.length());
  inputfile.delete();
  datalength5446 len = new datalength5446(in_count);
  objectlen5446 oblen = new objectlen5446((int)no_ob);
  File outfile = new File(arg+".huf");
  if (outfile.createNewFile())
  {
    System.out.println("File is created!");
  }
  else
  {
    System.out.println("File already exists.");
  }
  FileOutputStream fout = null;
  ObjectOutputStream oos = null; 
  try 
  {
			fout = new FileOutputStream(outfile);   
			oos = new ObjectOutputStream(fout);
			oos.writeObject(heaptree.node[0]);
      oos.flush();
      oos.writeObject(len); 
      oos.flush();
      oos.writeObject(oblen);
      oos.flush();
      for(int obj=0;obj<no_ob;obj++)
      {
      oos.writeObject(ob[obj]);
      oos.flush();
      } 
      System.out.println("Done"); 

		}
    catch (Exception ex) 
    {
			ex.printStackTrace();
		} 
    finally 
    {
      if(fout != null) 
      {
      try 
      {
				fout.close();
      } 
      catch (IOException e) 
      {
				e.printStackTrace();
		  }
		  }
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}
    }
	catch(Exception e)
	{
		System.out.println("Error message:"+e);
	}
 
	}
 
 public static void main(String args[])
	{
   if(args.length == 1)
   {
     System.out.println(args[0]); 
   System.out.println("encoding");
     compress5446(args[0]);
   }
   else
   System.out.println("Please provide proper argument"); 
   
   }
   
}