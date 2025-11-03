import java.util.*;
 public class mysterypuzzle{
 public static int findout(int N,String S){
    int len=S.length();
    long total=1;
    for(int i=0;i<len/2;i++){
        int left=S.charAt(i);
        int right=S.charAt(len-1-i);
        if(left=='?' && right=='?'){
            total=(total*26)%N;
        }
        else if(left=='?'|| right=='?'){
            total=(total*1)%N;
        }
        else if(left!=right){
            return 0;
        }
    }
      if (len % 2 == 1 && S.charAt(len / 2) == '?') {
            total = (total * 26) % N;
        }

        return (int)(total % N);
    }

 
public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n");
    int N=sc.nextInt();
    // ✅ Consume leftover newline

        System.out.println("Enter S:");
        String S = sc.next();
        System.out.println(findout(N, S));
}
}