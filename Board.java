package project;

public class Board {

	Node[] Nodes;	
	Board(){
		Nodes=new Node[23];
		for (int i=0;i<23;i++)
			Nodes[i]=new Node();
	}
	public boolean ThreeSameColor(int Node1,int Node2,int Node3){
		boolean result=(Nodes[Node1].getColor()==Nodes[Node2].getColor() && Nodes[Node1].getColor()==Nodes[Node3].getColor())?true:false;
		return result;
	}
	public int colorCount(int theColor){
		int colorCounts=0;
		for(int i=0; i<23; i++){
			if(Nodes[i].getColor()==theColor)
				colorCounts++;
		}
		return colorCounts;
	}
	public int[] colorList(int theColor, int colorCounts){
		int[] theList=new int[colorCounts];
		int index=0;
		for(int i=0; i<23; i++){
			if(Nodes[i].getColor()==theColor){
				theList[index]=i;
				index++;// CHECK index < colorCounts
			}
		}
		return theList;
	}
	public void readTheBoard(String theBoard){
		//CHECK theBoard is length 23
		if(theBoard.length()!=23){
			System.out.print("WARNING: Input String is not lenght 23");
		}
		for(int i=0; i<23; i++){
			char colorChar=theBoard.charAt(i);
			switch(colorChar){
			case('x'):
				Nodes[i].setColor(0);
				break;
			case('W'):
				Nodes[i].setColor(1);
				break;
			case('B'):
				Nodes[i].setColor(2);
				break;
			}
		}
	}
	/*
	public String printTheBoard(){
		String theBoardString="";
		for(int i=0;i<23;i++){
			switch(Nodes[i].getColor()){
			case 0:
				theBoardString+="x";
				break;
			case 1:
				theBoardString+="W";
				break;
			case 2:
				theBoardString+="B";
				break;
			}
		}
		return theBoardString;
	}*/

