(ns tic-tac-toe-clojure.game-evaluation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-evaluation :refer :all]))

(describe "Game Evaluation"
  (describe "tied"      
    (it "returns true if the game is tied"
      (should= true 
                (tied? 
                 [ 
                   :x :o :x
                   :o :x :o
                   :x :o :x
                 ])))
                 
    (it "returns false if the game is not tied"
      (should= false 
               (tied? 
                [ 
                 :x  1 :x
                 :o :x :o
                 6  :o :x
                ]))))

  (describe "winning-marker"
    (context "won by row" 
      (it "returns a string if the game is won by the first row all being the same marker"
        (should= :x
                 (winning-marker
                  [ 
                   :x :x :x
                   :o  4  5
                    6  :o 8
                  ])))

      (it "returns false if the game is not won"
        (should= nil
                 (winning-marker 
                  [ 
                   :x 1 :x
                   :o  4  5
                    6  :o 8
                  ])))

      (it "returns true if the game is won by the second row all being the same marker"
        (should= :x 
                 (winning-marker 
                  [ 
                   :o   1  2
                   :x  :x  :x
                    6  :o  :o
                  ])))

      (it "returns true if the game is won by the third row all being the same marker"
        (should= :o
                 (winning-marker 
                  [ 
                   :x  1  2
                   :x  4  :x
                   :o  :o  :o
                  ]))))

    (context "won by column"
      (it "returns true if the game is won by the first column all being the same value" 
        (should= :o
                 (winning-marker 
                  [ 
                   :o  1  2
                   :o  :x  :x
                   :o  7  8
                  ])))


      (it "returns true if the game is won by the second column all being the same value" 
        (should= :x
                 (winning-marker
                  [ 
                   0  :x  2
                   3  :x  :o
                   :o  :x  8
                  ])))

      (it "returns true if the game is won by the third column all being the same value" 
        (should= :o
                 (winning-marker 
                  [ 
                   0   1  :o
                   :x  4  :o
                   :x  7  :o
                  ])))

      (it "returns false if the game is not won"
        (should= nil
                 (winning-marker 
                  [ 
                   0   1  2
                   3  :o  5
                   6   7  8
                  ]))))

    (context "won by diagonal"
      (it "returns true if the game is won by a diagonal all being the same value"
        (should= :x
                 (winning-marker
                  [ 
                   :x  :o :o
                   :o  :x  :o
                   :x  :o  :x
                  ]))

        (should= :o
                 (winning-marker 
                  [ 
                   :o  :x  :o
                   :x  :o  :o
                   :o  :x  :x
                  ])))))

  (describe "game-over"
    (it "returns true if the game is over"
      (should= true
               (game-over?
                [ 
                 :o  :x  :o
                 :x  :o  :o
                 :o  :x  :x
                ])))

    (it "returns false if the game is not over"
      (should= false
               (game-over?
                [ 
                 :o  1  :o
                 :x  :o :o
                 6   :x :x
                ])))

    (it "returns true if the game is won by the third column all being the same value" 
      (should= true
               (game-over? 
                [ 
                 0   1 :o
                 :x  4 :o
                 :x  7 :o
                ])))))

