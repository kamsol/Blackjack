package blackjack;

import java.util.*;

public class Card {    
    public static ArrayList cardList;
    private Suit suit;
    private Value value;
    
    
    private enum Suit {
        HEART,
        SPADE,
        DIAMOND,
        CLUB;
        
        private String s;
        
    private Suit() {
       s = this.name().substring(0, 1);
    }
    }
    
    public String getChar() {
     return suit.s;
    }
    
    private enum Value {
        TO(2,"2"),
        TRE(3,"3"),
        FIRE(4,"4"),
        FEM(5,"5"),
        SEKS(6,"6"),
        SIV(7,"7"),
        ATTE(8,"8"),
        NI(9,"9"),
        TI(10,"10"),
        KNEKT(10,"J"), //value equal to 10
        DRONNING(10,"Q"),
        KONGE(10,"K"),
        ESS(11,"A");

    private int numericValue;
    private String symbol;

    private Value(int val, String symbol) {
       this.numericValue = val;
       this.symbol=symbol;
    }
       
   }
    public int getValue() {
     return value.numericValue;
    }
    public String getSymbol() {
     return value.symbol;
    }
  
    //Constructor
    public Card(Suit suit, Value value) {
     this.suit = suit;
     this.value = value;
    }
 
    @Override
    public String toString() {
    return String.format("{suit: %S ,value: %s}" ,suit, value.symbol);
   }
  
    
 
    
    public static ArrayList<Card> kortDeck (){
        cardList=new ArrayList();
        for(Suit s:Suit.values())
            for(Value v:Value.values()){
            cardList.add(new Card(s, v));          
        }
        Collections.shuffle(cardList);
        return cardList;
    }

}
