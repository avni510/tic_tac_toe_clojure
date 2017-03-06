(ns tic-tac-toe-clojure.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.board :refer :all]))

(def empty-board
  [
   0 1 2
   3 4 5
   6 7 8
  ])

(describe "Board"
  (describe "get-board"
    (it "returns an empty board"
      (should= [
                0 1 2
                3 4 5
                6 7 8
               ]
               (get-board empty-board))))

  (describe "fill-board"
    (it "returns a board with a filled in marker"
      (should= [
                0 :x 2
                3  4 5
                6  7 8
               ]
               (fill-board 1 empty-board :x))

      (should= [
                :x  1  2
                3   4  :x
                :o  :o :o
               ]
               (fill-board
                 8
                 [
                  :x  1   2
                  3   4  :x
                  :o  :o  8
                 ]
                 :o))))

  (describe "open-spaces"
    (it "returns a lazy sequence of all the open spaces on the board"
       (should= '(0 2 3 4 5 6 7 8) (open-spaces [
                                                  0 :x 2
                                                  3  4 5
                                                  6  7 8])))))
