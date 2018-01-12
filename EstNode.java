package project;

import java.util.ArrayList;
import java.util.List;

public class EstNode<T> {
	private List<EstNode<T>> children = new ArrayList<EstNode<T>>();
	private EstNode<T> parent = null;
	private T data = null;
	private int estPoint;
	private int colorToMove;//1 as WHITE, 2 as BLACK
	private int openingCount;
	private int depth;
	private T childChoice = null;
	
	public EstNode(T data){
		this.data = data;
	}
	public EstNode(T data, EstNode<T> parent){
		this.data = data;
		this.parent = parent;
		parent.children.add(this);
	}
	public EstNode(T data, EstNode<T> parent, int point){
		this.data = data;
		this.parent = parent;
		parent.children.add(this);
		this.estPoint=point;
	}
	public EstNode(T data, EstNode<T> parent, int color, int count, int depth){
		this.data = data;
		this.parent = parent;
		parent.children.add(this);
		this.colorToMove=color;
		this.openingCount=count;
		this.depth=depth;
	}
	public void setParent(EstNode<T> parent){
		parent.children.add(this);
		this.parent = parent;
	}
	public EstNode<T> getParent(){
		return this.parent;
	}
	public void addChild(T data){
		EstNode<T> child = new EstNode<T>(data);
		child.setParent(this);
		this.children.add(child);
	}
	public void addChild(EstNode<T> child){
		child.setParent(this);
		this.children.add(child);
	}
	public List<EstNode<T>> getChildren(){
		return this.children;
	}
	public T getData(){
		return this.data;
	}
	public void setPoint(int point){
		this.estPoint=point;
	}
	public int getPoint(){
		return this.estPoint;
	}
	public boolean isRoot(){
		return (this.parent == null);
	}
	public boolean isLeaf(){
		if(this.children.size() == 0)
			return true;
		else
			return false;
	}
	public void removeParent(){
		this.parent = null;
	}
	public void setMoveColor(int color){
		this.colorToMove=color;
	}
	public int getMoveColor(){
		return this.colorToMove;
	}
	public void setOpeningCount(int count){
		this.openingCount=count;
	}
	public int getOpeningCount(){
		return this.openingCount;
	}
	public void setDepth(int depth){
		this.depth=depth;
	}
	public int getDepth(){
		return this.depth;
	}
	public void setChildChoice(T choice){
		this.childChoice=choice;
	}
	public T getChildChoice(){
		return this.childChoice;
	}
	
	
	
	public static void main(String []args){
		
		EstNode<String> parentNode = new EstNode<String>("Parent");
		EstNode<String> childNode1 = new EstNode<String>("child 1",parentNode);
		
		EstNode<String> childNode2 = new EstNode<String>("child 2");
		
		childNode2.setParent(parentNode);
		
		//Node<String> grandchildNode = new Node<String>("GrandChild of parentNode. Child of childNode", childNode1);
		List<EstNode<String>> childrenNodes = parentNode.getChildren();
		
		System.out.println(parentNode.getData());
		System.out.println(childNode1.getData());
		
		System.out.println(childrenNodes.size());
		
		for(int i=0; i<childrenNodes.size(); i++){
			System.out.print(childrenNodes.get(i).getData()+", ");
		}

	}
	
}
