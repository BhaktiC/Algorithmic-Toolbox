import java.util.*;

public class GCD {
  private static int calcgcd(int a, int b)
  {
      if(b==0)
      return a;
      else
      return calcgcd(b,a%b);
    }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
   
    if(a<b)
    {
        int temp=a;
        a=b;
        b=temp;
    }
    System.out.println(calcgcd(a, b));
  }
}
