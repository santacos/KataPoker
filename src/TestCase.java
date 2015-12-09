import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Vector;

import org.junit.Test;



public class TestCase {
	@Test
	public void createCard() {
		Card card = new Card(Rank.ACE,Suit.C);
		assertEquals(Rank.ACE, card.getRank());
		assertEquals(Suit.C, card.getSuit());
	}
	
	@Test
	public void createPlayer() {
		Card cardA = new Card(Rank.ACE,Suit.D);
		Card cardB = new Card(Rank.ACE,Suit.C);
		Card cardC = new Card(Rank.ACE,Suit.H);
		Card cardD = new Card(Rank.FIVE,Suit.S);
		Card cardE = new Card(Rank.TWO,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(4,player.suits.size());

		assertEquals(3,player.getDistinctRank().size());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println();
			i++;
		}
	}
	
	@Test
	public void HighCard() {
		Card cardA = new Card(Rank.ACE,Suit.D);
		Card cardB = new Card(Rank.TWO,Suit.C);
		Card cardC = new Card(Rank.SIX,Suit.H);
		Card cardD = new Card(Rank.FIVE,Suit.S);
		Card cardE = new Card(Rank.FOUR,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
//		assertEquals(4,player.suits.size());
//
//		assertEquals(5,player.getDistinctRank().size());
		
		assertEquals(PlayerMode.High_card, player.getMode());
		System.out.println(player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println();
			i++;
		}
	}
	
	@Test
	public void Pair() {
		Card cardA = new Card(Rank.TWO,Suit.D);
		Card cardB = new Card(Rank.TWO,Suit.C);
		Card cardC = new Card(Rank.THREE,Suit.H);
		Card cardD = new Card(Rank.FIVE,Suit.S);
		Card cardE = new Card(Rank.FOUR,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Pair, player.getMode());
		System.out.println(player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void TwoPair() {
		Card cardA = new Card(Rank.TWO,Suit.D);
		Card cardB = new Card(Rank.TWO,Suit.C);
		Card cardC = new Card(Rank.THREE,Suit.H);
		Card cardD = new Card(Rank.THREE,Suit.S);
		Card cardE = new Card(Rank.FOUR,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Two_pair, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void ThreeOfAKind() {
		Card cardA = new Card(Rank.TWO,Suit.D);
		Card cardB = new Card(Rank.TWO,Suit.C);
		Card cardC = new Card(Rank.TWO,Suit.H);
		Card cardD = new Card(Rank.THREE,Suit.S);
		Card cardE = new Card(Rank.FOUR,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Three_of_a_kind, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void Straight() {
		Card cardA = new Card(Rank.TWO,Suit.D);
		Card cardB = new Card(Rank.FIVE,Suit.C);
		Card cardC = new Card(Rank.SIX,Suit.H);
		Card cardD = new Card(Rank.THREE,Suit.S);
		Card cardE = new Card(Rank.FOUR,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Straight, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void StraightACE() {
		Card cardA = new Card(Rank.TWO,Suit.D);
		Card cardB = new Card(Rank.FIVE,Suit.C);
		Card cardC = new Card(Rank.ACE,Suit.H);
		Card cardD = new Card(Rank.THREE,Suit.S);
		Card cardE = new Card(Rank.FOUR,Suit.C);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Straight, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void Flush() {
		Card cardA = new Card(Rank.TWO,Suit.S);
		Card cardB = new Card(Rank.EIGHT,Suit.S);
		Card cardC = new Card(Rank.ACE,Suit.S);
		Card cardD = new Card(Rank.QUEEN,Suit.S);
		Card cardE = new Card(Rank.THREE,Suit.S);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Flush, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void Fullhouse() {
		Card cardA = new Card(Rank.TEN,Suit.D);
		Card cardB = new Card(Rank.TEN,Suit.D);
		Card cardC = new Card(Rank.TEN,Suit.S);
		Card cardD = new Card(Rank.THREE,Suit.D);
		Card cardE = new Card(Rank.THREE,Suit.H);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Full_house, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void FourOfAKind() {
		Card cardA = new Card(Rank.TEN,Suit.D);
		Card cardB = new Card(Rank.TEN,Suit.D);
		Card cardC = new Card(Rank.TEN,Suit.S);
		Card cardD = new Card(Rank.TEN,Suit.D);
		Card cardE = new Card(Rank.THREE,Suit.H);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Four_of_a_kind, player.getMode());
		assertEquals(player.getTopScore(), "TEN");
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}
	
	@Test
	public void StraightFlush() {
		Card cardA = new Card(Rank.SEVEN,Suit.D);
		Card cardB = new Card(Rank.SIX,Suit.D);
		Card cardC = new Card(Rank.FIVE,Suit.D);
		Card cardD = new Card(Rank.FOUR,Suit.D);
		Card cardE = new Card(Rank.THREE,Suit.D);
		
		Vector<Card> cards = new Vector<>();
		
		cards.add(cardA);
		cards.add(cardB);
		cards.add(cardC);
		cards.add(cardD);
		cards.add(cardE);
		
		Player player = new Player(cards);
		assertEquals(PlayerMode.Straight_flush, player.getMode());
		
		int i=1;
		for(Vector<Rank> eachCountRank : player.getCards()){
			System.out.println("#: "+i);
			for(Rank rank:eachCountRank){
				System.out.print(rank.toString()+" ");
			}
			System.out.println("------");
			i++;
		}
	}

}
