package io.mine.ft.train.maintest.linear.double_t;

import io.mine.ft.train.structure.linear.double_t.CirDoublyList;

public class CirDoublyListTest {

	public static void main(String[] args) {
		CirDoublyList<Integer> cirDoublyList = new CirDoublyList<Integer>();
		
		cirDoublyList.insert(100);
		cirDoublyList.insert(200);
		cirDoublyList.insert(300);
		
		System.out.println(cirDoublyList);
		
//		cirDoublyList.insert(2, 250);
//		Integer a1 = cirDoublyList.get(0);
//		DoubleNode<Integer> first = cirDoublyList.first();
//		System.out.println(a1);
	}
}
