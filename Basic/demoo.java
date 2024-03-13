class Calc
{
    public int add(int n,int y,int z){
        return n+y+z;
    }
    public int add(int n,int y){
        return n+y;
    }
}

 
public class demoo {
    public static void main(String[] args) {
        Calc cac = new Calc();
        int r = cac.add(4,5,7);
        System.out.println(r);
     }
}
