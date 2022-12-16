package competition;
import competition.*;
import observer.*;
import util.*;
import io.*;
import java.util.*;

public class LeagueMain{
  public static void main(String[] args){
    List<Competitor> compet1 = new ArrayList<Competitor>();
    try{
      Competition league = new League(compet1);
      System.out.println("Enter a number of competitors before starting a League :");
      int choice = Input.readInt();
      int i = choice;
      int j = 1;
      while (i>0){
        league.addCompetitors(new Competitor("competitor "+j));
        i -= 1;
        j += 1;
      }
      System.out.println("");
      System.out.println("New League :");
      System.out.println("");
      Bookmaker b = new Bookmaker();
      JournalistMatch jm = new JournalistMatch();
      JournalistCompetition jc = new JournalistCompetition();
      league.addMatchListener(jm);
      league.addMatchListener(b);
      league.addCompetitionListener(jc);
      league.play();
    }
    catch(NumberNotPowerOf2Exception e){
      System.out.println("Cannot launch a tournament with "+compet1.size()+" competitors!");
      System.out.println("Try again with a number of competitors to the power of 2");
    }
    catch(java.io.IOException t){
      int choix=0;
    }
  }
}
