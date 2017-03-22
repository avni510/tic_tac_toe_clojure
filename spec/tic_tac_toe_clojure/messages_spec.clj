(ns tic-tac-toe-clojure.messages-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.messages :refer :all]))

(describe "Messages"
  (describe "player-turn"
    (it "returns a string stating whose turn it is"
      (should= "It is Player X's turn"
               (player-turn :x))))

  (describe "player-move-instructions"
    (it "returns a string stating the user to enter their move"
      (should= "Please enter your move by selecting a number between 0 and 8"
               (player-move-instructions [
                                           0 :x 2
                                           3  4 5
                                           6  7 8]))))

  (describe "tied-game"
    (it "returns a string stating the game is tied"
      (should= "The game ended in a tie"
               (tied-game))))

  (describe "won-game"
    (it "returns a string stating the game is won"
      (should= "The game is won by the player with marker O"
               (won-game :o))))

  (describe "pick-marker"
    (it "returns a string stating for the user to pick their marker"
      (should= "Please pick either 'X' or 'O' for your marker"
               (pick-marker :x :o))))

 (describe "valid-marker"
    (it "returns a string stating for the user to pick a valid marker"
      (should= "Please enter a valid marker"
               (valid-marker))))

  (describe "board-string"
    (context "it is a 3X3 board"
      (it "displays the board as a string"
        (should= "  0 |  X |  O \n====+====+====\n  3 |  4 |  5 \n====+====+====\n  6 |  7 |  8 "
                 (board-string
                  [ 0  :x  :o
                    3  4  5
                    6  7  8]))))

    (context "it is a 4X4 board"
      (it "displays the board as a string"
        (should="  0 |  X |  O |  3 \n====+====+====+====\n  4 |  X |  6 |  7 \n====+====+====+====\n  8 |  9 |  X |  O \n====+====+====+====\n  X | 13 | 14 | 15 "
                (board-string
                 [ 0  :x  :o 3
                   4  :x  6 7
                   8  9  :x :o
                   :x 13  14 15 ])))))

  (describe "game-instructions"
    (it "displays instructions for the game"
      (should= "Please select your marker by entering a character between A-Z"
               (game-instructions))))

  (describe "blank-space"
    (it "displays a blank space"
      (should= " "
               (blank-space))))

  (describe "invalid-player-type"
    (it "displays a string stating the type of player does not exist"
      (should= "This player type does not exist"
               (invalid-player-type))))

  (describe "computer-move"
    (it "displays a string stating which space the computer moved to"
      (should= "The computer selected cell 6"
               (computer-move 6))))

  (describe "computer-marker"
    (it "displays a string stating what marker the computer is"
      (should= "The computer is marker X"
               (computer-marker :x))))

  (describe "game-type-instructions"
    (it "displays a string stating instructions to select a game type"
      (should= "Please select which type of game you would like to play" (game-type-instructions))))

  (describe "board-type-instructions"
    (it "displays a string stating instructions to select a game type"
      (should= "Please select which type of game you would like to play" (game-type-instructions))))

  (describe "game-menu-instructions"
    (it "displays instructions to select an option from the menu"
      (should= "Enter a number next to the choice" (game-menu-instructions)))))
