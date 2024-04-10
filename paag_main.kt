class Game(){
    var output = arrayOf("Jeg har aldri vært på fest", "Bjørnar drikker", "Alle jenter drikker")
    var current = 0
    
    fun nextQuestion(){ current++ }
    fun prevQuestion(){ current-- }
    fun printOutput(): String{ return output[current] }
}

fun play(){
    var game: Game = Game()
    println(game.printOutput())
    
}

fun main() {
    play()
}