	public boolean adjacent(int node1, int node2){
		boolean result=false;
		switch(node1){
			case 0:
				result=(node2==1 || node2==3 || node2==8)?true:false;
				break;
			case 1:
				result=(node2==0 || node2==2 || node2==4)?true:false;
				break;
			case 2:
				result=(node2==1 || node2==5 || node2==13)?true:false;
				break;
			case 3:
				result=(node2==0 || node2==4 || node2==6 || node2==9)?true:false;
				break;
			case 4:
				result=(node2==1 || node2==3 || node2==5)?true:false;
				break;
			case 5:
				result=(node2==2 || node2==4 || node2==7 || node2==12)?true:false;
				break;
			case 6:
				result=(node2==3 || node2==7 || node2==10)?true:false;
				break;
			case 7:
				result=(node2==5 || node2==6 || node2==11)?true:false;
				break;
			case 8:
				result=(node2==0 || node2==9 || node2==20)?true:false;
				break;
			case 9:
				result=(node2==3 || node2==8 || node2==10 || node2==17)?true:false;
				break;
			case 10:
				result=(node2==6 || node2==9 || node2==14)?true:false;
				break;
			case 11:
				result=(node2==7 || node2==12 || node2==16)?true:false;
				break;
			case 12:
				result=(node2==5 || node2==11 || node2==13 || node2==19)?true:false;
				break;
			case 13:
				result=(node2==2 || node2==12 || node2==22)?true:false;
				break;
			case 14:
				result=(node2==10 || node2==15 || node2==17)?true:false;
				break;
			case 15:
				result=(node2==14 || node2==16 || node2==18)?true:false;
				break;
			case 16:
				result=(node2==11 || node2==15 || node2==19)?true:false;
				break;
			case 17:
				result=(node2==9 || node2==14 || node2==18 || node2==20)?true:false;
				break;
			case 18:
				result=(node2==15 || node2==17 || node2==19 || node2==21)?true:false;
				break;
			case 19:
				result=(node2==12 || node2==16 || node2==18 || node2==22)?true:false;
				break;
			case 20:
				result=(node2==8 || node2==17 || node2==21)?true:false;
				break;
			case 21:
				result=(node2==18 || node2==20 || node2==22)?true:false;
				break;
			case 22:
				result=(node2==13 || node2==19 || node2==21)?true:false;
				break;
		}
		return result;
	}
	public boolean inMill(int node){
		boolean result=false;
		switch(node){
		case 0:
			result=(ThreeSameColor(0,1,2) ||
					ThreeSameColor(0,3,6) ||
					ThreeSameColor(0,8,20)
					)?true:false;
			break;
		case 1:
			result=(ThreeSameColor(0,1,2))?true:false;
			break;
		case 2:
			result=(ThreeSameColor(0,1,2) ||
					ThreeSameColor(2,5,7) ||
					ThreeSameColor(2,13,22)
					)?true:false;
			break;
		case 3:
			result=(ThreeSameColor(0,3,6) ||
					ThreeSameColor(3,4,5) ||
					ThreeSameColor(3,9,17)
					)?true:false;
			break;
		case 4:
			result=(ThreeSameColor(3,4,5))?true:false;
			break;
		case 5:
			result=(ThreeSameColor(3,4,5) ||
					ThreeSameColor(2,5,7) ||
					ThreeSameColor(5,12,19)
					)?true:false;
			break;
		case 6:
			result=(ThreeSameColor(0,3,6) ||
					ThreeSameColor(6,10,14)
					)?true:false;
			break;
		case 7:
			result=(ThreeSameColor(2,5,7) ||
					ThreeSameColor(7,11,16)
					)?true:false;
			break;
		case 8:
			result=(ThreeSameColor(8,9,10) ||
					ThreeSameColor(0,8,20) 
					)?true:false;
			break;
		case 9:
			result=(ThreeSameColor(8,9,10) ||
					ThreeSameColor(3,9,17)
					)?true:false;
			break;
		case 10:
			result=(ThreeSameColor(8,9,10) ||
					ThreeSameColor(6,10,14)
					)?true:false;
			break;
		case 11:
			result=(ThreeSameColor(7,11,16) ||
					ThreeSameColor(11,12,13)
					)?true:false;
			break;
		case 12:
			result=(ThreeSameColor(11,12,13) ||
					ThreeSameColor(5,12,19)
					)?true:false;
			break;
		case 13:
			result=(ThreeSameColor(11,12,13) ||
					ThreeSameColor(2,13,22)
					)?true:false;
			break;
		case 14:
			result=(ThreeSameColor(6,10,14) ||
					ThreeSameColor(14,15,16) ||
					ThreeSameColor(14,17,20)
					)?true:false;
			break;
		case 15:
			result=(ThreeSameColor(14,15,16) ||
					ThreeSameColor(15,18,21)
					)?true:false;
			break;
		case 16:
			result=(ThreeSameColor(14,15,16) ||
					ThreeSameColor(7,11,16) ||
					ThreeSameColor(16,19,22)
					)?true:false;
			break;
		case 17:
			result=(ThreeSameColor(14,17,20) ||
					ThreeSameColor(3,9,17) ||
					ThreeSameColor(17,18,19)
					)?true:false;
			break;
		case 18:
			result=(ThreeSameColor(15,18,21) ||
					ThreeSameColor(17,18,19)
					)?true:false;
			break;
		case 19:
			result=(ThreeSameColor(16,19,22) ||
					ThreeSameColor(5,12,19) ||
					ThreeSameColor(17,18,19)
					)?true:false;
			break;
		case 20:
			result=(ThreeSameColor(0,8,20) ||
					ThreeSameColor(14,17,20) ||
					ThreeSameColor(20,21,22)
					)?true:false;
			break;
		case 21:
			result=(ThreeSameColor(15,18,21) ||
					ThreeSameColor(20,21,22)
					)?true:false;
			break;
		case 22:
			result=(ThreeSameColor(2,13,22) ||
					ThreeSameColor(16,19,22) ||
					ThreeSameColor(20,21,22)
					)?true:false;
			break;
		}
		return result;	
	}

