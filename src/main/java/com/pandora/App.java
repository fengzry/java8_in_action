package com.pandora;

import com.java8.Apple;
import com.java8.Predicate;
import com.java8.User;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

/*Integer I=new Integer(12);
String str=new String("123");
        Map<Integer,String> map=new HashMap<Integer, String>(10);

        Float f=0.75f;

User user=new User(123);
        System.out.println(user);
        System.out.println(f);
       // System.out.println(str);*/

/*        File[] hiddenFiles = new File("E:\\个人文档\\记录").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        for (File file:hiddenFiles) {
            System.out.println(file.getName());
        }
        System.out.println(hiddenFiles);

        File[] hiddenFiles1 = new File("E:\\个人文档\\记录").listFiles(File::isHidden);
        for (File file:hiddenFiles1) {
            System.out.println(file.getName());
        }*/
        Apple a1=new Apple();
        a1.setColor("red");
        a1.setWeight(150);
        Apple a2=new Apple();
        a2.setColor("green");
        a2.setWeight(200);
        Apple a3=new Apple();
        a3.setColor("green");
        a3.setWeight(200);
        Apple a4=new Apple();
        a4.setColor("red");
        a4.setWeight(200);
        Apple a5=new Apple();
        a5.setColor("green");
        a5.setWeight(80);

        List<Apple> inventory=new ArrayList<>();
        inventory.add(a1);
        inventory.add(a2);
        inventory.add(a3);
        inventory.add(a4);
        inventory.add(a5);


       List<Apple>  list=filterApples(inventory,(Apple a) -> { return  "green".equals(a.getColor());});

        System.out.println(list.size());



    }

    public static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }


        return result;

    }
}
