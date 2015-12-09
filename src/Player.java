import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class Player {
	public 	Set<Suit> suits = EnumSet.noneOf(Suit.class);
	private Set<Rank> distinctRank = EnumSet.noneOf(Rank.class);
	private Vector<Vector<Rank>> cards = new Vector<Vector<Rank>>(10);
	private PlayerMode mode;
	
	public Player(Vector<Card> cards) {
		for(int i=0;i<4;i++){
			Vector<Rank> ranks = new Vector<Rank>();
			this.cards.add(ranks);
		}
		
		
		for(Card card : cards){
			suits.add(card.getSuit());
			distinctRank.add(card.getRank());
		}
		
		
		List<Rank> myList = new ArrayList(distinctRank);
		myList.sort(new RankComparator());
		
		for(Rank rank:myList){
			int count=0;
			for(Card card:cards){
				if(card.getRank().ordinal()==rank.ordinal())count++;
			}
			
			if(count<5&&count>0){
				if(this.cards.size()>0) this.cards.get(count-1).add(rank);
			}
		}
		
		mode = findPlayerMode();
		
	}
	
	private PlayerMode findPlayerMode(){
		boolean isFlush = (suits.size()==1)? true :false;
		int countDistinct = distinctRank.size();
		
		if(countDistinct==5){
			if(isConsecutive()){
				mode = isFlush? PlayerMode.Straight_flush : PlayerMode.Straight;
			}else{
				mode = isFlush? PlayerMode.Flush : PlayerMode.High_card;
			}
		}
		else if (countDistinct == 4) {
			mode = PlayerMode.Pair;
		}
		
		else if (countDistinct == 3) {
			mode = getMaxCountCard() == 2 ? PlayerMode.Two_pair : PlayerMode.Three_of_a_kind;
			
		}
		else {
			mode = getMaxCountCard() == 3 ? PlayerMode.Full_house : PlayerMode.Four_of_a_kind;
		}
		return mode;
		
	}
	
	private boolean isConsecutive(){
		Vector<Rank> checkRank = cards.get(0);
		//case Ace,one,two,three,four
		if(checkRank.firstElement().equals(Rank.ACE)&& checkRank.get(1).equals(Rank.FIVE)){
			int second = checkRank.get(1).ordinal();
			int last = checkRank.lastElement().ordinal();
			if(second-last==3)return true;
			return false;
		}
		
		int first = checkRank.firstElement().ordinal();
		int last = checkRank.lastElement().ordinal();
		if(first-last==4) return true;
		return false;
	}
	
	public int getMaxCountCard(){
		int count =0;
		for(int i=cards.size()-1;i>=0;i--){
			if(cards.get(i).size()!=0){
				count=i+1;
				break;
			}
		}
		return count;
	}
	
	public String getTopScore(){
		String score="";
		for(int i=cards.size()-1;i>=0;i--){
			if(cards.get(i).size()!=0){
				score=cards.get(i).firstElement().toString();
				break;
			}
		}
		return score;
	}
	
	public Vector<Vector<Rank>> getCards(){
		return cards;
	}
	
	public Set<Rank> getDistinctRank(){
		return distinctRank;
	}
	
	public PlayerMode getMode(){
		return mode;
	}

	protected static class RankComparator implements Comparator {
        /**
         * Method for compairing two objects, TypeSafeEnums in this case. The
         * comparison is made on the ordinal values.
         * @param a First object to be compared
         * @param b Second object to be compared.
         * @return The value 0 if <tt>a</tt> is numerically equal to <tt>b</tt>; a value less than 0 if
         * <tt>a</tt> is numerically less than <tt>b</tt>; and a value greater than 0  if <tt>a</tt>
         * is numerically greater than <tt>b</tt>.
         */
        public int compare(Object a, Object b) {
            return ((Rank)b).ordinal() - ((Rank)a).ordinal();
        }
    }
	
}
