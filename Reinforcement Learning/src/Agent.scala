import scala.io.Source
import scala.collection.mutable.HashMap
class Agent
{
  var game:Game = _
  var  Policy:HashMap[Int,List[Double]]
  def playMove(board:Board):Board =
  {
    //identifyState
    val state = identifyState(board)
    //changeTheBoard
    board.state += state
    //returntheBoard
    board
    
  }
  def initializeFromFile(path:String)
  {
    Policy = new HashMap[Int,List[Double]]()
    Source.fromFile(path).getLines().foreach
    {
      line =>
        val thisLine = line.trim.split(" ").map(x => x.toDouble)
        if(Policy.contains(thisLine(0).toInt))println("Error :  the policy state is duplicate")
        else Policy += thisLine(0).toInt -> thisLine.tail.toList
    }
  }
  def learn(reward:Int)
  {
    
  }
  def identifyState(board:Board):Int = 
  {
    board.state
  }
  def writeToFile
  {}
}