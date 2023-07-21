package HuoChess;

//import java.util.*;
import java.util.Scanner;
//import java.io.*;

public class HuoChess {

// Huo Chess by Spiros Kakos (2018)
// License: Reuse the code as you please, as long as you mention the author and where you first read it!
    
// Declare variables

// Player color
public static String m_PlayerColor;
// Who plays
public static String m_WhoPlays;
// Move related variables
public static String playerMove;
public static String movingPiece;
public static String startingColumn;
public static String startingRank;
public static String finishingColumn;
public static String finishingRank;
public static int startingRankNum;
public static int finishingRankNum;
public static int startingColumnNum;
public static int finishingColumnNum;
public static boolean moveValidity;
public static boolean moveLegality;
// Additional variables for check legality of move
public static int p, h;
public static int how_to_move_Rank = 0;
public static int how_to_move_Column = 0;
public static boolean m_WrongColumn;
public static boolean exit_elegxos_nomimothtas;
public static boolean enpassant_occured;
public static String ProsorinoKommati_KingCheck;
public static boolean WhiteKingCheck;
public static boolean BlackKingCheck;
public static int WhiteKingColumn;
public static int WhiteKingRank;
public static int BlKingColumn;
public static int BlKingRank;        
public static boolean DangerFromRight;
public static boolean DangerFromLeft;
public static boolean DangerFromUp;
public static boolean DangerFromDown;
public static boolean DangerFromUpRight;
public static boolean DangerFromDownLeft;
public static boolean DangerFromDownRight;
public static boolean DangerFromUpLeft;
// Variables to store the best move
public static boolean bestMoveFound;
public static int Best_Move_StartingColumnNumber;
public static int Best_Move_StartingRank;
public static int Best_Move_FinishingColumnNumber;
public static int Best_Move_FinishingRank;
// Variables to store the score
public static double tempScore;
public static double bestScore;
// The chessboard
//public static String[][] Skakiera = new String[8][8];
public static String[][] drawChessBoard = new String[8][8];
// The tool used to read the input from the user
static Scanner reader = new Scanner(System.in);

////////////////////////////////////////////////////////////////////////////////////////////////////////
// DECLARE VARIABLES (v0.970: Sanitization)
////////////////////////////////////////////////////////////////////////////////////////////////////////

//C# TO JAVA CONVERTER WARNING: The java.io.OutputStreamWriter constructor does not accept all the arguments passed to the System.IO.StreamWriter constructor:
//ORIGINAL LINE: public static StreamWriter huo_sw1 = new StreamWriter("Minimax_Thought_Process.txt", true);
//		public static OutputStreamWriter huo_sw1 = new OutputStreamWriter("Minimax_Thought_Process.txt");
//C# TO JAVA CONVERTER WARNING: The java.io.OutputStreamWriter constructor does not accept all the arguments passed to the System.IO.StreamWriter constructor:
//ORIGINAL LINE: public static StreamWriter huo_sw_attackers = new StreamWriter("Attackers.txt", true);
//		public static OutputStreamWriter huo_sw_attackers = new OutputStreamWriter("Attackers.txt");

// New writers for logging the attackers, the defenders and the dangerous squares
//public static StreamWriter huo_sw_defenders = new StreamWriter("Defenders.txt", true);
//public static StreamWriter huo_sw_dangerous = new StreamWriter("Dangerous.txt", true);

public static String NextLine;
public static String FinalPositions;

//v0.990
public static String ThisIsStupidMove = "N";
public static boolean Danger_for_piece;
public static boolean ThereIsCheck;
//Is it possible to eat a piece of greater value?
public static boolean possibility_to_eat;
public static int ValueOfKommati = 0;
public static int ValueOfTargetPiece = 0;
// Chessboard for logging purposes
public static String[][] SkakieraLog = new String[8][8]; // Î”Î®Î»Ï‰ÏƒÎ· Ï€Î¯Î½Î±ÎºÎ± Ï€Î¿Ï… Î±Î½Ï„Î¹Ï€ÏÎ¿ÏƒÏ‰Ï€ÎµÏÎµÎ¹ Ï„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±

//v0.980: Change small Strings to Int
//0 = Not dangerous square
//1 = Dangerous square
public static int[][] Skakiera_Dangerous_Squares = new int[8][8];
//v0.990: New dangerous squares check to see if the computer moves his pieve into a square,
//where the only defender was the same moving piece! (and there exists an attacker of course...)
//public static int[,] Skakiera_Dangerous_Squares_2 = new int[8, 8];
public static int[][] Number_of_defenders = new int[8][8];
public static int[][] Number_of_attackers = new int[8][8];
//v0.980: Removed Attackers_coordinates_column/ rank since they are not used!
//public static int[,] Attackers_coordinates_column = new int[8, 8];
//public static int[,] Attackers_coordinates_rank = new int[8, 8];
public static int[][] Value_of_defenders = new int[8][8];
public static int[][] Value_of_attackers = new int[8][8];
//v0.980: Removed Exception_defender_column/ rank since they are not used!
//public static int[,] Exception_defender_column = new int[8, 8];
//public static int[,] Exception_defender_rank = new int[8, 8];

// Parameter which determined the weight of danger in the counting of the score of positions
//v0.980: Removed humanDangerParameter and computerDangerParameter
//public static int humanDangerParameter = 0;
//public static int computerDangerParameter = 1;

// Is it possible to eat back the piece that was moved by the computer?
public static boolean possibility_to_eat_back;

//v0.970 added
public static int ValueOfHumanMovingPiece = 0;
public static int ValueOfMovingPiece = 0;

// Variables to store the scores of positions during the analysis
//v0.970: Changed them to integers
public static int Temp_Score_Move_0;
public static int Temp_Score_Move_1_human;
public static int Temp_Score_Move_2;
public static int Temp_Score_Move_3_human;
public static int Temp_Score_Move_4;
public static int Temp_Score_Move_5_human;
public static int Temp_Score_Move_6;

// 0.970
// These arrays will hold the Minimax analysis nodes data (skakos)
// Dimension ,1: For the score
// Dimension ,2: For the parent
// Dimensions 3-6: For the initial move starting/ finishing columns-ranks (only for the 0-level array)
// Changed them to integers for less memory usage
//v0.980: Reduced size of arrays
public static int[][] NodesAnalysis0 = new int[1000000][6];
public static int[][] NodesAnalysis1 = new int[1000000][2];
public static int[][] NodesAnalysis2 = new int[1000000][2];
// v0.990 Move 4 changes
// These variables cannot be activated.
// If they are activated, the program does not start.
// (a memory limitation problem?)
//		public static int[][] NodesAnalysis3 = new int[10000000][2];
//		public static int[][] NodesAnalysis4 = new int[100000000][2]; // Increased depth => Increased size (logical...)

//		public static String[] NodesAnalysis0_Move = new String[1000000]; //v0.990
//		public static String[] NodesAnalysis1_Move = new String[1000000]; //v0.990
//		public static String[] NodesAnalysis2_Move = new String[1000000]; //v0.990
//																		   //public static String[] NodesAnalysis3_Move = new String[1000000];  //v0.990
//																		   //public static String[] NodesAnalysis4_Move = new String[1000000];  //v0.990
//		public static String[][][] NodesAnalysis0_Chessboard = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis1_Chessboard = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis2_Chessboard = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis2_Chessboard_2 = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis4_Chessboard_4 = new String[8][8][1000000]; //v0.990
//																						   //public static String[,,] NodesAnalysis3_Chessboard = new String[8, 8, 1000000];  //v0.990
//																						   //public static String[,,] NodesAnalysis4_Chessboard = new String[8, 8, 1000000];  //v0.990
//		public static String[][][] NodesAnalysis0_Chessboard_before = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis1_Chessboard_before = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis2_Chessboard_before = new String[8][8][1000000]; //v0.990
//																								//public static String[,,] NodesAnalysis3_Chessboard_before = new String[8, 8, 1000000];  //v0.990
                                                                                                                                                                                //public static String[,,] NodesAnalysis4_Chessboard_before = new String[8, 8, 1000000];  //v0.990
                                                                                                                                                                                //public static int[,] NodesAnalysis3 = new int[1000000, 2];

public static int Nodes_Total_count;
public static int NodeLevel_0_count;
public static int NodeLevel_1_count;
public static int NodeLevel_2_count;
public static int NodeLevel_3_count;
public static int NodeLevel_4_count;
public static int NodeLevel_5_count;
public static int NodeLevel_6_count;

// If Hu eats a piece, then make the square a preferred target!!!
public static int Human_last_move_target_column;
public static int Human_last_move_target_row;

// The chessboard (=skakiera in Greek)
public static String[][] Skakiera = new String[8][8]; // Î”Î®Î»Ï‰ÏƒÎ· Ï€Î¯Î½Î±ÎºÎ± Ï€Î¿Ï… Î±Î½Ï„Î¹Ï€ÏÎ¿ÏƒÏ‰Ï€ÎµÏÎµÎ¹ Ï„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±
public static String[][] Skakiera_Thinking_init = new String[8][8];

// Variable which determines of the program will show the inner
// thinking process of the AI. Good for educational purposes!!!
// UNCOMMENT TO SHOW INNER THINKING MECHANISM!
//bool huo_debug;

// Arrays to use in ComputerMove function
// Penalty for moving the only piece that defends a square to that square (thus leavind the defender
// alone in the square he once defended, defenceless!)
// This penalty is also used to indicate that the computer loses its Queen with the move analyzed
//v0.980: Removed. It wa not used.
//public static bool Danger_penalty;

//public static String m_PlayerColor;
//v0.980
//public static String m_ComputerLevel = "Kakos";
//public static String m_WhoPlays;
public static String m_WhichColorPlays;
public static String MovingPiece;

// Variable to store temporarily the piece that is moving
public static String ProsorinoKommati;
//public static String ProsorinoKommati_KingCheck;

// Variables to check the legality of the move
//public static boolean exit_elegxos_nomimothtas = false;
//public static int h;
//public static int p;
//public static int how_to_move_Rank;
//public static int how_to_move_Column;

public static boolean KingCheck = false;

// Coordinates of the starting square of the move
public static String m_StartingColumn;
public static int m_StartingRank;
public static String m_FinishingColumn;
public static int m_FinishingRank;

// Variable for en passant moves
//public static boolean enpassant_occured;

// Move number
public static int Move;
//v0.980
public static int number_of_moves_analysed;

// Variable to show if promotion of a pawn occured
public static boolean Promotion_Occured = false;

// Variable to show if castrling occured
public static boolean Castling_Occured = false;

// Variables to help find out if it is legal for the computer to perform castling
//v0.980: Removed all that code! It was not used anyway!
//public static bool White_King_Moved = false;
//public static bool Bl_King_Moved = false;
//public static bool White_Rook_a1_Moved = false;
//public static bool White_Rook_h1_Moved = false;
//public static bool Bl_Rook_a8_Moved = false;
//public static bool Bl_Rook_h8_Moved = false;
//v0.980: Removed unsused variables.
//public static bool Can_Castle_Big_White;
//public static bool Can_Castle_Big_Bl;
//public static bool Can_Castle_Small_White;
//public static bool Can_Castle_Small_Bl;

// If it possible to eat the queen of the opponent, go for it!
// v0.980: removed since it was not used
//public static bool go_for_it;

// Variables to show where the kings are in the chessboard
//public static int WhiteKingColumn;
//public static int WhiteKingRank;
//public static int BlKingColumn;
//public static int BlKingRank;

// Variables to show if king is in check
//public static boolean WhiteKingCheck;
//public static boolean BlackKingCheck;

// Variables to show if there is a possibility for mate
//public static bool WhiteMate = false;
//public static bool BlMate = false;
//public static bool Mate;

// Variable to show if a move is found for the H/Y to do
public static boolean Best_Move_Found;

// Variables to help find if a king is under check.
// (see CheckForWhiteCheck and CheckForBlackCheck functions)
//public static boolean DangerFromRight;
//public static boolean DangerFromLeft;
//public static boolean DangerFromUp;
//public static boolean DangerFromDown;
//public static boolean DangerFromUpRight;
//public static boolean DangerFromDownRight;
//public static boolean DangerFromUpLeft;
//public static boolean DangerFromDownLeft;

// Initial coordinates of the two kings
// (see CheckForWhiteCheck and CheckForBlackCheck functions)
public static int StartingWhiteKingColumn;
public static int StartingWhiteKingRank;
public static int StartingBlKingColumn;
public static int StartingBlKingRank;

// Volumn number inserted by the user
public static int m_StartingColumnNumber;
public static int m_FinishingColumnNumber;

///////////////////////////////////////////////////////////////////////////////////////////////////
// ÎœÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ Î³Î¹Î± Ï„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿ Ï„Î·Ï‚ "Î¿ÏÎ¸ÏŒÏ„Î·Ï„Î±Ï‚" ÎºÎ±Î¹ Ï„Î·Ï‚ "Î½Î¿Î¼Î¹Î¼ÏŒÏ„Î·Ï„Î±Ï‚" Î¼Î¹Î±Ï‚ ÎºÎ¯Î½Î·ÏƒÎ·Ï‚ Ï„Î¿Ï… Ï‡ÏÎ®ÏƒÏ„Î·
// Variables to check the correctess (Î¿ÏÎ¸ÏŒÏ„Î·Ï„Î±) and the legality (Î½Î¿Î¼Î¹Î¼ÏŒÏ„Î·Ï„Î±) of the moves
///////////////////////////////////////////////////////////////////////////////////////////////////

// Variable for the correctness of the move
public static boolean m_OrthotitaKinisis;
// Variable for the legality of the move
public static boolean m_NomimotitaKinisis;
// Has the user entered a wrong column?
//public static boolean m_WrongColumn;

// Variables for 'For' loops
public static int i;
public static int j;

// User choices
public static int ApophasiXristi = 1;
public static int choise_of_user;

//////////////////////////////////////
// Computer Thought
//////////////////////////////////////
// Chessboards used for the computer throught
public static String[][] Skakiera_Move_0 = new String[8][8]; // Î”Î®Î»Ï‰ÏƒÎ· Ï€Î¯Î½Î±ÎºÎ± Ï€Î¿Ï… Î±Î½Ï„Î¹Ï€ÏÎ¿ÏƒÏ‰Ï€ÎµÏÎµÎ¹ Ï„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±
public static String[][] Skakiera_Move_After = new String[8][8];
public static String[][] Skakiera_Thinking = new String[8][8];
public static String[][] Skakiera_CM_Check = new String[8][8];
// Rest of variables used for computer thought
//public static double Best_Move_Score;
public static int Current_Move_Score;
//public static int Best_Move_StartingColumnNumber;
//public static int Best_Move_FinishingColumnNumber;
//public static int Best_Move_StartingRank;
//public static int Best_Move_FinishingRank;
public static int Move_Analyzed;
public static boolean Stop_Analyzing;
public static int Thinking_Depth;
public static int m_StartingColumnNumber_HY;
public static int m_FinishingColumnNumber_HY;
public static int m_StartingRank_HY;
public static int m_FinishingRank_HY;
public static boolean First_Call;
public static String Who_Is_Analyzed;
public static String MovingPiece_HY;

// For writing the computer move
public static String HY_Starting_Column_Text;
public static String HY_Finishing_Column_Text;

// Variables which help find the best move of the Hu-opponent during the HY thought analysis
//v0.980 removed
//public static bool First_Call_Human_Thought;
//public static String MovingPiece_Human = "";
//public static int m_StartingColumnNumber_Human = 1;
//public static int m_FinishingColumnNumber_Human = 1;
//public static int m_StartingRank_Human = 1;
//public static int m_FinishingRank_Human = 1;

// Coordinates of the square Where the player can perform en passant
public static int enpassant_possible_target_rank;
public static int enpassant_possible_target_column;

//v0.980: Removed unused variables
// Is there a possible mate?
//public static bool Human_is_in_check;
//public static bool Possible_mate;

// Does the HY moves its King with the move it is analyzing?
//public static bool moving_the_king;

///////////////////////////////////////////////////////////////////////////////////////////////////
// END OF VARIABLES DECLARATION
///////////////////////////////////////////////////////////////////////////////////////////////////


  public static void main(String[] args) {
   
   Thinking_Depth = 2;
   
   // Ask for the color the player wants to play with
   System.out.println("Huo Chess v0.991 by Spiros Kakos");
   System.out.println("Please choose color (w/b)");
   m_PlayerColor = reader.next();
   //m_PlayerColor = reader.next();
   
   // Print the choice of the player
   // System.out.println("Your choice: " + m_PlayerColor);
   // Transform w and b to White and Black and print again (not needed, just to show how the if command works)
   if (m_PlayerColor.equals("w"))
      System.out.println("Your color : " + "White");
   else if (m_PlayerColor.equals("b"))
      System.out.println("Your color : " + "Black");
   else
      System.out.println("Invalid choice");
   
   if (m_PlayerColor.equals("w"))
   {
    // Human player plays
    m_WhoPlays = "human";
    // Call the function which sets up the initial position
    startingPosition();
    // Call the function which draws the position
    drawPosition();
    // Call the function which asks from the user to enter his move
    EnterMove();
   }
 
   if (m_PlayerColor.equals("b"))
   {
    // Call the function which sets up the initial position
    startingPosition();
    // Call the function to start the computer thinking
    Move_Analyzed = 0;
    Stop_Analyzing = false;
    First_Call = true;
    Best_Move_Found = false;
    Who_Is_Analyzed = "HY";
    m_WhichColorPlays = "White";
    ComputerMove(Skakiera);
   }
   
  }
  
  // Function which sets up the initial chessboard position
  public static void startingPosition() {
  
  // Note that chessboard ranks and columns numbers start from 0
  // i = Column (starting from 0)
  // j = Rank (starting from 0)
  
  for (int i = 7; i > -1; i--)
  {
    for (int j = 7; j > -1; j--)
    {
      // Clear the chessboard
      Skakiera[i][j] = "";
    }
  }
  
    // Put the pieces in the chessboard (e.g. WR for White Rook)
    Skakiera[0][0] = "WR";
    Skakiera[0][1] = "WP";
    Skakiera[1][0] = "WN";
    Skakiera[1][1] = "WP";
    Skakiera[2][0] = "WB";
    Skakiera[2][1] = "WP";
    Skakiera[3][0] = "WQ";
    Skakiera[3][1] = "WP";
    Skakiera[4][0] = "WK";
    Skakiera[4][1] = "WP";
    Skakiera[5][0] = "WB";
    Skakiera[5][1] = "WP";
    Skakiera[6][0] = "WN";
    Skakiera[6][1] = "WP";
    Skakiera[7][0] = "WR";
    Skakiera[7][1] = "WP";
    // Put the black pieces as well
    Skakiera[0][7] = "BR";
    Skakiera[0][6] = "BP";
    Skakiera[1][7] = "BN";
    Skakiera[1][6] = "BP";
    Skakiera[2][7] = "BB";
    Skakiera[2][6] = "BP";
    Skakiera[3][7] = "BQ";
    Skakiera[3][6] = "BP";
    Skakiera[4][7] = "BK";
    Skakiera[4][6] = "BP";
    Skakiera[5][7] = "BB";
    Skakiera[5][6] = "BP";
    Skakiera[6][7] = "BN";
    Skakiera[6][6] = "BP";
    Skakiera[7][7] = "BR";
    Skakiera[7][6] = "BP";
  }
  
