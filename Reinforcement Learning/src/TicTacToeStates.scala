object states
{
  var h:scala.collection.mutable.HashMap[Boolean, String] =  new scala.collection.mutable.HashMap[Boolean,String]()
  var allPos:scala.collection.mutable.HashSet[String] = new scala.collection.mutable.HashSet[String]
  var total = 0
  def main(args: Array[String]): Unit = 
  {
    h += (true -> "x")
    h += (false -> "o")
    var board:Array[Array[String]] = Array.fill(3, 3)("")
    genStates(board,true)
  }
  
  def genStates(board:Array[Array[String]],isTurnX:Boolean)
  {
     total +=1
     println(total)
    //println("I am here")
    //println("board : " + board.flatMap(x => x.mkString).mkString)
       (0 until board.size).foreach
       {
          row =>
            (0 until board(row).size).foreach
            {
              col =>
                if(board(row)(col) == "")
                {
                  board(row)(col) = h.get(isTurnX).get
                  val toBehashed = board.toList.flatMap
                  {
                    x =>
                        List(x.mkString(""))
                  }.mkString
                  //println(allPos.contains(toBehashed))
                  //println("is contained :" + toBehashed)
                  //println("I am at : " +row +" "+col)
                  if(!allPos.contains(toBehashed))
                  {
                    //allPos.add( toBehashed)
                    //println(toBehashed)
                   
                    genStates(board,!isTurnX)
                  }
                  board(row)(col) = ""
                  //println("after take out : " + board.flatMap(x => x.mkString).mkString)
                }
                //println(row +" "+ col)
                  
            }
       }
      /*  println("-----------------")
       val toBehashased = board.toList.flatMap
      {
                    x =>
                        List(x.mkString(""))
     }.mkString("\n")
     println(toBehashased)
     println("-----------------")*/
  }
}