package blackjack;

import java.util.*;

public class Blackjack { 

    public static void main(String[] args) {
        
        final String Kambiz="Kambiz";
        Play s=new Play();
        s.spil(Kambiz); //this line of code 
        
        // If you wish to have continuous playing, just make above code as comment and remove comment sign
        //of below codes. Otherwise, just run the program without any changes (one time play). 

        /*
        Scanner scan=new Scanner(System.in);
        String p;        
        while(true){
            
            System.out.println("\n\nSett inn p og trykk på enter å begynne spil!!!\n");
            p=scan.next();
            if(p.equalsIgnoreCase("p"))
            s.spil(Kambiz);
            
        }
        */
        
    }
    
}