(ns tic-tac-toe-clojure.computer-move-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.computer-move :refer :all]
            [tic-tac-toe-clojure.helpers :as helpers]))

  (describe "Computer Move"
    (describe "ai-move"
      (context "the player is a simple computer"
        (it "returns a random move"
          (with-redefs [helpers/random-number (fn [open-spaces-sequence] 4)]
            (should= 4 (ai-move {:board [
                                         :o :o :x
                                         :x 4 5
                                         :x 7 :o]
                                :current-player {:player-type :simple-computer :marker :x}
                                :opponent-player {:player-type :human :marker :o}})))))

      (context "the player is a hard computer"
        (it "returns a move where the computer is most likely to win"
          (should= 4 (ai-move {:board [
                                        :o :o :x
                                        :x 4 5
                                        :x 7 :o]
                               :current-player {:player-type :hard-computer :marker :x}
                               :opponent-player {:player-type :human :marker :o}}))))))
