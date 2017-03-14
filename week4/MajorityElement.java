import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }
        
        else
        {
            int k=(right+left)/2;
            int lno=getMajorityElement(a,left,k);
            int rno=getMajorityElement(a,k+1,right);
            if(lno==rno)
            return lno;
            int lcount=getFrequency(a,lno,left,right);
            int rcount=getFrequency(a,rno,left,right);
            if(k%2==0)
            {
            if(lcount>k)
            return lno;
            else if(rcount>k)
            return rno;
            
        }
        else
        {
            if(lcount>k+1)
            return lno;
            else if(rcount>k+1)
            return rno;
        
        }
          return -1;
        }
        
        
    }
    
    static int getFrequency(int[] a, int no, int l, int r)
    {
        int count=0;
        for(int i=l;i<=r;i++)
        {
            if(a[i]==no)
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        while(true)
        {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

