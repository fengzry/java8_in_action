package com.pandora;

import com.java8.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

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
/*        Apple a1=new Apple();
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

        System.out.println(list.size());*/
        try {
            readText1(Abcd.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static List<Apple> filterApples(List<Apple> inventory,
                                           Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }


        return result;

    }

    private static void read() throws FileNotFoundException, IOException {
        File file = new File("E:\\delegated-apnic-latest");// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";// 用来保存每次读取一行的内容
        String str1 = "";
        while ((line = bufferedReader.readLine()) != null) {
            if (line.trim().startsWith("#")) {
                continue;
            }
            System.out.println(line);
            String[] str = line.split("\\|");
            System.out.println(str.length);
            if (str[1].equals("CN") && str[2].equals("ipv4")) {
                str1 = str1 + str[3] + " " + str[4] + ",";
            }
        }
        bufferedReader.close();// 关闭输入流

        str1 = str1.substring(0, str1.length() - 1);
        File file1 = new File("E:\\a.txt");// 指定要写入的文件
        if (!file1.exists()) {// 如果文件不存在则创建
            file1.createNewFile();
        }
        String[] result = str1.split(",");
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        // 写入信息
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流

    }

    private static void readText() throws FileNotFoundException, IOException {
        File file = new File("E:\\delegated-apnic-latest");// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";// 用来保存每次读取一行的内容
        String str1 = "";
        while ((line = bufferedReader.readLine()) != null) {
            if (line.trim().startsWith("#")) {
                continue;
            }
            System.out.println(line);
            String[] str = line.split("\\|");
            System.out.println(str.length);
            if (str[1].equals("CN") && str[2].equals("ipv4")) {
                str1 = str1 + str[3] + ":" + str[4] + ",";
            }
        }
        bufferedReader.close();// 关闭输入流

        str1 = str1.substring(0, str1.length() - 1);
/*        File file1 = new File("E:\\a.txt");// 指定要写入的文件
        if (!file1.exists()) {// 如果文件不存在则创建
            file1.createNewFile();
        }*/
        List<IpUser> list = new ArrayList<>();
        String[] result = str1.split(",");
        for (int i = 0; i < result.length; i++) {
            String[] str = result[i].split(":");
            IpUser user = new IpUser();
            user.setIp(str[0]);
            user.setLet(str[1]);
            list.add(user);
        }

        System.out.println(list);
        // 获取该文件的缓冲输出流
/*        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        // 写入信息
        for(int i=0;i<result.length;i++){
            bufferedWriter.write(result[i]);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流*/

    }

    private static <T> void readText1(Class<T> classtype) throws FileNotFoundException, IOException {
        File file = new File("E:\\test.txt");// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";// 用来保存每次读取一行的内容
        T t = null;
        List<T> alist = new ArrayList();
        List<Pair> pairList=null;
        // Abc abc=null;
        while ((line = bufferedReader.readLine()) != null) {
            String s = line.trim();
            if (line.trim().startsWith("\uFEFF")) {
                continue;
            }
            if (line.equals("")) {
                continue;
            }
            if (line.trim().startsWith("#")) {
                continue;
            }
            if (line.trim().startsWith("$")) {
                t = createClassInstance(classtype);
                pairList=new ArrayList<>();
                continue;
            }
            if (line.trim().startsWith("&")) {
                t=converT(t,pairList);
                alist.add(t);
                continue;
            }
            System.out.println(line);
            int index = line.indexOf("#");
            String str1 = line.substring(0, index);
            String[] str = str1.split("=");
            //取出一个对象的所有属性名和值
            Pair p=new Pair();
            p.setKey(str[0].trim());
            p.setValue(str[1].trim());
            pairList.add(p);
/*            if (str[0].trim().equals("a")) {
                abc.setA(str[1].trim());
            }
            if (str[0].trim().equals("b")) {
                abc.setB(str[1].trim());
            }
            if (str[0].trim().equals("c")) {
                abc.setC(str[1].trim());
            }*/

            //   System.out.println(str.length);
/*            if(str[1].equals("CN")&&str[2].equals("ipv4")){
                str1=str1+str[3]+" "+str[4]+",";
            }*/
        }
        bufferedReader.close();// 关闭输入流

/*        str1=str1.substring(0,str1.length()-1);
        File file1 = new File("E:\\a.txt");// 指定要写入的文件
        if (!file1.exists()) {// 如果文件不存在则创建
            file1.createNewFile();
        }
        String [] result=str1.split(",");*/
        // 获取该文件的缓冲输出流
/*        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        // 写入信息
        for(int i=0;i<result.length;i++){
            bufferedWriter.write(result[i]);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流*/
        System.out.println(alist);

    }

    private static <T> T converT(T t, List<Pair> pairList) {
            //获得此对象的所有属性
        Map<String,Object> filedMap=getFiledMap(t);
        //将值放入属性中
      for(Pair p:pairList){
          Field field=(Field) filedMap.get(p.getKey());
          if(field!=null){
             field.setAccessible(true);
              try {
                  field.set(t,p.getValue());
              } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
              }
          }
      }
      return t;
    }

    private static <T> Map<String,Object> getFiledMap(T t) {
        Field[] files=t.getClass().getDeclaredFields();
        Map<String,Object> map=new HashMap<>();
        for(Field f:files){
            map.put(f.getName().toLowerCase(),f);
        }
        return map;
    }

    private static <T> T createClassInstance(Class<T> classtype) {
        try {
            return classtype.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }




}
