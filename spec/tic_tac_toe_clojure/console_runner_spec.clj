(ns tic-tac-toe-clojure.console-runner-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.console-runner :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def num-cells-in-board
  (count empty-board))

(def o-letter-alphabet-value
  15)

(def simple-computer-game-values (atom [o-letter-alphabet-value 4 8]))

(defn fake-value []
  (let [next-value (first @simple-computer-game-values)
        _ (swap! simple-computer-game-values rest)]
    next-value))
      
(describe "Console Runner"
  (describe "run"
    (it "runs the game"
      (let [game (with-out-str 
                   (with-redefs [helpers/random-number (fn [num-cells-in-board] (fake-value))]
                     (with-in-str "x\n0\n1\n2" (run))))
            messages (clojure.string/split game #"\n")]
        (should= "The game is won by the player with marker X" (last messages))))))
          
