import java.util.Vector;


public class Committee {
	Player black;
	Player white;
	int winner;
	PlayerMode winnerMode;
	String winnerScore="";
	public Committee(Player b,Player w){
		black =b;
		white =w;
		winner = findWinner();
		if(winner==1){
			winnerMode= black.getMode();
			if(winnerScore.equals(""))
				winnerScore = black.getTopScore();
		}else if(winner==2||winner==3){
			winnerMode= white.getMode();
			if(winnerScore.equals(""))
				winnerScore = white.getTopScore();
		}
	}
	
	private int findWinner(){
		PlayerMode blackMode = black.getMode();
		PlayerMode whiteMode = white.getMode();
		
		if(blackMode.ordinal()==whiteMode.ordinal()){
			int maxCard = black.getMaxCountCard();
			for(int i=maxCard-1;i>=0;i--){
				Vector<Rank> blackcards = black.getCards().get(i);
				Vector<Rank> whitecards = white.getCards().get(i);
				for(int j=0;j<blackcards.size();j++){
					int blackscore = blackcards.get(j).ordinal();
					int whitescore = whitecards.get(j).ordinal();
					if(blackscore>whitescore) {
						winnerScore=blackcards.get(j).toString();
						
						return 1;
					}
					else if(blackscore<whitescore){
						winnerScore=whitecards.get(j).toString();
						return 2;
					}
				}
			}
			
			return 3;
		}else if(blackMode.ordinal()>whiteMode.ordinal()){
			return 1;
		}
		return 2;
	}
	
	public PlayerMode getWinnerMode(){
		return winnerMode;
	}
	public String getWinnerScore(){
		return winnerScore;
	}
	
	
	public int getWinner(){
		return winner;
	}
}
