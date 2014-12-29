import java.io._
object ReinforcementLearningModel
{
  def main(args: Array[String]): Unit = 
  {
    assignInitialRandomizedPolicy("player1Policy.txt")
    assignInitialRandomizedPolicy("player2Policy.txt")
    val reach100Game = new Game()
    trainAgentsMonteCarlo(reach100Game, 1000000)
  }
  def playAgainstHuman
  {}
  
  def trainAgentsMonteCarlo(game:Game, numberOfEpisodes:Int) 
  {
    
    //initialize agents
    game.player1 = new Agent("Player 1")
    game.player2 = new Agent("Player 2")
    game.board = new Board()
    game.player1.initializeFromFile("player1Policy.txt")
    game.player2.initializeFromFile("player2Policy.txt")
    
    //make them play against each other
    (0 until numberOfEpisodes).foreach
    {
      episode =>
        game.board.state = 0
        println(episode)
        val returns = game.playGame
        val (player1return, player2return) = dealReturns(returns)
        if (  (player1return, player2return) ==(0,0)   )throw new Exception("Err found as return")
        //manipulate returns
        game.player1.learnMonteCarloFirstVisit(player1return)
        game.player2.learnMonteCarloFirstVisit(player2return)
    }
    game.player1.writePolicyToFile("player1LearnedPol.txt")
    game.player2.writePolicyToFile("player1LearnedPol.txt")
  }
  def dealReturns(ret:String):(Int,Int) =
  {
    if(ret == "Err") 
    {
      (0,0)
    }
    else if(ret == "1") (1,0)
    else(0,1)
  }
  def assignInitialRandomizedPolicy(fileName:String)
  {
      val writer = new PrintWriter(new File(fileName))
      (0 to 100).foreach
      {
        num =>
          val probs = (1 to 10).map(x => 0.1).toList
          writer.write(num +" "+probs.mkString(" "))
          writer.write("\n")
      }
      writer.close()
  }
}