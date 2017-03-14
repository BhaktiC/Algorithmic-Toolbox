import java.util.*;

public class Knapsack {
    static int optimalWeight1(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }
    static int result=0;
    static int optimalWeight2(int cap, int[] w, int n)
    {
      if(n==0 || cap==0)
      return 0;
      if(w[n-1]>cap)
      return optimalWeight(cap, w, n-1);
      else
      return Math.max(w[n-1]+optimalWeight(cap-w[n-1],w,n-1), optimalWeight(cap,w,n-1));
      
    }
    
     static int optimalWeight(int cap, int[] w, int n)
    {
      int val[][]=new int[n+1][cap+1];
      val[0][cap-1]=0;
      for(int i=0;i<=cap;i++)
      val[0][i]=0;
      for(int i=1;i<=n;i++)
      {
          val[i][0]=0;
          for(int j=1;j<=cap;j++)
          {
              int wt=w[i];
              if(wt<=j)
              {
                  int l1=wt+val[i-1][j-wt];
                  int l2=val[i-1][j];
                if(l1>l2)
                val[i][j]=l1;
                else
                val[i][j]=l2;
                }
                else
                val[i][j]=val[i-1][j];
            }
        }
        return val[n][cap];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w, n));
    }
}

