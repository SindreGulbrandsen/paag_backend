package com.example.paag_multi.Classes

class Game (raw_output: MutableList<String> = mutableListOf()){
    var output = mutableListOf<Question>()
    var players = mutableListOf<Player>()
    var current = 0
    val rounds = output.size
    var raw_output = mutableListOf<String>()

    init {
        this.raw_output = raw_output
        //raw_output = mutableListOf("Question 1", "Question 2 *p*", "Question 3", "Question 4", "Question 5", "Question 6 *p*")
        players = mutableListOf(Player("Player 1"), Player("Player 2"))
        raw_output.shuffle()
        raw_output.add("Game Over")
        output.add(Question(raw_output[current],players))
    }

    fun printQuestion(): String{
        try{
            return output[current].questionText
        }catch(e: Error){
            return "Error: Dont find the question"
        }
    }
    fun nextQuestion(){
        if (!checkGameEnd()){
            current++
            output.add(Question(raw_output[current], players))
        }
    }
    fun prevQuestion(){
        if(current > 0){
            current--
        }
    }
    fun checkGameEnd(): Boolean = current >= raw_output.size - 1

    fun addPlayer(player: Player){
        players.add((player))
    }
    fun removePlayer(playerName: String) {
        val playerToRemove = players.indexOfFirst { it.getName() == playerName }
        if (playerToRemove != -1) {
            players.removeAt(playerToRemove)
        }
    }

}
