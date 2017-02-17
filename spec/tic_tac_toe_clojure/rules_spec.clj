(ns tic-tac-toe-clojure.rules-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.rules :refer :all]))

(def current-board
  ["X" "1" "2"
   "3" "4" "X"
   "O" "O" "X"])

(describe "Rules"

  (around [it]
    (with-out-str (it)))

  (describe "valid-move-loop"
    (it "returns the move if it is valid"
      (should= "4" (valid-move-loop current-board "4")))
          
    (it "prompts the user to enter another move if the first input was invalid"
      (should= "3" (with-in-str "3" (valid-move-loop current-board "0"))))))
