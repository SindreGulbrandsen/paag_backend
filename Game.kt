package com.example.paag_multi.Classes

class Game {
    var output = mutableListOf<String>("Question 1", "Question 2 *p*")
    var players = mutableListOf<Player>(Player("Player 1"), Player("Player 2"))
    var current = 0
    val rounds = output.size

    fun printQuestion(): String{
        try{
            return output[current]
        }catch(e: Error){
            return "Error: Dont find the question"
        }
    }
    fun nextQuestion(){
        if (!checkGameEnd()){
            current++
        }
    }
    fun prevQuestion(){
        if(current < 0){
            current--
        }
    }
    fun checkGameEnd(): Boolean{
        if (current >= output.size){
            return true
        }
        return false
    }
}
