package training.tutorial.exampleclass;

public class ShapeCircle extends ShapeCal{
    double radius;
    public ShapeCircle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    
    @Override
    public double area(){
        double result = Math.PI * radius * radius;
        return result;
    }
    public void name(){
        System.out.println("This is a circle calculator: "+name);
    }
}
