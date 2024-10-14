package training;
// 在java中所有的class都是 Object class 的一个child class
// 在创建class时，java会默认加上隐式的继承 class class_name extends Object
// 这也是为什么在一个class中 就算没有创建方法，也可以直接使用Object的方法

import training.exampleclass.Animal;


public class s_ObjectClass_equals_toString_hashCode extends Object { // 可以将隐式继承写出来
    public static void main(String[] args){
    // toString()方法
    //  如果打印一个object本身，java会默认加上隐式的toString()方法
    Animal animal1 = new Animal();
    System.out.println(animal1);
    System.out.println(animal1.toString()); // 返回的结果一致 training.exampleclass.Animal@2dda6444
    /*  public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    } */
    //  toString()会将calss的目录+名称+@+hashcode作为返回值，这个hashcode会被cast为16进制数字
    //  但是也可以在Amnimal class中重写这个toString()方法，使得toString()方法返回需要的值


    // hashCode()方法
    //   基于object的内存地址，计算出一个数字来表示，也可以重写hashCode()方法来返回想要的hashcode
    //   1、基于hash结构的数据可以根据这个hashcode来快速查找删除等操作
    //   2、通过hashcode来来定位object所在的hash bucket（哈希桶），如果两个object的hashcode相同，则放入一个hash bucket中，然后再根据equals()方法进一步对比
    //   object的hashcode可能会相等，但是不代表他们的内存地址一样，因为hashcode()方法只是基于内存地址计算出。
    //   所以hashcode()相等的情况下equals()可能不相等，但是equals()相等的情况下hashcode()肯定相等


    // equals()方法
    //   Object class中默认的equals()方法会比较object的内存地址，只有object引用了同一个object时 equals()才会相等。
    //    == ，是默认的equals()实现的方式，== 本质上就是比较两个引用的内存地址是否相等
    //   同样的，如果不想比较内存地址，只想比较内容，可以重写equaks()方法，比如String class中，重写了equals()方法来比较字符的内容
    //   如果只用默认的equals()来比较内存地址，两个object字符内容相等，但是可能内存地址不一样，因为：
    //     1、在String pool存储的String object，每一个object都是unique的，本质上是相同的object被不同的引用
    //     2、通过new String(“。。。”)创建的String object储存在heap中，两个相同内容的object的内存地址并不一样
    //   所以，两个String object的字符内容一样时，内存地址可能不同，但是两个object内存地址相等是肯定equals()相等
    
    Animal animal2 = new Animal();
    animal2.animalName = "Birds";
    Animal animal3 = new Animal();
    animal3.animalName = "Birds";
    boolean result = animal2.equals(animal3);
    System.out.println(result); // 输出结果是false，因为两个object中的String虽然字符内容相同，但是本质上是存在heap中的两个object，内存地址不相等
    // 如果想比较的是object的内容，则可以在Animal class中重写这个equals()方法，来比较内容。

    }
}
