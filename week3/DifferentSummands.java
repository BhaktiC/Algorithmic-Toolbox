import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k=0;
        int prev=0;
        while(n!=0)
        {
            if(n/2>=prev)
            {
              int prev1=prev;
                while((prev1==prev && prev<=n) || (float)n/2<=prev)
                {
                prev++;
                if(prev==n)
                break;
            }
                summands.add(prev);
                n=n-prev;
            }
            else
            {
            summands.add(n);
            n=0;
           }
            }
        
        return summands;
    }
    
    public static void main(String[] args) {
        while(true)
        {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
    }
}

