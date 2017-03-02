(ns tic-tac-toe-clojure.game-setup-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-setup :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def x-alpha-value
  23)

(describe "Game Setup"
  (around [it]
    (with-out-str (it)))

  (describe "select-marker"
     (it "prompts the user to enter a marker and returns that marker as a keyword"
       (should= :x (with-in-str "X" (select-marker))))

     (context "the user enters an invalid marker"
       (it "prompts the user to enter another marker"
         (should= :o (with-in-str "O\n #" (select-marker))))
            
       (it "continues to prompt the user to enter another marker until it is valid"
         (should= :o (with-in-str "O            \n #\n \nhello\n5.5\n}" (select-marker))))))

  (describe "game-players"
    (context "the user selects game type of Human V. Simple Computer"
      (it "returns a vector of two maps and the first value is the first player"
        (with-redefs [helpers/random-number (fn [letters-in-alphabet] x-alpha-value)]
          (should= [{:player-type :human :marker :o} {:player-type :simple-computer :marker :x}] 
                   (game-players :human-v-simple-computer :o)))))

    (context "the user selects game type of Human V. Hard Computer"
      (it "returns a vector of two maps and the first value is the first player"
        (with-redefs [helpers/random-number (fn [letters-in-alphabet] x-alpha-value)]
          (should= [{:player-type :human :marker :o} {:player-type :hard-computer :marker :x}] 
                   (game-players :human-v-hard-computer :o)))))))

          
  
          
          
