package Reflection.d_getField;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class c_changeFieldValue {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 字段的值只存在于对象中，所以需要先创建对象
        // 使用反射的方式来创建对象
        Class<?> userClass = Class.forName("Reflection.d_getField.User");
        Constructor<?> con = userClass.getDeclaredConstructor(String.class, int.class, char.class);
        if (!Modifier.toString(con.getModifiers()).equals("public")){
            con.setAccessible(true);
        }
        User user = (User)con.newInstance("Gary", 1, 'M');

        // 1. 获取到所有的字段
        Field[] allFields = userClass.getDeclaredFields();
        // 2. 遍历所有字段，获取字段的值,获取字段的值时，需要传递的参数是这个对象
        for(Field field : allFields){
            if (!Modifier.toString(field.getModifiers()).equals("public")){ // 如果不是public字段
                field.setAccessible(true);
            }
            System.out.println("Field name: " + field.getName() +
                    ", Field type: " + field.getType().getSimpleName() +
                    ", Field value: " + field.get(user));
        }
        // 3.遍历所有字段，修改字段的值,需要传递的参数是对象和新的值
        for (Field f : allFields){
            // 获取字段的基本信息
            String modifier = Modifier.toString(f.getModifiers());
            String fieldName = f.getName();
            Class<?> fieldType = f.getType();
            if (!modifier.equals("public")){
                f.setAccessible(true);
            }
            switch (fieldType.getSimpleName()){
                case "String" -> f.set(user,"Tom");
                case "int" -> f.set(user, 2);
                case "char" -> f.set(user, 'F');
            }
        }
        System.out.println("After changing the field value: " + user);
    }
}
