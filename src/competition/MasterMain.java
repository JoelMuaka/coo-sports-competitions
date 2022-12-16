package competition;
import competition.*;
import competition.methods.*;
import observer.*;
import util.*;
import io.*;
import java.util.*;

public class MasterMain{
  public static void main(String[] args){
    List<Competitor> compet1 = new ArrayList<Competitor>();
    Method method = null;
    int groupe = 0;
    try{
      Competition master = null;
      System.out.println("Please enter the number corresponding to the mode of your Master :");
      System.out.println("SelectFirst (1)   SelectFirstTwo (2)    SelectFirstTwoAndBestThirds (3)");
      int choix = Input.readInt();
      while ((choix != 1)&&(choix != 2)&&(choix != 3)){
        System.out.println("Please enter the number corresponding to the mode of your Master :");
        System.out.println("SelectFirst (1)   SelectFirstTwo (2)    SelectFirstTwoAndBestThirds (3)");
        choix = Input.readInt();
      }
      if (choix == 1){
          method = new SelectFirst();
      }
      else if (choix == 2){
        method = new SelectFirstTwo();
      }
      else{
        method = new SelectFirstTwoAndBestThirds();
      }
      System.out.println("Enter a number of competitors before starting a Master :");
      int choix1 = Input.readInt();
      System.out.println("Number of groups :");
      groupe = Input.readInt();
      master = new Master(compet1, groupe, method);
      int i = choix1;
      int j = 1;
      while (i>0){
        master.addCompetitors(new Competitor("competitor "+j));
        i -= 1;
        j += 1;
      }
      System.out.println("");
      System.out.println("New Master :");
      System.out.println("");
      Bookmaker b = new Bookmaker();
      JournalistMatch jm = new JournalistMatch();
      JournalistCompetition jc = new JournalistCompetition();
      master.addMatchListener(jm);
      master.addMatchListener(b);
      master.addCompetitionListener(jc);
      master.play();
    }
    catch(NumberNotPowerOf2Exception e){
      System.out.println("Cannot launch this type of Master with "+compet1.size()+" competitors and "+groupe+" groups");
    }
    catch(java.io.IOException t){
      int choix=0;
    }
  }
}
