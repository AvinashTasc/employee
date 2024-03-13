class calculator{
    public int add(int a,int b){
        System.out.println("hii add done");
        int result = a+b;
        return result;
    }
}
public class calcu {
    public static void main(String[] args) {
        calculator ct = new calculator();  
        int num=5;
        int mun=7;
        int result =ct.add(num,mun);
        System.out.println(result);
    }
}
