(ns tic-tac-toe-clojure.validation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation :refer :all]))

(def current-board
   [:x  1   2
    3   4  :x
    :o  :o :x])

(describe "Validation"
  (describe "execute-move"

    (it "returns an error string if the cell is taken"
      (should= {:errors "This cell is taken, please enter another move"}
               (execute-move current-board "0")))

    (it "returns nil if the cell is open"
      (should= {:errors nil} 
               (execute-move current-board "4")))

    (it "returns an error string if the input for a move is a string"
      (should= {:errors "This selection is invalid, please enter an integer between 0 and 8"}
               (execute-move current-board "hello world")))

    (it "returns an error string if the input is a number less than 0"
      (should= {:errors "This selection is invalid, please enter an integer between 0 and 8"}
               (execute-move current-board "-1")))

    (it "returns an error string if the input is a number greater than 8"
      (should= {:errors "This selection is invalid, please enter an integer between 0 and 8"}
               (execute-move current-board "9")))

    (it "returns nil if the input is a number between 0 to 8"
      (should= {:errors nil}
               (execute-move current-board "2"))))
          
  (describe "execute-marker"
    (it "returns an errors string if the input is not a valid character of the alphabet"
      (should= {:errors "This selection is invalid, please enter a marker between the characters A-Z"}
               (execute-marker "*")))

    (it "returns nil if the input is a valid character of the alphabet"
      (should= {:errors nil}
               (execute-marker "X")))))
