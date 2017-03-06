(ns tic-tac-toe-clojure.game-completion-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-completion :refer :all]))

(def tied-board
 [
  :x  :o  :o
  :o  :x  :x
  :o  :x  :o ])

(describe "Game Completion"
  (describe "game-over-message"
    (around [it]
      (with-out-str (it)))

    (it "displays a tied message if the game is tied"
      (should= "The game ended in a tie"
               (game-over-message
                [
                 :x  :o  :o
                 :o  :x  :x
                 :o  :x  :o ])))


    (it "displays the winning marker X if the game is won by Player X"
      (should= "The game is won by the player with marker X"
               (game-over-message
                [
                 0    1  :o
                 3   :o   5
                 :x  :x  :x ])))

    (it "displays the winning marker O if the game is won by Player O"
      (should= "The game is won by the player with marker O"
               (game-over-message
                [
                 :o  1  2
                 :o  :x  :x
                 :o  7  8])))))
