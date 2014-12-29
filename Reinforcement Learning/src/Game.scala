class Game
{
  var player1:Agent = _
  var player2:Agent = _
  var board:Board =_
  def playGame:String =
  {
    var curPlayer = player1
    
    while(!isWonLost(board))
    {
      //change Players
      if(curPlayer==player1) curPlayer= player2
      else curPlayer = player1
      
      //make move
      board = curPlayer.playMove(board)
    }
    
    //return score
    if(isWonLost(board))
    {
      if(curPlayer == player1) return "1"
      else return "2"
    }
    return "Err"
  }
  def isWonLost(board:Board) = board.state >=100
}