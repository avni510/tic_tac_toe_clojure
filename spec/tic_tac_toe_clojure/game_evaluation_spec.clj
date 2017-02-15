(ns tic-tac-toe-clojure.game-evaluation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-evaluation :refer :all]))

(describe "GameEvaluation"
  (it "returns a string if the game is tied"
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
                "X" "" "X"
                "O" "X" "O"
                "" "O" "X"
              ])))

  (context "won by row" 
    (it "returns a string if the game is won by the first row all being the same marker"
      (should= "X"
               (winning-marker
                [ 
                  "X" "X" "X"
                  "O" "" ""
                  "" "O" ""
                ])))

    (it "returns false if the game is not won"
      (should= nil
               (winning-marker 
                [ 
                  "X" "" "X"
                  "O" "" ""
                  "" "O" ""
                ])))

    (it "returns true if the game is won by the second row all being the same marker"
      (should= "X"
               (winning-marker 
                [ 
                  "O" "" ""
                  "X" "X" "X"
                  "" "O" "O"
                ])))

    (it "returns true if the game is won by the third row all being the same marker"
      (should= "O"
               (winning-marker 
                [ 
                  "X" "" ""
                  "X" "" "X"
                  "O" "O" "O"
                ]))))

  (context "won by column"
    (it "returns true if the game is won by the first column all being the same value" 
      (should= "O"
               (winning-marker 
                [ 
                  "O" "" ""
                  "O" "X" "X"
                  "O" "" ""
                ])))


    (it "returns true if the game is won by the second column all being the same value" 
      (should= "X"
               (winning-marker
                [ 
                  "" "X" ""
                  "" "X" "O"
                  "O" "X" ""
                ])))

    (it "returns true if the game is won by the third column all being the same value" 
      (should= "O"
               (winning-marker 
                [ 
                  "" "" "O"
                  "X" "" "O"
                  "X" "" "O"
                ])))

    (it "returns false if the game is not won"
      (should= nil
               (winning-marker 
                [ 
                  "" "" ""
                  "" "O" ""
                  "" "" ""
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
                ]))))

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
                "O" "" "O"
                "X" "O" "O"
                "" "X" "X"
              ])))

  (it "returns true if the game is won by the third column all being the same value" 
    (should= true
             (game-over? 
              [ 
                "" "" "O"
                "X" "" "O"
                "X" "" "O"
              ]))))

