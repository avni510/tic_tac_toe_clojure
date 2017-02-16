(ns tic-tac-toe-clojure.messages-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.messages :refer :all]))

(def marker-o
  "O")

(def marker-x
  "X")

(describe "messages" 
  (it "returns a string stating whose turn it is"
    (should= "It is Player X's turn"
             (player-turn "X")))

  (it "returns a string stating the user to enter their move"
    (should= "Please enter your move by selecting a number between 0 and 8"
             (player-move)))
  
  (it "returns a string stating the game is tied"
    (should= "The game ended in a tie"
             (tied-game)))
          
  (it "returns a string stating the game is won"
    (should= "The game is won by the player with marker O"
             (won-game "O")))

  (it "returns a string stating for the user to pick their marker"
    (should= "Please pick either 'X' or 'O' for your marker"
             (pick-marker marker-x marker-o)))

  (it "returns a string stating for the user to pick a valid marker"
    (should= "Please enter a valid marker"
             (valid-marker)))
          
  (it "displays the board as a string"
    (should=" 1 | X | O\n===+===+===\n 3 | O | X\n===+===+===\n O | X | O\n"
             (board-string 
              ["1" "X" "O" 
               "3" "O" "X" 
               "O" "X" "O"] 
               )))) 