  // Function to draw the chessboard position
  // It simply prints the pieces, nothing fancy
  public static void drawPosition() {
      
  // Transform chessboard to the drawChessBoard
  // by adding spaces in the empty squares.
  // This allows the program to draw a decent chessboard.
  for (int i = 0; i < 8; i++)
  {
    for (int j = 0; j < 8; j++)
    {
        if (!Skakiera[i][j].equals(""))
            drawChessBoard[i][j] = Skakiera[i][j];
        else if (Skakiera[i][j].equals(""))
            drawChessBoard[i][j] = "  ";
    }
  }
  // Print an empty line to separate the printed chessboard from the previous text in the screen
  System.out.println("");
  
  // Print one rank at a time
  //for (int i = 7; i > -1; i--)
  //{
  //    System.out.println(
  //    "[" + Skakiera[0][i] + "]" +
  //    "[" + Skakiera[1][i] + "]" +
  //    "[" + Skakiera[2][i] + "]" +
  //    "[" + Skakiera[3][i] + "]" +
  //    "[" + Skakiera[4][i] + "]" +
  //    "[" + Skakiera[5][i] + "]" +
  //    "[" + Skakiera[6][i] + "]" +
  //    "[" + Skakiera[7][i] + "]" 
  //    );
  //}
  
  System.out.println(
      "-------------------------");
      
    // Print one rank at a time
  for (int i = 7; i > -1; i--)
  {
      System.out.println(
      "|" + drawChessBoard[0][i] +
      "|" + drawChessBoard[1][i] +
      "|" + drawChessBoard[2][i] +
      "|" + drawChessBoard[3][i] +
      "|" + drawChessBoard[4][i] +
      "|" + drawChessBoard[5][i] +
      "|" + drawChessBoard[6][i] +
      "|" + drawChessBoard[7][i] + "|" 
      );
      
      System.out.println(
      "-------------------------");
  }
  
  
  }
  
   // Function which asks for the user to enter his move  
  public static void EnterMove() {
   System.out.println("");
   System.out.println("Enter move (e.g. c2c4) and press Enter. Enter 'q' to quit.");
   // Read the move the user inputs
   playerMove = reader.next();
   
   // Break the move entered in starting and finishing columns and ranks
   startingColumn = Character.toString( playerMove.charAt(0) );
   startingRank = Character.toString( playerMove.charAt(1) );
   finishingColumn = Character.toString( playerMove.charAt(2) );
   finishingRank = Character.toString( playerMove.charAt(3) );
  
   if(playerMove.equals("q"))
       System.exit(0);
   
   System.out.println("Move : " + startingColumn + startingRank + " -> " + finishingColumn + finishingRank);
   
  // Convert characters to numbers for the program to be able to process them
  startingRankNum = Integer.valueOf(startingRank);
  
  finishingRankNum = Integer.valueOf(finishingRank);
  
  switch (startingColumn)
  {
    case "a":
        startingColumnNum = 1; break;
    case "b":
        startingColumnNum = 2; break;
    case "c":
        startingColumnNum = 3; break;
    case "d":
        startingColumnNum = 4; break;
    case "e":
        startingColumnNum = 5; break;
    case "f":
        startingColumnNum = 6; break;
    case "g":
        startingColumnNum = 7; break;
    case "h":
        startingColumnNum = 8; break;
  }
  
  switch (finishingColumn)
  {
    case "a":
        finishingColumnNum = 1; break;
    case "b":
        finishingColumnNum = 2; break;
    case "c":
        finishingColumnNum = 3; break;
    case "d":
        finishingColumnNum = 4; break;
    case "e":
        finishingColumnNum = 5; break;
    case "f":
        finishingColumnNum = 6; break;
    case "g":
        finishingColumnNum = 7; break;
    case "h":
        finishingColumnNum = 8; break;
  }
 
  // Store the moving piece in the relative variable
  movingPiece = Skakiera[(startingColumnNum-1)][(startingRankNum-1)];
  System.out.println("Piece: " + movingPiece);
  System.out.println("Move : " + startingColumnNum + startingRankNum + " -> " + finishingColumnNum + finishingRankNum);
  //movingPiece = Skakiera[(startingRankNum-1)][(startingColumnNum-1)];
  
  // Just a test to show how if statement is working
  //   if ((startingRankNum == finishingRankNum) || (startingColumnNum == finishingColumnNum))
  //      System.out.println("Test 1!");
  
  // Call the function which checks for move legality.
  // There result of the check will be returned to the variable moveLegality
  // The parameters passed over to the function are the starting and finishing ranks and columns plus the moving piece
  m_WhoPlays = "Human";
  m_WrongColumn = false;
  // Call the function which checks the move's legality
//  startingRankNum = startingRankNum + 1;
//  startingColumnNum = startingColumnNum + 1;
//  finishingRankNum = finishingRankNum + 1;
//  finishingColumnNum = finishingColumnNum + 1;
  moveValidity = ElegxosOrthotitas(Skakiera, 0, startingRankNum, startingColumnNum, finishingRankNum, finishingColumnNum, movingPiece);
  moveLegality = ElegxosNomimotitas(Skakiera, 0, startingRankNum, startingColumnNum, finishingRankNum, finishingColumnNum, movingPiece);
  
  if ((moveValidity == true) && (moveLegality == true))
  {
      System.out.println("Valid move");
      // Do the move
      Skakiera[(finishingColumnNum-1)][(finishingRankNum-1)] = movingPiece;
      Skakiera[(startingColumnNum-1)][(startingRankNum-1)] = "";
      // Draw the chessboard
      drawPosition();
      
      // Call the function to start the computer thinking
    Move_Analyzed = 0;
    Stop_Analyzing = false;
    First_Call = true;
    Best_Move_Found = false;
    Who_Is_Analyzed = "HY";
    m_WhichColorPlays = "Black";
    ComputerMove(Skakiera);
  }
  else
  {
      System.out.println("Wrong move!");
  }
}
  
  			public static void CheckMove(String[][] CMSkakiera, int m_StartingRankCM, int m_StartingColumnNumberCM, int m_FinishingRankCM, int m_FinishingColumnNumberCM, String MovingPieceCM)
			{
				///#region WriteLog
				//huo_sw1.WriteLine("");
				//huo_sw1.WriteLine("ChMo -- Entered CheckMove");
				//huo_sw1.WriteLine(string.Concat("ChMo -- Depth analyzed: ", Move_Analyzed.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of moves analyzed: ", number_of_moves_analysed.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Move analyzed: ", m_StartingColumnNumber_HY.ToString(), m_StartingRank_HY.ToString(), " -> ", m_FinishingColumnNumber_HY.ToString(), m_FinishingRank_HY.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 0: ", NodeLevel_0_count.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 1: ", NodeLevel_1_count.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 2: ", NodeLevel_2_count.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 3: ", NodeLevel_3_count.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 4: ", NodeLevel_4_count.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 5: ", NodeLevel_5_count.ToString()));
				//huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 6: ", NodeLevel_6_count.ToString()));
				//huo_sw1.WriteLine("");
				///#endregion WriteLog

				String ProsorinoKommatiCM;

				for (int iii = 0; iii <= 7; iii++)
				{
					for (int jjj = 0; jjj <= 7; jjj++)
					{
						Skakiera_CM_Check[iii][jjj] = CMSkakiera[(iii)][(jjj)];
					}
				}

				number_of_moves_analysed++;

				m_WhoPlays = "Human";
				m_WrongColumn = false;

				// Check correctness of move
				m_OrthotitaKinisis = ElegxosOrthotitas(CMSkakiera, 0, m_StartingRankCM, m_StartingColumnNumberCM, m_FinishingRankCM, m_FinishingColumnNumberCM, MovingPieceCM);
				// if move is correct, then check the legality also
				if (m_OrthotitaKinisis == true)
				{
					m_NomimotitaKinisis = ElegxosNomimotitas(CMSkakiera, 0, m_StartingRankCM, m_StartingColumnNumberCM, m_FinishingRankCM, m_FinishingColumnNumberCM, MovingPieceCM);
				}

				// Restore the normal value of the m_WhoPlays
				m_WhoPlays = "HY";

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#region CheckCheck

				// Temporarily move the piece to see if the king will continue to be under check
				Skakiera_CM_Check[(m_StartingColumnNumberCM - 1)][(m_StartingRankCM - 1)] = "";
				ProsorinoKommatiCM = Skakiera_CM_Check[(m_FinishingColumnNumberCM - 1)][(m_FinishingRankCM - 1)];
				// Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î® Î±Ï€Î¿Î¸Î®ÎºÎµÏ…ÏƒÎ· Ï„Î¿Ï… ÎºÎ¿Î¼Î¼Î±Ï„Î¹Î¿Ï Ï€Î¿Ï… Î²ÏÎ¯ÏƒÎºÎµÏ„Î±Î¹ ÏƒÏ„Î¿ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ Ï€ÏÎ¿Î¿ÏÎ¹ÏƒÎ¼Î¿Ï
				// (Î²Î». Î¼ÎµÏ„Î¬ Î³Î¹Î± Ï„Î· Ï‡ÏÎ·ÏƒÎ¹Î¼ÏŒÏ„Î·Ï„Î± Ï„Î¿Ï…, ÎµÎºÎµÎ¯ Ï€Î¿Ï… Î³Î¯Î½ÎµÏ„Î±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡).
				Skakiera_CM_Check[(m_FinishingColumnNumberCM - 1)][(m_FinishingRankCM - 1)] = MovingPieceCM;

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#region Remove
				//v0.990: Need to check again the dangerous squares? The computer might attempt to move
				//        his piece to a square where the moving piece was the only defender!
				//v0.990 change: The dangerous squares must be checked AGAIN after the move!
				//The moving piece might be moving into a dangerous square!
				//v0.990 change: Added this section here!
				/*
				#region DangerousSquares

				Danger_for_piece = false;

				for (int o1 = 0; o1 <= 7; o1++)
				{
				    for (int p1 = 0; p1 <= 7; p1++)
				    {
				        //v0.980: Change small Strings to Int
				        Skakiera_Dangerous_Squares_2[(o1), (p1)] = 0;
				    }
				}

				// Find attackers-defenders
				FindAttackers(CMSkakiera);
				FindDefenders(CMSkakiera);

				// Determine dangerous squares
				for (int o1 = 0; o1 <= 7; o1++)
				{
				    for (int p1 = 0; p1 <= 7; p1++)
				    {
				        //v0.990 debug
				        //MessageBox.Show(String.Concat("Number of attackers for ", (o1 + 1).ToString(), (p1 + 1).ToString(), " : ", Number_of_attackers[o1, p1].ToString()));
				        //MessageBox.Show(String.Concat("Number of defenders for ", (o1 + 1).ToString(), (p1 + 1).ToString(), " : ", Number_of_defenders[o1, p1].ToString()));

				        //v0.990 change: Changed ">" to ">="
				        if (Number_of_attackers[o1, p1] >= Number_of_defenders[o1, p1])
				            //if (Number_of_attackers[o1, p1] > Number_of_defenders[o1, p1])
				            //v0.980: Change small Strings to Int
				            Skakiera_Dangerous_Squares_2[(o1), (p1)] = 1;
				    }
				}
				#endregion DangerousSquares

				if(Skakiera_Dangerous_Squares_2[(m_FinishingColumnNumberCM - 1), (m_FinishingRankCM - 1)] == 1)
				    m_NomimotitaKinisis = false;
				*/
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#endregion Remove

				//////////////////////////////////////////////////////////////////////////
				// is the king still under check?
				//////////////////////////////////////////////////////////////////////////

				//v0.990
				WhiteKingCheck = CheckForWhiteCheck(Skakiera_CM_Check);
				//WhiteKingCheck = CheckForWhiteCheck(CMSkakiera);

				if ((m_WhichColorPlays.equals("White")) && (WhiteKingCheck == true))
				{
					m_NomimotitaKinisis = false;
				}

				///////////////////////////////////////////////////////////////////////////
				// is the black king under check?
				///////////////////////////////////////////////////////////////////////////

				//v0.990
				//BlackKingCheck = CheckForBlackCheck(CMSkakiera);
				BlackKingCheck = CheckForBlackCheck(Skakiera_CM_Check);

				if ((m_WhichColorPlays.equals("Black")) && (BlackKingCheck == true))
				{
					m_NomimotitaKinisis = false;
				}

				// Restore pieces to their initial positions
				// CMSkakiera[(m_StartingColumnNumberCM - 1), (m_StartingRankCM - 1)] = MovingPieceCM;
				// CMSkakiera[(m_FinishingColumnNumberCM - 1), (m_FinishingRankCM - 1)] = ProsorinoKommatiCM;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#endregion CheckCheck

				//v0.990: Removed! This is already done in ComputerMove!
				/*
				if (((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true)) && (Move_Analyzed == 0))
				{
				    // Store the move to ***_HY variables (because after continuous calls of ComputerMove the initial move under analysis will be lost...)

				    MovingPiece_HY = MovingPiece;
				    m_StartingColumnNumber_HY = m_StartingColumnNumber;
				    m_FinishingColumnNumber_HY = m_FinishingColumnNumber;
				    m_StartingRank_HY = m_StartingRank;
				    m_FinishingRank_HY = m_FinishingRank;

				    // Store the initial move coordinates (at the node 0 level)
				    NodesAnalysis0[NodeLevel_0_count, 2] = m_StartingColumnNumber_HY;
				    NodesAnalysis0[NodeLevel_0_count, 3] = m_FinishingColumnNumber_HY;
				    NodesAnalysis0[NodeLevel_0_count, 4] = m_StartingRank_HY;
				    NodesAnalysis0[NodeLevel_0_count, 5] = m_FinishingRank_HY;

				    // Check is HY eats the opponents queen (so it is preferable to do so...)
				    // Not operational yet...
				    //if ((ProsorinoKommati.equals("WQ")) || (ProsorinoKommati.equals("BQ")))
				    //    go_for_it = true;
				    // v0.970: Danger penalty now checked directly in ComputerMove
				}
				*/

			}

  
public static void ComputerMove(String[][] Skakiera_Thinking_init)
{
        // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
        // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
        int bestScoreLevel0 = 0;
        //V0.990: Initialized the values
        int iii = 0;
        int jjj = 0;
        Temp_Score_Move_0 = 0;
        Temp_Score_Move_1_human = 0;
        Temp_Score_Move_2 = 0;
        Human_last_move_target_column = 0;
        Human_last_move_target_row = 0;
        MovingPiece = "";
        ProsorinoKommati = "";
        exit_elegxos_nomimothtas = false;
        First_Call = true;
        h = 0;
        p = 0;
        WhiteKingColumn = 0;
        WhiteKingRank = 0;
        BlKingColumn = 0;
        BlKingRank = 0;
        DangerFromUp = false;
        m_OrthotitaKinisis = false;
        m_NomimotitaKinisis = false;
        i = 0;
        j = 0;
        Current_Move_Score = 0;
        Best_Move_FinishingColumnNumber = 0;
        Best_Move_FinishingRank = 0;
        Best_Move_StartingColumnNumber = 0;
        Best_Move_StartingRank = 0;
        Stop_Analyzing = true;
        m_StartingColumnNumber_HY = 0;
        m_StartingRank_HY = 0;
        m_FinishingColumnNumber_HY = 0;
        m_FinishingRank_HY = 0;
        enpassant_possible_target_column = 0;
        //First_Caenpassant_possible_target_rankll = 0;
        //v0.990: Removed the "0" variables.
        //String MovingPiece;
        //String ProsorinoKommati0;
        //int m_StartingColumnNumber;
        //int m_FinishingColumnNumber;
        //int m_StartingRank;
        //int m_FinishingRank;

        //v0.990
        String[][] Skakiera_Move_After_0 = new String[8][8];

        // If there is a possibility to eat back what was eaten, then go for it!
        possibility_to_eat_back = false;
        possibility_to_eat = false;

        ///#region InitializeNodes
        // START [MiniMax algorithm - skakos]
        NodeLevel_0_count = 0;
        NodeLevel_1_count = 0;
        NodeLevel_2_count = 0;
        //v0.980: Removed unwanted nodes (+total nodes)
        //NodeLevel_3_count = 0;
        //NodeLevel_4_count = 0;
        Nodes_Total_count = 0;

        //v0.990 Added initialization of variables
        ValueOfHumanMovingPiece = 0;
        ValueOfMovingPiece = 0;

        //0.970
        for (int dimension1 = 0; dimension1 < 1000000; dimension1++)
        {
                for (int dimension2 = 0; dimension2 < 6; dimension2++)
                {
                        NodesAnalysis0[dimension1][dimension2] = 0;
                }
        }

        for (int dimension1 = 0; dimension1 < 1000000; dimension1++)
        {
                for (int dimension2 = 0; dimension2 < 2; dimension2++)
                {
                        NodesAnalysis1[dimension1][dimension2] = 0;
                        NodesAnalysis2[dimension1][dimension2] = 0;
                        //NodesAnalysis3[dimension1, dimension2] = 0;
                }
        }

        // Store the initial position in the chessboard
        for (iii = 0; iii <= 7; iii++)
        {
                for (jjj = 0; jjj <= 7; jjj++)
                {
                        Skakiera_Thinking[iii][jjj] = Skakiera_Thinking_init[(iii)][(jjj)];
                        Skakiera_Move_0[(iii)][(jjj)] = Skakiera_Thinking_init[(iii)][(jjj)];
                }
        }

        // CHECK IF POSITION IS IN THE OPENING BOOK - Removed in v0.980

        // CHECK FOR DANGEROUS SQUARES
        // Also find number and value of attackers and defenders for each square of the chessboard: will be used below to determine if the move is stupid
        Danger_for_piece = false;

        for (int o1 = 0; o1 <= 7; o1++)
        {
                for (int p1 = 0; p1 <= 7; p1++)
                {
                        //v0.980: Change small Strings to Int
                        Skakiera_Dangerous_Squares[(o1)][(p1)] = 0;
                        //v0.990 test. Added initialization. By adding it it makes the computer not wanting to eat the bishop.
                        Value_of_defenders[(o1)][(p1)] = 0;
                        Value_of_attackers[(o1)][(p1)] = 0;
                        //v0.990: Added also these initializations! Let's see what happens now...
                        //        I had forgot those! Could this be the reason the HY did not
                        //        want to eat the bishop?
                        Number_of_defenders[(o1)][(p1)] = 0;
                        Number_of_attackers[(o1)][(p1)] = 0;
                }
        }

        // Find attackers-defenders
        FindAttackers(Skakiera_Thinking);
        FindDefenders(Skakiera_Thinking);

        // Determine dangerous squares
        for (int o1 = 0; o1 <= 7; o1++)
        {
                for (int p1 = 0; p1 <= 7; p1++)
                {
                        //The case where the only defender is the moving piece can only be captured 
                        //in the CheckMove function!
                        if (Number_of_attackers[o1][p1] > Number_of_defenders[o1][p1])
                        {
                                //v0.980: Change small Strings to Int
                                Skakiera_Dangerous_Squares[(o1)][(p1)] = 1;
                        }
                }
        }

        ///#endregion DangerousSquares

        // v0.990
        // Check if HY is currently under check
        ThereIsCheck = false;

        if (m_PlayerColor.equals("w"))
        {
                ThereIsCheck = CheckForBlackCheck(Skakiera_Thinking);
        }
        else if (m_PlayerColor.equals("b"))
        {
                ThereIsCheck = CheckForBlackCheck(Skakiera_Thinking);
        }

        //---------------------------------------
        // CHECK ALL POSSIBLE MOVES!
        //---------------------------------------

        for (iii = 0; iii <= 7; iii++)
        {
                for (jjj = 0; jjj <= 7; jjj++)
                {
                        //v0.980: Reduce all texts ("WK" for "Wh King", "WN" for "Wh Knight" and so on...)
                        if (((Who_Is_Analyzed.equals("HY")) && ((((Skakiera_Thinking[(iii)][(jjj)].equals("WK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("White Rook")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Thinking[(iii)][(jjj)].equals("BK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BR")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BP"))) && (m_PlayerColor.equals("w"))))) || ((Who_Is_Analyzed.equals("Hu")) && ((((Skakiera_Thinking[(iii)][(jjj)].equals("WK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("White Rook")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WP"))) && (m_PlayerColor.equals("w"))) || (((Skakiera_Thinking[(iii)][(jjj)].equals("BK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BR")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BP"))) && (m_PlayerColor.equals("b"))))))
                        {

                                for (int w = 0; w <= 7; w++)
                                {
                                        for (int r = 0; r <= 7; r++)
                                        {
                                                //v0.980: Removed. It was not used.
                                                //Danger_penalty = false;
                                                MovingPiece = Skakiera_Thinking[(iii)][(jjj)];
                                                m_StartingColumnNumber = iii + 1;
                                                m_FinishingColumnNumber = w + 1;
                                                m_StartingRank = jjj + 1;
                                                m_FinishingRank = r + 1;

                                                // Store temporary move data in local variables, so as to use them in the Undo of the move
                                                // at the end of this function (the MovingPiece, m_StartingColumnNumber, etc variables are
                                                // changed by next functions as well, so using them leads to problems)
                                                // ProsorinoKommati = Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)];

                                                // Check for stupid moves in the start of the game
                                                ThisIsStupidMove = "N";

                                                if (Move < 5)
                                                {
                                                        if ((MovingPiece.equals("WQ")) || (MovingPiece.equals("BQ")) || (MovingPiece.equals("White Rook")) || (MovingPiece.equals("BR")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if (((MovingPiece.equals("WN")) || (MovingPiece.equals("BN"))) && (m_FinishingColumnNumber == 1))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if (((MovingPiece.equals("WN")) || (MovingPiece.equals("BN"))) && (m_FinishingColumnNumber == 8))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WN")) && (m_FinishingRank == 2) && (m_FinishingColumnNumber == 4) && (Skakiera_Thinking[(2)][(0)].equals("WB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WN")) && (m_FinishingRank == 2) && (m_FinishingColumnNumber == 5) && (Skakiera_Thinking[(5)][(0)].equals("WB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BN")) && (m_FinishingRank == 7) && (m_FinishingColumnNumber == 4) && (Skakiera_Thinking[(2)][(7)].equals("BB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BN")) && (m_FinishingRank == 7) && (m_FinishingColumnNumber == 5) && (Skakiera_Thinking[(5)][(7)].equals("BB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WP")) && ((m_StartingColumnNumber == 1) || (m_StartingColumnNumber == 2)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WP")) && ((m_StartingColumnNumber == 7) || (m_StartingColumnNumber == 8)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BP")) && ((m_StartingColumnNumber == 1) || (m_StartingColumnNumber == 2)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BP")) && ((m_StartingColumnNumber == 7) || (m_StartingColumnNumber == 8)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WK")) || (MovingPiece.equals("BK")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if (((MovingPiece.equals("WB")) || (MovingPiece.equals("BB"))) && ((m_FinishingRank == 3) || (m_FinishingRank == 5) || (m_FinishingRank == 6)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                }

                                                // v0.970
                                                // Store the value of the moving piece
                                                if ((MovingPiece.equals("White Rook")) || (MovingPiece.equals("BR")))
                                                {
                                                        ValueOfMovingPiece = 5;
                                                }
                                                if ((MovingPiece.equals("WN")) || (MovingPiece.equals("BN")))
                                                {
                                                        ValueOfMovingPiece = 3;
                                                }
                                                if ((MovingPiece.equals("WB")) || (MovingPiece.equals("BB")))
                                                {
                                                        ValueOfMovingPiece = 3;
                                                }
                                                if ((MovingPiece.equals("WQ")) || (MovingPiece.equals("BQ")))
                                                {
                                                        ValueOfMovingPiece = 9;
                                                }
                                                if ((MovingPiece.equals("WK")) || (MovingPiece.equals("BK")))
                                                {
                                                        ValueOfMovingPiece = 119;
                                                }
                                                if ((MovingPiece.equals("WP")) || (MovingPiece.equals("BP")))
                                                {
                                                        ValueOfMovingPiece = 1;
                                                }

                                                // If a pieve of lower value attacks the square where the computer moves, then... stupid move!
                                                if ((Number_of_attackers[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] >= 1) && (Value_of_attackers[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] < ValueOfMovingPiece))
                                                {
                                                        ThisIsStupidMove = "Y";
                                                }

                                                //if ((ThisIsStupidMove.equals("N")) && (Skakiera_Dangerous_Squares[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] == 0))
                                                if ( 1 == 1 )
                                                {
                                                //if ((Skakiera_Dangerous_Squares[(m_FinishingColumnNumber - 1), (m_FinishingRank - 1)] == 0))
                                                        // THE HEART OF THE THINKING MECHANISM: Here the computer checks the moves

                                                        // Validity and legality of the move will be checked in CheckMove
                                                        // (plus some additional checks for possible mate etc)
                                                        CheckMove(Skakiera_Thinking, m_StartingRank, m_StartingColumnNumber, m_FinishingRank, m_FinishingColumnNumber, MovingPiece);
                                                        //CheckMove(Skakiera_Thinking);

                                                        //v0.980: Removed
                                                        //number_of_moves_analysed++;

                                                        if (((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true)) && (Move_Analyzed == 0))
                                                        {
                                                                // Store the move to ***_HY variables (because after continuous calls of ComputerMove the initial move under analysis will be lost...)

                                                                MovingPiece_HY = MovingPiece;
                                                                m_StartingColumnNumber_HY = m_StartingColumnNumber;
                                                                m_FinishingColumnNumber_HY = m_FinishingColumnNumber;
                                                                m_StartingRank_HY = m_StartingRank;
                                                                m_FinishingRank_HY = m_FinishingRank;

                                                                // Store the initial move coordinates (at the node 0 level)
                                                                NodesAnalysis0[NodeLevel_0_count][2] = m_StartingColumnNumber_HY;
                                                                NodesAnalysis0[NodeLevel_0_count][3] = m_FinishingColumnNumber_HY;
                                                                NodesAnalysis0[NodeLevel_0_count][4] = m_StartingRank_HY;
                                                                NodesAnalysis0[NodeLevel_0_count][5] = m_FinishingRank_HY;

                                                                Best_Move_Found = true;
                                                        }


                                                        // If everything is OK, then do the move and measure it's score
                                                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                                                        {
                                                                // Do the move
                                                                ProsorinoKommati = Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)];
                                                                Skakiera_Thinking[(m_StartingColumnNumber - 1)][(m_StartingRank - 1)] = "";
                                                                Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] = MovingPiece;

                                                                // v0.990
                                                                if ((MovingPiece.equals("White Rook")) || (MovingPiece.equals("BR")))
                                                                {
                                                                        ValueOfKommati = 5;
                                                                }
                                                                if ((MovingPiece.equals("WN")) || (MovingPiece.equals("BN")))
                                                                {
                                                                        ValueOfKommati = 3;
                                                                }
                                                                if ((MovingPiece.equals("WB")) || (MovingPiece.equals("BB")))
                                                                {
                                                                        ValueOfKommati = 3;
                                                                }
                                                                if ((MovingPiece.equals("WQ")) || (MovingPiece.equals("BQ")))
                                                                {
                                                                        ValueOfKommati = 9;
                                                                }
                                                                if ((MovingPiece.equals("WK")) || (MovingPiece.equals("BK")))
                                                                {
                                                                        ValueOfKommati = 119;
                                                                }
                                                                if ((MovingPiece.equals("WP")) || (MovingPiece.equals("BP")))
                                                                {
                                                                        ValueOfKommati = 1;
                                                                }

                                                                if ((ProsorinoKommati.equals("White Rook")) || (ProsorinoKommati.equals("BR")))
                                                                {
                                                                        ValueOfTargetPiece = 5;
                                                                }
                                                                if ((ProsorinoKommati.equals("WN")) || (ProsorinoKommati.equals("BN")))
                                                                {
                                                                        ValueOfTargetPiece = 3;
                                                                }
                                                                if ((ProsorinoKommati.equals("WB")) || (ProsorinoKommati.equals("BB")))
                                                                {
                                                                        ValueOfTargetPiece = 3;
                                                                }
                                                                if ((ProsorinoKommati.equals("WQ")) || (ProsorinoKommati.equals("BQ")))
                                                                {
                                                                        ValueOfTargetPiece = 9;
                                                                }
                                                                if ((ProsorinoKommati.equals("WK")) || (ProsorinoKommati.equals("BK")))
                                                                {
                                                                        ValueOfTargetPiece = 119;
                                                                }
                                                                if ((ProsorinoKommati.equals("WP")) || (ProsorinoKommati.equals("BP")))
                                                                {
                                                                        ValueOfTargetPiece = 1;
                                                                }

                                                                // Check the score after the computer move
                                                                Temp_Score_Move_0 = CountScore(Skakiera_Thinking);

                                                                // v0.990 change
                                                                // Store the best move score at this level
                                                                if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_0 > bestScoreLevel0))
                                                                {
                                                                        bestScoreLevel0 = Temp_Score_Move_0;
                                                                }
                                                                else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_0 < bestScoreLevel0))
                                                                {
                                                                        bestScoreLevel0 = Temp_Score_Move_0;
                                                                }

                                                                ///#region Eat
                                                                if (ValueOfKommati < ValueOfTargetPiece)
                                                                {
                                                                        Best_Move_StartingColumnNumber = m_StartingColumnNumber;
                                                                        Best_Move_StartingRank = m_StartingRank;
                                                                        Best_Move_FinishingColumnNumber = m_FinishingColumnNumber;
                                                                        Best_Move_FinishingRank = m_FinishingRank;

                                                                        possibility_to_eat = true;
                                                                }

                                                                ///#region EatBack
                                                                // v0.970: Check if you can eat back the piece of the Hu which moved!
                                                                if ((m_FinishingColumnNumber == Human_last_move_target_column) && (m_FinishingRank == Human_last_move_target_row) && (ValueOfMovingPiece <= ValueOfHumanMovingPiece))
                                                                {
                                                                        Best_Move_StartingColumnNumber = m_StartingColumnNumber;
                                                                        Best_Move_StartingRank = m_StartingRank;
                                                                        Best_Move_FinishingColumnNumber = m_FinishingColumnNumber;
                                                                        Best_Move_FinishingRank = m_FinishingRank;

                                                                        possibility_to_eat_back = true;
                                                                }

                                                                // v0.970: If you can eat back the piece of the Hu, then go for it and don't analyze!
                                                                // v0.990: Added the possibility_to_eat
                                                                if ((Move_Analyzed < Thinking_Depth) && (possibility_to_eat_back == false))
                                                                {
                                                                        Move_Analyzed = Move_Analyzed + 1;

                                                                        //v0.990
                                                                        String[][] Skakiera_Move_After_0_new = new String[8][8];

                                                                        for (i = 0; i <= 7; i++)
                                                                        {
                                                                                for (j = 0; j <= 7; j++)
                                                                                {
                                                                                        Skakiera_Move_After_0[(i)][(j)] = Skakiera_Thinking[(i)][(j)];
                                                                                        Skakiera_Move_After_0_new[(i)][(j)] = Skakiera_Thinking[(i)][(j)];
                                                                                }
                                                                        }

                                                                        //v0.980: removed
                                                                        Who_Is_Analyzed = "Human";
                                                                        //First_Call_Human_Thought = true;

                                                                        // Check Hu move (to find the best possible answer of the Hu
                                                                        // to the move currently analyzed by the HY Thought process)
                                                                        Analyze_Move_1_HumanMove(Skakiera_Move_After_0_new);
                                                                }

                                                                // Undo the move
                                                                Skakiera_Thinking[(m_StartingColumnNumber - 1)][(m_StartingRank - 1)] = MovingPiece;
                                                                Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] = ProsorinoKommati;

                                                                //v0.991: This should be done here
                                                                NodeLevel_0_count++;
                                                        }

                                                }

                                        }
                                }

                        }


                }
        }

