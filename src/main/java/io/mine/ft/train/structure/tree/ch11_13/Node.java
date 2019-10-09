package io.mine.ft.train.structure.tree.ch11_13;
/*
 * 二叉树节点
 */
public class Node<T> {
	//数据项
	public long data;
	//数据项
	public T objData;
	//左子节点
	public Node<T> leftChild;
	//右子节点
	public Node<T> rightChild;
	
	/**
	 * 构造方法
	 * @param data
	 */
	public Node(long data, T objData) {
		this.data = data;
		this.objData = objData;
	}
	
}
