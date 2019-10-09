package io.mine.ft.train.maintest.linear.single;

import io.mine.ft.train.structure.linear.single.Node;
import io.mine.ft.train.structure.linear.single.SinglyList;

public class SinglyListTest {
	public static void main(String[] args) {
		SinglyList<Integer> list = new SinglyList<Integer>();
		list.insert(3, 2);
		list.insert(10);
		Node<Integer> firstNode = list.first();
		Node<Integer> lastNode = list.last();
		System.out.println(firstNode);
		System.out.println(lastNode);
	}
}
