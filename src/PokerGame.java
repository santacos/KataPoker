import java.util.Scanner;
import java.util.Vector;


public class PokerGame {
	Player black;
	Player white;
	Committee committee;
	
	public static void main(String[] args) {
		PokerGame pokerGame = new PokerGame();
		String input="";
		
		Scanner in = new Scanner(System.in);
		System.out.print("Black: ");
		input = in.nextLine();
		try {
			pokerGame.addInput(1,input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print("White: ");
		input = in.nextLine();
		try {
			pokerGame.addInput(2,input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
		pokerGame.setCommittee();
		System.out.println(pokerGame.getResult());
	}
	
	public void addInput(int person,String text) throws Exception{
		String[] input = new String[5];
		input = text.split(" ", 5);
		Vector<Card> cards = new Vector<Card>();
		
		for(String item : input){
			String r,s;
			if(item.length()==2){
				r = item.substring(0,1);
				s = item.substring(1,2);	
				Rank rank = MapStringToRank(r);
				Suit suit = MapStringToSuit(s);
				Card card = new Card(rank,suit);
				cards.add(card);
			}
		}
		if(person==1)black=new Player(cards);
		else white=new Player(cards);
		

	}
	
	public void setCommittee(){
		if(black!=null&&white!=null)
			committee = new Committee(black, white);
	}
	
	private Rank MapStringToRank(String text) throws Exception{
		switch (text) {
		case "2":return Rank.TWO;
		case "3":return Rank.THREE;
		case "4":return Rank.FOUR;
		case "5":return Rank.FIVE;
		case "6":return Rank.SIX;
		case "7":return Rank.SEVEN;
		case "8":return Rank.EIGHT;
		case "9":return Rank.NINE;
		case "T":return Rank.TEN;
		case "J":return Rank.JACK;
		case "Q":return Rank.QUEEN;
		case "K":return Rank.KING;
		case "A":return Rank.ACE;
		default: throw new IllegalArgumentException();
		}
	}
	
	private Suit MapStringToSuit(String text) throws Exception{
		switch (text) {
		case "C":return Suit.C;
		case "D":return Suit.D;
		case "H":return Suit.H;
		case "S":return Suit.S;
		default: throw new IllegalArgumentException();
		}
	}
	
	public String getResult(){
		int result = committee.getWinner();
		String text="";
		if(result==1){
			text = "Black wins. - with "+committee.getWinnerMode().toString()+": "+committee.getWinnerScore();
		}
		else if(result==2){
			text = "White wins. - with "+committee.getWinnerMode().toString()+": "+committee.getWinnerScore();
		}
		else text =  "Tie.";
		return text;
	}

}
