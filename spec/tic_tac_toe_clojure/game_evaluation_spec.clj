(ns tic-tac-toe-clojure.game-evaluation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-evaluation :refer :all]))

(describe "Game Evaluation"
  (describe "tied"
    (it "returns true if the game is tied"
      (should= true
                (tied?
                 [:x :o :x
                  :o :x :o
                  :x :o :x])))

    (it "returns false if the game is not tied"
      (should= false
               (tied?
                [:x  1 :x
                 :o :x :o
                 6  :o :x]))))

  (describe "winning-marker"
    (context "won by row"
      (context "it is a 3X3 board"
        (it "returns the marker if the game is won by the first row being the same value"
          (should= :x
                   (winning-marker
                    [:x :x :x
                     :o  4  5
                      6  :o 8])))

        (it "returns nil if the game is not won"
          (should= nil
                   (winning-marker
                    [:x 1 :x
                     :o  4  5
                      6  :o 8])))

        (it "returns the marker if the game is won by the second row being the same value"
          (should= :x
                   (winning-marker
                    [:o   1   2
                     :x  :x  :x
                      6  :o  :o])))

        (it "returns the marker if the game is won by the third row being the same value"
          (should= :o
                   (winning-marker
                    [:x  1   2
                     :x  4  :x
                     :o  :o  :o]))))

      (context "it is a 4X4 board"
        (it "returns the marker if the game is won by the first row being the same value"
          (should= :x
                   (winning-marker
                     [:x  :x  :x  :x
                      4   5   :x   7
                      :o  :o  :o   11
                      12  13  14   15])))

        (it "returns nil if the game is not won"
          (should= nil
                   (winning-marker
                     [:x  1  2  3
                      4   5  :x 7
                      :o  :o :o 11
                      12  13 14 15])))

        (it "returns the marker if the game is won by the second row being the same value"
          (should= :x
                   (winning-marker
                     [:x    1  2  3
                      :x   :x  :x :x
                      :o   :o  :o 11
                      12   13  14 15])))

        (it "returns the marker if the game is won by the third row being the same value"
          (should= :o
                   (winning-marker
                     [:x  1  2   3
                      4   5  :x  7
                      :o  :o :o :o
                      12  13 14 15])))

        (it "returns the marker if the game is won by the fourth row being the same value"
          (should= :o
                   (winning-marker
                     [:x  1  2   3
                      4   5  :x  7
                      :o  :o :x :o
                      :o  :o :o :o])))))

    (context "won by column"
      (context "it is a 3X3 board"
        (it "returns the marker if the game is won by the first column being the same value"
          (should= :o
                   (winning-marker
                    [:o  1   2
                     :o  :x  :x
                     :o  7  8])))

        (it "returns the marker if the game is won by the second column being the same value"
          (should= :x
                   (winning-marker
                    [0  :x   2
                     3  :x  :o
                     :o  :x  8])))

        (it "returns the marker if the game is won by the third column being the same value"
          (should= :o
                   (winning-marker
                    [0   1  :o
                     :x  4  :o
                     :x  7  :o])))

        (it "returns false if the game is not won"
          (should= nil
                   (winning-marker
                    [0   1  2
                     3  :o  5
                     6   7  8]))))

      (context "it is a 4X4 board"
        (it "returns the marker if the game is won by the first column being the same value"
          (should= :o
                   (winning-marker
                    [:o  1   2  3
                     :o  :x  :x 7
                     :o  9  10  11
                     :o  13 14  15])))

        (it "returns the marker if the game is won by the second column being the same value"
          (should= :x
                   (winning-marker
                    [0  :x   2  3
                     4  :x  :o 7
                    :o  :x  :o  11
                    :o  :x 14  15])))

        (it "returns the marker if the game is won by the third column being the same value"
          (should= :o
                   (winning-marker
                    [0   1  :o  3
                     4   :x :o  7
                     8   9  :o  11
                     12  13 :o  15])))

        (it "returns the marker if the game is won by the fourth column being the same value"
          (should= :o
                   (winning-marker
                    [0   1  :x :o
                     4   :x  6 :o
                     :x   9 :x :o
                     12  13 :x :o])))

        (it "returns false if the game is not won"
          (should= nil
                   (winning-marker
                    [:x  1   2  3
                     :o  :x  :x 7
                     :x  9  10  11
                     :o  13 14  15])))))

    (context "won by diagonal"
      (context "it is a 3X3 board"
        (it "returns the marker if the game is won by a diagonal being the same value"
          (should= :x
                   (winning-marker
                    [:x  :o :o
                     :o  :x  :o
                     :x  :o  :x]))

          (should= :o
                   (winning-marker
                    [:o  :x  :o
                     :x  :o  :o
                     :o  :x  :x]))))

      (context "it is a 4X4 board"
        (it "returns the marker if the game is won by a diagonal being the same value"
          (should= :x
                   (winning-marker
                    [:x  :o  :o  3
                     :o  :x  :o 7
                     :x  :o  :x 11
                     :x  :o  14 :x]))

          (should= :o
                   (winning-marker
                    [0 :o  :x  :o
                     4 :x  :o  :o
                     8 :o  :x  :x
                     :o :o 14  :o]))))))

  (describe "game-over"
    (it "returns true if the game is tied"
      (should= true
               (game-over?
                [:o  :x  :o
                 :x  :o  :o
                 :o  :x  :x])))

    (it "returns false if the game is not over"
      (should= false
               (game-over?
                [:o  1  :o
                 :x  :o :o
                 6   :x :x])))

    (it "returns true if the game is won"
      (should= true
               (game-over?
                [0  1 :o
                 :x  4 :o
                 :x  7 :o])))))
