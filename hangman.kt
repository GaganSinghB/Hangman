// Hangman figures
fun hangman(i: Int){
  if(i == 0) {
    println("   _______")
    println("   |     |")
    println("   |")
    println("   |")
    println("   |")
    println("   |")
    println("___|___")
  }
  if(i == 1) {
    println("   _______")
    println("   |     |")
    println("   |     O")
    println("   |")
    println("   |")
    println("   |")
    println("___|___")
  }
  if(i == 2) {
    println("   _______")
    println("   |     |")
    println("   |     O")
    println("   |     |")
    println("   |     |")
    println("   |")
    println("___|___")
  }
  if(i == 3) {
    println("   _______")
    println("   |     |")
    println("   |     O")
    println("   |    /|")
    println("   |     |")
    println("   |")
    println("___|___")
  }
  if(i == 4) {
    println("   _______")
    println("   |     |")
    println("   |     O")
    println("   |    /|\\")
    println("   |     |")
    println("   |")
    println("___|___")
  }
  if(i == 5) {
    println("   _______")
    println("   |     |")
    println("   |     O")
    println("   |    /|\\")
    println("   |     |")
    println("   |    /")
    println("___|___")
  }
  if(i == 6) {
    println("   _______")
    println("   |     |")
    println("   |     O")
    println("   |    /|\\")
    println("   |     |")
    println("   |    / \\")
    println("___|___")
  }
}

// Main Game function
fun game(player_01: String, player_02: String): Int{
  var win: Int = 0  // Will change to 1 if the player guessed the movie name
  var letters: String = ""  // All correct letters that the PLAYER_02 guessed
  var guesses: Int = 0 // Number of guesses per game

  println(player_01 + ", please input the name of the movie you want " + player_02 + " to guess: ")
  var movie: String = readLine()!!  //Name of movie set by PLAYER_01
  
  for (i in 1..100) {
    println()
  }
  
  hangman(0)
  printQuestion(movie, letters)
  println("\n" + player_02 + ", you can either guess a LETTER or the FULL NAME of the movie: ")

  // PLAYER_02 gets 6 chances to guess the movie name
  while(guesses < 6){
    var answer = readLine()!! //  PLAYER_02's guess
    var test: Int = 0 

    for (j in 1..100) {
      println()
    }
    
    if(answer.length > 1) {
      if(answer.uppercase() == movie.uppercase()) {
        println("CONGRATULATIONS, " + player_02 + "...YOU WON!!!")
        win = 1
        break
      }
      else {
        guesses++
        if(guesses < 6) {
          hangman(guesses)
          printQuestion(movie, letters)
          println("\nYOU GUESSED WRONG, TRY AGAIN: ")
          println()
        }
        else {
          hangman(guesses)
          println("YOU COULDN'T GUESS THE NAME OF THE MOVIE")
          println("MOVIE NAME: " + movie)
        }
      }
    }
    else {
      var check: Int = 0  // Will change to 1 if PLAYER_02 repeats a (correct) guess 

      // Checks if PLAYER_02 repeats a guess
      for(j in letters) {
        for(k in answer)
        // if(j == k || k == 'A' || k =='a' || k =='E' || k =='e' || k =='I' || k =='i' || k =='O' || k =='o' || k =='U' || k =='u') {
        if(j == k || k == 'A' || k =='a') {
          check = 1
        }
      }

      // Will add letter to "letter" string if guess is correct 
      if (check == 0){
        for(j in movie) {
          for(k in answer) {
            if (j == k) {
              letters = letters + k
              test = 1
            }
          }
          if(test == 1) {
            break
          }
        }
        
        if(test == 0){
          guesses++
          if(guesses < 6) {
            hangman(guesses)
            printQuestion(movie, letters)
            println("\nYOU GUESSED WRONG, TRY AGAIN: ")
            println()
          }
          else {
            hangman(guesses)
            println("YOU COULDN'T GUESS THE NAME OF THE MOVIE")
            println("MOVIE NAME: " + movie)
          }
        }
        else {
          hangman(guesses)
          printQuestion(movie, letters)
          println("\nYOU GUESSED CORRECT: ")
        }
      }
      else {
        hangman(guesses)
        printQuestion(movie, letters)
        println("\nYOU GUESSED CORRECT: ")
      }
    }
  }
  return win
}

// Changes movie name to a series of "_"s and will update if PLAYER_02 guesses correct
fun printQuestion(movie: String, letters: String) {
  for (i in movie) {
    var x: Int = 0
    for(j in letters) {
      if(i == j) {
        print(i + " ")
        x = 1
      }
    }

    // if(i == 'A' || i =='a' || i =='E' || i =='e' || i =='I' || i =='i' || i =='O' || i =='o' || i =='U' || i =='u'){
    if(i == 'A' || i =='a'){
      print(i + " ")
    }
    else if(( i < 'A' && i > 'Z') || (i < 'a' && i > 'z')) {
      print(i)
    }
    else if(i == ' ') {
      print("  ")
    }
    else {
      if(x == 0){
        print("_ ")
      }
    }
  }
}

fun main() {
  var x: Int = 1  // Decides if score needs to be set or not
  var p1Game: Int = 0 // Number of games played by P1
  var p2Game: Int = 0 // Number of games played by P2
  var p1Score: Int = 0  // Number of games P1 won
  var p2Score: Int = 0  // Number of games P2 won
  var game: Int

  println("RULES :-")
  println("1. Player_01 will enter the name of a movie")
  println("2. Player_02 will try to guess it by guessing letters")
  println("3. Player_02 can also attempt o guess the full name")
  println("4. Each wrong guess will lead to the man being hanged")
  println("\nPlease enter your name, PLAYER 1: ")
  var player_01: String = readLine()!!.uppercase()
  println("Please enter your name, PLAYER 2: ")
  var player_02: String = readLine()!!.uppercase()
  
  game = game(player_01, player_02)

  while(x == 1 || x == -1) {
    println("Would you like to play again? (y/n): ")
    var response = readLine()!!

    // Sets score
    if (x == 1){
      if(game == 1){
        p2Score++
      }
      p2Game++
    }
    else {
      if(game == 1){
        p1Score++
      }
      p1Game++
    }

    for (j in 1..100) {
      println()
    }

    if(response == "Y" || response == "y") {
      x = x * -1
      if (x == 1){
        game = game(player_01, player_02)
      }
      else {
        game = game(player_02, player_01)     
      }
    }
    else {
      println("THANK YOU FOR PLAYING!!!")
      println(player_01 + "'S SCORE: " + p1Score + "/" + p1Game)
      println(player_02 + "'S SCORE: " + p2Score + "/" + p2Game)
      x = 0
    }
  }
}
