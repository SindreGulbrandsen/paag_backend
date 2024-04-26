# paag_backend
This repo is to develop the paag backend code

# TODO 
- Create load from file functionallity for both android and ios (https://stackoverflow.com/questions/68191209/file-io-with-kotlin-multiplatform)
- Create UI for both android and ios
- Colors: Color pallete inspo: https://hookagency.com/blog/color-schemes/ | https://no.pinterest.com/pin/378302437451189011/ | https://coolors.co/ (https://coolors.co/514b23-ef2d56-026bb1-d7bea8-23ce6b)


Requirements
Load a set of questions
Assign players to question, where relevant
Randomize questions
Create different game length
Be able to use the same code for different game modes


# Game Class Documentation

## Overview
The `Game` class represents a game consisting of questions and players. It manages the progression of the game, tracks the current question, and handles player management.

## Attributes
- **raw_output**: MutableList<String> - A list of raw question strings provided to the game.
- **output**: MutableList<Question> - A list of Question objects representing the questions in the game.
- **players**: MutableList<Player> - A list of Player objects representing the players participating in the game.
- **current**: Int - The index of the current question being displayed.
- **rounds**: Int - The total number of rounds in the game.

## Constructor
- **Game(raw_output: MutableList<String> = mutableListOf())**: Initializes the game with the provided raw question strings and default players. It shuffles the questions, adds a "Game Over" message, and creates the first question.

## Methods
- **printQuestion(): String**: Retrieves and returns the text of the current question. If an error occurs (e.g., current question not found), it returns an error message.
- **nextQuestion()**: Moves to the next question in the game if the game has not ended.
- **prevQuestion()**: Moves to the previous question in the game if possible.
- **checkGameEnd(): Boolean**: Checks if the game has ended by comparing the current round with the total number of rounds.
- **addPlayer(player: Player)**: Adds a player to the game.
- **removePlayer(playerName: String)**: Removes a player from the game based on their name.

## Usage
1. Create a new instance of the `Game` class, optionally providing a list of raw question strings.
2. Access and manipulate the game state using the provided methods.
3. Interact with players and questions as needed during gameplay.


# Player Class Documentation

## Overview
The `Player` class represents a player in the game. It stores the player's name and provides a method for accessing the player's name.

## Attributes
- **name**: String - The name of the player.

## Constructor
- **Player(name: String)**: Initializes a player with the provided name.

## Methods
- **getName(): String**: Returns the name of the player.

## Usage
1. Create a new instance of the `Player` class, providing the player's name.
2. Access the player's name using the `getName()` method.
  

# Question Class Documentation

## Overview
The `Question` class represents a single question in the game, with dynamic text generation based on provided templates and player data.

## Attributes
- **questionText**: String - The text of the question, dynamically generated based on templates and player data.
- **players**: MutableList<Player> - A list of Player objects associated with the question.
- **color**: String - The color associated with the question (default: "Blue").
- **sips**: Int - The number of sips associated with the question, extracted from the question text.
- **player_identifiers**: List<String> - Identifiers used to reference players within the question text.

## Constructor
- **Question(questionText: String, players: MutableList<Player> = mutableListOf())**: Initializes a question with the provided question text and optional list of players. It generates the question text dynamically based on templates and player data.

## Methods
- **generateQuestionText(qt: String): String**: Generates the question text dynamically based on provided templates and player data. It extracts the number of sips and replaces placeholders with player names and other dynamic content.
- **extractSips(word_list: List<String>): Int**: Extracts the number of sips from the last word in the question text, if present. It returns -1 if the last word is not convertible to an integer.

## Usage
1. Create a new instance of the `Question` class, providing the question text and optionally a list of associated players.
2. Access the generated question text using the `questionText` attribute.
3. Interact with the question object as needed during gameplay, such as retrieving the number of sips or associated players.

*documentation created by chatGPT
