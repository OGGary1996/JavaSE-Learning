package training.exampleclass;

public class ShapeRectangle extends ShapeCal{
    double length;
    double width;
    public ShapeRectangle(String name,double length, double width){
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area(){
        double result = length * width;
        return result;
    }
    public void name(){
        System.out.println("This is a rectangle calculator: "+name);
    }

}
