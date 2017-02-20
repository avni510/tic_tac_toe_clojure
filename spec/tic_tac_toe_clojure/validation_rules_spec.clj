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
    (it "returns true if the input is not a number on the board"
      (should= true (invalid-cell? current-board 9)))
            
    (it "returns false if the input is a number on the board"
      (should= false (invalid-cell? current-board 5)))))


