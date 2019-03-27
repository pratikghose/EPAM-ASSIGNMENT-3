import java.util.*;
class RodCutting {
    public static void main(String args[] ) throws Exception {
       Scanner sc=new Scanner(System.in);
       int testcase=sc.nextInt();
       while(testcase>0)
       {
           long rodlen=sc.nextLong();
           int count=0;
           long len=3;
           while(len<=rodlen)
           {
               len=2*len+1;
               count++;
           }
           System.out.println(count);
           testcase--;
           
       }
       
       
    }
}