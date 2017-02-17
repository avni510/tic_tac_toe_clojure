(ns tic-tac-toe-clojure.game-evaluation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-evaluation :refer :all]))

(describe "Game Evaluation"
  (describe "tied"      
    (it "returns true if the game is tied"
      (should= true 
                (tied? 
                 [ 
                   "X" "O" "X"
                   "O" "X" "O"
                   "X" "O" "X"
                 ])))
                 
    (it "returns false if the game is not tied"
      (should= false 
               (tied? 
                [ 
                  "X" "1" "X"
                  "O" "X" "O"
                  "6" "O" "X"
                ]))))

  (describe "winning-marker"
    (context "won by row" 
      (it "returns a string if the game is won by the first row all being the same marker"
        (should= "X"
                 (winning-marker
                  [ 
                    "X" "X" "X"
                    "O" "4" "5"
                    "6" "O" "8"
                  ])))

      (it "returns false if the game is not won"
        (should= nil
                 (winning-marker 
                  [ 
                    "X" "1" "X"
                    "O" "4" "5"
                    "6" "O" "8"
                  ])))

      (it "returns true if the game is won by the second row all being the same marker"
        (should= "X"
                 (winning-marker 
                  [ 
                    "O" "1" "2"
                    "X" "X" "X"
                    "6" "O" "O"
                  ])))

      (it "returns true if the game is won by the third row all being the same marker"
        (should= "O"
                 (winning-marker 
                  [ 
                    "X" "1" "2"
                    "X" "4" "X"
                    "O" "O" "O"
                  ]))))

    (context "won by column"
      (it "returns true if the game is won by the first column all being the same value" 
        (should= "O"
                 (winning-marker 
                  [ 
                    "O" "1" "2"
                    "O" "X" "X"
                    "O" "7" "8"
                  ])))


      (it "returns true if the game is won by the second column all being the same value" 
        (should= "X"
                 (winning-marker
                  [ 
                    "0" "X" "2"
                    "3" "X" "O"
                    "O" "X" "8"
                  ])))

      (it "returns true if the game is won by the third column all being the same value" 
        (should= "O"
                 (winning-marker 
                  [ 
                    "0" "1" "O"
                    "X" "4" "O"
                    "X" "7" "O"
                  ])))

      (it "returns false if the game is not won"
        (should= nil
                 (winning-marker 
                  [ 
                    "0" "1" "2"
                    "3" "O" "5"
                    "6" "7" "8"
                  ]))))

    (context "won by diagonal"
      (it "returns true if the game is won by a diagonal all being the same value"
        (should= "X"
                 (winning-marker
                  [ 
                    "X" "O" "O"
                    "O" "X" "O"
                    "X" "O" "X"
                  ]))

        (should= "O"
                 (winning-marker 
                  [ 
                    "O" "X" "O"
                    "X" "O" "O"
                    "O" "X" "X"
                  ])))))

  (describe "game-over"
    (it "returns true if the game is over"
      (should= true
               (game-over?
                [ 
                  "O" "X" "O"
                  "X" "O" "O"
                  "O" "X" "X"
                ])))

    (it "returns false if the game is not over"
      (should= false
               (game-over?
                [ 
                  "O" "1" "O"
                  "X" "O" "O"
                  "6" "X" "X"
                ])))

    (it "returns true if the game is won by the third column all being the same value" 
      (should= true
               (game-over? 
                [ 
                  "1" "2" "O"
                  "X" "4" "O"
                  "X" "7" "O"
                ])))))

