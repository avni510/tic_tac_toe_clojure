(ns tic-tac-toe-clojure.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.board :refer :all]))

(describe "board" 
  (it "returns an empty board"
    (should= [ 
                "" "" ""
                "" "" ""
                "" "" ""
             ] 
             (get-board empty-board)))

  (it "returns a board with a filled in marker" 
    (should= [ 
                "" "X" ""
                "" "" ""
                "" "" ""
             ] 
             (fill-board empty-board 1 "X"))

    (should= [ 
                "X" "" ""
                "" "" "X"
                "O" "O" "O"
             ] 
             (fill-board 
               [ 
                "X" "" ""
                "" "" "X"
                "O" "O" ""
               ] 
               8 
               "O"))))

