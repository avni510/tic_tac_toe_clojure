(ns tic-tac-toe-clojure.game-loop-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-loop :refer :all]))

(def current-board
  [
   :x  1   2
    3  4   :x
   :o  :o  8])

(describe "Game Loop"
  (describe "run"
    (around [it]
      (with-out-str (it)))

    (it "prompts the user to enter their move and returns a new board" 
      (should=  [           
                 :x  1   2
                  3  4  :x
                 :o  :o  :o] 
                (with-in-str "8" (run current-board :o :x))))

    (context "the user enters an invalid move"
      (it "continues to prompts the user to enter another move"
        (should= [             
                  :x  1   2
                  3   4  :x
                  :o  :o  :o] 
                 (with-in-str "8\n#\n    \nfive\n4.35" (run current-board :o :x)))))

    (it "continues to ask the user for their move until the game is tied"
      (should= [             
                 :x  :o  :o
                 :o  :x  :x
                 :o  :x  :o ]
                (with-in-str "7\n3" 
                (run [ 
                      :x  :o  :o
                       3  :x  :x
                      :o  7  :o  
                     ]
                     :x 
                     :o))))

    (it "continues to ask the user for their move until the game is won"
      (should= [             
                0    1  :o
                3   :o   5
                :x  :x  :x ]
                (with-in-str "6\n2\n7\n4\n8" 
                (run [
                       0  1  2
                       3  4  5
                       6  7  8 
                      ]
                      :x 
                      :o))))))
