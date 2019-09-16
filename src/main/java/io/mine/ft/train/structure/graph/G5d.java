package io.mine.ft.train.structure.graph;

import io.mine.ft.train.structure.linked_matrix.Triple;

//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月9日
//7.5.2  以Floyd算法求带权图每对顶点间的最短路径。
 
public class G5d
{
    public static void main(String args[])
    {
        String[] vertices={"A","B","C","D"};
        Triple edges[]={new Triple(0,1,16), new Triple(0,2,57), new Triple(0,3,65), 
                      new Triple(1,2,11), new Triple(1,3,43),
                      new Triple(2,0,39), new Triple(2,3,9), 
                      new Triple(3,0,22)};
        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);
//        System.out.print("带权有向图G5，"+graph.toString());
        graph.shortestPath();                    //调用Floyd算法求带权图每对顶点间的最短路径
    }
}
/*
程序运行结果如下：
带权有向图G5，顶点集合：(A, B, C, D) 
邻接矩阵:  
     0    16    57    65
     ∞     0    11    43
    39     ∞     0     9
    22     ∞     ∞     0
  
带权有向图G5，顶点集合：(A, B, C, D) 
出边表：
0 -> ((0,1,16),(0,2,57),(0,3,65))
1 -> ((1,2,11),(1,3,43))
2 -> ((2,0,39),(2,3,9))
3 -> ((3,0,22))
  
dist 矩阵Matrix（4×4）：
     0    16    57    65
 99999     0    11    43
    39 99999     0     9
    22 99999 99999     0
path 矩阵Matrix（4×4）：
    -1     0     0     0
    -1    -1     1     1
     2    -1    -1     2
     3    -1    -1    -1
路径矩阵：
(A,A) (A,B) (A,C) (A,D) 
(B,A) (B,B) (B,C) (B,D) 
(C,A) (C,B) (C,C) (C,D) 
(D,A) (D,B) (D,C) (D,D) 

以A作为中间顶点，替换路径如下：
(B,C)路径长度11，替换为(B,A),(A,C)路径长度100056？否
(B,D)路径长度43，替换为(B,A),(A,D)路径长度100064？否
(C,B)路径长度99999，替换为(C,A),(A,B)路径长度55？是，d21=55，p21=0
(C,D)路径长度9，替换为(C,A),(A,D)路径长度104？否
(D,B)路径长度99999，替换为(D,A),(A,B)路径长度38？是，d31=38，p31=0
(D,C)路径长度99999，替换为(D,A),(A,C)路径长度79？是，d32=79，p32=0
dist 矩阵Matrix（4×4）：
     0    16    57    65
 99999     0    11    43
    39    55     0     9
    22    38    79     0
path 矩阵Matrix（4×4）：
    -1     0     0     0
    -1    -1     1     1
     2     0    -1     2
     3     0     0    -1
路径矩阵：
(A,A) (A,B) (A,C) (A,D) 
(B,A) (B,B) (B,C) (B,D) 
(C,A) (C,A,B) (C,C) (C,D) 
(D,A) (D,A,B) (D,A,C) (D,D) 

以B作为中间顶点，替换路径如下：
(A,C)路径长度57，替换为(A,B),(B,C)路径长度27？是，d02=27，p02=1
(A,D)路径长度65，替换为(A,B),(B,D)路径长度59？是，d03=59，p03=1
(C,A)路径长度39，替换为(C,A,B),(B,A)路径长度100054？否
(C,D)路径长度9，替换为(C,A,B),(B,D)路径长度98？否
(D,A)路径长度22，替换为(D,A,B),(B,A)路径长度100037？否
(D,A,C)路径长度79，替换为(D,A,B),(B,C)路径长度49？是，d32=49，p32=1
dist 矩阵Matrix（4×4）：
     0    16    27    59
 99999     0    11    43
    39    55     0     9
    22    38    49     0
path 矩阵Matrix（4×4）：
    -1     0     1     1
    -1    -1     1     1
     2     0    -1     2
     3     0     1    -1
路径矩阵：
(A,A) (A,B) (A,B,C) (A,B,D) 
(B,A) (B,B) (B,C) (B,D) 
(C,A) (C,A,B) (C,C) (C,D) 
(D,A) (D,A,B) (D,A,B,C) (D,D) 

以C作为中间顶点，替换路径如下：
(A,B)路径长度16，替换为(A,B,C),(C,A,B)路径长度82？否
(A,B,D)路径长度59，替换为(A,B,C),(C,D)路径长度36？是，d03=36，p03=2
(B,A)路径长度99999，替换为(B,C),(C,A)路径长度50？是，d10=50，p10=2
(B,D)路径长度43，替换为(B,C),(C,D)路径长度20？是，d13=20，p13=2
(D,A)路径长度22，替换为(D,A,B,C),(C,A)路径长度88？否
(D,A,B)路径长度38，替换为(D,A,B,C),(C,A,B)路径长度104？否
dist 矩阵Matrix（4×4）：
     0    16    27    36
    50     0    11    20
    39    55     0     9
    22    38    49     0
path 矩阵Matrix（4×4）：
    -1     0     1     2
     2    -1     1     2
     2     0    -1     2
     3     0     1    -1
路径矩阵：
(A,A) (A,B) (A,B,C) (A,B,C,D) 
(B,C,A) (B,B) (B,C) (B,C,D) 
(C,A) (C,A,B) (C,C) (C,D) 
(D,A) (D,A,B) (D,A,B,C) (D,D) 

以D作为中间顶点，替换路径如下：
(A,B)路径长度16，替换为(A,B,C,D),(D,A,B)路径长度74？否
(A,B,C)路径长度27，替换为(A,B,C,D),(D,A,B,C)路径长度85？否
(B,C,A)路径长度50，替换为(B,C,D),(D,A)路径长度42？是，d10=42，p10=3
(B,C)路径长度11，替换为(B,C,D),(D,A,B,C)路径长度69？否
(C,A)路径长度39，替换为(C,D),(D,A)路径长度31？是，d20=31，p20=3
(C,D,A,B)路径长度55，替换为(C,D),(D,A,B)路径长度47？是，d21=47，p21=0
dist 矩阵Matrix（4×4）：
     0    16    27    36
    42     0    11    20
    31    47     0     9
    22    38    49     0
path 矩阵Matrix（4×4）：
    -1     0     1     2
     3    -1     1     2
     3     0    -1     2
     3     0     1    -1
路径矩阵：
(A,A) (A,B) (A,B,C) (A,B,C,D) 
(B,C,D,A) (B,B) (B,C) (B,C,D) 
(C,D,A) (C,D,A,B) (C,C) (C,D) 
(D,A) (D,A,B) (D,A,B,C) (D,D) 

每对顶点间的最短路径如下：
(A,B)长度16，(A,B,C)长度27，(A,B,C,D)长度36，
(B,C,D,A)长度42，(B,C)长度11，(B,C,D)长度20，
(C,D,A)长度31，(C,D,A,B)长度47，(C,D)长度9，
(D,A)长度22，(D,A,B)长度38，(D,A,B,C)长度49，

*/

//@author：Yeheya。2014-8-9
