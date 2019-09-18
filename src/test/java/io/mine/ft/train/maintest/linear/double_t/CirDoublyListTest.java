package io.mine.ft.train.maintest.linear.double_t;

import io.mine.ft.train.structure.linear.double_t.CirDoublyList;

public class CirDoublyListTest {

	public static void main(String[] args) {
		CirDoublyList<Integer> cirDoublyList = new CirDoublyList<Integer>();
		
		cirDoublyList.insert(100);
		cirDoublyList.insert(200);
		System.out.println(cirDoublyList);
		
		//cirDoublyList.insertDifferent(x);
		//JsonUtil.toJson(cirDoublyList);
	}
}
