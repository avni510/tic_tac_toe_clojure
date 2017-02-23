(ns tic-tac-toe-clojure.console-runner-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.console-runner :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def num-cells-in-board
  (count empty-board))

(def o-letter-alphabet-value
  15)

(def computer-game-values (atom [o-letter-alphabet-value 4 8]))

(defn fake-value []
  (let [next-value (first @computer-game-values)
        _ (swap! computer-game-values rest)]
    next-value))
      
(describe "Console Runner"
  (describe "run"
    (around [it]
      (with-out-str (it)))

    (it "runs the game"
      (should= nil 
        (with-redefs [helpers/random-number (fn [num-cells-in-board] (fake-value))]
          (with-in-str "x\n0\n1\n2" (run)))))))
          
