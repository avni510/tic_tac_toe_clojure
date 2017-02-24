(ns tic-tac-toe-clojure.game-loop-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-loop :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def current-board
  [
   :x  1   2
    3  4   :x
   :o  :o  8])

(def num-cells-in-board
  (count current-board))

(def simple-computer-moves (atom [2 4]))

(defn fake-move []
  (let [next-move (first @simple-computer-moves)
        _ (swap! simple-computer-moves rest)]
    next-move))

(describe "Game Loop"
  (describe "run"
    (around [it]
      (with-out-str (it)))

    (context "the game ends in a tie"
      (it "continues to ask the user for their move until the game is over"
        (with-redefs [helpers/random-number (fn [num-cells-in-board] 3)]
          (should= [             
                     :x  :o  :o
                     :o  :x  :x
                     :o  :x  :o ]
                    (with-in-str "7" 
                      (run [ 
                            :x  :o  :o
                             3  :x  :x
                            :o  7   :o ]
                           {:player-type :human :marker :x}
                           {:player-type :simple-computer :marker :o}))))))

    (context "the game is won by player x"
      (it "continues to ask the user for their move until the game is over"
        (with-redefs [helpers/random-number (fn [num-cells-in-board] (fake-move))]
           (should= [             
                     0    1  :o
                     3   :o   5
                     :x  :x  :x ]
                     (with-in-str "6\n7\n8" 
                       (run [
                              0  1  2
                              3  4  5
                              6  7  8 
                             ]
                             {:player-type :human :marker :x} 
                             {:player-type :simple-computer :marker :o}))))))))
