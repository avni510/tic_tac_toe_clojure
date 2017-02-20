(ns tic-tac-toe-clojure.game-loop-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-loop :refer :all]))

(def current-board
  [
   :x  1   2
    3  4   :x
   :o  :o  :x])

(describe "Game Loop"
;  (describe "valid-move-loop"
;    (around [it]
;      (with-out-str (it)))
;
;    (it "returns the move if it is valid"
;      (should= "4" (valid-move-loop current-board "4")))
;          
;    (it "prompts the user to enter another move if the first input was invalid"
;      (should= "3" (with-in-str "3" (valid-move-loop current-board "0"))))
;          
;    (it "continues to ask the to enter another move if their input is invalid"
;      (should= "3" (with-in-str "3\n#\n \nfive\n4.35" (valid-move-loop current-board "0")))))
          
  (describe "player-turn"
    (around [it]
      (with-out-str (it)))

    (it "" 
      (should= 1 1))))
          
