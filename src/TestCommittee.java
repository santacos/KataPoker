import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

/**
 * 
 */

/**
 * @author COSCOS
 *
 */
public class TestCommittee {

	@Test
	public void test() {
		Card cardA = new Card(Rank.TWO,Suit.S);
		Card cardB = new Card(Rank.EIGHT,Suit.S);
		Card cardC = new Card(Rank.ACE,Suit.S);
		Card cardD = new Card(Rank.QUEEN,Suit.S);
		Card cardE = new Card(Rank.THREE,Suit.S);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.H);
		Card cardQ = new Card(Rank.FOUR,Suit.S);
		Card cardR = new Card(Rank.FOUR,Suit.C);
		Card cardS = new Card(Rank.TWO,Suit.D);
		Card cardZ = new Card(Rank.FOUR,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(2,cc.getWinner());
		assertEquals(PlayerMode.Full_house, cc.getWinnerMode());
//		assertEquals("ACE",cc.getWinnerScore());
	}
	
	@Test
	public void Tiewithhighcard() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.THREE,Suit.D);
		Card cardC = new Card(Rank.FIVE,Suit.S);
		Card cardD = new Card(Rank.NINE,Suit.C);
		Card cardE = new Card(Rank.KING,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.D);
		Card cardQ = new Card(Rank.THREE,Suit.H);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.NINE,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(3,cc.getWinner());
		assertEquals(PlayerMode.High_card, cc.getWinnerMode());
//		assertEquals("NINE",cc.getWinnerScore());
	}
	
	@Test
	public void WinPair() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.THREE,Suit.D);
		Card cardC = new Card(Rank.FIVE,Suit.S);
		Card cardD = new Card(Rank.NINE,Suit.C);
		Card cardE = new Card(Rank.KING,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.D);
		Card cardQ = new Card(Rank.TWO,Suit.H);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.NINE,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(2,cc.getWinner());
		assertEquals(PlayerMode.Pair, cc.getWinnerMode());
		assertEquals("TWO",cc.getWinnerScore());
	}

	@Test
	public void WinPairSameMode() {
		Card cardA = new Card(Rank.THREE,Suit.H);
		Card cardB = new Card(Rank.THREE,Suit.D);
		Card cardC = new Card(Rank.FIVE,Suit.S);
		Card cardD = new Card(Rank.NINE,Suit.C);
		Card cardE = new Card(Rank.KING,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.D);
		Card cardQ = new Card(Rank.TWO,Suit.H);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.NINE,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(1,cc.getWinner());
		assertEquals(PlayerMode.Pair, cc.getWinnerMode());
		assertEquals("THREE",cc.getWinnerScore());
	}
	
	@Test
	public void WinPairSameModeSecond() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.TWO,Suit.D);
		Card cardC = new Card(Rank.SIX,Suit.S);
		Card cardD = new Card(Rank.NINE,Suit.C);
		Card cardE = new Card(Rank.KING,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.C);
		Card cardQ = new Card(Rank.TWO,Suit.S);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.NINE,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(1,cc.getWinner());
		assertEquals(PlayerMode.Pair, cc.getWinnerMode());
		assertEquals("SIX",cc.getWinnerScore());
	}
	
	@Test
	public void WinTWOPair() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.TWO,Suit.D);
		Card cardC = new Card(Rank.SIX,Suit.S);
		Card cardD = new Card(Rank.SIX,Suit.C);
		Card cardE = new Card(Rank.KING,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.C);
		Card cardQ = new Card(Rank.TWO,Suit.S);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.FIVE,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(1,cc.getWinner());
		assertEquals(PlayerMode.Two_pair, cc.getWinnerMode());
		assertEquals("SIX",cc.getWinnerScore());
	}
	@Test
	public void WinTWOPairwithHighCard() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.TWO,Suit.D);
		Card cardC = new Card(Rank.SIX,Suit.D);
		Card cardD = new Card(Rank.SIX,Suit.H);
		Card cardE = new Card(Rank.NINE,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.C);
		Card cardQ = new Card(Rank.TWO,Suit.S);
		Card cardR = new Card(Rank.SIX,Suit.C);
		Card cardS = new Card(Rank.SIX,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(2,cc.getWinner());
		assertEquals(PlayerMode.Two_pair, cc.getWinnerMode());
		assertEquals("KING",cc.getWinnerScore());
	}
	
	@Test
	public void WinThreeOfAKind() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.TWO,Suit.D);
		Card cardC = new Card(Rank.TWO,Suit.D);
		Card cardD = new Card(Rank.SIX,Suit.H);
		Card cardE = new Card(Rank.NINE,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.TWO,Suit.C);
		Card cardQ = new Card(Rank.SIX,Suit.D);
		Card cardR = new Card(Rank.SIX,Suit.C);
		Card cardS = new Card(Rank.SIX,Suit.S);
		Card cardZ = new Card(Rank.KING,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(2,cc.getWinner());
		assertEquals(PlayerMode.Three_of_a_kind, cc.getWinnerMode());
		assertEquals("SIX",cc.getWinnerScore());
	}
	
	@Test
	public void WinStraight() {
		Card cardA = new Card(Rank.TWO,Suit.H);
		Card cardB = new Card(Rank.THREE,Suit.D);
		Card cardC = new Card(Rank.FOUR,Suit.D);
		Card cardD = new Card(Rank.SIX,Suit.H);
		Card cardE = new Card(Rank.FIVE,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.THREE,Suit.C);
		Card cardQ = new Card(Rank.FOUR,Suit.D);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.SIX,Suit.S);
		Card cardZ = new Card(Rank.SEVEN,Suit.H);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(2,cc.getWinner());
		assertEquals(PlayerMode.Straight, cc.getWinnerMode());
		assertEquals("SEVEN",cc.getWinnerScore());
	}
	
	@Test
	public void WinFlush() {
		Card cardA = new Card(Rank.TWO,Suit.D);
		Card cardB = new Card(Rank.NINE,Suit.D);
		Card cardC = new Card(Rank.FOUR,Suit.D);
		Card cardD = new Card(Rank.SIX,Suit.D);
		Card cardE = new Card(Rank.FIVE,Suit.D);
		
		Vector<Card> blackcards = new Vector<>();
		
		blackcards.add(cardA);
		blackcards.add(cardB);
		blackcards.add(cardC);
		blackcards.add(cardD);
		blackcards.add(cardE);
		
		Card cardP = new Card(Rank.THREE,Suit.C);
		Card cardQ = new Card(Rank.JACK,Suit.C);
		Card cardR = new Card(Rank.FIVE,Suit.C);
		Card cardS = new Card(Rank.TEN,Suit.C);
		Card cardZ = new Card(Rank.SEVEN,Suit.C);
		
		Vector<Card> whitecards = new Vector<>();
		
		whitecards.add(cardP);
		whitecards.add(cardQ);
		whitecards.add(cardR);
		whitecards.add(cardS);
		whitecards.add(cardZ);
		
		Player black = new Player(blackcards);

		Player white = new Player(whitecards);
		
		Committee cc = new Committee(black, white);
		
		assertEquals(2,cc.getWinner());
		assertEquals(PlayerMode.Flush, cc.getWinnerMode());
		assertEquals("JACK",cc.getWinnerScore());
	}
	
}
