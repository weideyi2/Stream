package test;


import utils.SysTools;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/3/25.
 */
public class Main {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("保护环境");     //向列表中添加数据
//        list.add("爱护地球");     //向列表中添加数据
//        list.add("从我做起");        //向列表中添加数据
//        list.add(1, "从我做起");
//        list.add("");
//
//        long count = list.stream().filter(item -> item != "").count();
////        list.stream().collect(Collectors.counting());
//
//        System.out.println(count);
//
//        List<String> list_add = new ArrayList<>();
//        list_add.add("公益广告");
//
//        boolean result = list_add.addAll(list);
//        System.out.println("添加是否成功：" + result);
//
//        for (int i = 0; i < list_add.size(); i++) {
//            System.out.println("第" + i + "个元素：" + list_add.get(i));
//        }
//
//
////        List<Integer> nums = new ArrayList<Integer>(1,1,null,2,3,4,null,5,6,7,8,9,10);
//
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(1);
//        nums.add(null);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//        nums.add(null);
//        nums.add(5);
//        nums.add(6);
//        nums.add(7);
//        nums.add(8);
//        nums.add(9);
//        nums.add(10);
//
//
//        int result1 = nums.stream()
//                .filter(item -> item != null)//过滤值为null的item
//                .distinct()//去重操作，此种情况之下，是去掉一个 1
//                .mapToInt(item -> item * 2)//每个元素乘以 2
//                .peek(System.out::println)//每个元素被消费的时候打印自身
//                .skip(2)//跳过前两个元素
//                .limit(4)//去掉前四个元素
//                .sum();//进行和运算
//
//        System.out.println(result1);


        List<String> list1 = new ArrayList<>();
        list1.add("c");
        list1.add("d");
        list1.add("g");
        list1.add("f");

        System.out.println("############################# 流的stream.map的用法 #########################################");

        List<String> collect = list1.stream().map(item -> item.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);

        //遍历方式一
        List<String> collect1 = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect1);

        //遍历方式二
        List<String> collect2 = new ArrayList<>();
        collect2.addAll(list1.stream().map(item -> item.toUpperCase()).collect(Collectors.toList()));
        System.out.println(collect2);

        //遍历方式三
        List<String> collect3 = new ArrayList<>();
        list1.forEach(item -> {
            collect3.add(item.toUpperCase());
        });
        System.out.println(collect3);


        System.out.println("############################# 流的filter的用法 #########################################");

        //filter的用法（过滤操作）
        List<String> list2 = new ArrayList<>();
        list2.add("");
        list2.add("c");
        list2.add("d");

        List<String> s1 = list2.stream().filter(item -> item != "").collect(Collectors.toList());
        SysTools.PrintTool(s1);


        SysTools.PrintTool("############################返回特定的结果集合###########################################");
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        list3.add("d");
        list3.add("g");
        list3.add("f");

        SysTools.PrintTool(list3);

        List<String> collect4 = list3.stream().limit(2).collect(Collectors.toList());
        List<String> collect5 = list3.stream().skip(2).collect(Collectors.toList());

        SysTools.PrintTool("limit 返回 Stream 的前面 n 个元素:" + collect4);
        SysTools.PrintTool("skip 则是扔掉前 n 个元素:" + collect5);

        SysTools.PrintTool("############################ 排序（sort/min/max/distinct） ###########################################");

        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(0);
        nums.add(3);
        nums.add(3);

        //排序
        List<Integer> collect6 = nums.stream().sorted().collect(Collectors.toList());
        SysTools.PrintTool("sort排序：" + collect6);

        //去重 ：distinct()方法能找出stream中元素equal()，即相同的元素，并将相同的去除
        List<Integer> collect7 = nums.stream().distinct().collect(Collectors.toList());
        SysTools.PrintTool("distinct去重：" + collect7);
        SysTools.PrintTool("去重后排序：" + nums.stream().distinct().sorted().collect(Collectors.toList()));

        int asInt = list3.stream().mapToInt(item -> item.length()).max().getAsInt();
        SysTools.PrintTool("字符串的最大长度：" + asInt);

        Integer maxInt = nums.stream().max(Integer::compareTo).get();
        SysTools.PrintTool("最大数：" + maxInt);

        Integer minInt = nums.stream().min(Integer::compareTo).get();
        SysTools.PrintTool("最小数：" + minInt);

        SysTools.PrintTool("############################ 匹配(Match方法) ###########################################");


        /**
         *
         allMatch：Stream 中全部元素符合传入的 predicate，返回 true
         anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
         noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
         */
        List<String> matchList = new ArrayList<>();
        matchList.add("a");
        matchList.add("a");
        matchList.add("c");
        matchList.add("d");
        matchList.add("");

        boolean b = matchList.stream().anyMatch(item -> item.equals("c"));
        SysTools.PrintTool("是否有c字母：" + b);

        boolean b1 = matchList.stream().noneMatch(item -> item.isEmpty());
        SysTools.PrintTool("是否全不为空：" + b1);


        List<String> list = new ArrayList<>();

    }
}