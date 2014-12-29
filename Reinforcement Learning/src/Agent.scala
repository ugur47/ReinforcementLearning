import scala.io.Source
import scala.collection.mutable.HashMap
import java.io._
import scala.util.Random
import scala.util.control.Breaks._
class Agent(name:String)
{
  var game:Game = _
  var  Policy:HashMap[Int,List[Float]] = new HashMap[Int,List[Float]]()
  def playMove(board:Board):Board =
  {
    //println("I am here " + name)
    //identifyState
    val state = identifyState(board)
    
    //get action 
    val policyForState = Policy.get(state).get
    
    val r = new Random().nextFloat()
    var whichAct = 0
    var i = 0
   breakable{
      
      //get cumilative list
      stepSum(List(0.0.toFloat),policyForState).foreach{
        possible =>
          if(possible > r) 
          {
            whichAct = i
            break
          }
          i += 1
      }
    }
    //println(whichAct)
    //changeTheBoard
    board.state += whichAct
    //returntheBoard
    board
    
  }
  
 def stepSum (sums: List [Float], steps: List [Float]) : List [Float] = steps match { 
     case Nil => sums.reverse.tail                                                  
     case x :: xs => stepSum (sums.head + x :: sums, steps.tail) }
  def initializeFromFile(path:String)
  {
    Policy = new HashMap[Int,List[Float]]()
    Source.fromFile(path).getLines().foreach
    {
      line =>
        val thisLine = line.trim.split(" ").map(x => x.toFloat)
        if(Policy.contains(thisLine(0).toInt))println("Error :  the policy state is duplicate")
        else Policy += thisLine(0).toInt -> thisLine.tail.toList
    }
    
  }
  def learnMonteCarloFirstVisit(reward:Int)
  {
    println(name + ": I am learning " + reward)
  }
  def learnMonteCarloEveryVisit(reward:Int)
  {
    
  }
  
  def identifyState(board:Board):Int = 
  {
    board.state
  }
  
  def writePolicyToFile(myPolicyFile:String)
  {
    val writer = new PrintWriter(new File(myPolicyFile))
    
    Policy.foreach
    {
      case (k,v) =>
        //val probs = (1 to 10).map(x => 0.1).toList
        writer.write(k +" "+v.mkString(" "))
        writer.write("\n")
    }
    writer.close
  }
}