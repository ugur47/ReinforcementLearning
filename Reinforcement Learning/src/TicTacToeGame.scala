class TicTacToeGame
{
  var player1:Agent = _
  var player2:Agent = _
  var board:TicTacToeBoard =_
  
  def playGame:String =
  {
    var curPlayer = player1
    
    while(isWonLost(board)._1)
    {
      //change Players
      if(curPlayer==player1) curPlayer= player2
      else curPlayer = player1
      
      //make move
      //board = curPlayer.playMove(board)
    }
    
    //return score
    return isWonLost(board)._2
  }
  
  def isWonLost(Ticboard:TicTacToeBoard):(Boolean,String) =
  {
    val board = Ticboard.thisboard
    //rowwise check
    (0 until 3).foreach
    {
      i =>
        if(board(i).forall(x => x == board(i)(0)))
        {
          
          if(board(i)(0) =="x")
          {
            return (true, "x")
          }
          else if(board(i)(0) =="0")
          {
            return (true,"o")
          }
          
        }
    }
    //columnwise check
    (0 until 3).foreach
    {
      i =>
        val checkBoard = List(board(0)(i),board(1)(i),board(2)(i))
        if(checkBoard.forall(x => x == checkBoard(0)))
        {
          if(checkBoard(0) =="x")
          {
            return (true, "x")
          }
          else if(checkBoard(0) =="o")
          {
            return (true, "o")
          }
        }
    }
    //corner win check
   val checkBoard1 = List(board(0)(0),board(1)(1),board(2)(2))
   if(checkBoard1.forall(x => x == checkBoard1(0)))
   {
      if(checkBoard1(0) =="x")
      {
        return (true,"x")
      }
      else if(checkBoard1(0) =="o")
      {
        return (true,"o")
      }
    }
   val checkBoard2 = List(board(2)(0),board(1)(1),board(0)(2))
   if(checkBoard2.forall(x => x == checkBoard2(0)))
   {
      if(checkBoard2(0) =="x")
      {
        return (true, "x")
      }
      else if(checkBoard2(0) =="o")
      {
        return (true, "o")
      }
    }
    return (false, "")
  }
}