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
                 (with-in-str "8" (make-move {:board current-board 
                                              :current-player-map {:player-type :human :marker :x}})))))

      (context "the user enters an invalid move"
        (it "continues to prompts the user to enter another move"
          (should= [            
                    :x  1   2
                     3  4   :x
                    :o  :o  :o]
                   (with-in-str "8\n#\n    \nfive\n4.35" (make-move {:board current-board 
                                                                     :current-player-map {:player-type :human :marker :o}})))))
          
    (context "the player type is invalid"
      (it "displays a message stating the player type is invalid"
        (should= "This player type does not exist\n" (with-out-str (make-move {:board current-board 
                                                                               :current-player-map {:player-type :person :marker :x}})))))
    
    (context "the player is a simple-computer"
      (it "generates a random move and returns a board"
        (with-redefs [helpers/random-number (fn [num-cells-in-board] 4)]
          (should= [
                    :x  1   2
                     3  :o  :x         
                    :o  :o  8]
                   (make-move {:board current-board 
                               :current-player-map {:player-type :simple-computer :marker :o}})))))
            
    (context "the player is a hard computer"
      (it "generates the move that is most likely to win and returns a board"
        (should=[
                 :o :o :x
                 :x :x 5 
                 :x 7 :o]
                (make-move {:board [
                                    :o :o :x
                                    :x 4 5 
                                    :x 7 :o] 
                           :current-player-map {:player-type :hard-computer :marker :x} 
                           :opponent-player-map {:player-type :human :marker :o}}))))))
