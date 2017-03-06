(ns tic-tac-toe-clojure.computer-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.player :refer [play-turn]]
            [tic-tac-toe-clojure.helpers :as helpers]
            [tic-tac-toe-clojure.computer :refer :all]))

(describe "Computer"
  (describe "play-turn"
    (around [it]
      (with-out-str (it)))

      (context "the player is a simple-computer"
        (it "generates a random move and returns a board"
          (with-redefs [helpers/random-number (fn [open-spaces-sequence] 4)]
            (should= [
                      :x  1   2
                       3  :o  :x
                      :o  :o  8]
                     (play-turn {:board [
                                         :x  1   2
                                          3  4   :x
                                         :o  :o  8]
                                 :current-player {:player-type :simple-computer :marker :o}})))))

      (context "the player is a hard computer"
        (it "generates the move that is most likely to win and returns a board"
          (should=[
                   :o :o :x
                   :x :x 5
                   :x 7 :o]
                  (play-turn {:board [
                                      :o :o :x
                                      :x 4 5
                                      :x 7 :o]
                             :current-player {:player-type :hard-computer :marker :x}
                             :opponent-player {:player-type :human :marker :o}}))))))