	public boolean checkMoveMill(int node, int color){
		boolean result=false;
		Node T= new Node(color);
		switch(node){
		case 0:
			result=(ThreeSameColor(T,this.Nodes[1],this.Nodes[2]) ||
					ThreeSameColor(T,this.Nodes[3],this.Nodes[6]) ||
					ThreeSameColor(T,this.Nodes[8],this.Nodes[20])
					)?true:false;
			break;
		case 1:
			result=(ThreeSameColor(T,this.Nodes[0],this.Nodes[2]))?true:false;
			break;
		case 2:
			result=(ThreeSameColor(T,this.Nodes[0],this.Nodes[1]) ||
					ThreeSameColor(T,this.Nodes[5],this.Nodes[7]) ||
					ThreeSameColor(T,this.Nodes[13],this.Nodes[22])
					)?true:false;
			break;
		case 3:
			result=(ThreeSameColor(T,this.Nodes[0],this.Nodes[6]) ||
					ThreeSameColor(T,this.Nodes[4],this.Nodes[5]) ||
					ThreeSameColor(T,this.Nodes[9],this.Nodes[17])
					)?true:false;
			break;
		case 4:
			result=(ThreeSameColor(T,this.Nodes[3],this.Nodes[5]))?true:false;
			break;
		case 5:
			result=(ThreeSameColor(T,this.Nodes[3],this.Nodes[4]) ||
					ThreeSameColor(T,this.Nodes[2],this.Nodes[7]) ||
					ThreeSameColor(T,this.Nodes[12],this.Nodes[19])
					)?true:false;
			break;
		case 6:
			result=(ThreeSameColor(T,this.Nodes[0],this.Nodes[3]) ||
					ThreeSameColor(T,this.Nodes[10],this.Nodes[14])
					)?true:false;
			break;
		case 7:
			result=(ThreeSameColor(T,this.Nodes[2],this.Nodes[5]) ||
					ThreeSameColor(T,this.Nodes[11],this.Nodes[16])
					)?true:false;
			break;
		case 8:
			result=(ThreeSameColor(T,this.Nodes[9],this.Nodes[10]) ||
					ThreeSameColor(T,this.Nodes[0],this.Nodes[20]) 
					)?true:false;
			break;
		case 9:
			result=(ThreeSameColor(T,this.Nodes[8],this.Nodes[10]) ||
					ThreeSameColor(T,this.Nodes[3],this.Nodes[17])
					)?true:false;
			break;
		case 10:
			result=(ThreeSameColor(T,this.Nodes[8],this.Nodes[9]) ||
					ThreeSameColor(T,this.Nodes[6],this.Nodes[14])
					)?true:false;
			break;
		case 11:
			result=(ThreeSameColor(T,this.Nodes[7],this.Nodes[16]) ||
					ThreeSameColor(T,this.Nodes[12],this.Nodes[13])
					)?true:false;
			break;
		case 12:
			result=(ThreeSameColor(T,this.Nodes[11],this.Nodes[13]) ||
					ThreeSameColor(T,this.Nodes[5],this.Nodes[19])
					)?true:false;
			break;
		case 13:
			result=(ThreeSameColor(T,this.Nodes[11],this.Nodes[12]) ||
					ThreeSameColor(T,this.Nodes[2],this.Nodes[22])
					)?true:false;
			break;
		case 14:
			result=(ThreeSameColor(T,this.Nodes[6],this.Nodes[10]) ||
					ThreeSameColor(T,this.Nodes[15],this.Nodes[16]) ||
					ThreeSameColor(T,this.Nodes[17],this.Nodes[20])
					)?true:false;
			break;
		case 15:
			result=(ThreeSameColor(T,this.Nodes[14],this.Nodes[16]) ||
					ThreeSameColor(T,this.Nodes[18],this.Nodes[21])
					)?true:false;
			break;
		case 16:
			result=(ThreeSameColor(T,this.Nodes[14],this.Nodes[15]) ||
					ThreeSameColor(T,this.Nodes[7],this.Nodes[11]) ||
					ThreeSameColor(T,this.Nodes[19],this.Nodes[22])
					)?true:false;
			break;
		case 17:
			result=(ThreeSameColor(T,this.Nodes[14],this.Nodes[20]) ||
					ThreeSameColor(T,this.Nodes[3],this.Nodes[9]) ||
					ThreeSameColor(T,this.Nodes[18],this.Nodes[19])
					)?true:false;
			break;
		case 18:
			result=(ThreeSameColor(T,this.Nodes[15],this.Nodes[21]) ||
					ThreeSameColor(T,this.Nodes[17],this.Nodes[19]) 
					)?true:false;
			break;
		case 19:
			result=(ThreeSameColor(T,this.Nodes[16],this.Nodes[22]) ||
					ThreeSameColor(T,this.Nodes[5],this.Nodes[12]) ||
					ThreeSameColor(T,this.Nodes[17],this.Nodes[18])
					)?true:false;
			break;
		case 20:
			result=(ThreeSameColor(T,this.Nodes[0],this.Nodes[8]) ||
					ThreeSameColor(T,this.Nodes[14],this.Nodes[17]) ||
					ThreeSameColor(T,this.Nodes[21],this.Nodes[22])
					)?true:false;
			break;
		case 21:
			result=(ThreeSameColor(T,this.Nodes[15],this.Nodes[18]) ||
					ThreeSameColor(T,this.Nodes[20],this.Nodes[22])
					)?true:false;
			break;
		case 22:
			result=(ThreeSameColor(T,this.Nodes[2],this.Nodes[13]) ||
					ThreeSameColor(T,this.Nodes[16],this.Nodes[19]) ||
					ThreeSameColor(T,this.Nodes[20],this.Nodes[21])
					)?true:false;
			break;
		}
		return result;
	}

