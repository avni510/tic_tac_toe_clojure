(ns tic-tac-toe-clojure.simple-computer-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.simple-computer :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]
            [tic-tac-toe-clojure.computer-move :refer [ai-move]]))

(describe "Simple Computer"
    (describe "ai-move"
      (it "returns a random move"
        (with-redefs [helpers/random-number (fn [open-spaces-sequence] 4)]
          (should= 4 (ai-move {:board [
                                       :o :o :x
                                       :x 4 5
                                       :x 7 :o]
                              :current-player {:player-type :simple-computer :marker :x}
                              :opponent-player {:player-type :human :marker :o}}))))))
