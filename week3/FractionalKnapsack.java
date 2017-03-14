import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) 
    {
        double value = 0;
        int n=values.length;
        double arr[]=new double[n];
        for (int i = 0; i<n ; i++)
        {
            arr[i]=(double)values[i]/(double)weights[i];
        }
        double swap;
        int swap1;
         for (int i = 0; i<n - 1; i++)
         {
            for (int j= 0; j<n-i-1; j++)
            {
               if (arr[j] < arr[j+1])
               {
                  swap = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = swap;
                  swap1=weights[j];
                  weights[j]=weights[j+1];
                  weights[j+1]=swap1;
                  swap1=values[j];
                  values[j]=values[j+1];
                  values[j+1]=swap1;
                }
               }
        }
        int k=0;
        while(capacity!=0 && k<n)
        {
          if(capacity>=weights[k])
          {
          capacity=capacity-weights[k];
          value=value+values[k];
          k++;
         }
         else
         {
             value=value+(arr[k]*capacity);
             capacity=0;
        }
    }
        return value;
    
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