	public int[] listAllEmptyNode(){
		int[] tempResult= new int[23];
		int temp=0;
		for(int i=0; i<23; i++){
			if(this.Nodes[i].getColor()==0){
				tempResult[temp]=i;
				temp++;
			}
		}
		int[] finalResult=new int[temp];
		for(int i=0; i<temp; i++){
			finalResult[i]=tempResult[i];
		}
		return finalResult;
	}
	public int[] listAllLegalRemove(int removeColor){
		int[] tempResult= new int[23];
		int temp=0;
		for(int i=0; i<23; i++){
			if(this.Nodes[i].getColor()==removeColor){
				if( inMill(i)==false ){
					tempResult[temp]=i;
					temp++;
				}
			}
		}
		int[] finalResult=new int[temp];
		for(int i=0; i<temp; i++){
			finalResult[i]=tempResult[i];
		}
		return finalResult;
	}

	public int estFunction_Opening(){
		int black=this.colorCount(2);
		int white=this.colorCount(1);
		return 1000*(white-black);
	}
	public int estFunction_MidEnd(){
		int black=this.colorCount(2);
		int white=this.colorCount(1);
		int blackMoves= moveGenerator_midgame(2).length;
		if(black<=2)
			return 10000;
		else if(white<=2)
			return -10000;
		else if(blackMoves==0)
			return 10000;
		else
			return (1000*(white-black)-blackMoves);//TODO calculate blackMoves
	}
	
