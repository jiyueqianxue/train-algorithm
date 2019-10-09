package io.mine.ft.train.structure.tree.ch11_13;

public class TestTree {
	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>();
		tree.insert(10,"James");
		tree.insert(20,"YAO");
		tree.insert(15,"Kobi");
		tree.insert(3,"Mac");
		
//		System.out.println(tree.root.data);
//		System.out.println(tree.root.rightChild.data);
//		System.out.println(tree.root.rightChild.leftChild.data);
//		System.out.println(tree.root.leftChild.data);
		
//		Node<String> node = tree.find(3);
//		System.out.println(node.data + ", " + node.objData);
		
//		tree.afterOrder(tree.root);
		tree.delete(90);
		tree.inOrder(tree.root);
	}
}
