package project;

public class Node {


	private int color;// 0 as empty, 1 as White, 2 as Black	
	Node(){
		color=0;
	}
	Node(int theColor){
		color=theColor;
	}
	public void setColor(int newColor){
		this.color=newColor;
	}
	public int getColor(){
		return this.color;
	}

}
