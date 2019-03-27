import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class TestClass {
static long total = 0;
public static void main(String[] args)
{
TestClass solution=new TestClass();
 
solution.mymethod();
}
public void mymethod()
{
    Scanner sc = new Scanner(System.in);
int test_cases = sc.nextInt();
for(int n=0;n<test_cases;n++)
{
String on_switches = sc.next();
long inp = sc.nextLong();
char swt[]=new char[100];
swt=on_switches.toCharArray();
List<Integer> list = new LinkedList<Integer>();
for(int i=0;i<on_switches.length();i++)
{
if(swt[i] == '1')
{
list.add(i+1);
}
}
if(list.size() == 1)
{
System.out.println(list.get(0)*inp);
}
else
{
long lowest = list.get(0);
long highest = list.get(0)*inp;
long Onbulbs= 0;
 
while(lowest <= highest)
{
long count = 0;
long mid_value = (lowest + highest)/2;
for(int i=0;i<list.size();i++)
{
long d = mid_value/list.get(i);
count = count + d;
}
 
for(int i=2;i<=list.size();i++)
{
total = 0;
method(list,list.size(),i,mid_value);
if(i%2==0)
{
count = count - total;
}
else
{
    count = count + total;
 
}
}
if(count < inp)
{
	 lowest = mid_value + 1;
 
}
else
{
   
    Onbulbs = mid_value;
highest = mid_value - 1 ;
}
}
System.out.println( Onbulbs);
}
}
sc.close();
 
}
 
 
public static void method2(List<Integer> list3,int[] arr,int start_element,int last_element,int val,int i,long mid_value)
{
if(val == i)
{
long tempvar = 1;
for(int j=0;j<i;j++)
{
tempvar = tempvar*arr[j];
}
long tempvar1 = mid_value/tempvar;
total = total + tempvar1;
return;
}
for(int j=start_element;j<=last_element && last_element-j+1>=i-val;j++)
{
arr[val] = list3.get(j);
method2(list3,arr,j+1,last_element,val+1,i,mid_value);
}
}
 
public static void method(List<Integer> list2,int size,int i,long mid_value)
{
int[] arr = new int[i];
method2(list2,arr,0,size-1,0,i,mid_value);
}
 
 
  
 
 
}