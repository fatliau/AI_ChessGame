package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ABOpening {
	
	public static int nodeEvaluated=0;
	
	public static void main(String []args){

	final String folder="/Users/JC/Documents/UTD CS/CS6364_Artificial Intelligence/AI_Project1/";
	Scanner input=new Scanner(System.in);

	System.out.println("Please enter the input board, output board, and depth:");
	//board1.txt board2.txt 4
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
	String output=ABOpening(inputString, true, depth);
	
	System.out.println("The number of node evaluated: "+nodeEvaluated);
	theIO.writeFile(output, folder+outputfile);
	System.out.println("output board: "+theIO.readFile(folder+outputfile));

	input.close();
	}
	
	public static String ABOpening(String testBoard, boolean forMax, int estDepth){
		  //String testBoard="WWWBxBBBxxxxxxWxWBBxxBB";
		  //String testBoard="01234567890123456789012";
			Board theBoard=new Board();
			theBoard.readTheBoard(testBoard);
			
			EstNode<Board> theRoot=new EstNode<>(theBoard);
			int temp=(forMax==true)?-1000:1000;
			theRoot.setPoint(temp);
			//theRoot.setOpeningCount(countUpto18);
			theRoot.setDepth(0);
			
			int rootColor=(forMax==true)?1:2;
			theRoot.setMoveColor(rootColor); 
			EstNode<Board> theResultMove=new EstNode(theRoot);
			if(rootColor==1)
				theResultMove=MaxMin(theRoot, -100000, 100000, estDepth);//TODO Remove depth
			else
				theResultMove=MinMax(theRoot, -100000, 100000, estDepth);//TODO Remove depth
				
			//System.out.println("The Target board is: "+tempTarget.getData()+", with points: "+tempTargetPoints);
			//TODO//System.out.println("The number of node evaluated: "+nodeEvaluated);
			System.out.println("The estPoints propagated to the root: "+theResultMove.getPoint());
			System.out.println("The choice should make in the root is: "+theResultMove.getChildChoice());
			
			if(theResultMove.getChildChoice()==null){
				System.out.println("The choice is null, input information:");
				System.out.println("testBoard "+testBoard+", forMax "+forMax+", estDepth "+ estDepth);
			}
			return theResultMove.getChildChoice().toString();
		}

	public static EstNode<Board> MaxMin(EstNode<Board> x,int A, int B, int depthLimit ){
		//get info from x
		//int countUpto18=x.getOpeningCount();
		int estDepth=x.getDepth();
		int estDepthLimit=depthLimit;
		
		int alpha=A;
		int beta=B;
		EstNode<Board> result=new EstNode<>(x.getData()); 
		//opening game
		Board[] moves= result.getData().moveGenerator(1);//Max means color is white
		int movesLength=moves.length;
		if(movesLength==0 || estDepth>=estDepthLimit){//no moves are available in this board TODO bigeer and equal 
			result.setPoint(result.getData().estFunction_Opening());
			nodeEvaluated++;
			if(movesLength==0){
				System.out.println("No moves are available in this board: "+result);
				//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
				return result;
			}
			else{
				//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
				return result;
			}
		}
		else{
			int v=-100000;
			for(int i=0;i<movesLength;i++){
				EstNode<Board> child=new EstNode<>(moves[i], result, 2, 0, estDepth+1);//TODO use new creater()
				int childPoint=MinMax(child,alpha,beta,estDepthLimit).getPoint();
				if(childPoint > v){//v=(v>=childPoint)?v:childPoint;
					v=childPoint;
					result.setChildChoice(moves[i]);
				}else{}
				if(v>=beta){
					result.setPoint(v);
					result.setChildChoice(moves[i]);
					//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
					return result;
				}
				else{
					alpha=(alpha>=v)?alpha:v;
				}
			}
			result.setPoint(v);
			//x.setChildChoice(moves[i]);  //how to set child choice????
			//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
			return result;
		}

		
	}
	public static EstNode<Board> MinMax(EstNode<Board> x,int A, int B, int depthLimit ){
		//get info from x
		//int countUpto18=x.getOpeningCount();
		int estDepth=x.getDepth();
		int estDepthLimit=depthLimit;

		int alpha=A;
		int beta=B;
		EstNode<Board> result=new EstNode<>(x.getData()); 
		//opening game
		Board[] moves= result.getData().moveGenerator(2);//Max means color is white
		int movesLength=moves.length;
		if(movesLength==0 || estDepth>=estDepthLimit){//no moves are available in this board TODO bigeer and equal 
			result.setPoint(result.getData().estFunction_Opening());
			nodeEvaluated++;
			if(movesLength==0){
				System.out.println("No moves are available in this board: "+result);
				//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
				return result;
			}
			else{
				//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
				return result;
			}
		}
		else{
			int v=100000;
			for(int i=0;i<movesLength;i++){
				EstNode<Board> child=new EstNode<>(moves[i], result, 1, 0, estDepth+1);//TODO use new creater()
				int childPoint=MaxMin(child,alpha,beta,estDepthLimit).getPoint();
				if(childPoint < v){//v=(v<=childPoint)?v:childPoint;
					v=childPoint;
					result.setChildChoice(moves[i]);
				}else{}
				if(v<=alpha){
					result.setPoint(v);
					result.setChildChoice(moves[i]);
					//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
					return result;
				}
				else{
					beta=(beta<=v)?beta:v;
				}
			}
			result.setPoint(v);
			//x.setChildChoice(moves[i]);  //how to set child choice????
			//System.out.println("The data in Opening is: "+result.getData()+"  The point is: "+result.getPoint()+"  The child choice is "+result.getChildChoice());
			return result;
		}


	}
	
	
	
	
	
}
