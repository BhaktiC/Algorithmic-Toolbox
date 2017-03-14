import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

     private static List<Integer> optimal_sequence1(int n) {
        List<Integer> min = new ArrayList<Integer>(n+1);
        min.add(0,0);
        min.add(1,0);
        for(int i=2;i<n+1;i++)
         {
             int l2,l3,minimum;
            minimum=1+min.get(i-1);
            if(i%2==0)
            {
            l2=1+min.get(i/2);
            minimum=Math.min(minimum,l2);
          }
          if(i%3==0)
          {
            l3=1+min.get(i/3);
            minimum=Math.min(minimum,l3);
            }
           min.add(i,minimum);
        }
        int j=min.get(n);
         List<Integer> sequence = new ArrayList<Integer>(j);
         if(j==0)
         {
             sequence.add(0,1);
             return sequence;
            }
        sequence.add(0,n);
        for(int i=1;i<j;i++)
        {
            int l1=sequence.get(i-1);
            int l2=min.get(l1);
            
          if(l1%2==0 && min.get(l1/2)+1==l2)
          sequence.add(i,l1/2);
          
          else if(l1%3==0 && min.get(l1/3)+1==l2)
          sequence.add(i,l1/3);
          
          else 
          sequence.add(i,l1-1);
        }
        sequence.add(j,1);
        Collections.reverse(sequence);
        return sequence;
        }
        
            
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence1(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

