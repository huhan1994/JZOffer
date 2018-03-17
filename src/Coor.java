public class Coor {
    public int[]  coordinate=new int[3];
//    public Coor(int[]  coordinate){
//        this.coordinate=coordinate;
//    }
    public int[] getCoor() {
        return coordinate;
    }

    public void setCoor(int[] coordinate) {
        this.coordinate= coordinate;
    }

    @Override
    public int hashCode() {
        int h=0;
        for(int i=0;i<coordinate.length;i++){
            h+=7*h+coordinate[i];
        }
        return h;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if (obj instanceof Coor){
            Coor coor=(Coor)obj;
            for(int i=0;i<coor.coordinate.length;i++){
                if(coor.coordinate[i]!=coordinate[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
