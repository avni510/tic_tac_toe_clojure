(ns tic-tac-toe-clojure.validation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation :refer :all]))

(def current-board
   [:x  1   2
    3   4  :x
    :o  :o :x])

(describe "Validation"
  (describe "execute"

    (it "returns an error string if the cell is taken"
      (should= {:errors "This cell is taken, please enter another move"}
               (execute current-board "0")))

    (it "returns nil if the cell is open"
      (should= {:errors nil} 
               (execute current-board "4")))

    (it "returns an error string if the input for a move is a string"
      (should= {:errors "Please enter an integer between 0 and 8"}
               (execute current-board "hello world")))

    (it "returns an error string if the input is a number less than 0"
      (should= {:errors "Please enter an integer between 0 and 8"}
               (execute current-board "-1")))

    (it "returns an error string if the input is a number greater than 8"
      (should= {:errors "Please enter an integer between 0 and 8"}
               (execute current-board "9")))

    (it "returns nil if the input is a number between 0 to 8"
      (should= {:errors nil}
               (execute current-board "2")))))
