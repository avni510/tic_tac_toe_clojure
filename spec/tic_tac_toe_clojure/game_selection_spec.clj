(ns tic-tac-toe-clojure.game-selection-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.game-selection :refer :all]))

(def board-menu
  {:1 "1. 3X3 board"
   :2 "2. 4X4 board"})

(def game-menu
  {:1 "1. Human V. Simple Computer"
   :2 "2. Human V. Hard Computer"})

(describe "Game Selection"
  (around [it]
    (with-out-str (it)))

  (describe "run"
    (it "returns the type of game the user would like to play"
      (should= :human-v-simple-computer (with-in-str "1" (run (messages/game-type-instructions) game-menu))))

    (it "continues to ask the user to enter a game type if the user enters an invalid type"
      (should= :human-v-hard-computer (with-in-str "}\ne\n2  " (run (messages/game-type-instructions) game-menu))))

    (it "returns an empty board based on the user selection for the type of board they would like to play with"
      (should= :3X3-board (with-in-str "1" (run (messages/board-type-instructions) board-menu))))

    (it "returns an empty board based on the user selection for the type of board they would like to play with"
      (should= :4X4-board (with-in-str "2" (run (messages/board-type-instructions) board-menu))))))
