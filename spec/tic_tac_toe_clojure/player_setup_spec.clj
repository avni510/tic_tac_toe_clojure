(ns tic-tac-toe-clojure.player-setup-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.player-setup :refer :all]
            [tic-tac-toe-clojure.game-setup :as game-setup]))

(describe "Player Setup"
  (describe "create-human-player"
    (it "creates a map for the human player"
      (should= {:player-type :human :marker :o} (->
                                                  (with-in-str "O" (game-setup/select-marker))
                                                  (create-human-player)))))
  (describe "create-computer-player"
    (context "the human selects :o as their marker"
      (it "creates a map for the computer player and the computer marker should not equal the human marker"
        (let [human-marker (with-in-str "O" (game-setup/select-marker))]
        (should-not= (:marker (create-human-player human-marker)) (:marker (create-computer-player human-marker))))))))