        // v0.990
        //if (((WhiteKingCheck == true) || (BlackKingCheck == true)) && (Best_Move_Found == false))
        if ((ThereIsCheck == true) && (Best_Move_Found == false))
        {
                //v0.990
                System.out.println("Checkmate!");
                //Console.WriteLine("Checkmate!");
        }
        ///#endregion CheckIfMate

        // DO THE BEST MOVE FOUND
        // Analyze only if possibility to eat back is not true!!!
        // MessageBox.Show("Entered Best Move found area!");

        //v0.990 test: Add a log of the nodes
        //v0.990: Added the possibility_to_eat
        //v0.991: Removed possibility to eat! Why not think everything?
        if ((possibility_to_eat_back == false))
        {
                // MessageBox.Show("Entered checkpoint 1");
                // [MiniMax algorithm - skakos]
                // Find node 1 move with the best score via the MiniMax algorithm.
                // v0.990 Move 4 changes
                int counter0, counter1, counter2, counter3, counter4; // v0.980: Remove unsued counter3,4. counter3, counter4, counter5, counter6, counter7, counter8, counter9, counter10;

                // ------------------------------------------------------
                // NodesAnalysis
                // ------------------------------------------------------
                // Nodes structure...
                // [ccc, xxx, 0]: Score of node No. ccc at level xxx
                // [ccc, xxx, 1]: Parent of node No. ccc at level xxx-1

                //v0.980: Remove
                int parentNodeAnalyzed = -999;

                // v0.991: Start from 0!
                // v0.991: Use "counter2 < NodeLevel_2_count" instead of "counter2 <= NodeLevel_2_count"!
                for (counter2 = 0; counter2 < NodeLevel_2_count; counter2++)
                {
                        if (NodesAnalysis2[counter2][1] != parentNodeAnalyzed)
                        {
                                //parentNodeAnalyzedchanged = true;
                                parentNodeAnalyzed = NodesAnalysis2[counter2][1];
                                NodesAnalysis1[NodesAnalysis2[counter2][1]][0] = NodesAnalysis2[counter2][0];
                        }

                        if (m_PlayerColor.equals("w"))
                        {
                            if (NodesAnalysis2[counter2][0] <= NodesAnalysis1[NodesAnalysis2[counter2][1]][0])
                            {
                                    NodesAnalysis1[NodesAnalysis2[counter2][1]][0] = NodesAnalysis2[counter2][0];
                            }
                        }
                        else if (m_PlayerColor.equals("b"))
                        {
                            if (NodesAnalysis2[counter2][0] >= NodesAnalysis1[NodesAnalysis2[counter2][1]][0])
                            {
                                    NodesAnalysis1[NodesAnalysis2[counter2][1]][0] = NodesAnalysis2[counter2][0];
                            }
                        }
                }

                // Now the Node1 level is filled with the score data
                // this is line 1 in the shape at http://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Minimax.svg/300px-Minimax.svg.png

                parentNodeAnalyzed = -999;

                for (counter1 = 0; counter1 < NodeLevel_1_count; counter1++)
                {
                        if (NodesAnalysis1[counter1][1] != parentNodeAnalyzed)
                        {
                                //parentNodeAnalyzedchanged = true;
                                parentNodeAnalyzed = NodesAnalysis1[counter1][1];
                                NodesAnalysis0[NodesAnalysis1[counter1][1]][0] = NodesAnalysis1[counter1][0];
                        }

                        if (m_PlayerColor.equals("w"))
                        {
                            if (NodesAnalysis1[counter1][0] >= NodesAnalysis0[NodesAnalysis1[counter1][1]][0])
                            {
                                    NodesAnalysis0[NodesAnalysis1[counter1][1]][0] = NodesAnalysis1[counter1][0];
                            }
                        }
                        else if (m_PlayerColor.equals("b"))
                        {
                            if (NodesAnalysis1[counter1][0] <= NodesAnalysis0[NodesAnalysis1[counter1][1]][0])
                            {
                                    NodesAnalysis0[NodesAnalysis1[counter1][1]][0] = NodesAnalysis1[counter1][0];
                            }
                        }
                }

                // Choose the biggest score at the Node0 level
                // Check example at http://en.wikipedia.org/wiki/Minimax#Example_2
                // This is line 0 at the shape at http://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Minimax.svg/300px-Minimax.svg.png

                // Initialize the score with the first score and move found
                double temp_score = NodesAnalysis0[0][0];
                Best_Move_StartingColumnNumber = NodesAnalysis0[0][2];
                Best_Move_StartingRank = NodesAnalysis0[0][4];
                Best_Move_FinishingColumnNumber = NodesAnalysis0[0][3];
                Best_Move_FinishingRank = NodesAnalysis0[0][5];

                for (counter0 = 0; counter0 < NodeLevel_0_count; counter0++)
                {
                    if (m_PlayerColor.equals("b"))
                    {
                        if (NodesAnalysis0[counter0][0] > temp_score)
                        {
                                temp_score = NodesAnalysis0[counter0][0];

                                Best_Move_StartingColumnNumber = NodesAnalysis0[counter0][2];
                                Best_Move_StartingRank = NodesAnalysis0[counter0][4];
                                Best_Move_FinishingColumnNumber = NodesAnalysis0[counter0][3];
                                Best_Move_FinishingRank = NodesAnalysis0[counter0][5];
                        }
                    }
                    else if (m_PlayerColor.equals("w"))
                    {
                        if (NodesAnalysis0[counter0][0] < temp_score)
                        {
                                temp_score = NodesAnalysis0[counter0][0];

                                Best_Move_StartingColumnNumber = NodesAnalysis0[counter0][2];
                                Best_Move_StartingRank = NodesAnalysis0[counter0][4];
                                Best_Move_FinishingColumnNumber = NodesAnalysis0[counter0][3];
                                Best_Move_FinishingRank = NodesAnalysis0[counter0][5];
                        }
                    }
                }

        }

        /////////////////////////////////////////////////////////////////////////////////////////////////
        // REDRAW THE CHESSBOARD
        /////////////////////////////////////////////////////////////////////////////////////////////////

