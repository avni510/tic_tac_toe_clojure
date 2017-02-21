(ns tic-tac-toe-clojure.console-runner
  (:require [tic-tac-toe-clojure.game-loop :as game-loop]
            [tic-tac-toe-clojure.game-completion :as game-completion]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.game-setup :as game-setup]
            [tic-tac-toe-clojure.player-setup :as player-setup]
            ))

(def empty-board 
  [
   0 1 2
   3 4 5
   6 7 8
  ])


  (defn run []
    (let [human-marker (game-setup/select-marker)
          [human-player-map computer-player-map] (game-setup/create-players human-marker)]
      (-> (game-loop/run empty-board human-player-map computer-player-map)
          (game-completion/game-over-message)
          (console-ui/print-message))))


