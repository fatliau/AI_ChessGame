package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MiniMaxGameImproved {
	
	public static int nodeEvaluated=0;

	public static void main(String []args){

		final String folder="/Users/JC/Documents/UTD CS/CS6364_Artificial Intelligence/AI_Project1/";
		Scanner input=new Scanner(System.in);

		System.out.println("Please enter the input board, output board, and depth:");
		//board3.txt board4.txt 4
		String userInput=input.nextLine();
		ArrayList<String> commandTokens = new ArrayList<String>(Arrays.asList(userInput.split(" ")));
		String inputfile=commandTokens.get(0);
		System.out.println("input file : "+ inputfile);
		String outputfile=commandTokens.get(1);
		System.out.println("output file: "+ outputfile);
		int depth=Integer.parseInt(commandTokens.get(2));
		System.out.println("depth      : "+ depth);

		ReadWriteTxt theIO=new ReadWriteTxt();
		String inputString=theIO.readFile(folder+inputfile);

		System.out.println("Input board : "+inputString+" with length : "+inputString.length());
		//inputString=inputString.substring(0, 22);
		//System.out.println("Input board : "+inputString+" with length : "+inputString.length());
		//        minimaxDFS("WBBWWBWxxxxxxxxxxxxxxxx", true, 8, 4)
		String output=MiniMaxGameImproved(inputString, true, depth);

		theIO.writeFile(output, folder+outputfile);
		System.out.println("output board: "+theIO.readFile(folder+outputfile));

		input.close();
	}
	
	public static String MiniMaxGameImproved(String testBoard, boolean forMax, int estDepth){
		  //String testBoard="WWWBxBBBxxxxxxWxWBBxxBB";
		  //String testBoard="01234567890123456789012";
			Board theBoard=new Board();
			theBoard.readTheBoard(testBoard);
			Stack theStack=new Stack();
			
			EstNode<Board> theRoot=new EstNode<>(theBoard);
			int temp=(forMax==true)?-10000:10000;
			theRoot.setPoint(temp);
			//theRoot.setOpeningCount(countUpto18);
			theRoot.setDepth(0);
			
			int rootColor=(forMax==true)?1:2;
			theRoot.setMoveColor(rootColor); 
			theStack.add(theRoot);
			
			//int nodeEvaluated=0;//count node number which is evaluated
			
			while(!theStack.isEmpty()){
				EstNode<Board> element=(EstNode<Board>)theStack.pop();
				
				//System.out.println("The data in MidGame is: "+element.getData()+"  The point is: "+element.getPoint());
				Board[] moves= element.getData().moveGenerator_midgame(element.getMoveColor());//1 as generate WHITE moves  //TODO deal with exchange term

				int movesLength=moves.length;
				if(movesLength==0 || element.getDepth()>=estDepth){//no moves are available in this board TODO bigeer and equal 
					if(movesLength==0){
						System.out.println("No moves are available in this board: "+element.getData());
					}
					EstNode<Board> elementUP=new EstNode<Board>(element.getData(), element.getParent(), element.getPoint());
					while(elementUP.getParent()!=null){
						if(elementUP.getParent().getMoveColor()==1){//parent are search for Max
							//propagate MiniMax points
							if(elementUP.getPoint()>=elementUP.getParent().getPoint()){//TODO should consider equal situation 
								elementUP.getParent().setPoint(elementUP.getPoint());
								elementUP.getParent().setChildChoice(elementUP.getData());
							}
						}
						else{//SearchForMin
							if(elementUP.getPoint()<=elementUP.getParent().getPoint()){
								elementUP.getParent().setPoint(elementUP.getPoint());
								elementUP.getParent().setChildChoice(elementUP.getData());
							}
						}
						if(elementUP.getParent().getParent()!=null){
							elementUP= new EstNode<Board>(elementUP.getParent().getData(), elementUP.getParent().getParent(), element.getParent().getPoint());
						}
						else{
							elementUP= new EstNode<Board>(elementUP.getParent().getData());
							elementUP.setPoint(element.getParent().getPoint());
						}
					}
				}
				else{
					EstNode<Board>[] children=new EstNode[movesLength];
					int nextMoveColor=(element.getMoveColor()==1)?2:1;
					for(int i=0; i<movesLength; i++){
						children[i]=new EstNode<Board>(moves[i],element,moves[i].estFunction_improvedGame());
						nodeEvaluated++;
						children[i].setMoveColor(nextMoveColor);
						//children[i].setOpeningCount(element.getOpeningCount()+1);//TODO need examine this add one mechanism
						children[i].setDepth(element.getDepth()+1);
						theStack.add(children[i]);
					}
				}
			}
			
			//TODO rewrite DPS, make est points propagate to the root
			
			//System.out.println("The Target board is: "+tempTarget.getData()+", with points: "+tempTargetPoints);
			System.out.println("The number of node evaluated: "+nodeEvaluated);
			System.out.println("The estPoints propagated to the root: "+theRoot.getPoint());
			System.out.println("The choice should make in the root is: "+theRoot.getChildChoice());
			
			return theRoot.getChildChoice().toString();
		}
	
}
