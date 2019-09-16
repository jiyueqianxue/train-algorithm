package io.mine.ft.train.structure.tree.two_fork;
//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.3  排序顺序表
//3. 多态原则，子类覆盖父类成员方法
//【例2.3】  顺序表与排序顺序表的插入操作。

import io.mine.ft.train.structure.linear.sequence.SeqList;

public class SortedSeqList_Integer 
{
    public static void main(String args[])
    {
        //3. 多态原则，子类覆盖父类成员方法
        //（1） 排序顺序表的插入操作
        //（2） 编译时多态
//        Integer values[]=MyArray.randomInteger(5, 100);     //见例1.4
        Integer[] values={70,20,80,30,60};                 //Java自动将int包装成Integer实例
        SeqList<Integer> list1=new SeqList<Integer>(values);//顺序表
        SortedSeqList<Integer> slist1=new SortedSeqList<Integer>(list1);  //子类对象引用子类实例，由顺序表构造排序顺序表
                                                           //slist1、list1的元素类型赋值相容
        list1.insert(0,10);                                //调用insert(i,x)，顺序表插入
        list1.insert(50);                                  //父类对象调用父类方法，顺序表尾插入，将int包装成Integer实例
        slist1.insert(50);                                 //子类对象调用子类方法，排序顺序表按值插入，覆盖
        System.out.println("list1="+list1.toString());
        System.out.println("slist1="+slist1.toString());   //子类继承toString()
//        slist1.insert(0,90);                             //排序顺序表插入，抛出异常
        
        //（3） 排序顺序表的查找和删除操作
        Integer key = 55;                        //自动将int包装成Integer实例
        int find = slist1.search(key);           //运行时多态，执行子类覆盖的方法
        System.out.println("slist1顺序查找 "+key+"， "+((find==-1)?"不":"")+"成功");
        
        list1.remove(1);                         //调用remove(int i)
        key = 1;                                 //自动将int包装成Integer实例
        list1.remove(key);                      //调用remove(T key)
        System.out.println("list1 删除第"+1+"个元素，删除元素"+key+"，list1="+list1.toString());
        slist1.remove(1);                         //调用remove(int i)，继承
        slist1.remove(key);                      //调用remove(T key)，继承，其中调用子类覆盖的search(key)，运行时多态
        System.out.println("slist1 删除第"+1+"个元素，删除元素"+key+"，slist1="+slist1.toString());
        
        
        //5. 类型的多态，子类对象即是父类对象
        //（1） 子类对象即是父类对象，赋值相容
        SeqList<Integer> list2 = new SeqList<Integer>(slist1); //顺序表深拷贝，由排序顺序表构造顺序表
        System.out.println("list2="+list2.toString());
        SortedSeqList<Integer> slist2 = new SortedSeqList<Integer>(slist1); //排序顺序表深拷贝
        System.out.println("slist2="+slist2.toString());

        //equals()，继承，父与子均可比
        System.out.println("list1.equals(slist1)？ "+list1.equals(slist1));  //父类equals(子)
        System.out.println("slist1.equals(list1)？ "+slist1.equals(list1));  //子类equals(父)
        System.out.println("slist1.equals(slist2)？ "+slist1.equals(slist2));//子类equals(子)
    }
}
/*
程序设计运行结果如下。
list1=(10, 70, 20, 80, 30, 60, 50) 
slist1=(20, 30, 50, 60, 70, 80) 
20？30？50？slist1顺序查找 55， 不成功
list1 删除第1个元素，删除元素1，list1=(10, 20, 80, 30, 60, 50) 
slist1 删除第1个元素，删除元素1，slist1=(20, 50, 60, 70, 80) 
list2=(20, 50, 60, 70, 80) 
slist2=(20, 50, 60, 70, 80) 
list1.equals(slist1)？ false
slist1.equals(list1)？ false
slist1.equals(slist2)？ true
*/
//@author：Yeheya。2015-1-30
