(ns tic-tac-toe-clojure.player.human-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.player :refer [play-turn]]
            [tic-tac-toe-clojure.player.human :refer :all]))

(def current-board
  [
   :x  1   2
    3  4   :x
   :o  :o  8])

(describe "Human"
  (describe "play-turn"
    (around [it]
      (with-out-str (it)))

    (context "the player type is a human"
      (it "prompts the user to enter their move and returns a board"
        (should= [
                  :x  1   2
                   3  4   :x
                  :o  :o  :x]
                 (with-in-str "8"
                   (play-turn {:board current-board
                               :current-player {:player-type :human :marker :x}})))))

      (context "the user enters an invalid move"
        (it "continues to prompts the user to enter another move"
          (should= [
                    :x  1   2
                     3  4   :x
                    :o  :o  :o]
                   (with-in-str "8\n#\n    \nfive\n4.35"
                     (play-turn {:board current-board
                                 :current-player {:player-type :human :marker :o}})))))))
