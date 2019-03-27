import java.util.*;
public class TestClassArmy {
    public static void main(String args[]) {
               Scanner sc = new Scanner(System.in);
        
        int N =sc.nextInt();
        long S = sc.nextLong();
        long E = sc.nextLong();
        TreeMap<Long,Long> tr1=new TreeMap<Long,Long>();
        TreeMap<Long,Long> tr2=new TreeMap<Long,Long>();
        for(int i=0;i<N;i++)
        {
            long position = sc.nextLong();
            long army_size = sc.nextLong();
            tr1.put((position-army_size),(position+army_size));
        
    }
    List<Long> l1=new ArrayList<Long>(tr1.keySet());
    List<Long> l2=new ArrayList<Long>(tr1.values());
        long c = l1.get(0);
        long d = l2.get(0);
        for(int i=1;i<tr1.size();i++)
        {
            if(l1.get(i)<=d)
                d = Math.max(d,l2.get(i));
            else
            {
                
                tr2.put(c,d);
                c = l1.get(i);
                d = l2.get(i);
            }
            
        }
        tr2.put(c,d);
             int i;
        long ans = 0;
  l1=new ArrayList<Long>(tr2.keySet());
    l2=new ArrayList<Long>(tr2.values());
 
        
        for(i=0;i<l1.size();i++)
        {
            if(S>=E)
            {
                S=E;
                break;
            }
            if(l1.get(i)<=S && S<=l2.get(i))
                S = l2.get(i);
            else if(S<=l1.get(i) && E>=l2.get(i))
            {
                ans+=l1.get(i)-S;
                S = l2.get(i);
                
            }
            else if(S<=l1.get(i) && E>=l1.get(i) &&  E<=l2.get(i))
            {
                ans+=l1.get(i)-S;
                S = E;
            }
            else if(S<=l1.get(i) && E<=l1.get(i))
            {
                ans+=E-S;
                S = E;
            }
        }
        if(S<E)
            ans+=E-S;
        System.out.println(ans);
    }
}