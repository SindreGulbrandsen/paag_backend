# paag_backend
This repo is to develop the paag backend code


Requirements
Load a set of questions
Assign players to question, where relevant
Randomize questions
Create different game length
Be able to use the same code for different game modes


Classes

## Game (raw_output: mutableList<String>)
printQuestion(): String
nextQuestion()
prevQuestion()
checkGameEnd(): Bool
addPlayer()
removePlayer()

output mutableListOf<Question>
players mutableListOf<Player>
current int
rounds int
raw_output mutableListOf<String>

## Player
getName(): String
name

## Question(questionText: String, players: MutableList<Player>)
generateQuestionText(qt: String): String
extractSips(word_list: List<String>): Int


questionText String
players mutableListOf<Player>
color int
sips int
player_identifiers private list<String>