        //v0.981: If no move found => Resign. If best move found => OK. Go do it.
        if (Best_Move_StartingColumnNumber > 0)
        {
                MovingPiece = Skakiera[(Best_Move_StartingColumnNumber - 1)][(Best_Move_StartingRank - 1)];
                Skakiera[(Best_Move_StartingColumnNumber - 1)][(Best_Move_StartingRank - 1)] = "";

                if (Best_Move_StartingColumnNumber == 1)
                {
                        HY_Starting_Column_Text = "a";
                }
                else if (Best_Move_StartingColumnNumber == 2)
                {
                        HY_Starting_Column_Text = "b";
                }
                else if (Best_Move_StartingColumnNumber == 3)
                {
                        HY_Starting_Column_Text = "c";
                }
                else if (Best_Move_StartingColumnNumber == 4)
                {
                        HY_Starting_Column_Text = "d";
                }
                else if (Best_Move_StartingColumnNumber == 5)
                {
                        HY_Starting_Column_Text = "e";
                }
                else if (Best_Move_StartingColumnNumber == 6)
                {
                        HY_Starting_Column_Text = "f";
                }
                else if (Best_Move_StartingColumnNumber == 7)
                {
                        HY_Starting_Column_Text = "g";
                }
                else if (Best_Move_StartingColumnNumber == 8)
                {
                        HY_Starting_Column_Text = "h";
                }

                // Position piece to the square of destination

                Skakiera[(Best_Move_FinishingColumnNumber - 1)][(Best_Move_FinishingRank - 1)] = MovingPiece;

                if (Best_Move_FinishingColumnNumber == 1)
                {
                        HY_Finishing_Column_Text = "a";
                }
                else if (Best_Move_FinishingColumnNumber == 2)
                {
                        HY_Finishing_Column_Text = "b";
                }
                else if (Best_Move_FinishingColumnNumber == 3)
                {
                        HY_Finishing_Column_Text = "c";
                }
                else if (Best_Move_FinishingColumnNumber == 4)
                {
                        HY_Finishing_Column_Text = "d";
                }
                else if (Best_Move_FinishingColumnNumber == 5)
                {
                        HY_Finishing_Column_Text = "e";
                }
                else if (Best_Move_FinishingColumnNumber == 6)
                {
                        HY_Finishing_Column_Text = "f";
                }
                else if (Best_Move_FinishingColumnNumber == 7)
                {
                        HY_Finishing_Column_Text = "g";
                }
                else if (Best_Move_FinishingColumnNumber == 8)
                {
                        HY_Finishing_Column_Text = "h";
                }

                // Is there a pawn to promote?
                if ((MovingPiece.equals("WP")) || (MovingPiece.equals("BP")))
                {
                        if (Best_Move_FinishingRank == 8)
                        {
                                Skakiera[(Best_Move_FinishingColumnNumber - 1)][(Best_Move_FinishingRank - 1)] = "WQ";
                                System.out.println("Queen!");
                                //Console.WriteLine("Queen!");
                        }
                        else if (Best_Move_FinishingRank == 1)
                        {
                                Skakiera[(Best_Move_FinishingColumnNumber - 1)][(Best_Move_FinishingRank - 1)] = "BQ";
                                System.out.println("Queen!");
                                //Console.WriteLine("Queen!");
                        }
                }

                //v0.980: No need to have NextLine
                //NextLine = String.Concat(HY_Starting_Column_Text, Best_Move_StartingRank.toString(), " -> ", HY_Finishing_Column_Text, Best_Move_FinishingRank.toString());
                System.out.println("My move: " + HY_Starting_Column_Text + Best_Move_StartingRank + " -> " + HY_Finishing_Column_Text + Best_Move_FinishingRank);
                drawPosition();

                number_of_moves_analysed = 0;

                // Now it is the other color's turn to play
                if (m_PlayerColor.equals("b"))
                {
                        m_WhichColorPlays = "Black";
                        Move = Move + 1;
                }
                else if (m_PlayerColor.equals("w"))
                {
                        m_WhichColorPlays = "White";
                }

                // Now it is the Human's turn to play
                m_WhoPlays = "Human";

                EnterMove();
        }
        //v0.981: If no move found => Resign
        else
        {
                //JOptionPane.showMessageDialog(null, "I resign!");
                 System.out.println("I resign!");
                //Console.WriteLine("I resign!");
        }
}
  
  // Function to measure the score of a position in the chessboard
public static int CountScore(String[][] skakieraCS) {
 int score = 0;
 
// v0.991: Have the stupid move generate penalty in the score, without blocking the analysis of moves (all the moves are analyzed)!
if (ThisIsStupidMove.equals("Y"))
{
   //System.out.println("Stupid move:" + m_StartingColumnNumber + m_StartingRank + m_FinishingColumnNumber + m_FinishingRank);
    
   if (m_PlayerColor.equals("w"))
       score = score + 1;
   else if (m_PlayerColor.equals("b"))
       score = score - 1;
}

// v0.991: Added a penalty for moving to dangerous square, without blocking the analysis of moves (all the moves are analyzed)!
if (Skakiera_Dangerous_Squares[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] != 0)
{
   if (m_PlayerColor.equals("w"))
       score = score + 1;
   else if (m_PlayerColor.equals("b"))
       score = score - 1;
}

// v0.991: Add points if possibility to eat is true
if ((possibility_to_eat == true))
{
   if (m_PlayerColor.equals("w"))
       score = score - 1;
   else if (m_PlayerColor.equals("b"))
       score = score + 1;
}
            
   // Scan the chessboard
  for (int i = 0; i < 8; i++)
  {
    for (int j = 0; j < 8; j++)
    {
      // Increase the score for any white piece you find
      if (skakieraCS[i][j].equals("WR"))
         score = score + 5;
      else if (skakieraCS[i][j].equals("WN"))
         score = score + 3;
      else if (skakieraCS[i][j].equals("WB"))
         score = score + 3;
      else if (skakieraCS[i][j].equals("WQ"))
         score = score + 9;
      else if (skakieraCS[i][j].equals("WK"))
         score = score + 15;
      else if (skakieraCS[i][j].equals("WP"))
         score = score + 1; 
      // Derease the score for any black piece you find
      else if (skakieraCS[i][j].equals("BR"))
         score = score - 5;
      else if (skakieraCS[i][j].equals("BN"))
         score = score - 3;
      else if (skakieraCS[i][j].equals("BB"))
         score = score - 3;
      else if (skakieraCS[i][j].equals("BQ"))
         score = score - 9;
      else if (skakieraCS[i][j].equals("BK"))
         score = score - 15;
      else if (skakieraCS[i][j].equals("BP"))
         score = score - 1;
    }
  }
 
  System.out.println("Score returned:" + score);
  
 return score;
  }
   
public static boolean ElegxosNomimotitas(String[][] ENSkakiera, int checkForDanger, int startRank, int startColumn, int finishRank, int finishColumn, String MovingPiece_2)              
	{												         
	// TODO: Add your control notification handler code here

	boolean Nomimotita;
    //Console.WriteLine("into Elegxos Nomimotitas");

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î·Ï‚ "ÎÎŸÎœÎ™ÎœÎŸÎ¤Î—Î¤Î‘Î£" Ï„Î·Ï‚ ÎºÎ¯Î½Î·ÏƒÎ·Ï‚. Î‘Î½ Ï€.Ï‡. Î¿ Ï‡ÏÎ®ÏƒÏ„Î·Ï‚ Î­Ï‡ÎµÎ¹ ÎµÏ€Î¹Î»Î­Î¾ÎµÎ¹ Î½Î± ÎºÎ¹Î½Î®ÏƒÎµÎ¹ Î­Î½Î±Î½ Ï€ÏÏÎ³Î¿ Î±Ï€ÏŒ
	// Ï„Î¿ Î±2 ÏƒÏ„Î¿ Î±5, Î±Î»Î»Î¬ ÏƒÏ„Î¿ Î±4 Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¬Ï€Î¿Î¹Î¿ Ï€Î¹ÏŒÎ½Î¹ Ï„Î¿Ï…, Ï„ÏŒÏ„Îµ Î· Nomimotita Î­Ï‡ÎµÎ¹ Ï„Î¹Î¼Î® false.
	// Î— ÏƒÏ…Î½Î¬ÏÏ„Î·ÏƒÎ· "ÎµÏ€Î¹ÏƒÏ„ÏÎ­Ï†ÎµÎ¹" Ï„Î· booleanean Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î® Nomimotita.
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	Nomimotita = true;

	if( ((finishRank-1) > 7) || ((finishRank-1) < 0) || ((finishColumn-1) > 7) || ((finishColumn-1) < 0) )
		Nomimotita = false;

	// if a piece of the same colout is in the destination square...
    if (checkForDanger == 0)
    {
        if ((MovingPiece_2.equals("WK")) || (MovingPiece_2.equals("WQ")) || (MovingPiece_2.equals("WR")) || (MovingPiece_2.equals("WN")) || (MovingPiece_2.equals("WB")) || (MovingPiece_2.equals("WP")))
        {
            if ((ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WK")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WQ")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WR")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WN")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WB")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WP")))
            {
                Nomimotita = false;
            }
        }
        else if ((MovingPiece_2.equals("BK")) || (MovingPiece_2.equals("BQ")) || (MovingPiece_2.equals("BR")) || (MovingPiece_2.equals("BN")) || (MovingPiece_2.equals("BB")) || (MovingPiece_2.equals("BP")))
        {
            if ((ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BK")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BQ")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BR")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BN")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BB")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BP")))
                Nomimotita = false;
        }
    }

	if (MovingPiece_2.equals("WK"))
	{
        if (checkForDanger == 0)
        {
            /////////////////////////
            // WK
            /////////////////////////
            // is the king threatened in the destination square?
            // temporarily move king
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "";
            ProsorinoKommati_KingCheck = ENSkakiera[(finishColumn - 1)][(finishRank - 1)];
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = "WK";
            
            WhiteKingCheck = CheckForWhiteCheck(ENSkakiera);

            if (WhiteKingCheck == true)
                Nomimotita = false;

            // restore pieces
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "WK";
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = ProsorinoKommati_KingCheck;
        }
	}
	else if (MovingPiece_2.equals("BK"))
	{
        if (checkForDanger == 0)
        {
            ///////////////////////////
            // BK
            ///////////////////////////
            // is the BK threatened in the destination square?
            // temporarily move king
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "";
            ProsorinoKommati_KingCheck = ENSkakiera[(finishColumn - 1)][(finishRank - 1)];
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = "BK";

            BlackKingCheck = CheckForBlackCheck(ENSkakiera);

            if (BlackKingCheck == true)
            {
                Nomimotita = false;
            }
            
            // restore pieces
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "BK";
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = ProsorinoKommati_KingCheck;
        }
	}
	else if (MovingPiece_2.equals("WP"))
	{
        if (checkForDanger == 0)
        {
            //Console.WriteLine("checking WP");
            //System.out.println("Checkpoint 2");
            
            /////////////////////
            // WP
            /////////////////////

            // move forward

            if ((finishRank == (startRank + 1)) && (finishColumn == startColumn))
            {
                if (!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                {
                    //Console.WriteLine("pawn Nomimotita false");
                    Nomimotita = false;
                    
                    System.out.println("Checkpoint 2.1 - Wrong move");
                }
            }

            // move forward for 2 squares
            else if ((finishRank == (startRank + 2)) && (finishColumn == startColumn))
            {
                if (startRank == 2)
                {
                    if ((!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("")) || (!ENSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)].equals("")))
                    {
                        Nomimotita = false;
                        System.out.println("Checkpoint 2.2 - Wrong move");
                        System.out.println("Checkpoint 2.2 - Final square     : " + ENSkakiera[(finishColumn - 1)][(finishRank - 1)]);
                        System.out.println("Checkpoint 2.2 - Pre-final square : " + ENSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)]);
                    }
                }
            }

            // eat forward to the right

            else if ((finishRank == (startRank + 1)) && (finishColumn == startColumn + 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                    {
                        Nomimotita = false;
                        System.out.println("Checkpoint 2.3 - Wrong move");
                    }
                }
            }

            // eat forward to the left

            else if ((finishRank == (startRank + 1)) && (finishColumn == startColumn - 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                    {
                        Nomimotita = false;
                        System.out.println("Checkpoint 2.4 - Wrong move");
                    }
                }
            }
        }
	}
	else if (MovingPiece_2.equals("BP"))
	{
        if (checkForDanger == 0)
        {
            /////////////////////
            // BP
            /////////////////////

            // move forward

            if ((finishRank == (startRank - 1)) && (finishColumn == startColumn))
            {
                if (!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                    Nomimotita = false;
            }

            // move forward for 2 squares
            else if ((finishRank == (startRank - 2)) && (finishColumn == startColumn))
            {
                if (startRank == 7)
                {
                    if ((!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("")) || (!ENSkakiera[(finishColumn - 1)][(finishRank + 1 - 1)].equals("")))
                        Nomimotita = false;
                }
            }

            // eat forward to the right

            else if ((finishRank == (startRank - 1)) && (finishColumn == startColumn + 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                        Nomimotita = false;
                }
            }

            // eat forward to the left

            else if ((finishRank == (startRank - 1)) && (finishColumn == startColumn - 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                        Nomimotita = false;
                }
            }
        }
	}
	else if( (MovingPiece_2.equals("WR")) || (MovingPiece_2.equals("WQ")) || (MovingPiece_2.equals("WB")) || (MovingPiece_2.equals("BR")) || (MovingPiece_2.equals("BQ")) || (MovingPiece_2.equals("BB")) )
	{
		h = 0;
		p = 0;
		//hhh = 0;
		how_to_move_Rank = 0;
		how_to_move_Column = 0;

		if(((finishRank-1) > (startRank-1)) || ((finishRank-1) < (startRank-1)))
			how_to_move_Rank = ((finishRank-1) - (startRank-1))/ Math.abs((finishRank-1) - (startRank-1));
			
		if(((finishColumn-1) > (startColumn-1)) || ((finishColumn-1) < (startColumn-1)) )
			how_to_move_Column = ((finishColumn-1) - (startColumn-1))/Math.abs((finishColumn-1) - (startColumn-1));

		exit_elegxos_nomimothtas = false;

		do
		{
			h = h + how_to_move_Rank;
			p = p + how_to_move_Column;

			if( (((startRank-1) + h) == (finishRank-1)) && ((((startColumn-1) + p)) == (finishColumn-1)) )
				exit_elegxos_nomimothtas = true;

			if((startColumn - 1 + p)<0)
				exit_elegxos_nomimothtas = true;
			else if((startRank - 1 + h)<0)
				exit_elegxos_nomimothtas = true;
			else if((startColumn - 1 + p)>7)
				exit_elegxos_nomimothtas = true;
			else if((startRank - 1 + h)>7)
				exit_elegxos_nomimothtas = true;

			// if a piece exists between the initial and the destination square,
			// then the move is illegal!
			if( exit_elegxos_nomimothtas == false )
			{
				if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WR"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WN"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WB"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WQ"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WK"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WP"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				
				if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BR"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BN"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BB"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BQ"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BK"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BP"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
			}
		}while(exit_elegxos_nomimothtas == false);
	}
	return Nomimotita;
	}