	public int weightedNodeCount(){
		int point=0;
		for(int i=0;i<23;i++){
			switch(i){
				case 0:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 1:
					point=(this.Nodes[i].getColor()==1)?point+4:point-4;
					break;
				case 2:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 3:
					point=(this.Nodes[i].getColor()==1)?point+7:point-7;
					break;
				case 4:
					point=(this.Nodes[i].getColor()==1)?point+4:point-4;
					break;
				case 5:
					point=(this.Nodes[i].getColor()==1)?point+7:point-7;
					break;
				case 6:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 7:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 8:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 9:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 10:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 11:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 12:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 13:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 14:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 15:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 16:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 17:
					point=(this.Nodes[i].getColor()==1)?point+7:point-7;
					break;
				case 18:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 19:
					point=(this.Nodes[i].getColor()==1)?point+7:point-7;
					break;
				case 20:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
				case 21:
					point=(this.Nodes[i].getColor()==1)?point+5:point-5;
					break;
				case 22:
					point=(this.Nodes[i].getColor()==1)?point+6:point-6;
					break;
			}
		}
		return point;
	}
	public int estFunction_imporvedOpening(){
		return this.weightedNodeCount()*100;
	}
	public int estFunction_improvedGame(){
		int black=this.colorCount(2);
		int white=this.colorCount(1);
		int blackMoves= moveGenerator_midgame(2).length;
		if(black<=2)
			return 10000;
		else if(white<=2)
			return -10000;
		else if(blackMoves==0)
			return 10000;
		else
			return (100*(this.weightedNodeCount())-blackMoves);
	}
	
	public boolean ThreeSameColor(Node Node1,Node Node2,Node Node3){
		boolean result=(Node1.getColor()==Node2.getColor() && Node1.getColor()==Node3.getColor())?true:false;
		return result;
	}

