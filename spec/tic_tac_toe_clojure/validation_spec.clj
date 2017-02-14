(ns tic-tac-toe-clojure.validation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation :refer :all]))

(def current-board
  [ 
   "X" "" ""
   "" "" "X"
   "O" "O" "X"                                                                  
  ])

(describe "validation"
  (it "returns an error string if the cell is taken"
    (should= "This cell is taken, please enter another move" 
             (execute current-board "0")))

  (it "returns nil if the cell is open"
    (should= nil 
             (execute current-board "4")))

  (it "returns an error string if the input for a move is a string"
    (should= "Please enter an integer between 0 and 8" 
             (execute current-board "hello world")))

  (it "returns an error string if the input is a number less than 0"
    (should= "Please enter an integer between 0 and 8" 
             (execute current-board "-1")))

  (it "returns an error string if the input is a number greater than 8"
    (should= "Please enter an integer between 0 and 8" 
             (execute current-board "9")))

  (it "returns nil if the input is a number between 0 to 8"
    (should= nil
             (execute current-board "2"))))