// FUNCTION TO CHECK THE CORRECTNESS (='Orthotita' in Greek) OF THE MOVE
// (i.e. a Bishop can only move in diagonals, rooks in lines and columns etc)
// The ElegxosOrthotitas "checkForDanger" mode differs from the ElegxosOrthotitas normal mode in that it does not make all the validations
// (since it is used to check for "Dangerous" squares in the chessboard and not to actually judge the correctness of an actual move)
public static boolean ElegxosOrthotitas(String[][] EOSkakiera, int checkForDanger, int startRank, int startColumn, int finishRank, int finishColumn, String MovingPiece_2)
{
    // TODO: Add your control notification handler code here

    // If called for checking dangerous squares, put a virtual piece in the destination square so as to pass the validation checks
    // if (checkForDanger == 1)
    // Don't care about checking for the existence of a piece in the destination square


    boolean Orthotita;
    Orthotita = false;
    enpassant_occured = false;

            //Console.WriteLine("ElegxosOrthotitas");
            //Console.WriteLine(MovingPiece_2);

    //Micro edition 2: Convert small Strings to Int
    //If m_WhoPlays = Human
    if ((m_WhoPlays.equals("Human")) && (m_WrongColumn == false) && (!MovingPiece_2.equals("")))    // Î‘Î½ Î¿ Ï‡ÏÎ®ÏƒÏ„Î·Ï‚ Î­Ï‡ÎµÎ¹ Î³ÏÎ¬ÏˆÎµÎ¹ Î¼Î¯Î± Î­Î³ÎºÏ…ÏÎ· ÏƒÏ„Î®Î»Î· ÎºÎ±Î¹ Î­Ï‡ÎµÎ¹
    {                                                         // ÎµÏ€Î¹Î»Î­Î¾ÎµÎ¹ Î½Î± ÎºÎ¹Î½Î®ÏƒÎµÎ¹ Î­Î½Î± ÎºÎ¿Î¼Î¼Î¬Ï„Î¹ (ÎºÎ±Î¹ Î´ÎµÎ½ Î­Ï‡ÎµÎ¹ ÎµÏ€Î¹-
        // Î»Î­Î¾ÎµÎ¹ Î½Î± ÎºÎ¹Î½Î®ÏƒÎµÎ¹ Î­Î½Î± "ÎºÎµÎ½ÏŒ" Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿) ÎºÎ±Î¹ ÎµÎ¯Î½Î±Î¹ Î· ÏƒÎµÎ¹ÏÎ¬ Ï„Î¿Ï… Î½Î± Ï€Î±Î¯Î¾ÎµÎ¹, Ï„ÏŒÏ„Îµ Î½Î± Î³Î¯-
        // Î½ÎµÎ¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î·Ï‚ Î¿ÏÎ¸ÏŒÏ„Î·Ï„Î±Ï‚ Ï„Î·Ï‚ ÎºÎ¯Î½Î·ÏƒÎ·Ï‚. 

        //Console.WriteLine("1");

        // ROOK

        if ((MovingPiece_2.equals("WR")) || (MovingPiece_2.equals("BR")))
        {
            if ((finishColumn != startColumn) && (finishRank == startRank))       // ÎšÎ¯Î½Î·ÏƒÎ· ÏƒÎµ ÏƒÏ„Î®Î»Î·
                Orthotita = true;
            else if ((finishRank != startRank) && (finishColumn == startColumn))  // ÎšÎ¯Î½Î·ÏƒÎ· ÏƒÎµ Î³ÏÎ±Î¼Î¼Î®
                Orthotita = true;
        }

        // horse (with knight...)

        if ((MovingPiece_2.equals("WN")) || (MovingPiece_2.equals("BN")))
        {
            if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank + 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 2)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank - 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank - 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 2)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 2)) && (finishRank == (startRank + 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank + 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 2)) && (finishRank == (startRank + 1)))
                Orthotita = true;
        }

        // bishop

        if ((MovingPiece_2.equals("WB")) || (MovingPiece_2.equals("BB")))
        {
            ////////////////////
            // 2009 v4 change
            ////////////////////
            //if ((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank)))
            //    Orthotita = true;
            if (((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank))) && (finishColumn != startColumn) && (finishRank != startRank))
                Orthotita = true;
            ////////////////////
            // 2009 v4 change
            ////////////////////
        }

        // queen

        if ((MovingPiece_2.equals("WQ")) || (MovingPiece_2.equals("BQ")))
        {
            if ((finishColumn != startColumn) && (finishRank == startRank))       // ÎšÎ¯Î½Î·ÏƒÎ· ÏƒÎµ ÏƒÏ„Î®Î»Î·
                Orthotita = true;
            else if ((finishRank != startRank) && (finishColumn == startColumn))  // ÎšÎ¯Î½Î·ÏƒÎ· ÏƒÎµ Î³ÏÎ±Î¼Î¼Î®
                Orthotita = true;

            ////////////////////
            // 2009 v4 change
            ////////////////////
            // move in diagonals
            //if ((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank)))
            //    Orthotita = true;
            if (((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank))) && (finishColumn != startColumn) && (finishRank != startRank))
                Orthotita = true;
            ////////////////////
            // 2009 v4 change
            ////////////////////
        }

        // king

        if ((MovingPiece_2.equals("WK")) || (MovingPiece_2.equals("BK")))
        {
            // move in rows and columns

            if ((finishColumn == (startColumn + 1)) && (finishRank == startRank))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == startRank))
                Orthotita = true;
            else if ((finishRank == (startRank + 1)) && (finishColumn == startColumn))
                Orthotita = true;
            else if ((finishRank == (startRank - 1)) && (finishColumn == startColumn))
                Orthotita = true;

            // move in diagonals

            else if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank + 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank + 1)))
                Orthotita = true;

        }

        // WP

        if (MovingPiece_2.equals("WP"))
        {
            // move forward
            //Console.WriteLine("2");
//            System.out.println("Checkpoint 1");
//            System.out.println("startRank =" + startRank);
//            System.out.println("finishRank =" + finishRank);
//            System.out.println("startColumn =" + startColumn);
//            System.out.println("finishColumn =" + finishColumn);

            if ((finishRank == (startRank + 1)) && (finishColumn == startColumn))
            {
                Orthotita = true;
                //System.out.println("Checkpoint 1.1 - Valid move");
            }

            // move forward for 2 squares
            else if ((finishRank == (startRank + 2)) && (finishColumn == startColumn) && (startRank == 2))
            {
                Orthotita = true;
                //System.out.println("Checkpoint 1.2 - Valid move");
            }

            else if ((finishRank == (startRank + 1)) && ((finishColumn == (startColumn - 1)) || (finishColumn == (startColumn + 1))))
            {
                if (checkForDanger == 0)
                {
                    // eat forward to the left
                    if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn - 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BQ"))))
                        Orthotita = true;

                    // eat forward to the right
                    if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn + 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BQ"))))
                        Orthotita = true;
                }
                else if (checkForDanger == 1)
                {
                        Orthotita = true;
                }
            }

            // En Passant eat forward to the left
            else if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn - 1)))
            {
                if (checkForDanger == 0)
                {
                    //Console.WriteLine(finishRank.ToString());
                    //Console.WriteLine(finishColumn.ToString());
                    //Console.WriteLine("checking En passant...");
                    if ((finishRank == 6) && (EOSkakiera[(finishColumn - 1)][(4)].equals("BP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)] = "";
                        //Console.WriteLine("En passant true");
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

            // En Passant eat forward to the right
            else if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn + 1)))
            {
                if (checkForDanger == 0)
                {
                    if ((finishRank == 6) && (EOSkakiera[(finishColumn - 1)][(4)].equals("BP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)] = "";
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

        }


        // BP

        if (MovingPiece_2.equals("BP"))
        {
            // move forward

            if ((finishRank == (startRank - 1)) && (finishColumn == startColumn))
                Orthotita = true;

            // move forward for 2 squares
            else if ((finishRank == (startRank - 2)) && (finishColumn == startColumn) && (startRank == 7))
                Orthotita = true;

            else if ((finishRank == (startRank - 1)) && ((finishColumn == (startColumn + 1)) || (finishColumn == (startColumn - 1))))
            {
                if (checkForDanger == 0)
                {
                    // eat forward to the left
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn + 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WQ"))))
                        Orthotita = true;

                    // eat forward to the right
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn - 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WQ"))))
                        Orthotita = true;
                }
                else if (checkForDanger == 1)
                {
                    // eat forward to the left
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn + 1)))
                        Orthotita = true;

                    // eat forward to the right
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn - 1)))
                        Orthotita = true;
                }
            }

            // En Passant eat forward to the left
            else if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn + 1)))
            {
                if (checkForDanger == 0)
                {
                    if ((finishRank == 3) && (EOSkakiera[(finishColumn - 1)][(3)].equals("WP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank + 1 - 1)] = "";
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

            // En Passant eat forward to the right
            else if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn - 1)))
            {
                if (checkForDanger == 0)
                {
                    if ((finishRank == 3) && (EOSkakiera[(finishColumn - 1)][(3)].equals("WP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank + 1 - 1)] = "";
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

        }

    }

    //Console.WriteLine(Orthotita.ToString());
    return Orthotita;
}

public static boolean CheckForWhiteCheck(String[][] WCSkakiera) {
    boolean KingCheck = false;
    
                int klopa;
                int i, j;
                
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Î•ÏÏÎµÏƒÎ· Ï„Ï‰Î½ ÏƒÏ…Î½Ï„ÎµÏ„Î±Î³Î¼Î­Î½Ï‰Î½ Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬.
                // Î‘Î½ ÏƒÎµ ÎºÎ¬Ï€Î¿Î¹Î¿ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ Î²ÏÎµÎ¸ÎµÎ¯ ÏŒÏ„Î¹ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î­Î½Î±Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚, Ï„ÏŒÏ„Îµ Î±Ï€Î»Î¬ ÎºÎ±Ï„Î±Î³ÏÎ¬Ï†ÎµÏ„Î±Î¹ Î· Ï„Î¹Î¼Î® Ï„Î¿Ï… ÎµÎ½ Î»ÏŒÎ³Ï‰
                // Ï„ÎµÏ„ÏÎ±Î³ÏŽÎ½Î¿Ï… ÏƒÏ„Î¹Ï‚ Î±Î½Ï„Î¯ÏƒÏ„Î¿Î¹Ï‡ÎµÏ‚ Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ Ï€Î¿Ï… Î´Î·Î»ÏŽÎ½Î¿Ï…Î½ Ï„Î· ÏƒÏ„Î®Î»Î· ÎºÎ±Î¹ Ï„Î· Î³ÏÎ±Î¼Î¼Î® ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î»ÎµÏ…ÎºÏŒÏ‚
                // Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚.
                // Î Î¡ÎŸÎ£ÎŸÎ§Î—: Î“ÏÎ¬Ï†Ï‰ (i+1) Î±Î½Ï„Î¯ Î³Î¹Î± i ÎºÎ±Î¹ (j+1) Î±Î½Ï„Î¯ Î³Î¹Î± j Î³Î¹Î±Ï„Î¯ Ï„Î¿ Ï€ÏÏŽÏ„Î¿ ÏƒÏ„Î¿Î¹Ï‡ÎµÎ¯Î¿ Ï„Î¿Ï… Ï€Î¯Î½Î±ÎºÎ± WCWCSkakiera[(8),(8)]
                // ÎµÎ¯Î½Î±Î¹ Ï„Î¿ WCSkakiera[(0),(0)] ÎºÎ±Î¹ ÎŸÎ§Î™ Ï„Î¿ WCSkakiera[(1),(1)]!
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

                for (i = 0; i <= 7; i++)
                {
                    for (j = 0; j <= 7; j++)
                    {

                        if (WCSkakiera[(i)][(j)].equals("WK"))
                        {
                            WhiteKingColumn = (i + 1);
                            WhiteKingRank = (j + 1);
                        }

                    }
                }

                ///////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ "ÏƒÎ±Ï‡"
                ///////////////////////////////////////////////////////////////

                KingCheck = false;

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Î•Î»Î­Î³Ï‡Î¿Ï…Î¼Îµ Î±ÏÏ‡Î¹ÎºÎ¬ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î¤Î‘ Î”Î•ÎžÎ™Î‘ Î¤ÎŸÎ¥. Î“Î¹Î± Î½Î± Î¼Î·Î½ Î²Î³Î¿ÏÎ¼Îµ Î­Î¾Ï‰ Î±Ï€ÏŒ Ï„Î±
                // ÏŒÏÎ¹Î± Ï„Î·Ï‚ WCSkakiera[(8),(8)] Î­Ï‡Î¿Ï…Î¼Îµ Ï€ÏÎ¿ÏƒÎ¸Î­ÏƒÎµÎ¹ Ï„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿ (WhiteKingColumn + 1) <= 8 ÏƒÏ„Î¿ "if". Î‘ÏÏ‡Î¹ÎºÎ¬ Î¿ "ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚"
                // Î±Ï€ÏŒ Ï„Î± "Î´ÎµÎ¾Î¹Î¬" ÎµÎ¯Î½Î±Î¹ Ï…Ï€Î±ÏÎºÏ„ÏŒÏ‚, Î¬ÏÎ± DangerFromRight = true. Î©ÏƒÏ„ÏŒÏƒÎ¿ Î±Î½ Î²ÏÎµÎ¸ÎµÎ¯ ÏŒÏ„Î¹ ÏƒÏ„Î± Î´ÎµÎ¾Î¹Î¬ Ï„Î¿Ï… Î»ÎµÏ…ÎºÎ¿Ï Î²Î±ÏƒÎ¹-
                // Î»Î¹Î¬ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¬Ï€Î¿Î¹Î¿ Î»ÎµÏ…ÎºÏŒ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹, Ï„ÏŒÏ„Îµ Î´ÎµÎ½ ÎµÎ¯Î½Î±Î¹ Î´Ï…Î½Î±Ï„ÏŒÎ½ Î¿ ÎµÎ½ Î»ÏŒÎ³Ï‰ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡ Î±Ï€ÏŒ Ï„Î± Î´ÎµÎ¾Î¹Î¬
                // Ï„Î¿Ï… (Î±Ï†Î¿Ï Î¸Î± "Ï€ÏÎ¿ÏƒÏ„Î±Ï„ÎµÏÎµÏ„Î±Î¹" Î±Ï€ÏŒ Ï„Î¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹ Î¹Î´Î¯Î¿Ï… Ï‡ÏÏŽÎ¼Î±Ï„Î¿Ï‚), Î¿Ï€ÏŒÏ„Îµ Î· DangerFromRight = false ÎºÎ±Î¹ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚
                // Î³Î¹Î± Î±Ï€ÎµÎ¹Î»Î­Ï‚ Î±Ï€ÏŒ Ï„Î± Î´ÎµÎ¾Î¹Î¬ ÏƒÏ„Î±Î¼Î±Ï„Î¬ÎµÎ¹ (Î³Î¹Î± Î±Ï…Ï„ÏŒ ÎºÎ±Î¹ Î­Ï‡Ï‰ Ï€ÏÎ¿ÏƒÎ¸Î­ÏƒÎµÎ¹ Ï„Î·Î½ Ï€ÏÎ¿Ï‹Ï€ÏŒÎ¸ÎµÏƒÎ· (DangerFromRight == true) ÏƒÏ„Î±
                // "if" Ï€Î¿Ï… ÎºÎ¬Î½Î¿Ï…Î½ Î±Ï…Ï„ÏŒÎ½ Ï„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿).
                // Î‘Î½ ÏŒÎ¼Ï‰Ï‚ Î´ÎµÎ½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ±Î½Î­Î½Î± Î»ÎµÏ…ÎºÏŒ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹ Î´ÎµÎ¾Î¹Î¬ Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î³Î¹Î± Î½Î± Ï„Î¿Î½ Ï€ÏÎ¿ÏƒÏ„Î±Ï„ÎµÏÎµÎ¹, Ï„ÏŒÏ„Îµ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î±
                // Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Î±Ï€ÎµÎ¹Î»ÎµÎ¯Ï„Î±Î¹ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î±Ï€ÏŒ Ï„Î± Î´ÎµÎ¾Î¹Î¬ Ï„Î¿Ï…, Î¿Ï€ÏŒÏ„Îµ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÏ„Î±Î¹.
                // Î£Î·Î¼ÎµÎ¯Ï‰ÏƒÎ·: ÎŸ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¯Î½ÎµÏ„Î±Î¹ Î³Î¹Î± Ï€Î¹Î¸Î±Î½ÏŒ ÏƒÎ±Ï‡ Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î±Î½Ï„Î¯Î¸ÎµÏ„Î¿Ï… Ï‡ÏÏŽÎ¼Î±Ï„Î¿Ï‚.
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn + klopa) <= 8) && (DangerFromRight == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WQ")))
                            DangerFromRight = false;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BK")))
                            DangerFromRight = false;
                    }
                }


                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î¤Î‘ Î‘Î¡Î™Î£Î¤Î•Î¡Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ±).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn - klopa) >= 1) && (DangerFromLeft == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WQ")))
                            DangerFromLeft = false;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BK")))
                            DangerFromLeft = false;
                    }
                }


                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î Î‘ÎÎ© (Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ±).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////


                DangerFromUp = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingRank + klopa) <= 8) && (DangerFromUp == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WQ")))
                            DangerFromUp = false;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BK")))
                            DangerFromUp = false;
                    }
                }


                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ ÎšÎ‘Î¤Î© (Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ±).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDown = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingRank - klopa) >= 1) && (DangerFromDown == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WQ")))
                            DangerFromDown = false;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BK")))
                            DangerFromDown = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î Î‘ÎÎ©-Î”Î•ÎžÎ™Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn + klopa) <= 8) && ((WhiteKingRank + klopa) <= 8) && (DangerFromUpRight == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WQ")))
                            DangerFromUpRight = false;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BK")))
                            DangerFromUpRight = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ ÎšÎ‘Î¤Î©-Î‘Î¡Î™Î£Î¤Î•Î¡Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn - klopa) >= 1) && ((WhiteKingRank - klopa) >= 1) && (DangerFromDownLeft == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WQ")))
                            DangerFromDownLeft = false;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BK")))
                            DangerFromDownLeft = false;
                    }
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ ÎšÎ‘Î¤Î©-Î”Î•ÎžÎ™Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn + klopa) <= 8) && ((WhiteKingRank - klopa) >= 1) && (DangerFromDownRight == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WQ")))
                            DangerFromDownRight = false;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BK")))
                            DangerFromDownRight = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î Î‘ÎÎ©-Î‘Î¡Î™Î£Î¤Î•Î¡Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn - klopa) >= 1) && ((WhiteKingRank + klopa) <= 8) && (DangerFromUpLeft == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WQ")))
                            DangerFromUpLeft = false;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BK")))
                            DangerFromUpLeft = false;
                    }
                }



                //////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î±Ï€ÎµÎ¹Î»ÎµÎ¯Ï„Î±Î¹ Î±Ï€ÏŒ Ï€Î¹ÏŒÎ½Î¹.
                //////////////////////////////////////////////////////////////////////////

                if (((WhiteKingColumn + 1) <= 8) && ((WhiteKingRank + 1) <= 8))
                {
                    if (WCSkakiera[(WhiteKingColumn + 1 - 1)][(WhiteKingRank + 1 - 1)].equals("BP"))
                    {
                        KingCheck = true;
                    }
                }


                if (((WhiteKingColumn - 1) >= 1) && ((WhiteKingRank + 1) <= 8))
                {
                    if (WCSkakiera[(WhiteKingColumn - 1 - 1)][(WhiteKingRank + 1 - 1)].equals("BP"))
                    {
                        KingCheck = true;
                    }
                }


                ///////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î±Ï€ÎµÎ¹Î»ÎµÎ¯Ï„Î±Î¹ Î±Ï€ÏŒ Î¯Ï€Ï€Î¿.
                ///////////////////////////////////////////////////////////////////////

                if (((WhiteKingColumn + 1) <= 8) && ((WhiteKingRank + 2) <= 8))
                    if (WCSkakiera[(WhiteKingColumn + 1 - 1)][(WhiteKingRank + 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn + 2) <= 8) && ((WhiteKingRank - 1) >= 1))
                    if (WCSkakiera[(WhiteKingColumn + 2 - 1)][(WhiteKingRank - 1 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn + 1) <= 8) && ((WhiteKingRank - 2) >= 1))
                    if (WCSkakiera[(WhiteKingColumn + 1 - 1)][(WhiteKingRank - 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 1) >= 1) && ((WhiteKingRank - 2) >= 1))
                    if (WCSkakiera[(WhiteKingColumn - 1 - 1)][(WhiteKingRank - 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 2) >= 1) && ((WhiteKingRank - 1) >= 1))
                    if (WCSkakiera[(WhiteKingColumn - 2 - 1)][(WhiteKingRank - 1 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 2) >= 1) && ((WhiteKingRank + 1) <= 8))
                    if (WCSkakiera[(WhiteKingColumn - 2 - 1)][(WhiteKingRank + 1 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 1) >= 1) && ((WhiteKingRank + 2) <= 8))
                    if (WCSkakiera[(WhiteKingColumn - 1 - 1)][(WhiteKingRank + 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn + 2) <= 8) && ((WhiteKingRank + 1) <= 8))
                    if (WCSkakiera[(WhiteKingColumn + 2 - 1)][(WhiteKingRank + 1 - 1)].equals("BN"))
                        KingCheck = true;

    return KingCheck;
}

