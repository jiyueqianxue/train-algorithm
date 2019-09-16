package io.mine.ft.train.structure.linked_matrix;

import io.mine.ft.train.structure.polynomial.Addible;

//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月30日
//§5.2.2 稀疏矩阵的压缩存储
//1.  表示稀疏矩阵非零元素的三元组

//§7.2.1   图的邻接矩阵表示和实现

//稀疏矩阵非零元素三元组类，图带权值的边类
public class Triple implements Comparable<Triple>, Addible<Triple> {

    public int row;                                //行号、列号、元素值，默认访问权限
                                                       //行号（边的起点序号），列号（终点序号）、元素值（权值），7.2.2节
	public int column;
	public int value;
    
    //构造方法，参数指定行号、列号、元素值。若行号、列号为负，则抛出无效参数异常
    public Triple(int row, int column, int value)
    {
        if (row>=0 && column>=0)
        {
            this.row = row;
            this.column = column;
            this.value = value;
        }
        else throw new IllegalArgumentException("行、列号不能为负数：row="+row+"，column="+column);
    }
    public Triple(Triple tri)                             //拷贝构造方法，复制一个三元组
    {
        this(tri.row, tri.column, tri.value);
    }

    public String toString()                               //返回三元组描述字符串
    {
        return "("+row+","+column+","+value+")";
    }

    //7.2.2节图删除顶点用//习题5，转置矩阵用
    public Triple toSymmetry()                            //返回矩阵对称位置元素的三元组。
    {
        return new Triple(this.column, this.row, this.value);
    }
    
    public boolean equals(Object obj)                      //比较两个三元组是否相等，比较位置和元素值
    {
        if (this==obj)
            return true;
        if (!(obj instanceof Triple))
            return false;
        Triple tri = (Triple)obj;
        return this.row==tri.row && this.column==tri.column && this.value==tri.value;
    }

    //根据行、列位置比较三元组对象大小，与元素值无关，约定三元组排序次序
    public int compareTo(Triple tri)
    {
        if (this.row==tri.row && this.column==tri.column)
            return 0;                                      //相等，与equals()方法含义不同
        return (this.row<tri.row || this.row==tri.row && this.column<tri.column)?-1:1;
    }
    
    public void add(Triple term)                           //加法（＋=运算），实现Addible<T>接口
    {
        if (this.compareTo(term)==0)
            this.value += term.value;
        else
            throw new IllegalArgumentException("两项的指数不同，不能相加。");
    }
    public boolean removable()                             //约定删除元素条件，实现Addible<T>接口
    {
        return this.value==0;                              //不存储值为0的元素
    }
}
//以上5.2.2节
//@author：Yeheya。2015-10-11

/*没有用到
    public Triple plus(Triple term)                 //加法，重载运算符＋
    {
    	Triple tmp = new Triple(this);             //拷贝构造方法
        tmp.add(term);
    	return tmp;
    } * 
 * 没有
    public Triple()
    {
        this(10,10,0);
    }
 */