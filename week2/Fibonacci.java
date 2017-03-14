import java.util.Scanner;

public class Fibonacci {
 

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(n==0)
    {
        System.out.println(0);
        System.exit(0);
    }
    long arr[]={0,1};
    long temp;
    for(int i=2;i<=n;i++)
    {
        temp=arr[1];
        arr[1]=arr[1]+arr[0];
        arr[0]=temp;
    }
    System.out.println(arr[1]);
  }
}
