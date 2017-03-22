(ns tic-tac-toe-clojure.validation.game-type-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation.game-type :refer :all]))

(def game-menu
  {:1 "1. Human V. Simple Computer"
   :2 "2. Human V. Hard Computer"})

(describe "Game Type"
  (describe "invalid-game-type?"
    (it "returns false if game type entered is a key in the game menu"
      (should= false (invalid-game-type? game-menu "1")))

    (it "returns true if game type entered is a letter and is not a key in the game menu"
      (should= true (invalid-game-type? game-menu "z")))

    (it "returns true if game type entered is a integer and is not a key in the game menu"
      (should= true (invalid-game-type? game-menu "5")))))
