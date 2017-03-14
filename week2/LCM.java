import java.util.*;
import java.math.*;
public class LCM {
  
  private static BigInteger calcgcd(BigInteger a, BigInteger b)
  {
      if((BigInteger.ZERO).compareTo(b)==0)
      return a;
      else
      return calcgcd(b,a.remainder(b));
    }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    BigInteger a=new BigInteger(s);
    s = scanner.next();
    BigInteger b=new BigInteger(s);
     if(a.compareTo(b)==-1)
    {
        BigInteger temp=a;
        a=b;
        b=temp;
    }
    BigInteger gcd=calcgcd(a,b);
    gcd=a.divide(gcd);
    gcd=gcd.multiply(b);
    System.out.println(gcd);
  }
}
