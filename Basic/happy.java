public class happy{
private String name;
private int age;

public happy(String name,int age ){
    this.name=name;
    this.age=age;
}
public String getName(){
    return name;
}
public int getAge(){
    return age;
}
public void setName(String name){
    this.name=name;
    
}
public void setAge(int age){
   this.age=age; 
}
public void MyCone(){
    System.out.println("your name is "+name+" and age is "+age);
}
}
class how{
public static void main(String[] args) {
    happy obj=new happy("one",18);
    happy obj1=new happy("one",20);
    obj.MyCone();
    obj1.MyCone();
}

}