import java.util.Arrays;
import java.util.HashSet;

public class test1 {
    public static void main(String[] args) {
        HashSet<Coor> set=new HashSet<>();
//        int[] a={1,2,3};
//        int[] b={3,2,1};
//        int[] c={3,2,5};
//        int[] d={1,2,3};
//        int[] e={3,2,1};
        Coor a=new Coor();
        a.setCoor(new int[]{1,2,3});
        Coor b=new Coor();
        b.setCoor(new int[]{3,2,1});
        Coor c=new Coor();
        c.setCoor(new int[]{3,2,5});
        Coor d=new Coor();
        d.setCoor(new int[]{1,2,3});
        Coor e=new Coor();
        e.setCoor(new int[]{3,2,1});
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);
        System.out.println(set.size());



//        String[] array = {"a","b","c","c","d","e","e","e","a"};
//        Set<String> set = new HashSet<>();
//        for(int i=0;i<array.length;i++){
//            set.add(array[i]);
//        }
//        String[] arrayResult = (String[]) set.toArray(new String[set.size()]);
//        System.out.println(Arrays.toString(arrayResult));
    }
}
