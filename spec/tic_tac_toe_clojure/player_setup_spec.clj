(ns tic-tac-toe-clojure.player-setup-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.player-setup :refer :all]
            [tic-tac-toe-clojure.game-setup :as game-setup]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def x-alpha-value
  23)

(describe "Player Setup"
  (around [it]
    (with-out-str(it)))

  (describe "create-human-player"
    (it "creates a map for the human player"
      (should= {:player-type :human :marker :o}
               (->
                 (with-in-str "O" (game-setup/select-marker))
                 (create-human-player)))))

  (describe "create-simple-computer-player"
    (context "the human selects :o as their marker"
      (it "creates a map for the simple-computer player and the computer marker should not equal the human marker"
        (with-redefs [helpers/random-number (fn [letters-in-alphabet-sequence] x-alpha-value)]
          (should= {:player-type :simple-computer :marker :x}
                   (create-simple-computer-player :o))))))

  (describe "create-hard-computer-player"
    (context "the human selects :o as their marker"
      (it "creates a map for the hard-computer player and the computer marker should not equal the human marker"
        (with-redefs [helpers/random-number (fn [letters-in-alphabet-sequence] x-alpha-value)]
          (should= {:player-type :hard-computer :marker :x}
                   (create-hard-computer-player :o)))))))
