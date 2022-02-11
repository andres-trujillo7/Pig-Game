//Completed and translated from python to java on 1-4-22 by Andres Trujillo

import java.io.*;
import java.util.*;


public class Pig
{
  public static void main(String[] args) throws Exception
  {

    welcomeMsg();

    System.out.println("Tell me a little about yourself... What is your name? Hit ENTER when you've typed your name!");
    Scanner kb = new Scanner(System.in);
    String name = kb.nextLine();
    System.out.println("Hello, " + name + "! Get ready to play PIG! You're up first! \n");

    int score = 0; //player's score
    int cscore = 0; //computer's score

    game(score, cscore, name, kb);

  }


  public static void welcomeMsg()
  {
    System.out.println("*******************************************************************************************************************************************************************");
    System.out.println("*                                                          -Hello! Welcome to Andres Trujillo's game of PIG!-                                                     *");
    System.out.println("*                                                                                                                                                                 *");
    System.out.println("*   In this game you are to roll an imaginary die (1-6) and so long as you do not roll a 1, the number you roll is added to your points count.                    *");
    System.out.println("*   Your end goal is to get up to 100 points. After each roll, you will have the option to HOLD and end your turn or keep rolling.                                *");
    System.out.println("*   This is high risk/high reward because you can get very close to 100 if you continue rolling, or lose EVERYTHING you've rolled that turn if you roll a 1.      *");
    System.out.println("*                                                                                                                                                                 *");
    System.out.println("*   Oh, and also you are going to be playing against The Computer. So..... good luck!                                                                             *");
    System.out.println("*******************************************************************************************************************************************************************");
  }

  public static void game(int score, int cscore, String name, Scanner kb)
  {
    int turnNum = 1;
    System.out.println("*********************************************************************");
    System.out.println("TURN# " + turnNum);
    System.out.println("_______ \n");

    while(score<100 && cscore<100)
    {
      boolean playOn = true;
      boolean cPlayOn = true;
      int turnScore = 0; //player's score from current turn

      while(playOn== true) //when false, player's turn is done
      {
        int roll = (int)(1+ Math.random()*6);
        if(roll!=1)
        {
          System.out.println("You rolled a " + roll);
          turnScore+=roll;

          if ((turnScore + score)>=100)
          {
            score = score + turnScore;
            System.out.println("Congratulations, " + name + "!" + " You won with a score of " + score + "!");
            playOn = false;
          }

            else
            {

              if (turnNum == 1 )
              {
                System.out.println("Your score is " + turnScore );
              }

              else
              {
                System.out.println("You score for this round is now " + turnScore + ". Your total score is currently " + (turnScore+score));
              }
                System.out.println("Would you like to hold? Answer with 'hold' or 'h', and then hit the ENTER key if you would like to hold. Otherwise, just hit ENTER.");
                String hold = kb.nextLine();
                if (hold.equals("Hold") || hold.equals("H") || hold.equals("h")|| hold.equals("hold"))
                {
                  score+= turnScore;
                  System.out.println("You decided to hold! Your total score is " + score);
                  System.out.println("*********************************************************************");
                  System.out.println("Computer's turn! \n");
                  playOn = false;
                }

            }

        }

        else
        {
          System.out.println("You rolled a 1!");
          if(score == 0)
            System.out.println("You have yet to gain any points!");
          else
            System.out.println("You lose all your points for this round!");

          turnScore = 0;
          System.out.println("Your score is " + score);
          System.out.println("*********************************************************************");
          System.out.println("Computer's turn! \n");
          playOn = false;
        }

      }

      int cTurnScore = 0;
      while(cPlayOn == true && playOn == false && score<100)
      {
        int cRoll = (int)(1+ Math.random()*6);
        if(cRoll != 1)
        {
          System.out.println("The Computer rolled a " + cRoll);

          cTurnScore+= cRoll;
          if(cTurnScore + cscore >= 100)
          {
            cscore+= cTurnScore;
            System.out.println("SORRY! THE COMPUTER WON WITH A SCORE OF " + cscore + "!");
            cPlayOn = false;
          }

          else
          {
            System.out.println("The Computer's score for this round is " + cTurnScore + "\n");
            int cHold = (int)Math.round(Math.random()); //0 for hold, 1 for continue
            if(cHold == 0)
            {
              cscore+=cTurnScore;
              System.out.println("The Computer decided to hold and its total score is now " + cscore);
              cPlayOn = false;
              System.out.println("*********************************************************************");
              turnNum++;
              System.out.println("TURN# " + turnNum);
              System.out.println("_______ \n");
              System.out.println("Your Turn! \n");
            }

          }
        }

        else
        {
          System.out.println("The Computer rolled a 1!");
          if(cscore == 0)
            System.out.println("The Computer has yet to gain any points!");
          else
              System.out.println("The Computer lost all of its points for this round!");

          System.out.println("The Computer's score is " + cscore);
          System.out.println("*********************************************************************");
          turnNum++;
          System.out.println("TURN# " + turnNum);
          System.out.println("_______ \n");
          System.out.println("Your turn! \n");
          cPlayOn = false;
        }
      }

    }
  }
}
