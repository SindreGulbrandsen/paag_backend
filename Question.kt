package com.example.paag_multi.Classes

import kotlin.random.Random


class Question(questionText: String, players: MutableList<Player> = mutableListOf()) {
    val questionText: String
    var players = mutableListOf<Player>()
    var color = "Blue"
    var sips = -1
    private var player_identifiers = listOf("@1", "@2")

    init {
        this.players = players
        this.questionText = generateQuestionText(questionText)
    }

    private fun generateQuestionText(qt: String): String {
        var word_list = qt.split(" ")

        sips = extractSips(word_list)
        var final = ""
        if(sips != -1 ){
            word_list = word_list.dropLast(1)
        }
        for ((i, word) in word_list.withIndex()){
            if(word in player_identifiers){
                val p = players.random()
                final += p.getName()
                players.remove(p)
            }
            else if (word.startsWith("€")){
                when (word) {
                    "€" -> final += sips.toString()
                    "€lurk" -> final += if (sips > 1) "slurker" else "slurk"
                    "€n" -> final += "\n"
                    "€drikk/del" -> final += if (Random.nextInt(2) == 0) "drikker" else "kan dele ut"
                    "€char" -> {
                        val charArray = listOf("A", "B", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V")
                        final += charArray.random()
                    }
                    else -> final += word
                }
            }
            else{
                final += word
            }
            if(i < word_list.size -1 && !word_list[i + 1].matches(Regex("[,.!?]"))) { // Check if word does not end with punctuation
                final += " "
            }
            /*if(i < word_list.size - 1)

            }*/
        }
        return final

    }

    private fun extractSips(word_list:  List<String>): Int {
        val last_word = word_list.lastOrNull()
        val isLastStringConvertibleToInt = try {
            last_word?.toIntOrNull() != null
        } catch (e: NumberFormatException) {
            false
        }

        return if (isLastStringConvertibleToInt) {
            last_word.toString().toInt()
        } else {
            -1
        }
    }
}

