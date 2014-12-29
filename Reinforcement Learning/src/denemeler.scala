object denemeler
{
  def main(args: Array[String]): Unit = 
  {
    val l = List[Float](1.1.toFloat, 2.2.toFloat, 3.1.toFloat)
    l.foldLeft((0.0.toFloat, List[Float]())){(acu,i)=>(i+acu._1, i+acu._1 :: acu._2)}._2.reverse.foreach(println)
    stepSum(List(0.0.toFloat),l).foreach(println)
  }
  def stepSum (sums: List [Float], steps: List [Float]) : List [Float] = steps match { 
     case Nil => sums.reverse.tail                                                  
     case x :: xs => stepSum (sums.head + x :: sums, steps.tail) }
}