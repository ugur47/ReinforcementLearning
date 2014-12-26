object StateGeneration
{
  //var allPos:scala.collection.mutable.HashSet[String] = new scala.collection.mutable.HashSet[String]
  var total = 0
  var totalTerminals = 0
  var terminalDraw = 0
  var terminalsX = 0
  var terminalsO =0
  val symbols = List("-","x","o")
  def main(args: Array[String]): Unit = 
  {
    //h += (true -> "x")
    //h += (false -> "o")
    var board:Array[Array[String]] = Array.fill(3, 3)("-")
    genStates(board,0,0)
    println(terminalsX+" "+terminalsO)
  }
  
  def genStates(board:Array[Array[String]],x:Int,y:Int)
  {
    if(x==2 && y==2)
    {
      //total += 3 
      //println(total)
      (0 until symbols.length).foreach
      {
        i =>
          board(x)(y) = symbols(i)
          if(isValidState(board))
          {
            total +=1
            calcTerminal(board)
            printBoard(board)
          }
      } 
      return
    }
    
    val (newX,newY) = incrementState(x,y)
    
    (0 until symbols.length).foreach
    {
      i =>
        board(x)(y) = symbols(i)
        //if(isValidState(board))
        //{
          //calcTerminal(board)
          genStates(board,newX,newY)
        //}
        //else
          //printBoard(board)
    }
    
  }
  def incrementState(x:Int,y:Int):(Int,Int)=
  {
    if(y!=2)
      (x,y+1)
    else
      (x+1,0)
  }
  def printBoard(board:Array[Array[String]])
  {
    println("---------------" + total +"-------------------")
    println(board.map(x => x.mkString("")).mkString("\n"))
    println("------------------------------------")
  }
  def calcTerminal(board:Array[Array[String]]):Boolean =
  {
    //rowwise check
    (0 until 3).foreach
    {
      i =>
        if(board(i).forall(x => x == board(i)(0)))
        {
          
          if(board(i)(0) =="x")
          {
            terminalsX += 1
            return true
          }
          else if(board(i)(0) =="0")
          {
            terminalsO += 1
            return true
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
            terminalsX += 1
            return true
          }
          else if(checkBoard(0) =="o")
          {
            terminalsO += 1
            return true
          }
        }
    }
    //corner win check
   val checkBoard1 = List(board(0)(0),board(1)(1),board(2)(2))
   if(checkBoard1.forall(x => x == checkBoard1(0)))
   {
      if(checkBoard1(0) =="x")
      {
        terminalsX += 1
        return true
      }
      else if(checkBoard1(0) =="o")
      {
        terminalsO += 1
        return true
      }
    }
   val checkBoard2 = List(board(2)(0),board(1)(1),board(0)(2))
   if(checkBoard2.forall(x => x == checkBoard2(0)))
   {
      if(checkBoard2(0) =="x")
      {
        terminalsX += 1
        return true
      }
      else if(checkBoard2(0) =="o")
      {
        terminalsO += 1
        return true
      }
    }
    return false
  }
  def isValidState(board:Array[Array[String]]):Boolean =
  {
    var noX = 0
    var noO = 0 
    
    board.foreach
    {
      row =>
        row.foreach
        {
          elem =>
            if(elem == "x") noX +=1
            else if(elem == "o") noO +=1
        }
    }
    Math.abs(noX-noO) <= 1
  }
  
}