public static boolean CheckForBlackCheck(String[][] BCSkakiera) {
    boolean KingCheck = false;
    
                 int klopa;
                 int ik, jk;
                 
                 //System.out.println("");
                 //System.out.println("Entered CheckForBlackCheck");
                 
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Î•ÏÏÎµÏƒÎ· Ï„Ï‰Î½ ÏƒÏ…Î½Ï„ÎµÏ„Î±Î³Î¼Î­Î½Ï‰Î½ Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬.
                // Î‘Î½ ÏƒÎµ ÎºÎ¬Ï€Î¿Î¹Î¿ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ Î²ÏÎµÎ¸ÎµÎ¯ ÏŒÏ„Î¹ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î­Î½Î±Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚, Ï„ÏŒÏ„Îµ Î±Ï€Î»Î¬ ÎºÎ±Ï„Î±Î³ÏÎ¬Ï†ÎµÏ„Î±Î¹ Î· Ï„Î¹Î¼Î® Ï„Î¿Ï… ÎµÎ½ Î»ÏŒÎ³Ï‰
                // Ï„ÎµÏ„ÏÎ±Î³ÏŽÎ½Î¿Ï… ÏƒÏ„Î¹Ï‚ Î±Î½Ï„Î¯ÏƒÏ„Î¿Î¹Ï‡ÎµÏ‚ Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ Ï€Î¿Ï… Î´Î·Î»ÏŽÎ½Î¿Ï…Î½ Ï„Î· ÏƒÏ„Î®Î»Î· ÎºÎ±Î¹ Ï„Î· Î³ÏÎ±Î¼Î¼Î® ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±ÏÏÎ¿Ï‚
                // Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚.
                // Î Î¡ÎŸÎ£ÎŸÎ§Î—: Î“ÏÎ¬Ï†Ï‰ (i+1) Î±Î½Ï„Î¯ Î³Î¹Î± i ÎºÎ±Î¹ (j+1) Î±Î½Ï„Î¯ Î³Î¹Î± j Î³Î¹Î±Ï„Î¯ Ï„Î¿ Ï€ÏÏŽÏ„Î¿ ÏƒÏ„Î¿Î¹Ï‡ÎµÎ¯Î¿ Ï„Î¿Ï… Ï€Î¯Î½Î±ÎºÎ± BCSkakiera[(8),(8)]
                // ÎµÎ¯Î½Î±Î¹ Ï„Î¿ BCSkakiera[(0),(0)] ÎºÎ±Î¹ ÎŸÎ§Î™ Ï„Î¿ BCSkakiera[(1),(1)]!
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

                for (ik = 0; ik <= 7; ik++)
                {
                    for (jk = 0; jk <= 7; jk++)
                    {

                        if (BCSkakiera[(ik)][(jk)].equals("BK"))
                        {
                            BlKingColumn = (ik + 1);
                            BlKingRank = (jk + 1);
                            //System.out.println("Found king at " + (ik + 1) + (jk + 1));
                        }

                    }
                }

                ///////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ "ÏƒÎ±Ï‡"
                ///////////////////////////////////////////////////////////////

                KingCheck = false;

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Î•Î»Î­Î³Ï‡Î¿Ï…Î¼Îµ Î±ÏÏ‡Î¹ÎºÎ¬ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î¤Î‘ Î”Î•ÎžÎ™Î‘ Î¤ÎŸÎ¥. Î“Î¹Î± Î½Î± Î¼Î·Î½ Î²Î³Î¿ÏÎ¼Îµ Î­Î¾Ï‰ Î±Ï€ÏŒ Ï„Î±
                // ÏŒÏÎ¹Î± Ï„Î·Ï‚ BCSkakiera[(8),(8)] Î­Ï‡Î¿Ï…Î¼Îµ Ï€ÏÎ¿ÏƒÎ¸Î­ÏƒÎµÎ¹ Ï„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿ (BlKingColumn + 1) <= 8 ÏƒÏ„Î¿ "if". Î‘ÏÏ‡Î¹ÎºÎ¬ Î¿ "ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚"
                // Î±Ï€ÏŒ Ï„Î± "Î´ÎµÎ¾Î¹Î¬" ÎµÎ¯Î½Î±Î¹ Ï…Ï€Î±ÏÎºÏ„ÏŒÏ‚, Î¬ÏÎ± DangerFromRight = true. Î©ÏƒÏ„ÏŒÏƒÎ¿ Î±Î½ Î²ÏÎµÎ¸ÎµÎ¯ ÏŒÏ„Î¹ ÏƒÏ„Î± Î´ÎµÎ¾Î¹Î¬ Ï„Î¿Ï… Î¼Î±ÏÏÎ¿Ï… Î²Î±ÏƒÎ¹-
                // Î»Î¹Î¬ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¬Ï€Î¿Î¹Î¿ Î¼Î±ÏÏÎ¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹, Ï„ÏŒÏ„Îµ Î´ÎµÎ½ ÎµÎ¯Î½Î±Î¹ Î´Ï…Î½Î±Ï„ÏŒÎ½ Î¿ ÎµÎ½ Î»ÏŒÎ³Ï‰ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡ Î±Ï€ÏŒ Ï„Î± Î´ÎµÎ¾Î¹Î¬
                // Ï„Î¿Ï… (Î±Ï†Î¿Ï Î¸Î± "Ï€ÏÎ¿ÏƒÏ„Î±Ï„ÎµÏÎµÏ„Î±Î¹" Î±Ï€ÏŒ Ï„Î¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹ Î¹Î´Î¯Î¿Ï… Ï‡ÏÏŽÎ¼Î±Ï„Î¿Ï‚), Î¿Ï€ÏŒÏ„Îµ Î· DangerFromRight = false ÎºÎ±Î¹ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚
                // Î³Î¹Î± Î±Ï€ÎµÎ¹Î»Î­Ï‚ Î±Ï€ÏŒ Ï„Î± Î´ÎµÎ¾Î¹Î¬ ÏƒÏ„Î±Î¼Î±Ï„Î¬ÎµÎ¹ (Î³Î¹Î± Î±Ï…Ï„ÏŒ ÎºÎ±Î¹ Î­Ï‡Ï‰ Ï€ÏÎ¿ÏƒÎ¸Î­ÏƒÎµÎ¹ Ï„Î·Î½ Ï€ÏÎ¿Ï‹Ï€ÏŒÎ¸ÎµÏƒÎ· (DangerFromRight == true) ÏƒÏ„Î±
                // "if" Ï€Î¿Ï… ÎºÎ¬Î½Î¿Ï…Î½ Î±Ï…Ï„ÏŒÎ½ Ï„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿).
                // Î‘Î½ ÏŒÎ¼Ï‰Ï‚ Î´ÎµÎ½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ±Î½Î­Î½Î± Î¼Î±ÏÏÎ¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹ Î´ÎµÎ¾Î¹Î¬ Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î³Î¹Î± Î½Î± Ï„Î¿Î½ Ï€ÏÎ¿ÏƒÏ„Î±Ï„ÎµÏÎµÎ¹, Ï„ÏŒÏ„Îµ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î±
                // Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Î±Ï€ÎµÎ¹Î»ÎµÎ¯Ï„Î±Î¹ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î±Ï€ÏŒ Ï„Î± Î´ÎµÎ¾Î¹Î¬ Ï„Î¿Ï…, Î¿Ï€ÏŒÏ„Îµ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÏ„Î±Î¹.
                // Î£Î·Î¼ÎµÎ¯Ï‰ÏƒÎ·: ÎŸ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¯Î½ÎµÏ„Î±Î¹ Î³Î¹Î± Ï€Î¹Î¸Î±Î½ÏŒ ÏƒÎ±Ï‡ Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î±Î½Ï„Î¯Î¸ÎµÏ„Î¿Ï… Ï‡ÏÏŽÎ¼Î±Ï„Î¿Ï‚.
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromRight = true;
                
                //System.out.println("BlKingColumn = " + BlKingColumn);
                //System.out.println("BlKingRank = " + BlKingRank);

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn + klopa) <= 8) && (DangerFromRight == true))
                    {
                        if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BQ")))
                            DangerFromRight = false;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WK")))
                            DangerFromRight = false;
                    }
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î¤Î‘ Î‘Î¡Î™Î£Î¤Î•Î¡Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ±).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn - klopa) >= 1) && (DangerFromLeft == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BQ")))
                            DangerFromLeft = false;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WK")))
                            DangerFromLeft = false;
                    }
                }



                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î Î‘ÎÎ© (Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ±).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////


                DangerFromUp = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingRank + klopa) <= 8) && (DangerFromUp == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BQ")))
                            DangerFromUp = false;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WK")))
                            DangerFromUp = false;
                    }
                }



                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ ÎšÎ‘Î¤Î© (Î±Ï€ÏŒ Ï€ÏÏÎ³Î¿ Î® Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ±).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDown = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingRank - klopa) >= 1) && (DangerFromDown == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BQ")))
                            DangerFromDown = false;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WK")))
                            DangerFromDown = false;
                    }
                }



                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î Î‘ÎÎ©-Î”Î•ÎžÎ™Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn + klopa) <= 8) && ((BlKingRank + klopa) <= 8) && (DangerFromUpRight == true))
                    {
                        if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BQ")))
                            DangerFromUpRight = false;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WK")))
                            DangerFromUpRight = false;
                    }
                }



                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ ÎšÎ‘Î¤Î©-Î‘Î¡Î™Î£Î¤Î•Î¡Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn - klopa) >= 1) && ((BlKingRank - klopa) >= 1) && (DangerFromDownLeft == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BQ")))
                            DangerFromDownLeft = false;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WK")))
                            DangerFromDownLeft = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ ÎšÎ‘Î¤Î©-Î”Î•ÎžÎ™Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn + klopa) <= 8) && ((BlKingRank - klopa) >= 1) && (DangerFromDownRight == true))
                    {
                        if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BQ")))
                            DangerFromDownRight = false;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WK")))
                            DangerFromDownRight = false;
                    }
                }



                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÎºÎ¯Î½Î´Ï…Î½Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬ Î‘Î ÎŸ Î Î‘ÎÎ©-Î‘Î¡Î™Î£Î¤Î•Î¡Î‘ Î¤ÎŸÎ¥ (Î±Ï€ÏŒ Î²Î±ÏƒÎ¯Î»Î¹ÏƒÏƒÎ± Î® Î±Î¾Î¹Ï‰Î¼Î±Ï„Î¹ÎºÏŒ).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn - klopa) >= 1) && ((BlKingRank + klopa) <= 8) && (DangerFromUpLeft == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BQ")))
                            DangerFromUpLeft = false;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WK")))
                            DangerFromUpLeft = false;
                    }
                }


                //////////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î±Ï€ÎµÎ¹Î»ÎµÎ¯Ï„Î±Î¹ Î±Ï€ÏŒ Ï€Î¹ÏŒÎ½Î¹.
                //////////////////////////////////////////////////////////////////////////

                if (((BlKingColumn + 1) <= 8) && ((BlKingRank - 1) >= 1))
                {
                    if (BCSkakiera[(BlKingColumn + 1 - 1)][(BlKingRank - 1 - 1)].equals("WP"))
                    {
                        KingCheck = true;
                    }
                }


                if (((BlKingColumn - 1) >= 1) && ((BlKingRank - 1) >= 1))
                {
                    if (BCSkakiera[(BlKingColumn - 1 - 1)][(BlKingRank - 1 - 1)].equals("WP"))
                    {
                        KingCheck = true;
                    }
                }


                ///////////////////////////////////////////////////////////////////////
                // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¹Î± Ï„Î¿ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î±Ï€ÎµÎ¹Î»ÎµÎ¯Ï„Î±Î¹ Î±Ï€ÏŒ Î¯Ï€Ï€Î¿.
                ///////////////////////////////////////////////////////////////////////

                if (((BlKingColumn + 1) <= 8) && ((BlKingRank + 2) <= 8))
                    if (BCSkakiera[(BlKingColumn + 1 - 1)][(BlKingRank + 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn + 2) <= 8) && ((BlKingRank - 1) >= 1))
                    if (BCSkakiera[(BlKingColumn + 2 - 1)][(BlKingRank - 1 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn + 1) <= 8) && ((BlKingRank - 2) >= 1))
                    if (BCSkakiera[(BlKingColumn + 1 - 1)][(BlKingRank - 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 1) >= 1) && ((BlKingRank - 2) >= 1))
                    if (BCSkakiera[(BlKingColumn - 1 - 1)][(BlKingRank - 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 2) >= 1) && ((BlKingRank - 1) >= 1))
                    if (BCSkakiera[(BlKingColumn - 2 - 1)][(BlKingRank - 1 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 2) >= 1) && ((BlKingRank + 1) <= 8))
                    if (BCSkakiera[(BlKingColumn - 2 - 1)][(BlKingRank + 1 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 1) >= 1) && ((BlKingRank + 2) <= 8))
                    if (BCSkakiera[(BlKingColumn - 1 - 1)][(BlKingRank + 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn + 2) <= 8) && ((BlKingRank + 1) <= 8))
                    if (BCSkakiera[(BlKingColumn + 2 - 1)][(BlKingRank + 1 - 1)].equals("WN"))
                        KingCheck = true;

    return KingCheck;
}

public static boolean CheckForBlackMate(String[][] BMSkakiera)
{
			// Check if the BK is under checkmate

			boolean Mate;
			//v0.990: Changed MovingPiece and ProsorinoKommati with the CBM variables
			String MovingPieceCBM;
			String ProsorinoKommatiCBM;

			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			// ÎœÎµÏ„Î±Î²Î»Î·Ï„Î® Ï€Î¿Ï… Ï‡ÏÎ·ÏƒÎ¹Î¼ÎµÏÎµÎ¹ ÏƒÏ„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿ Î³Î¹Î± Ï„Î¿ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ (Î²Î». ÏƒÏ…Î½Î±ÏÏ„Î®ÏƒÎµÎ¹Ï‚ CheckForWhiteMate() ÎºÎ±Î¹
			// CheckForBlMate()).
			// Î‘Î½Î±Î»Ï…Ï„Î¹ÎºÏŒÏ„ÎµÏÎ±, Ï„Î¿ Ï€ÏÏŒÎ³ÏÎ±Î¼Î¼Î± ÎµÎ»Î­Î³Ï‡ÎµÎ¹ Î±Î½ Î±ÏÏ‡Î¹ÎºÎ¬ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ ÎºÎ±Î¹, Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹, ÎµÎ»Î­Î³Ï‡ÎµÎ¹ Î±Î½ Î±Ï…Ï„ÏŒ Ï„Î¿
			// ÏƒÎ±Ï‡ Î¼Ï€Î¿ÏÎµÎ¯ Î½Î± Î±Ï€Î¿Ï†ÎµÏ…Ï‡Î¸ÎµÎ¯ Î¼Îµ Ï„Î· Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Ï…Ï€ÏŒ Î±Ï€ÎµÎ¹Î»Î® Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÏƒÎµ ÎºÎ¬Ï€Î¿Î¹Î¿ Î³ÎµÎ¹Ï„Î¿Î½Î¹ÎºÏŒ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿.
			// Î— Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î® ÎºÎ±Ï„Î±Î³ÏÎ¬Ï†ÎµÎ¹ Ï„Î¿ Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ ÏƒÏ„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±.
			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			boolean DangerForMate;

			////////////////////////////////////////////////////////////
			// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ "Î¼Î±Ï„" ÏƒÏ„Î¿Î½ Î¼Î±ÏÏÎ¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬
			////////////////////////////////////////////////////////////

			Mate = false;
			DangerForMate = true; // Î‘ÏÏ‡Î¹ÎºÎ¬, Ï€ÏÎ¿Ï†Î±Î½ÏŽÏ‚ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ ÏƒÏ„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±.
									 // Î‘Î½, Ï‰ÏƒÏ„ÏŒÏƒÎ¿, ÎºÎ¬Ï€Î¿Î¹Î± ÏƒÏ„Î¹Î³Î¼Î® Î²ÏÎµÎ¸ÎµÎ¯ ÏŒÏ„Î¹ Î±Î½ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î¼Ï€Î¿ÏÎµÎ¯ Î½Î± Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯
									 // ÏƒÎµ Î­Î½Î± Î´Î¹Ï€Î»Î±Î½ÏŒ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ ÎºÎ±Î¹ Î½Î± Ï€Î¬ÏˆÎµÎ¹ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡, Ï„ÏŒÏ„Îµ Ï€Î±ÏÎµÎ¹ Î½Î±
									 // Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ (Ï€ÏÎ¿Ï†Î±Î½ÏŽÏ‚) ÎºÎ±Î¹ Î· Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î® Ï€Î±Î¯ÏÎ½ÎµÎ¹ Ï„Î·Î½
									 // Ï„Î¹Î¼Î® false.


			//////////////////////////////////////////////////////////////
			// Î•ÏÏÎµÏƒÎ· Ï„Ï‰Î½ Î±ÏÏ‡Î¹ÎºÏŽÎ½ ÏƒÏ…Î½Ï„ÎµÏ„Î±Î³Î¼Î­Î½Ï‰Î½ Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬
			//////////////////////////////////////////////////////////////

			for (i = 0; i <= 7; i++)
			{
				for (j = 0; j <= 7; j++)
				{

					if (BMSkakiera[(i)][(j)].equals("BK"))
					{
						StartingBlKingColumn = (i + 1);
						StartingBlKingRank = (j + 1);
					}

				}
			}


			//////////////////////////////////////////////////
			// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ ÎµÎ¯Î½Î±Î¹ Î¼Î±Ï„
			//////////////////////////////////////////////////


			if (m_WhichColorPlays.equals("Black"))
			{

				////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Ï…Ï„Î® Ï„Î· ÏƒÏ„Î¹Î³Î¼Î®
				////////////////////////////////////////////////

				BlackKingCheck = CheckForBlackCheck(BMSkakiera);

				if (BlackKingCheck == false) // Î‘Î½ Î±Ï…Ï„Î® Ï„Î· ÏƒÏ„Î¹Î³Î¼Î® Î´ÎµÎ½ Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡, Ï„ÏŒÏ„Îµ Î½Î± Î¼Î· ÏƒÏ…Î½ÎµÏ‡Î¹ÏƒÏ„ÎµÎ¯ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚
				{
					DangerForMate = false; // ÎºÎ±Î¸ÏŽÏ‚ Î”Î•Î ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„.
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingRank < 8)
				{
					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 + 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.
						// ÎŸ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¯Î½ÎµÏ„Î±Î¹ Î¼ÏŒÎ½Î¿ Î±Î½ ÏƒÏ„Î¿ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ Ï€Î¿Ï… Î¼ÎµÏ„Î±ÎºÎ¹Î½ÎµÎ¯Ï„Î±Î¹ Ï€ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î¬ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î´ÎµÎ½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¬Î»Î»Î¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹
						// Ï„Î¿Ï… Î¯Î´Î¹Î¿Ï… Ï‡ÏÏŽÎ¼Î±Ï„Î¿Ï‚ Ï€Î¿Ï… Î½Î± Ï„Î¿Î½ ÎµÎ¼Ï€Î¿Î´Î¯Î¶ÎµÎ¹ ÎºÎ±Î¹ Î±Î½, Ï†Ï…ÏƒÎ¹ÎºÎ¬, Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î´ÎµÎ½ Î²Î³Î±Î¯Î½ÎµÎ¹ Î­Î¾Ï‰ Î±Ï€ÏŒ Ï„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ± Î¼Îµ
						// Î±Ï…Ï„Î® Ï„Î¿Ï… Ï„Î·Î½ ÎºÎ¯Î½Î·ÏƒÎ· ÎºÎ±Î¹ Î±Î½, Ï€ÏÎ¿Ï†Î±Î½ÏŽÏ‚, ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± ÏÏ€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ (ÎºÎ±Î¸ÏŽÏ‚ Î±Î½ Î´ÎµÎ½
						// Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï„Î­Ï„Î¿Î¹Î± Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î±, Ï„ÏŒÏ„Îµ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ ÎµÎ¯Î½Î±Î¹ Î¬Ï‡ÏÎ·ÏƒÏ„Î¿Ï‚).

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 + 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 + 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰-Î´ÎµÎ¾Î¹Î¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn < 8) && (StartingBlKingRank < 8))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 + 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 + 1) <= 7) && ((StartingBlKingColumn - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 + 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 + 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Î´ÎµÎ¾Î¹Î¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingColumn < 8)
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingColumn - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± ÎºÎ¬Ï„Ï‰-Î´ÎµÎ¾Î¹Î¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn < 8) && (StartingBlKingRank > 1))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 - 1) >= 0) && ((StartingBlKingColumn - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± ÎºÎ¬Ï„Ï‰
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingRank > 1)
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± ÎºÎ¬Ï„Ï‰-Î±ÏÎ¹ÏƒÏ„ÎµÏÎ¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn > 1) && (StartingBlKingRank > 1))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 - 1) >= 0) && ((StartingBlKingColumn - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Î±ÏÎ¹ÏƒÏ„ÎµÏÎ¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingColumn > 1)
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingColumn - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î¼Î±ÏÏÎ¿Ï‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰-Î±ÏÎ¹ÏƒÏ„ÎµÏÎ¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn > 1) && (StartingBlKingRank < 8))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 + 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 + 1) <= 7) && ((StartingBlKingColumn - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 + 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 + 1)] = ProsorinoKommatiCBM;

					}

				}

				if (DangerForMate == true)
				{
					Mate = true;
				}

			}

			return Mate;
		}

