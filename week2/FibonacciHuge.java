import java.util.*;
import java.math.*;

public class FibonacciHuge {
     static BigInteger rem[]=new BigInteger[1000000];
    private static BigInteger calcPisano(BigInteger m)
    {
        if((BigInteger.ONE).compareTo(m)==0)
        return BigInteger.ONE;
        BigInteger count=new BigInteger("0");
        BigInteger a=new BigInteger("0");
        BigInteger b=new BigInteger("0");
        BigInteger arr[]=new BigInteger[2];
        arr[0]=BigInteger.ZERO;
        arr[1]=BigInteger.ONE;
        BigInteger temp=new BigInteger("0");
        rem[0]=BigInteger.ZERO;
        rem[1]=BigInteger.ONE;
        int k=2;
        while(!((BigInteger.ZERO).compareTo(a)==0 && (BigInteger.ONE).compareTo(b)==0))
          {
              rem[k]=(arr[0].remainder(m)).add(arr[1].remainder(m));
              k++;
              temp=arr[1];
              arr[1]=arr[1].add(arr[0]);
              arr[0]=temp;
              a=arr[0].remainder(m);
              b=arr[1].remainder(m); 
             count= (BigInteger.ONE).add(count);
        }
        return count;
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        BigInteger n=new BigInteger(s); 
        s = scanner.next();
        BigInteger m=new BigInteger(s); 
        n=n.remainder(calcPisano(m));
        int n1=Integer.parseInt(n.toString());
        if(m.remainder(BigInteger.TEN)==BigInteger.ZERO)
        System.out.println(rem[n1].remainder(m));
        else
        System.out.println(rem[n1]);
}
}

