import java.util.ArrayList;
import java.util.Random;

//Add new Field into Deck class: usedCard, nUsed. 
	// usedCard is an ArrayList<Card> type, which keeps a record of all the cards given out/ taken by players. 
	// nUsed is an integer type, which counts the number of cards being used, which means given out/ taken by players. 
public class Deck{
	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard;
	public int nUsed;
	
	
//Add New Method: shuffle().
	// shuffle() is a void return type, which keeps all the cards back to the Deck and shuffle its positions in a Deck ArrayList.
	// By Shuffling, it means that Deck takes a card randomly and put it in new position in Deck.
	// Then, we will need to reset usedCard and nUsed records. 
	public void shuffle() {
		if (nUsed > 0) {
			for (int i = usedCard.size() -1 ; i >= 0; i--) {
				Card onHand = usedCard.get(i);
				cards.add(onHand);
				nUsed --;
			}
		}
		usedCard.clear();
		
		for (int i = cards.size()-1; i>=0; i--) {
			Card onHand = cards.get(i);
			Random rnd = new Random(); 
			int j = rnd.nextInt(i+1);
			Card onHand2 = cards.get(j);
			cards.set(j,onHand);
			cards.set(i,onHand2);
		}

	}
	
//Add New Method: getOneCard().
	// getOneCard() is a method that gives player a card, and return the card object. 
	public Card getOneCard() {
		
		if (cards.size() <= 0) {
			shuffle();
		}
		Card x = cards.get(0);
		usedCard.add(x);
		cards.remove(0);
		nUsed ++;
		return x;
			
	}
	
//Add shuffle() method into Deck constructor
	// shuffle() method is called when there is no more card in the Deck.
	// in order to call shuffle() method correctly,
	// Cards taken must be recorded in usedCard and 
	// number of cards taken must be recorded in nUsed.  
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCard =new ArrayList<Card>();
		nUsed = 0;
		for(Card.Suit s: Card.Suit.values()) {
			for(int j=1; j<=13; j++) {
				Card c = new Card(s,j);
				cards.add(c);
			}
		}
		shuffle();
		
	}	
	public void printDeck() {
		for(Card c: cards) {
			c.printCard();
		}
	}
	
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}