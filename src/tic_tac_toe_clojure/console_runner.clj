(ns tic-tac-toe-clojure.console-runner
  (:require [tic-tac-toe-clojure.game-loop :as game-loop]
            [tic-tac-toe-clojure.game-completion :as game-completion]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.game-setup :as game-setup]
            [tic-tac-toe-clojure.game-selection :as game-selection]
            [tic-tac-toe-clojure.player-setup :as player-setup]))

(def empty-board
  [
   0 1 2
   3 4 5
   6 7 8])

(def game-menu
  {:1 "1. Human V. Simple Computer"
   :2 "2. Human V. Hard Computer"})

(defn run []
  (let [game-type (game-selection/run game-menu)
        human-marker (game-setup/select-marker)
        [human-player computer-player] (game-setup/game-players
                                                 game-type
                                                 human-marker)]
    (-> (game-loop/run empty-board human-player computer-player)
        (game-completion/game-over-message)
        (console-ui/print-message))))
