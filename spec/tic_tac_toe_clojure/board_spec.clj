(ns tic-tac-toe-clojure.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.board :refer :all]))

(describe "board" 
  (it "returns an empty board"
    (should= [ 
               "0" "1" "2"
               "3" "4" "5"
               "6" "7" "8"
             ] 
             (get-board empty-board)))

  (it "returns a board with a filled in marker" 
    (should= [ 
               "0" "X" "2"
               "3" "4" "5"
               "6" "7" "8"
             ] 
             (fill-board empty-board 1 "X"))

    (should= [ 
                "X" "1" "2"
                "3" "4" "X"
                "O" "O" "O"
             ] 
             (fill-board 
               [ 
                "X" "1" "2"
                "3" "4" "X"
                "O" "O" "5"
               ] 
               8 
               "O"))))

