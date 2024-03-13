class comp
{
    public void play()
    {
        System.out.println("hii playig");
    }
    public String getpen(int cost)
    {
        if(cost>=10)
        return "pen";
    
        return "Nothing";
    }
}

public class demo {
    public static void main(String[] args) {
        
        comp com= new comp();
        com.play();
        String n= com.getpen(9);
        System.out.println(n);
    }
}
