package blackjack;

import java.util.*;

public class Play {
    
     final String spiller1="Kambiz";
     final String  spiller2="Stranger";
     ArrayList < Card > kort;
     int kortnum=0;
     String spillerNavn,vinner;     
     int spiller1_poeng=0, spiller2_poeng=0;
     ArrayList<Card> spiller1_kortene=new ArrayList<>();
     ArrayList<Card> spiller2_kortene=new ArrayList<>();
     int tmp;
     
    //Constructor
     public Play() {
     kort = Card.kortDeck();
     System.out.print("Dette er kortstokken:" );
     for (int i = 0; i < kort.size(); i++){
         if(i%6==0)System.out.println();
         System.out.print(kort.get(i) );
     }
     System.out.println("\n\n");
    } 
     
     
    public void spil(String spiller){
  
      spillerNavn=spiller;
      if(kortnum<51)
      {
      if(spillerNavn==spiller1)
      {      
         tmp=spiller1_kortene.size()==0? 2: 1;
         
              for(int i=kortnum; i<kortnum+tmp ;i++ ){                  
                  spiller1_kortene.add(kort.get(i));
                  spiller1_poeng+=kort.get(i).getValue();
              }
              kortnum+=tmp;
              poengKalkulator();
      }
      else if(spillerNavn==spiller2)
      {
          tmp=spiller2_kortene.size()==0? 2: 1;          
              for(int i=kortnum; i<kortnum+tmp ;i++ ){                  
                  spiller2_kortene.add(kort.get(i));
                  spiller2_poeng+=kort.get(i).getValue();
              }
              kortnum+=tmp;
              poengKalkulator();
      }
     
      }else
      {
        System.out.print("Ikke nok kort på kortstokken igjen!!! spill er ferdig" );  
        System.exit(0);
      }   
          
  }   

    private void poengKalkulator() {
        
        if(spillerNavn==spiller1){
        
            if(spiller1_poeng==21)
            {   
                vinner=spillerNavn;
                showKortene(); 
            }
            else if(spiller1_poeng>21)
            {    
                vinner=spiller2;
                showKortene(); 
            }
            else if(spiller1_poeng<17)
            {    
                spil(spillerNavn);
            }
            else
            {
                spillerNavn=spiller2;
                spil(spillerNavn);
            }                    
        }
        
        else if(spillerNavn==spiller2){
        
            if(spiller2_poeng==21)
            {   
                vinner=spillerNavn;
                showKortene(); 
            }
            else if(spiller2_poeng>21)
            {    
                vinner=spiller1;
                showKortene(); 
            }
            else if(spiller2_poeng<spiller1_poeng)
            {   
                spil(spillerNavn);
            }
            else if(spiller2_poeng>spiller1_poeng)
            {
            vinner=spillerNavn;
            showKortene();                
            }
           
        }     
    }
    

    private void showKortene() {
        System.out.println( "Vinner: "+vinner);
        
        StringBuilder str = new StringBuilder();
        for(Card s1:spiller1_kortene)
            str.append(s1.getChar()).append(s1.getSymbol()).append("| ");
        System.out.println(spiller1 +"| "+ spiller1_poeng +"| " +str);
        
  
        str=new StringBuilder();
        if(spiller2_kortene.size()>0)
        for(Card s2:spiller2_kortene)
            str.append(s2.getChar()).append(s2.getSymbol()).append("| ");
        System.out.print(spiller2 +"| "+ spiller2_poeng+"| "+str);
        
        spiller1_poeng=spiller2_poeng=0;
        spiller1_kortene=new ArrayList<>();
        spiller2_kortene=new ArrayList<>();
        
    }
        
}
        
