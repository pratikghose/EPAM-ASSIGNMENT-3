import java.util.*;
import java.io.*;
public class DescendingWeights {
 
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	@SuppressWarnings("unchecked")
	static int[] bucketSort(int[] input,int k)
    {
        ArrayList<Integer>[] buckets=(ArrayList<Integer>[])new ArrayList[k];
        for(int i=0;i<k;i++)
        {
        	buckets[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<input.length;i++)
        {
        	buckets[input[i]%k].add(input[i]);
        }
        for(int i=0;i<k;i++)
        {
        	Collections.sort(buckets[i]); 
        }
        int counter=0;
        for(int i=k-1;i>=0;i--)
        {
            for(int j=0;j<buckets[i].size();j++)
            {
            	input[counter++]=buckets[i].get(j);
            }
        }
        return input;
    }
	
	
	static void printResult(int[] result) throws Exception
	{
		 for(int i=0;i<result.length;i++)
		 {
			 bw.write(Integer.toString(result[i])+" ");
		 }
		 bw.newLine();
	}
	
	
    public static void main(String[] args ) throws Exception {
        int[] input=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();//taking input
        int[] inputs=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        inputs=bucketSort(inputs,input[1]);
        printResult(inputs);
        br.close();
        bw.close();
    }
}
