(ns tic-tac-toe-clojure.messages
  (:require [clojure.string :as string]
            [tic-tac-toe-clojure.board :as board]))

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

(defn- add-newline-characters [message]
  (str "\n" message "\n"))

(defn- board-divider [board]
  (let [dashes "===="
        plus-sign "+"]
    (->>
        (repeat (board/board-dimension board) dashes)
        (string/join plus-sign)
        (add-newline-characters))))

(defn board-string [board]
  (->>
    (map #(board/convert-space-to-string %) board)
    (partition (board/board-dimension board))
    (map #(clojure.string/join "|" %))
    (clojure.string/join (board-divider board))))

(defn game-instructions  []
  "Please select your marker by entering a character between A-Z")

(defn blank-space []
  " ")

(defn invalid-player-type []
  "This player type does not exist")

(defn computer-move [cell]
  (str "The computer selected cell " cell))

(defn computer-marker [marker]
  (str "The computer is marker " (string/upper-case (name marker))))

(defn game-type-instructions []
  "Please select which type of game you would like to play")

(defn game-menu-instructions []
  "Enter a number next to the choice")
