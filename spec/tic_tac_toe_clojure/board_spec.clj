(ns tic-tac-toe-clojure.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.board :refer :all]))

(def empty-board
  [
   0 1 2
   3 4 5
   6 7 8])

(describe "Board"
  (describe "fill-board"
    (context "it is a 3X3 board"
      (it "returns a board with the space given filled in with a marker"
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

    (context "it is a 4X4 board"
      (it "returns a board with the space given filled in with a marker"
        (should= [
                  :x  1  2  3
                  4   5  :x 7
                  :o  :o :o 11
                  12  :o 14 15
                 ]
                 (fill-board
                   13
                   [
                    :x  1  2  3
                    4   5  :x 7
                    :o  :o :o 11
                    12  13 14 15
                   ]
                   :o))))
            )

  (describe "open-spaces"
    (context "it is a 3X3 board"
      (it "returns a lazy sequence of all the open spaces on the board"
         (should= '(0 2 3 4 5 6 7 8) (open-spaces [
                                                    0 :x 2
                                                    3  4 5
                                                    6  7 8]))))
    (context "it is a 4X4 board"
      (it "returns a lazy sequence of all the open spaces on the board"
         (should= '(1 2 3 4 5 7 11 12 13 14 15) (open-spaces [
                                                              :x  1  2  3
                                                              4   5  :x 7
                                                              :o  :o :o 11
                                                              12  13 14 15])))))
  (describe "board-dimension"
    (it "returns the width of the board"
       (should= 3 (board-dimension [
                                     0 :x 2
                                     3  4 5
                                     6  7 8]))

       (should= 4 (board-dimension [
                                    :x  1  2  3
                                    4   5  :x 7
                                    :o  :o :o 11
                                    12  13 14 15])))))
