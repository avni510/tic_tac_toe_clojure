(ns tic-tac-toe-clojure.validation.rules-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation.rules :refer :all]))

(def nine-space-board
   [:x  1   2
    3   4  :x
    :o  :o :x])

(def sixteen-space-board
   [
    :x  1  2  3
    4   5  :x 7
    :o  :o :o 11
    12  13 14 15])

(describe "Validation Rules"
  (describe "cell-occupied?"
    (context "it is a 3X3 board"
      (it "returns true if the input is a cell occupied"
        (should= true (cell-occupied? nine-space-board 6)))

      (it "returns false if the input is a cell not occupied"
        (should= false (cell-occupied? nine-space-board 1))))

    (context "it is a 4X4 board"
      (it "returns true if the input is a cell occupied"
        (should= true (cell-occupied? sixteen-space-board 6)))

      (it "returns false if the input is a cell not occupied"
        (should= false (cell-occupied? sixteen-space-board 1)))))

  (describe "invalid-cell?"
    (context "it is a 3X3 board"
      (it "returns true if the input is a number greater than the max value on the board"
        (should= true (invalid-cell? nine-space-board 9)))

      (it "returns true if the input is a number less than the min value on the board"
        (should= true (invalid-cell? nine-space-board -2)))

      (it "returns false if the input is a number on the board"
        (should= false (invalid-cell? nine-space-board 5))))

    (context "it is a 4X4 board"
      (it "returns true if the input is a number greater than the max value on the board"
        (should= true (invalid-cell? sixteen-space-board 16)))

      (it "returns true if the input is a number less than the min value on the board"
        (should= true (invalid-cell? sixteen-space-board -2)))

      (it "returns false if the input is a number on the board"
        (should= false (invalid-cell? nine-space-board 5)))))

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
      (should= false (invalid-marker? "x")))

    (it "returns false if the input is an upper case character of the alphabet"
      (should= false (invalid-marker? "X")))))