public static boolean CheckForWhiteMate(String[][] WMSkakiera)
{
			// Check if the WK is under checkmate

			boolean Mate;
			//v0.990: Changed MovingPiece and ProsorinoKommati with the CWM variables
			String MovingPieceCWM;
			String ProsorinoKommatiCWM;

			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			// ÎœÎµÏ„Î±Î²Î»Î·Ï„Î® Ï€Î¿Ï… Ï‡ÏÎ·ÏƒÎ¹Î¼ÎµÏÎµÎ¹ ÏƒÏ„Î¿Î½ Î­Î»ÎµÎ³Ï‡Î¿ Î³Î¹Î± Ï„Î¿ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ (Î²Î». ÏƒÏ…Î½Î±ÏÏ„Î®ÏƒÎµÎ¹Ï‚ CheckForWhiteMate() ÎºÎ±Î¹
			// CheckForBlMate()).
			// Î‘Î½Î±Î»Ï…Ï„Î¹ÎºÏŒÏ„ÎµÏÎ±, Ï„Î¿ Ï€ÏÏŒÎ³ÏÎ±Î¼Î¼Î± ÎµÎ»Î­Î³Ï‡ÎµÎ¹ Î±Î½ Î±ÏÏ‡Î¹ÎºÎ¬ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ ÎºÎ±Î¹, Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹, ÎµÎ»Î­Î³Ï‡ÎµÎ¹ Î±Î½ Î±Ï…Ï„ÏŒ Ï„Î¿
			// ÏƒÎ±Ï‡ Î¼Ï€Î¿ÏÎµÎ¯ Î½Î± Î±Ï€Î¿Ï†ÎµÏ…Ï‡Î¸ÎµÎ¯ Î¼Îµ Ï„Î· Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Ï…Ï€ÏŒ Î±Ï€ÎµÎ¹Î»Î® Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÏƒÎµ ÎºÎ¬Ï€Î¿Î¹Î¿ Î³ÎµÎ¹Ï„Î¿Î½Î¹ÎºÏŒ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿.
			// Î— Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î® ÎºÎ±Ï„Î±Î³ÏÎ¬Ï†ÎµÎ¹ Ï„Î¿ Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ ÏƒÏ„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±.
			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			boolean DangerForMate;

			////////////////////////////////////////////////////////////
			// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ "Î¼Î±Ï„" ÏƒÏ„Î¿Î½ Î»ÎµÏ…ÎºÏŒ Î²Î±ÏƒÎ¹Î»Î¹Î¬
			////////////////////////////////////////////////////////////

			Mate = false;
			DangerForMate = true; // Î‘ÏÏ‡Î¹ÎºÎ¬, Ï€ÏÎ¿Ï†Î±Î½ÏŽÏ‚ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ ÏƒÏ„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±.
									 // Î‘Î½, Ï‰ÏƒÏ„ÏŒÏƒÎ¿, ÎºÎ¬Ï€Î¿Î¹Î± ÏƒÏ„Î¹Î³Î¼Î® Î²ÏÎµÎ¸ÎµÎ¯ ÏŒÏ„Î¹ Î±Î½ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î¼Ï€Î¿ÏÎµÎ¯ Î½Î± Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯
									 // ÏƒÎµ Î­Î½Î± Î´Î¹Ï€Î»Î±Î½ÏŒ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ ÎºÎ±Î¹ Î½Î± Ï€Î¬ÏˆÎµÎ¹ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡, Ï„ÏŒÏ„Îµ Ï€Î±ÏÎµÎ¹ Î½Î±
									 // Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ (Ï€ÏÎ¿Ï†Î±Î½ÏŽÏ‚) ÎºÎ±Î¹ Î· Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î® Ï€Î±Î¯ÏÎ½ÎµÎ¹ Ï„Î·Î½
									 // Ï„Î¹Î¼Î® false.


			//////////////////////////////////////////////////////////////
			// Î•ÏÏÎµÏƒÎ· Ï„Ï‰Î½ Î±ÏÏ‡Î¹ÎºÏŽÎ½ ÏƒÏ…Î½Ï„ÎµÏ„Î±Î³Î¼Î­Î½Ï‰Î½ Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬
			//////////////////////////////////////////////////////////////

			for (i = 0; i <= 7; i++)
			{
				for (j = 0; j <= 7; j++)
				{

					if (WMSkakiera[(i)][(j)].equals("WK"))
					{
						StartingWhiteKingColumn = (i + 1);
						StartingWhiteKingRank = (j + 1);
					}

				}
			}


			//////////////////////////////////////////////////
			// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ ÎµÎ¯Î½Î±Î¹ Î¼Î±Ï„
			//////////////////////////////////////////////////


			if (m_WhichColorPlays.equals("White"))
			{

				////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Î±Î½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Ï…Ï„Î® Ï„Î· ÏƒÏ„Î¹Î³Î¼Î®
				////////////////////////////////////////////////

				WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

				if (WhiteKingCheck == false) // Î‘Î½ Î±Ï…Ï„Î® Ï„Î· ÏƒÏ„Î¹Î³Î¼Î® Î´ÎµÎ½ Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ ÏƒÎ±Ï‡, Ï„ÏŒÏ„Îµ Î½Î± Î¼Î· ÏƒÏ…Î½ÎµÏ‡Î¹ÏƒÏ„ÎµÎ¯ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚
				{
					DangerForMate = false; // ÎºÎ±Î¸ÏŽÏ‚ Î”Î•Î ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï†Î¯ÏƒÏ„Î±Ï„Î±Î¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„.
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingRank < 8)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 + 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.
						// ÎŸ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Î³Î¯Î½ÎµÏ„Î±Î¹ Î¼ÏŒÎ½Î¿ Î±Î½ ÏƒÏ„Î¿ Ï„ÎµÏ„ÏÎ¬Î³Ï‰Î½Î¿ Ï€Î¿Ï… Î¼ÎµÏ„Î±ÎºÎ¹Î½ÎµÎ¯Ï„Î±Î¹ Ï€ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î¬ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î´ÎµÎ½ Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Î¬Î»Î»Î¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹
						// Ï„Î¿Ï… Î¯Î´Î¹Î¿Ï… Ï‡ÏÏŽÎ¼Î±Ï„Î¿Ï‚ Ï€Î¿Ï… Î½Î± Ï„Î¿Î½ ÎµÎ¼Ï€Î¿Î´Î¯Î¶ÎµÎ¹ ÎºÎ±Î¹ Î±Î½, Ï†Ï…ÏƒÎ¹ÎºÎ¬, Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î´ÎµÎ½ Î²Î³Î±Î¯Î½ÎµÎ¹ Î­Î¾Ï‰ Î±Ï€ÏŒ Ï„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ± Î¼Îµ
						// Î±Ï…Ï„Î® Ï„Î¿Ï… Ï„Î·Î½ ÎºÎ¯Î½Î·ÏƒÎ· ÎºÎ±Î¹ Î±Î½, Ï€ÏÎ¿Ï†Î±Î½ÏŽÏ‚, ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î± Î½Î± ÏÏ€Î¬ÏÏ‡ÎµÎ¹ Î¼Î±Ï„ (ÎºÎ±Î¸ÏŽÏ‚ Î±Î½ Î´ÎµÎ½
						// Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ Ï„Î­Ï„Î¿Î¹Î± Ï€Î¹Î¸Î±Î½ÏŒÏ„Î·Ï„Î±, Ï„ÏŒÏ„Îµ Î¿ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ ÎµÎ¯Î½Î±Î¹ Î¬Ï‡ÏÎ·ÏƒÏ„Î¿Ï‚).

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 + 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 + 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰-Î´ÎµÎ¾Î¹Î¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn < 8) && (StartingWhiteKingRank < 8))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 + 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 + 1) <= 7) && ((StartingWhiteKingColumn - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 + 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 + 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Î´ÎµÎ¾Î¹Î¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingColumn < 8)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingColumn - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± ÎºÎ¬Ï„Ï‰-Î´ÎµÎ¾Î¹Î¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn < 8) && (StartingWhiteKingRank > 1))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 - 1) >= 0) && ((StartingWhiteKingColumn - 1 + 1) <= 7))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± ÎºÎ¬Ï„Ï‰
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingRank > 1)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± ÎºÎ¬Ï„Ï‰-Î±ÏÎ¹ÏƒÏ„ÎµÏÎ¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn > 1) && (StartingWhiteKingRank > 1))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 - 1) >= 0) && ((StartingWhiteKingColumn - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 - 1)] = ProsorinoKommatiCWM;

					}
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Î±ÏÎ¹ÏƒÏ„ÎµÏÎ¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingColumn > 1)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingColumn - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ Î¸Î± ÏƒÏ…Î½ÎµÏ‡Î¯ÏƒÎµÎ¹ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡ Î±Î½ Î¿ Î»ÎµÏ…ÎºÏŒÏ‚ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Ï€ÏÎ¿ÏƒÏ€Î±Î¸Î®ÏƒÎµÎ¹ Î½Î± Î´Î¹Î±Ï†ÏÎ³ÎµÎ¹ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î¿ÏÎ¼ÎµÎ½Î¿Ï‚
				// Ï€ÏÎ¿Ï‚ Ï„Î± Ï€Î¬Î½Ï‰-Î±ÏÎ¹ÏƒÏ„ÎµÏÎ¬
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn > 1) && (StartingWhiteKingRank < 8))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 + 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 + 1) <= 7) && ((StartingWhiteKingColumn - 1 - 1) >= 0))
					{

						// (Î ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î®) Î¼ÎµÏ„Î±ÎºÎ¯Î½Î·ÏƒÎ· Ï„Î¿Ï… Î²Î±ÏƒÎ¹Î»Î¹Î¬ ÎºÎ±Î¹ Î­Î»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î¿Ï… Î±Î½ ÏƒÏ…Î½ÎµÏ‡Î¯Î¶ÎµÎ¹ Ï„ÏŒÏ„Îµ Î½Î± Ï…Ï€Î¬ÏÏ‡ÎµÎ¹ ÏƒÎ±Ï‡.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 + 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚ ÏƒÏ„Î·Î½ ÎºÎ±Ï„Î¬ÏƒÏ„Î±ÏƒÎ· ÏƒÏ„Î·Î½ Î¿Ï€Î¿Î¯Î± Î²ÏÎ¹ÏƒÎºÏŒÏ„Î±Î½ Ï€ÏÎ¹Î½ Î¼ÎµÏ„Î±ÎºÎ¹Î½Î·Î¸ÎµÎ¯ Î¿ Î²Î±ÏƒÎ¹Î»Î¹Î¬Ï‚ Î³Î¹Î± Ï„Î¿Ï…Ï‚
						// ÏƒÎºÎ¿Ï€Î¿ÏÏ‚ Ï„Î¿Ï… ÎµÎ»Î­Î³Ï‡Î¿Ï….

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 + 1)] = ProsorinoKommatiCWM;

					}

				}

				if (DangerForMate == true)
				{
					Mate = true;
				}

			}

			return Mate;
		}

public static void Analyze_Move_1_HumanMove(String[][] Skakiera_Human_Thinking_2)
{
    // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
    // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
    double bestScoreLevel1 = 0;

    // Scan chessboard . Find a piece of the Hu player . Move to all possible squares.
    // Check corr1ectness and legality of move . If all OK then measure the move's score.
    // Do the best move and handle over to the ComputerMove function to continue analysis in the next move (deeper depth...)
    //v0.990: Initialized the values
    int skakos1 = 0;
    int trelos35 = 0;
    String MovingPiece1 = "";
    String ProsorinoKommati1 = "";
    int m_StartingColumnNumber1 = 0;
    int m_FinishingColumnNumber1 = 0;
    int m_StartingRank1 = 0;
    int m_FinishingRank1 = 0;

    //v0.990
    String[][] Skakiera_Move_After_1 = new String[8][8];

    // Check all possible moves
    for (skakos1 = 0; skakos1 <= 7; skakos1++)
    {
        for (trelos35 = 0; trelos35 <= 7; trelos35++)
        {
            //v0.990: (Who_Is_Analyzed.equals("Hu")) -> (Who_Is_Analyzed.equals("Human"))
            if (((Who_Is_Analyzed.equals("Human")) && ((((Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BK")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BQ")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BR")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BN")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BB")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WK")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WQ")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("White Rook")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WN")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WB")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WP"))) && (m_PlayerColor.equals("w"))))))
            {
                for (int w = 0; w <= 7; w++)
                {
                    for (int r = 0; r <= 7; r++)
                    {
                        //v0.990: Removed the m_FinishingRank column and replace with m_FinishingRank1
                        MovingPiece1 = Skakiera_Human_Thinking_2[(skakos1)][(trelos35)];
                        m_StartingColumnNumber1 = skakos1 + 1;
                        m_FinishingColumnNumber1 = w + 1;
                        m_StartingRank1 = trelos35 + 1;
                        m_FinishingRank1 = r + 1;

                        // Store temporary move data in local variables, so as to use them in the Undo of the move
                        // at the end of this function (the MovingPiece, m_StartingColumnNumber, etc variables are
                        // changed by next functions as well, so using them leads to problems)
                        //v0.990: Removed the m_FinishingRank column and replace with m_FinishingRank1
                        //MovingPiece1 = MovingPiece;
                        //m_StartingColumnNumber1 = m_StartingColumnNumber;
                        //m_FinishingColumnNumber1 = m_FinishingColumnNumber;
                        //m_StartingRank1 = m_StartingRank;
                        //m_FinishingRank1 = m_FinishingRank;
                        ProsorinoKommati1 = Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)];

                        // Check the move
                        //v0.980: Removed
                        number_of_moves_analysed++;

                        // Necessary values for variables for the ElegxosOrthotitas (check move corr1ectness) and
                        // ElegxosNomimotitas (check move legality) function to...function properly.
                        m_WhoPlays = "Human";
                        m_WrongColumn = false;
                        //v0.990
                        //MovingPiece1 = Skakiera_Human_Thinking_2[(m_StartingColumnNumber1 - 1), (m_StartingRank1 - 1)];
                        //v0.990: MovingPiece -> MovingPiece1
                        m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera_Human_Thinking_2, 0, m_StartingRank1, m_StartingColumnNumber1, m_FinishingRank1, m_FinishingColumnNumber1, MovingPiece1);
                        m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera_Human_Thinking_2, 0, m_StartingRank1, m_StartingColumnNumber1, m_FinishingRank1, m_FinishingColumnNumber1, MovingPiece1);
                        // Restore normal value of m_WhoPlays
                        m_WhoPlays = "HY";

                        // If all ok, then do the move and measure it
                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                        {
                            // Do the move
                            //v0.990: ProsorinoKommati -> ProsorinoKommati1, MovingPiece -> MovingPiece1
                            ProsorinoKommati1 = Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)];
                            Skakiera_Human_Thinking_2[(m_StartingColumnNumber1 - 1)][(m_StartingRank1 - 1)] = "";
                            Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)] = MovingPiece1;

                            // Measure score AFTER the move
                            Temp_Score_Move_1_human = CountScore(Skakiera_Human_Thinking_2);

                            // Store the best move at this level
                            if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_1_human < bestScoreLevel1))
                            {
                                bestScoreLevel1 = Temp_Score_Move_1_human;
                            }
                            else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_1_human > bestScoreLevel1))
                            {
                                bestScoreLevel1 = Temp_Score_Move_1_human;
                            }

                            if (Move_Analyzed < Thinking_Depth)
                            // v0.990 test
                            //if ( ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("w")) && (Temp_Score_Move_1_human >= bestScoreLevel1))
                            //  || ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("b")) && (Temp_Score_Move_1_human <= bestScoreLevel1)) )
                            {
                                    // Call ComputerMove for the HY throught process to continue
                                    Move_Analyzed = Move_Analyzed + 1;

                                    Who_Is_Analyzed = "HY";

                                    //v0.990
                                    String[][] Skakiera_Move_After_1_new = new String[8][8];

                                    //v0.990: Why copy everything in Skakiera_Move_After?
                                    //Just use Skakiera_Human_Thinking_2 directly! No!
                                    //Remember the problem with the "reference" of the array at with ElegxosNomimotitas!)
                                    //Arrays can be passed as arguments to method parameters. Because arrays are reference types, the method can change the value of the elements.
                                    //SOURCES...
                                    //https://docs.microsoft.com/en-us/dotnet/articles/csharp/programming-guide/arrays/passing-arrays-as-arguments]
                                    //http://stackoverflow.com/questions/10325323/passing-arrays-by-value-and-by-reference
                                    //http://stackoverflow.com/questions/967402/are-arrays-or-lists-passed-by-default-by-reference-in-c
                                    for (i = 0; i <= 7; i++)
                                    {
                                        for (j = 0; j <= 7; j++)
                                        {
                                            Skakiera_Move_After_1[(i)][(j)] = Skakiera_Human_Thinking_2[(i)][(j)];
                                            Skakiera_Move_After_1_new[(i)][(j)] = Skakiera_Human_Thinking_2[(i)][(j)];
                                        }
                                    }

                                    //v0.990: Skakiera_Move_After -> Skakiera_Move_After_1 -> Skakiera_Move_After_1_new
                                    if (Move_Analyzed == 2)
                                    {
                                        Analyze_Move_2_ComputerMove(Skakiera_Move_After_1_new);
                                    }
                            }

                            // Undo the move
                            Skakiera_Human_Thinking_2[(m_StartingColumnNumber1 - 1)][(m_StartingRank1 - 1)] = MovingPiece1;
                            Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)] = ProsorinoKommati1;

                            //v0.991
                            NodeLevel_1_count++;
                         }

                    } // For 4
                } // For 3

            } // IF

        } // For 2
    } // For 1

    Move_Analyzed = Move_Analyzed - 1;
    Who_Is_Analyzed = "HY";
}

