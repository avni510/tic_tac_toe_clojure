(ns tic-tac-toe-clojure.game-setup-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-setup :refer :all]))

(describe "Game Setup"
  (describe "select-marker"
    (around [it]
      (with-out-str (it)))

     (it "prompts the user to enter a marker and returns that marker as a keyword"
       (should= :x (with-in-str "X" (select-marker))))

     (context "the user enters an invalid marker"
       (it "prompts the user to enter another marker"
         (should= :o (with-in-str "O\n #" (select-marker))))
            
       (it "continues to prompt the user to enter another marker"
         (should= :o (with-in-str "O            \n #\n \nhello\n5.5\n}" (select-marker))))))

  (describe "create-players"
    (it "returns a vector with two maps and first value is the human player"
      (should= :human (:player-type (get (create-players :o) 0)))) 

    (it "returns a vector with two maps and the second value is the computer player"
      (should= :computer (:player-type (get (create-players :o) 1))))))
