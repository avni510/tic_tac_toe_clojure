(ns tic-tac-toe-clojure.player-move-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.player-move :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def current-board
  [
   :x  1   2
    3  4   :x
   :o  :o  8])

(def num-cells-in-board
  (count current-board))

(describe "Player Move"
  (describe "make-move"
    (around [it]
      (with-out-str (it)))

    (context "the player type is a human"
      (it "prompts the user to enter their move and returns a board"
        (should= [
                  :x  1   2
                   3  4   :x
                  :o  :o  :x]
                 (with-in-str "8" (make-move current-board {:player-type :human :marker :x}))))

      (context "the user enters an invalid move"
        (it "continues to prompts the user to enter another move"
          (should= [            
                    :x  1   2
                     3  4   :x
                    :o  :o  :o]
                   (with-in-str "8\n#\n    \nfive\n4.35" (make-move current-board {:player-type :human :marker :o}))))))
          
    (context "the player type is invalid"
      (it "displays a message stating the player type is invalid"
        (should= "This player type does not exist\n" (with-out-str (make-move current-board {:player-type :person :marker :x})))))
    
    (context "the player is a computer"
      (it "generates a random move and returns a board"
        (with-redefs [helpers/random-number (fn [num-cells-in-board] 4)]
          (should= [
                    :x  1   2
                     3  :o  :x         
                    :o  :o  8]
                   (make-move current-board {:player-type :computer :marker :o})))))))

