package training.tutorial;
import training.exampleclass.ShapeCal;
import training.exampleclass.ShapeCircle;
import training.exampleclass.ShapeRectangle;


public class p_Abstract_key_word {
    public static double autoArea(ShapeCal name){ // 创建一个静态方法来自动计算面积
        return name.area();
    }
    public static void autoName(ShapeCal name){ // 创建一个静态方法来自动输出名字
        name.name();
    }
    public static void autoAuthor(ShapeCal name){ // 创建一个静态方法来自动输出作者
        name.author();
    }
    public static void main(String[] args){

        ShapeCal objects[] = new ShapeCal[4]; // 创建一个ShapeCal对象数组来统一管理4个对象

        objects[0] = new ShapeCircle("circleNum1", 5); // 创建一个circle对象
        objects[1] = new ShapeCircle("circleNum2", 8); // 创建一个新的circle对象
        objects[2] = new ShapeRectangle("rectangleNum1", 3, 4); // 创建一个rectangle对象
        objects[3] = new ShapeRectangle("rectangleNum2", 5, 6); // 创建一个新的rectangle对象
        
        for (int i = 0; i < objects.length; i++) { // 遍历对象数组分别计算面积和输出名字
            autoName(objects[i]); // 输出名字
            System.out.println("Area is: "+autoArea(objects[i])); // 计算面积  
            autoAuthor(objects[i]);// 输出作者
        }
        // 使用增强的for循环
        for (ShapeCal object : objects){
            autoName(object); // 输出名字
            System.out.println("Area is:" +autoArea(object)); // 计算面积
            autoAuthor(object); // 输出作者
        }

    }

}
