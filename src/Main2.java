import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int[][] array=new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                array[i][j]=sc.nextInt();
            }
        }
    }
}