	public Board[] moveGenerator(int colorOfMove){//TODO This is for opening, and need 9 piece limit
		int rivalColor=(colorOfMove==1)?2:1;
		Board[] tempBoards= new Board[200];
		for(int i=0;i<200;i++){
			tempBoards[i]=new Board();
			for(int k=0;k<23;k++)
				tempBoards[i].Nodes[k].setColor(this.Nodes[k].getColor());
		}
		int tempCount=0;	
		//System.out.println("the temp " +tempCount+" "+tempBoards[tempCount].printTheBoard());
		for(int i=0; i< 23; i++){
			if(this.Nodes[i].getColor()==0){//Check the node on board is empty
				if(this.checkMoveMill(i, colorOfMove)==true){//Check the node making a mill 
					//System.out.println("the temp " +tempCount+" "+tempBoards[tempCount].printTheBoard()+" "+ this.printTheBoard());
					int[] allLegalRemove= this.listAllLegalRemove(rivalColor);
					//System.out.println("INDICATE Node i "+i+ " with color: "+tempBoards[tempCount].Nodes[i].color);
					for(int j=0; j<allLegalRemove.length; j++){//All legal remove 
						//System.out.println("INDICATE Node j "+j+ " with color: "+tempBoards[tempCount].Nodes[j].color);
						tempBoards[tempCount].Nodes[i].setColor(colorOfMove);//put the move
						tempBoards[tempCount].Nodes[allLegalRemove[j]].setColor(0);//Remove
						tempCount++;
					}
				}
				else{//the node doesn't make a mill
					//System.out.println("the temp " +tempCount+" "+tempBoards[tempCount].printTheBoard()+" "+ this.printTheBoard());
					tempBoards[tempCount].Nodes[i].setColor(colorOfMove);
					tempCount++;
				}	
			}
		}
		Board outputBoard[] = new Board[tempCount];
		for(int i=0; i<tempCount; i++){
			outputBoard[i]=tempBoards[i];
		}
		return outputBoard; 
	}
	/*
	public Board[] moveGenerator_opening(int colorOfMove, int countUpto9){//TODO This is for opening, and need 9 piece limit
		int rivalColor=(colorOfMove==1)?2:1;
		Board[] tempBoards= new Board[200];
		for(int i=0;i<200;i++){
			tempBoards[i]=new Board();
			for(int k=0;k<23;k++)
				tempBoards[i].Nodes[k].setColor(this.Nodes[k].getColor());
		}
		int tempCount=0;	
		//System.out.println("the temp " +tempCount+" "+tempBoards[tempCount].printTheBoard());
		for(int i=0; i< 23; i++){
			if(this.Nodes[i].getColor()==0){//Check the node on board is empty
				if(this.checkMoveMill(i, colorOfMove)==true){//Check the node making a mill 
					//System.out.println("the temp " +tempCount+" "+tempBoards[tempCount].printTheBoard()+" "+ this.printTheBoard());
					int[] allLegalRemove= this.listAllLegalRemove_Opening(rivalColor);
					//System.out.println("INDICATE Node i "+i+ " with color: "+tempBoards[tempCount].Nodes[i].color);
					for(int j=0; j<allLegalRemove.length; j++){//All legal remove 
						//System.out.println("INDICATE Node j "+j+ " with color: "+tempBoards[tempCount].Nodes[j].color);
						tempBoards[tempCount].Nodes[i].setColor(colorOfMove);//put the move
						tempBoards[tempCount].Nodes[allLegalRemove[j]].setColor(0);//Remove
						tempCount++;
					}
				}
				else{//the node doesn't make a mill
					//System.out.println("the temp " +tempCount+" "+tempBoards[tempCount].printTheBoard()+" "+ this.printTheBoard());
					tempBoards[tempCount].Nodes[i].setColor(colorOfMove);
					tempCount++;
				}	
			}
		}
		Board outputBoard[] = new Board[tempCount];
		for(int i=0; i<tempCount; i++){
			outputBoard[i]=tempBoards[i];
		}
		return outputBoard; 
	}
	*/
	public Board[] moveGenerator_midgame(int colorOfMove){//TODO this should calculate less than 3 endgame criteria
		int rivalColor=(colorOfMove==1)?2:1;
		Board[] tempBoards= new Board[200];
		for(int i=0;i<200;i++){
			tempBoards[i]=new Board();
			for(int k=0;k<23;k++)
				tempBoards[i].Nodes[k].setColor(this.Nodes[k].getColor());
		}
		int tempCount=0;	
		//List all possible adjacent move
		
		if(this.colorCount(colorOfMove)>3){//situation MIDgame:
			for(int i=0; i< 23; i++){
				if(this.Nodes[i].getColor()==colorOfMove){//Check the node on board is the color to move			
					for(int j=0;j<23;j++){
						if(this.adjacent(i,j) && this.Nodes[j].getColor()==0){//check every adjacent node is empty
							if(this.checkMoveMill(j, colorOfMove)==true){//Check the node making a mill 
								int[] allLegalRemove= this.listAllLegalRemove(rivalColor);
								for(int k=0; k<allLegalRemove.length; k++){//All legal remove 
									tempBoards[tempCount].Nodes[i].setColor(0);//move form this node to node below
									tempBoards[tempCount].Nodes[j].setColor(colorOfMove);//put the move
									tempBoards[tempCount].Nodes[allLegalRemove[k]].setColor(0);//Remove
									tempCount++;
								}
							}
							else{//the node doesn't make a mill
								tempBoards[tempCount].Nodes[i].setColor(0);//move form this node to node below
								tempBoards[tempCount].Nodes[j].setColor(colorOfMove);//put the move
								tempCount++;
							}	
						}
					}
				}
			}
		}
		else{//situation ENDgame:
			for(int i=0; i< 23; i++){
				if(this.Nodes[i].getColor()==colorOfMove){//Check the node on board is the color to move	
					for(int j=0;j<23;j++){
						if(this.Nodes[j].getColor()==0){//check this node is empty
							if(this.checkMoveMill(j, colorOfMove)==true){//Check the node making a mill 
								int[] allLegalRemove= this.listAllLegalRemove(rivalColor);
								for(int k=0; k<allLegalRemove.length; k++){//All legal remove 
									tempBoards[tempCount].Nodes[i].setColor(0);//move form this node to node below
									tempBoards[tempCount].Nodes[j].setColor(colorOfMove);//put the move
									tempBoards[tempCount].Nodes[allLegalRemove[k]].setColor(0);//Remove
									tempCount++;
								}
							}
							else{//the node doesn't make a mill
								tempBoards[tempCount].Nodes[i].setColor(0);//move form this node to node below
								tempBoards[tempCount].Nodes[j].setColor(colorOfMove);//put the move
								tempCount++;
							}
						}
					}
				}
			}
		}
		Board outputBoard[] = new Board[tempCount];
		for(int i=0; i<tempCount; i++){
			outputBoard[i]=tempBoards[i];
		}
		return outputBoard; 
	}

