import java.util.*;
class EditDistance {
  public static int EditDistance(String s, String t) {
    int n=s.length();
    int m=t.length();
    int edit[][]=new int[n+1][m+1];
    for(int i=0;i<=n;i++)
    edit[i][0]=i;
    for(int j=0;j<=m;j++)
    edit[0][j]=j;
    
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<=m;j++)
      {
          int ins=edit[i][j-1]+1;
          int del=edit[i-1][j]+1;
          int match=edit[i-1][j-1];
          int mis=edit[i-1][j-1]+1;
          int min;
          if(s.charAt(i-1)==t.charAt(j-1))
          {
              min=Math.min(ins,del);
              min=Math.min(min,match);
              edit[i][j]=min;
            }
            else
            {
               min=Math.min(ins,del);
              min=Math.min(min,mis);
              edit[i][j]=min;
            }
        }
    }
    
    return edit[n][m];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
