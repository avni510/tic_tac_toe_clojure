(ns tic-tac-toe-clojure.messages
  (:require [clojure.string :as string]))

(defn player-turn [marker]
  (str "It is Player " (string/upper-case (name marker)) "'s turn"))

(defn player-move []
  "Please enter your move by selecting a number between 0 and 8")

(defn tied-game []
  "The game ended in a tie")

(defn won-game [marker]
  (str "The game is won by the player with marker " (string/upper-case (name marker))))

(defn pick-marker [marker1 marker2]
  (str "Please pick either '" (string/upper-case (name marker1)) "' or '" (string/upper-case (name marker2)) "' for your marker"))

(defn valid-marker []
  "Please enter a valid marker")

(defn- convert-to-string [cell]
  (if (number? cell)
    cell
    (string/upper-case (name cell))))

(defn board-string [board]
  (str " "(convert-to-string (nth board 0)) " | " 
       (convert-to-string (nth board 1)) " | " 
       (convert-to-string (nth board 2))
       "\n===+===+===\n " 
       (convert-to-string (nth board 3)) " | " 
       (convert-to-string (nth board 4)) " | " 
       (convert-to-string (nth board 5)) 
       "\n===+===+===\n " 
       (convert-to-string (nth board 6)) " | " 
       (convert-to-string (nth board 7)) " | " 
       (convert-to-string (nth board 8)) "\n"))

