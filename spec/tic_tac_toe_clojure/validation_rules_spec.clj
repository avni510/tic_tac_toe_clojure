(ns tic-tac-toe-clojure.validation-rules-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation-rules :refer :all]))

(def current-board
   [:x  1   2
    3   4  :x
    :o  :o :x])

(describe "Validation Rules"
  (describe "cell-occupied?" 
    (it "returns true if the input is a cell occupied"
      (should= true (cell-occupied? current-board 6))))
          
    (it "returns false if the input is a cell not occupied"
      (should= false (cell-occupied? current-board 1)))
  
  (describe "invalid-cell?"
    (it "returns true if the input is a number greater than the max value on the board"
      (should= true (invalid-cell? current-board 9)))

    (it "returns true if the input is a number less than the min value on the board"
      (should= true (invalid-cell? current-board -2)))
            
    (it "returns false if the input is a number on the board"
      (should= false (invalid-cell? current-board 5))))

  (describe "invalid-marker?"
    (it "returns true is a special character"
      (should= true (invalid-marker? "!")))

    (it "returns true if the input is an integer"
      (should= true (invalid-marker? "0")))

    (it "returns true if the input is a blank space"
      (should= true (invalid-marker? " ")))

    (it "returns true if the input is a string"
      (should= true (invalid-marker? "hello world")))
          
    (it "returns false if the input is a lower case character of the alphabet"
      (should= false (invalid-marker? "o")))

    (it "returns false if the input is an upper case character of the alphabet"
      (should= false (invalid-marker? "X")))))