	public String toString(){
		String result="";
		for(int i=0;i<23;i++){
			switch(this.Nodes[i].getColor()){
			case(0):
				result+="x";break;
			case(1):
				result+="W";break;
			case(2):
				result+="B";break;
			}
		}
		return result;
	}

	public static void main(String[] args){
		
		
		/*
		String testBoard="WWWBBBBBBWWBWxWxWxxWxBB";
		//String testBoard="WxxWxxxxxxxxxxxxxxxxxxx";
	  //String testBoard="01234567890123456789012";
		Board theBoard=new Board();
		theBoard.readTheBoard(testBoard);
		//System.out.println(theBoard.ThreeSameColor(0,3,6));
		System.out.println("the origin: "+theBoard.printTheBoard());

		System.out.println("The board with estFunction points: "+Integer.toString(theBoard.estFunction_Opening()));

		System.out.println("Empty Nodes:");
		int[] emptyNodes=theBoard.listAllEmptyNode();
		for(int i=0; i< emptyNodes.length; i++)
			System.out.print(emptyNodes[i]+" ");
		System.out.println();

		System.out.println("Legal Removes:");
		int[] legalRemoves=theBoard.listAllLegalRemove(1);
		for(int i=0; i< legalRemoves.length; i++)
			System.out.print(legalRemoves[i]+" ");
		System.out.println();

		System.out.println("the origin: "+theBoard.printTheBoard());

		System.out.println("the origin: "+theBoard.printTheBoard());
		Board[] moves= theBoard.moveGenerator_midgame(1);
		System.out.println("the origin: "+theBoard.printTheBoard());
		for(int i=0; i<moves.length; i++){
			System.out.print(moves[i].printTheBoard()+" - "+i);
			System.out.println(" - estPoints: "+ moves[i].estFunction_MidEnd());
			}
       */

		/*//test of opening game
		String testBoard="WWWBxBBBxxxxxxWxWBBxxBB";
	  //String testBoard="01234567890123456789012";
		Board theBoard=new Board();
		theBoard.readTheBoard(testBoard);
		System.out.println("the origin: "+theBoard.printTheBoard());
		
		System.out.println("The board with estFunction points: "+Integer.toString(theBoard.estFunction_Opening()));
		
		System.out.println("Empty Nodes:");
		int[] emptyNodes=theBoard.listAllEmptyNode_Opening();
		for(int i=0; i< emptyNodes.length; i++)
			System.out.print(emptyNodes[i]+" ");
		System.out.println();
		
		System.out.println("Legal Removes:");
		int[] legalRemoves=theBoard.listAllLegalRemove_Opening(1);
		for(int i=0; i< legalRemoves.length; i++)
			System.out.print(legalRemoves[i]+" ");
		System.out.println();
		
		System.out.println("the origin: "+theBoard.printTheBoard());
		
		System.out.println("the origin: "+theBoard.printTheBoard());
		Board[] moves= theBoard.moveGenerator(1);
		System.out.println("the origin: "+theBoard.printTheBoard());
		for(int i=0; i<moves.length; i++){
			System.out.print(moves[i].printTheBoard()+" - "+i);
			System.out.println(" - estPoints: "+ moves[i].estFunction_Opening());
		}
		*/
		
		/*
		Board[] testChangeNode=new Board[3];
		for(int i=0;i<3;i++)
			testChangeNode[i]=new Board();
		for(int i=0;i<3;i++)
			System.out.println(testChangeNode[i].printTheBoard()+" "+i);
		for(int i=0;i<3;i++)
			for(int j=0;j<23;j++)
				testChangeNode[i].Nodes[j].setColor(theBoard.Nodes[j].getColor());
		testChangeNode[1].Nodes[4].setColor(1);
		for(int i=0;i<3;i++)
			System.out.println(testChangeNode[i].printTheBoard()+" "+i);
		*/
	}
}



