(ns tic-tac-toe-clojure.minimax-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.minimax :refer :all]))

(describe "Minimax"
  (describe "best-move"
    (context "there are two spots open"
      (it "returns the spots where the computer is most likely to win"
        (should= 4 (best-move (scores-map [
                                           :o :o :x
                                           :x 4 :o
                                           :x 7 :o]
                                          :x
                                          :o)))

        (should= 8 (best-move (scores-map [
                                           :o :x 2
                                           :x :x :o
                                           :o :o 8]
                                          :x
                                          :o)))))

    (context "there are three spots open"
      (it "returns the spots where the computer is most likely to win"
        (should= 4 (best-move (scores-map [
                                           :o :o :x
                                           :x 4 5
                                           :x 7 :o]
                                          :x
                                          :o)))

        (should= 5 (best-move (scores-map [
                                           :x 1 :x
                                           3 :o 5
                                           :o :o :x]
                                          :x
                                          :o)))

        (should= 6 (best-move (scores-map [
                                           0 :x :o
                                           :x :o 5
                                           6 :o :x]
                                          :x
                                          :o)))))

    (context "there are four spots open"
      (it "returns the spots where the computer is most likely to win"
         (should= 4 (best-move (scores-map [
                                            :o :o :x
                                            3 4 5
                                            :x 7 :o]
                                           :x
                                           :o)))

         (should= 8 (best-move (scores-map [
                                            0 :x :o
                                            3 :x 5
                                            :o :o 8]
                                           :x
                                           :o)))))

    (context "there are six spots open"
      (it "returns the spots where the computer is most likely to win"
         (should= 3 (best-move (scores-map [
                                            :x 1 2
                                            3 :o 5
                                            :x 7 8]
                                           :o
                                           :x)))))))