public static void Analyze_Move_2_ComputerMove(String[][] Skakiera_Thinking_HY_2)
{
    // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
    // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
    double bestScoreLevel2 = 0;

    // Î”Î®Î»Ï‰ÏƒÎ· Î¼ÎµÏ„Î±Î²Î»Î·Ï„ÏŽÎ½ Ï€Î¿Ï… Ï‡ÏÎ·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹Î¿ÏÎ½Ï„Î±Î¹ ÏƒÏ„Î¿ Î²ÏÏŒÎ³Ï‡Î¿ "for" (Î´ÎµÎ½ Î¼Ï€Î¿ÏÎµÎ¯ Î½Î± Ï‡ÏÎ·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹Î·Î¸Î¿ÏÎ½ Î¿Î¹ Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ i ÎºÎ±Î¹ j Î´Î¹ÏŒÏ„Î¹ Î±Ï…Ï„Î­Ï‚ Î¿Î¹
    // Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ ÎµÎ¯Î½Î±Î¹ ÎºÎ±Î¸Î¿Î»Î¹ÎºÎ­Ï‚ ÎºÎ±Î¹ Î´Î·Î¼Î¹Î¿Ï…ÏÎ³ÎµÎ¯Ï„Î±Î¹ Ï€ÏÏŒÎ²Î»Î·Î¼Î± ÎºÎ±Ï„Î¬ Ï„Î·Î½ ÎµÏ€Î¹ÏƒÏ„ÏÎ¿Ï†Î® ÏƒÏ„Î·Î½ ComputerMove Î±Ï€ÏŒ Ï„Î·Î½ CheckMove)
    //v0.990: Initialized the values
    int iii2 = 0;
    int jjj2 = 0;
    String MovingPiece2 = "";
    String ProsorinoKommati2 = "";
    int m_StartingColumnNumber2 = 0;
    int m_FinishingColumnNumber2 = 0;
    int m_StartingRank2 = 0;
    int m_FinishingRank2 = 0;

    //v0.990
    String[][] Skakiera_Move_After_2 = new String[8][8];

    //huo_sw1.WriteLine(String.Concat("[Point 0] -> Î£ÎºÎ±ÎºÎ¹Î­ÏÎ±[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

    // Î£ÎºÎ±Î½Î¬ÏÎ¹ÏƒÎ¼Î± Ï„Î·Ï‚ ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ±Ï‚: ÎŒÏ„Î±Î½ ÎµÎ½Ï„Î¿Ï€Î¯Î¶ÎµÏ„Î±Î¹ ÎºÎ¬Ï€Î¿Î¹Î¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹ Ï„Î¿Ï… Ï…Ï€Î¿Î»Î¿Î³Î¹ÏƒÏ„Î®,
    // Î¸Î± Ï…Ï€Î¿Î»Î¿Î³Î¯Î¶Î¿Î½Ï„Î±Î¹ ÎŸÎ›Î•Î£ Î¿Î¹ Ï€Î¹Î¸Î±Î½Î­Ï‚ ÎºÎ¹Î½Î®ÏƒÎµÎ¹Ï‚ Ï„Î¿Ï… Ï€ÏÎ¿Ï‚ ÎºÎ¬Î¸Îµ ÎºÎ±Ï„ÎµÏÎ¸Ï…Î½ÏƒÎ·, Î±ÎºÏŒÎ¼Î±
    // ÎºÎ±Î¹ Î±Ï…Ï„Î­Ï‚ Ï€Î¿Ï… Î´ÎµÎ½ Î¼Ï€Î¿ÏÎµÎ¯ Î½Î± ÎºÎ¬Î½ÎµÎ¹ Ï„Î¿ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹. Î£Ï„Î· ÏƒÏ…Î½Î­Ï‡ÎµÎ¹Î±, Î¼Îµ Ï„Î· Î²Î¿Î®Î¸ÎµÎ¹Î±
    // Ï„Ï‰Î½ ÏƒÏ…Î½Î±ÏÏ„Î®ÏƒÎµÏ‰Î½ ElegxosNomimotitas ÎºÎ±Î¹ ElegxosOrthotitas Î¸Î± ÎµÎ»Î­Î³Ï‡ÎµÏ„Î±Î¹ Ï„Î¿
    // Î±Î½ Î· ÎºÎ¯Î½Î·ÏƒÎ· ÎµÎ¯Î½Î±Î¹ Î¿ÏÎ¸Î® ÎºÎ±Î¹ Î½ÏŒÎ¼Î¹Î¼Î·. Î‘Î½ ÎµÎ¯Î½Î±Î¹, Î· ÎµÎ½ Î»ÏŒÎ³Ï‰ ÎºÎ¯Î½Î·ÏƒÎ· Î¸Î± Î³Î¯Î½ÎµÏ„Î±Î¹
    // Ï€ÏÎ¿ÏƒÏ‰ÏÎ¹Î½Î¬ ÏƒÏ„Î· ÏƒÎºÎ±ÎºÎ¹Î­ÏÎ± ÎºÎ±Î¹ Î¸Î± ÎºÎ±Ï„Î±Î³ÏÎ¬Ï†ÎµÏ„Î±Î¹ Ï„Î¿ ÏƒÎºÎ¿Ï Ï„Î·Ï‚ Î½Î­Î±Ï‚ Î¸Î­ÏƒÎ·Ï‚ Ï€Î¿Ï…
    // Ï€ÏÎ¿Î­ÎºÏ…ÏˆÎµ

    // Î£Î—ÎœÎ•Î™Î©Î£Î—: Î£Îµ ÏŒÎ»ÎµÏ‚ Ï„Î¹Ï‚ ÏƒÏ„Î®Î»ÎµÏ‚ ÎºÎ±Î¹ Ï„Î¹Ï‚ Î¿ÏÎ¹Î¶ÏŒÎ½Ï„Î¹Î¿Ï…Ï‚ Ï€ÏÎ¿ÏƒÏ„Î¯Î¸ÎµÏ„Î±Î¹ Î· Î¼Î¿Î½Î¬Î´Î± (+1)
    // Î´Î¹ÏŒÏ„Î¹ Ï€ÏÎ­Ï€ÎµÎ¹ Î½Î± Î¼ÎµÏ„Î±Ï„ÏÎ±Ï€Î¿ÏÎ½ Î±Ï€ÏŒ Ï„Î¿ "ÏƒÏÏƒÏ„Î·Î¼Î±" Î¼Î­Ï„ÏÎ·ÏƒÎ·Ï‚ "0-7" (Ï€Î¿Ï… Ï‡ÏÎ·ÏƒÎ¹Î¼Î¿-
    // Ï€Î¿Î¹ÎµÎ¯Ï„Î±Î¹ ÏƒÏ„Î¿ Ï€Î±ÏÎ±ÎºÎ¬Ï„Ï‰ "for iâ€¦next" Î±Î»Î»Î¬ ÎºÎ±Î¹ ÏƒÏ„Î¿ ÏƒÏ…Î¼Î²Î¿Î»Î¹ÏƒÎ¼ÏŒ Ï„Î¿Ï… Ï€Î¯Î½Î±ÎºÎ±
    // Skakiera) ÏƒÏ„Î¿ ÏƒÏÏƒÏ„Î·Î¼Î± Î¼Î­Ï„ÏÎ·ÏƒÎ·Ï‚ "1-8" Ï„Î¿ Î¿Ï€Î¿Î¯Î¿ Ï‡ÏÎ·ÏƒÎ¹Î¼Î¿Ï€Î¿Î¹ÎµÎ¯Ï„Î±Î¹ ÏƒÏ„Î¹Ï‚
    // Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ Starting/Finishing_Column/Rank ÏƒÎµ ÏŒÎ»Î¿ Ï„Î¿ Ï…Ï€ÏŒÎ»Î¿Î¹Ï€Î¿ Ï€ÏÏŒÎ³ÏÎ±Î¼Î¼Î±.

    for (iii2 = 0; iii2 <= 7; iii2++)
    {
        for (jjj2 = 0; jjj2 <= 7; jjj2++)
        {
            if (((Who_Is_Analyzed.equals("HY")) && ((((Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WK")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WQ")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("White Rook")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WN")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WB")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BK")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BQ")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BR")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BN")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BB")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BP"))) && (m_PlayerColor.equals("w"))))))
            {
                //huo_sw1.WriteLine(String.Concat("[Point 1] -> Î£ÎºÎ±ÎºÎ¹Î­ÏÎ±[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

                for (int w = 0; w <= 7; w++)
                {
                    for (int r = 0; r <= 7; r++)
                    {
                        //huo_sw1.WriteLine(String.Concat("[Point 2] -> Î£ÎºÎ±ÎºÎ¹Î­ÏÎ±[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

                        //v0.990: Replaced m_StartingColumnNumber with m_StartingColumnNumber2
                        MovingPiece2 = Skakiera_Thinking_HY_2[(iii2)][(jjj2)];
                        m_StartingColumnNumber2 = iii2 + 1;
                        m_FinishingColumnNumber2 = w + 1;
                        m_StartingRank2 = jjj2 + 1;
                        m_FinishingRank2 = r + 1;
                        ProsorinoKommati2 = Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)];

                        // ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î·Ï‚ ÎºÎ¯Î½Î·ÏƒÎ·Ï‚

                        // Validity and legality of the move has been checked in CheckMove
                        // CheckMove(Skakiera_Thinking_HY_2);

                        // Check validity and legality
                        // Necessary values for variables for the ElegxosOrthotitas (check move corr1ectness) and
                        // ElegxosNomimotitas (check move legality) function to...function properly.
                        m_WhoPlays = "Human";
                        m_WrongColumn = false;
                        //v0.990: MovingPiece -> MovingPiece2

                        m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera_Thinking_HY_2, 0, m_StartingRank2, m_StartingColumnNumber2, m_FinishingRank2, m_FinishingColumnNumber2, MovingPiece2);
                        m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera_Thinking_HY_2, 0, m_StartingRank2, m_StartingColumnNumber2, m_FinishingRank2, m_FinishingColumnNumber2, MovingPiece2);
                        // Restore normal value of m_WhoPlays
                        m_WhoPlays = "HY";

                        // If all ok, then do the move and measure it
                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                        {
                            //huo_sw1.WriteLine(string.Concat("Hu move 1: Found a legal move!"));
                            //huo_sw1.WriteLine(String.Concat("[Point 5] -> Î£ÎºÎ±ÎºÎ¹Î­ÏÎ±[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

                            // Do the move
                            //v0.990: ProsorinoKommati -> ProsorinoKommati2, MovingPiece -> MovingPiece2
                            ProsorinoKommati2 = Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)];
                            Skakiera_Thinking_HY_2[(m_StartingColumnNumber2 - 1)][(m_StartingRank2 - 1)] = "";
                            Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)] = MovingPiece2;

                            //v0.991
                            //NodeLevel_2_count++;
                            //v0.980: Removed humanDangerParameter from every call of countScore
                            Temp_Score_Move_2 = CountScore(Skakiera_Thinking_HY_2);

                            // v0.990 change
                            // Store the best score at this level
                            if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_2 > bestScoreLevel2))
                            {
                                    bestScoreLevel2 = Temp_Score_Move_2;
                            }
                            else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_2 < bestScoreLevel2))
                            {
                                    bestScoreLevel2 = Temp_Score_Move_2;
                            }

                            // v0.990 change: Added back the part which calls deeper levels of analysis
                            // v0.990 change: Must trim the tree or else the app does not work and consums a lot of memory!
                            //if (Move_Analyzed < Thinking_Depth)
                            // v0.990 Move 4 changes: Trim the tree!
                            if (((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("w")) && (Temp_Score_Move_2 <= bestScoreLevel2)) || ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("b")) && (Temp_Score_Move_2 >= bestScoreLevel2)))
                            {
                                Move_Analyzed = Move_Analyzed + 1;

                                //v0.990: Skakiera_Move_After -> Skakiera_Move_After_2
                                for (i = 0; i <= 7; i++)
                                {
                                    for (j = 0; j <= 7; j++)
                                    {
                                        Skakiera_Move_After_2[(i)][(j)] = Skakiera_Thinking_HY_2[(i)][(j)];
                                    }
                                }

                                Who_Is_Analyzed = "Human";
                                //V0.980 REMOVED First_Call_Human_Thought = true;

                                // v0.990 Move 4 changes
                                // Check human move
                                //v0.990: Skakiera_Move_After -> Skakiera_Thinking_HY_2
                                if (Move_Analyzed == 1)
                                {
                                    Analyze_Move_1_HumanMove(Skakiera_Move_After_2);
                                }
                            }


                            if (Move_Analyzed == Thinking_Depth)
                            {
                                // [MiniMax algorithm - skakos]
                                // Record the node in the Nodes Analysis array (to use with MiniMax algorithm) skakos

                                //v0.970
                                NodesAnalysis0[NodeLevel_0_count][0] = Temp_Score_Move_0;
                                NodesAnalysis1[NodeLevel_1_count][0] = Temp_Score_Move_1_human;
                                NodesAnalysis2[NodeLevel_2_count][0] = Temp_Score_Move_2;

                                // Store the parents (number of the node of the upper level)
                                NodesAnalysis0[NodeLevel_0_count][1] = 0;
                                NodesAnalysis1[NodeLevel_1_count][1] = NodeLevel_0_count;
                                NodesAnalysis2[NodeLevel_2_count][1] = NodeLevel_1_count;

                                ///#endregion toRemove

                                //v0.980: removed
                                Nodes_Total_count++;
                            }

                            // Undo the move
                            Skakiera_Thinking_HY_2[(m_StartingColumnNumber2 - 1)][(m_StartingRank2 - 1)] = MovingPiece2;
                            Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)] = ProsorinoKommati2;

                            //v0.991
                            NodeLevel_2_count++;
                        }

                    } // FOR 4
                } // FOR 3

            } // IF
        }
    }

    Move_Analyzed = Move_Analyzed - 1;
    Who_Is_Analyzed = "Human";
}

public static void FindAttackers(String[][] SkakieraAttackers)
{
			//v0.990: Initialized the values
			String MovingPiece_Attack = "";
			int m_StartingRank_Attack = 0;
			int m_StartingColumnNumber_Attack = 0;
			int m_FinishingRank_Attack = 0;
			int m_FinishingColumnNumber_Attack = 0;

			// Scan the chessboard . if a piece of HY is found . check all
			// possible destinations in the chessboard . check correctness of
			// the move analyzed . check legality of the move analyzed . if
			// correct and legal, then do the move.
			// NOTE: In all column and rank numbers I add +1, because I must transform
			// them from the 0...7 'measure system' of the chessboard (='Skakiera' in Greek) table
			// to the 1...8 'measure system' of the chessboard.

			for (int iii2 = 0; iii2 <= 7; iii2++)
			{
				for (int jjj2 = 0; jjj2 <= 7; jjj2++)
				{
					if ((((SkakieraAttackers[(iii2)][(jjj2)].equals("WK")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WQ")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("White Rook")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WN")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WB")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WP"))) && (m_PlayerColor.equals("w"))) || (((SkakieraAttackers[(iii2)][(jjj2)].equals("BK")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BQ")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BR")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BN")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BB")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BP"))) && (m_PlayerColor.equals("b"))))
					{

						MovingPiece_Attack = SkakieraAttackers[(iii2)][(jjj2)];
						m_StartingColumnNumber_Attack = iii2 + 1;
						m_StartingRank_Attack = jjj2 + 1;

						// find squares where the Hu opponent can hit
						for (int w2 = 0; w2 <= 7; w2++)
						{
							for (int r2 = 0; r2 <= 7; r2++)
							{
								m_FinishingColumnNumber_Attack = w2 + 1;
								m_FinishingRank_Attack = r2 + 1;

								// check the move
								m_WhoPlays = "Human";
								m_WrongColumn = false;
								m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								if (m_OrthotitaKinisis == true)
								{
									m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								}
								// restore normal value of m_whoplays
								m_WhoPlays = "HY";
								// 2012: If a pawn is moving, then take into account only moves of eating other pieces!
								// and not moves of moving forward
								if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
								{
									if (m_FinishingColumnNumber_Attack == m_StartingColumnNumber_Attack)
									{
										m_OrthotitaKinisis = false;
									}
								}

								if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
								{
									// Another attacker on that square found!
									Number_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Number_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;
									// v0.96
									//Skakiera_Dangerous_Squares[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = "Danger";

									//2012 new
									//v0.980: Removed Attackers_coordinates_column/rank since they are not used!
									//Attackers_coordinates_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = m_StartingColumnNumber_Attack - 1;
									//Attackers_coordinates_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = m_StartingRank_Attack - 1;

									// Calculate the value (total value) of the attackers
									//MessageBox.Show(string.Concat("Added something to the value of attackers: ", MovingPiece_Attack.ToString()));

									if ((MovingPiece_Attack.equals("White Rook")) || (MovingPiece_Attack.equals("BR")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 5;
									}
									else if ((MovingPiece_Attack.equals("WB")) || (MovingPiece_Attack.equals("BB")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WN")) || (MovingPiece_Attack.equals("BN")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WQ")) || (MovingPiece_Attack.equals("BQ")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 9;
									}
									else if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;
									}
									//v0.95
									//else if ((MovingPiece_Attack.equals("WK")) || (MovingPiece_Attack.equals("BK")))
									//    Value_of_attackers[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] + 15;
								}
							}
						}
					}
				}
			}


		}

public static void FindDefenders(String[][] SkakieraDefenders)
{
			//v0.990: Initialized the values
			String MovingPiece_Attack = "";
			int m_StartingRank_Attack = 0;
			int m_StartingColumnNumber_Attack = 0;
			int m_FinishingRank_Attack = 0;
			int m_FinishingColumnNumber_Attack = 0;

			// Find squares that are also 'protected' by a piece of the HY.
			// If protected, then the square is not really dangerous

			// Changed in version 0.5
			// Initialize all variables used to find exceptions in the non-dangerous squares.
			// Exceptions definition: If Hu can hit a square and the computer defends it with its pieces, then the
			// square is not dangerous. However, if the computer has only one (1) piece to defend that square, then
			// it cannot move that specific piece to that square (because then the square would have no defenders and
			// would become again a dangerous square!).

			for (int iii3 = 0; iii3 <= 7; iii3++)
			{
				for (int jjj3 = 0; jjj3 <= 7; jjj3++)
				{
					if ((((SkakieraDefenders[(iii3)][(jjj3)].equals("WK")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WQ")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("White Rook")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WN")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WB")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((SkakieraDefenders[(iii3)][(jjj3)].equals("BK")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BQ")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BR")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BN")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BB")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BP"))) && (m_PlayerColor.equals("w"))))
					{
						MovingPiece_Attack = SkakieraDefenders[(iii3)][(jjj3)];
						m_StartingColumnNumber_Attack = iii3 + 1;
						m_StartingRank_Attack = jjj3 + 1;

						for (int w1 = 0; w1 <= 7; w1++)
						{
							for (int r1 = 0; r1 <= 7; r1++)
							{

								m_FinishingColumnNumber_Attack = w1 + 1;
								m_FinishingRank_Attack = r1 + 1;

								// ÎˆÎ»ÎµÎ³Ï‡Î¿Ï‚ Ï„Î·Ï‚ ÎºÎ¯Î½Î·ÏƒÎ·Ï‚
								// Î‘Ï€ÏŒÎ´Î¿ÏƒÎ· Ï„Î¹Î¼ÏŽÎ½ ÏƒÏ„Î¹Ï‚ Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î­Ï‚ m_WhoPlays ÎºÎ±Î¹ m_WrongColumn, Î¿Î¹ Î¿Ï€Î¿Î¯ÎµÏ‚ ÎµÎ¯Î½Î±Î¹ Î±Ï€Î±ÏÎ±Î¯Ï„Î·Ï„ÎµÏ‚ Î³Î¹Î± Î½Î± Î»ÎµÎ¹Ï„Î¿Ï…ÏÎ³Î®ÏƒÎµÎ¹ ÏƒÏ‰ÏƒÏ„Î¬ Î¿Î¹ ÏƒÏ…Î½Î±ÏÏ„Î®ÏƒÎµÎ¹Ï‚ ElegxosNomimotitas ÎºÎ±Î¹ ElegxosOrthotitas
								m_WhoPlays = "Human";
								m_WrongColumn = false;
								m_OrthotitaKinisis = ElegxosOrthotitas(SkakieraDefenders, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								if (m_OrthotitaKinisis == true)
								{
									m_NomimotitaKinisis = ElegxosNomimotitas(SkakieraDefenders, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								}
								// Î•Ï€Î±Î½Î±Ï†Î¿ÏÎ¬ Ï„Î·Ï‚ ÎºÎ±Î½Î¿Î½Î¹ÎºÎ®Ï‚ Ï„Î¹Î¼Î®Ï‚ Ï„Î·Ï‚ m_WhoPlays
								m_WhoPlays = "HY";

								// NEW
								// You can count for all moves that "defend" a square,
								// except the move of a pawn forward! :)
								if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
								{
									if (m_FinishingColumnNumber_Attack == m_StartingColumnNumber_Attack)
									{
										m_OrthotitaKinisis = false;
									}
								}

								m_WhoPlays = "HY";
								if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
								{
									// A new defender for that square is found!
									Number_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Number_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;

									// Calculate the value (total value) of the defenders
									//MessageBox.Show(string.Concat("Added something to the value of defenders for (", (m_FinishingColumnNumber_Attack).ToString(), ",", (m_FinishingRank_Attack).ToString(), "): ", MovingPiece_Attack.ToString()));

									if ((MovingPiece_Attack.equals("White Rook")) || (MovingPiece_Attack.equals("BR")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 5;
									}
									else if ((MovingPiece_Attack.equals("WB")) || (MovingPiece_Attack.equals("BB")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WN")) || (MovingPiece_Attack.equals("BN")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WQ")) || (MovingPiece_Attack.equals("BQ")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 9;
									}
									else if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;
									}
									else if ((MovingPiece_Attack.equals("WK")) || (MovingPiece_Attack.equals("BK")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 15;
									}

									//v0.980: Removed Exception_defender_column/ rank since they are not used!
									// Exception for Defenders!
									// If the defender found is the only one, then that defender cannot move to that square,
									// since then the square would be again dangerous (since its only defender would have moved into it!)
									// If more than one defenders is found, then no exceptions exist.
									//if (Number_of_defenders[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] == 1)
									//{
									//    Exception_defender_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = (m_StartingColumnNumber_Attack - 1);
									//    Exception_defender_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = (m_StartingRank_Attack - 1);

									//    // DEBUGGING
									//    //if (((m_FinishingColumnNumber_Attack - 1) == 2) && ((m_FinishingRank_Attack - 1) == 4))
									//    //{
									//    //    MessageBox.Show("hOU");
									//    //    MessageBox.Show(String.Concat("Move found: ", m_StartingColumnNumber_Attack.ToString(), m_StartingRank_Attack.ToString(), "->", m_FinishingColumnNumber_Attack.ToString(), m_FinishingRank_Attack.ToString()));
									//    //    MessageBox.Show(String.Concat("Exception column: ",Exception_defender_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)]));
									//    //    MessageBox.Show(String.Concat("Exception rank: ",Exception_defender_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)]));
									//    //    MessageBox.Show(String.Concat("Exception column: ",(iii3).ToString()));
									//    //    MessageBox.Show(String.Concat("Exception rank: ",(jjj3).ToString() ));
									//    //}
									//    // PLAYING
									//}
									//else if (Number_of_defenders[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] > 1)
									//{
									//    Exception_defender_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = -99;
									//    Exception_defender_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = -99;
									//}

								}
							}
						}
					}
				}
			}
		}

public static void PawnPromotion()
{
			for (i = 0; i <= 7; i++)
			{
				if ((Skakiera[(i)][(0)].equals("BP")) && (m_WhoPlays.equals("Human")))
				{
					///////////////////////////
					// promote pawn
					///////////////////////////

					System.out.println("Promote to: 1. Queen, 2. Rook, 3. Knight, 4. Bishop? ");
					choise_of_user = Integer.parseInt(new Scanner(System.in).nextLine());

					switch (choise_of_user)
					{
						case 1:
							Skakiera[(i)][(0)] = "BQ";
							break;

						case 2:
							Skakiera[(i)][(0)] = "BR";
							break;

						case 3:
							Skakiera[(i)][(0)] = "BN";
							break;

						case 4:
							Skakiera[(i)][(0)] = "BB";
							break;
					};

				}


				if ((Skakiera[(i)][(7)].equals("WP")) && (m_WhoPlays.equals("Human")))
				{
					///////////////////////////
					// promote pawn
					///////////////////////////

					System.out.println("Promote to: 1. Queen, 2. Rook, 3. Knight, 4. Bishop? ");
					choise_of_user = Integer.parseInt(new Scanner(System.in).nextLine());

					switch (choise_of_user)
					{
						case 1:
							Skakiera[(i)][(0)] = "WQ";
							break;

						case 2:
							Skakiera[(i)][(0)] = "White Rook";
							break;

						case 3:
							Skakiera[(i)][(0)] = "WN";
							break;

						case 4:
							Skakiera[(i)][(0)] = "WB";
							break;
					};
				}

			}
		}

}