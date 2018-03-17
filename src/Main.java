import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            String [] arr = s.split(" ");
            int n=Integer.parseInt(arr[0]);
            int m=Integer.parseInt(arr[1]);
            int x=Integer.parseInt(arr[2]);
            int k=Integer.parseInt(arr[3]);
            String s2 = bf.readLine();
            String [] arr2 = s2.split(" ");
            int money=m*n;
            int wrong=0;
            int right=0;
            for(int i=0;i<n;i++){
                int ans=Integer.parseInt(arr2[i]);
                if(ans==1){
                    right++;
                    money-=k;
                }
                if(ans==0){
                    money-=x;
                    wrong++;
                }
            }
            if(wrong<=right)
                money=money+wrong*k;
            else
                money=money+right*k;
            System.out.println(money);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
