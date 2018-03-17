import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testcode {
    public static void main(String[] args) {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n= 0;
        try {
            n = Integer.parseInt(bf.readLine());
            String s = bf.readLine();
            String [] arr = s.split(" ");

            int x0=Integer.parseInt(arr[0]);
            int x1=Integer.parseInt(arr[1]);
            int x2=Integer.parseInt(arr[2]);
            int count=0;
            for(int i=0;i<n;i++){
                String s2 = bf.readLine();
                String [] arr2 = s2.split(" ");
                int y0=Integer.parseInt(arr2[0]);
                int y1=Integer.parseInt(arr2[1]);
                int y2=Integer.parseInt(arr2[2]);
                if(y0<=x0 && y1<=x1 &&y2<=x2){
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

      //  int[][] a=new int[n][3];

    }

    public static class test1 {
    }
}
