(ns tic-tac-toe-clojure.game-selection-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-selection :refer :all]
            ))

(def game-menu
  {:1 "1. Human V. Simple Computer"
   :2 "2. Human V. Hard Computer"})

(describe "Game Selection"
  (around [it]
    (with-out-str (it)))

  (describe "run"
    (it "returns the type of game the user would like to play"
      (should= :human-v-simple-computer (with-in-str "1" (run game-menu))))

    (it "continues to ask the user to enter a game type if the user enters an invalid type"
      (should= :human-v-hard-computer (with-in-str "}\ne\n2  " (run game-menu))))))
