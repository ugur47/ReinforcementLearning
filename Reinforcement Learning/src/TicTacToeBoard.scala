class TicTacToeBoard extends Board
{
  var thisboard:Array[Array[String]] = _
  
  def printBoard()
  {
    println("------------------------------------")
    println(thisboard.map(x => x.mkString("")).mkString("\n"))
    println("------------------------------------")
  }
}