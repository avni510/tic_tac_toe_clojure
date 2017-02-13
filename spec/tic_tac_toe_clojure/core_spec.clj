(ns tic-tac-toe-clojure.core-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.core :refer :all]))

(describe "board" 
  (it "returns an empty board"
      (should= [ 
                  "" "" ""
                  "" "" ""
                  "" "" ""
               ] (get-board empty-board))
  )

  (it "returns a board with a filled in marker" 
      (should= [ 
                  "" "X" ""
                  "" "" ""
                  "" "" ""
               ] (fill-board empty-board 1 "X"))

      (should= [ 
                  "X" "" ""
                  "" "" "X"
                  "O" "O" "X"
               ] (fill-board [ 
                              "X" "" ""
                              "" "" "X"
                              "O" "O" ""
                             ] 8 "X"))
  ) 

  (it "returns a boolean if the cell is open" 
      (should= false (cell-open?  [ 
                                    "X" "" ""
                                    "" "" "X"
                                    "O" "O" "X"
                                  ] 0))
    )
          )

