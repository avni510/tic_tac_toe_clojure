(ns tic-tac-toe-clojure.messages)

(defn player-turn [marker]
  (str "It is Player " marker "'s turn"))

(defn player-move []
  "Please enter your move by selecting a number between 0 and 8")

(defn tied-game []
  "The game ended in a tie")

(defn won-game [marker]
  (str "The game is won by the player with marker " marker))

(defn pick-marker [marker1 marker2]
  (str "Please pick either '" marker1 "' or '" marker2 "' for your marker"))

(defn valid-marker []
  "Please enter a valid marker")

(defn board-string [board]
  (str " "(nth board 0) " | " (nth board 1) " | " (nth board 2) 
       "\n===+===+===\n " 
       (nth board 3) " | " (nth board 4) " | " (nth board 5) 
       "\n===+===+===\n " 
       (nth board 6) " | " (nth board 7) " | " (nth board 8) "\n"))

