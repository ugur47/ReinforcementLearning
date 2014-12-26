object ReinforcementLearningModel
{
  def main(args: Array[String]): Unit = 
  {
    
  }
  def playAgainstHuman
  {}
  
  def trainAgentsMonteCarlo(game:TicTacToeGame, numberOfEpisodes:Int) 
  {
    (0 until numberOfEpisodes).foreach
    {
      episode =>
        val returns = game.playGame
        val player1Return = returns.toInt
        val player2Return = returns.toInt
        
        //manipulate returns
        game.player1.learn(player1Return)
        game.player2.learn(player2Return)
    }
  }
  
}