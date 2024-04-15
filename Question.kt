package com.example.paag_multi.Classes


class Question(questionText: String, players: MutableList<Player> = mutableListOf()) {
    val questionText: String
    var color = "Blue"
    private var player_identifier = "*p*"

    init {
        if(players.isNotEmpty()){
            this.questionText = questionText.replace(player_identifier, players[0]?.getName() ?: "")
        }else{
            this.questionText = questionText
        }
    }

}
