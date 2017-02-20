(ns tic-tac-toe-clojure.console-runner
  (:require [tic-tac-toe-clojure.game-loop :as game-loop]
            [tic-tac-toe-clojure.game-completion :as game-completion]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.game-setup :as game-setup]))

(def empty-board 
  [
   0 1 2
   3 4 5
   6 7 8
  ])

(defn run []
  (console-ui/print-message (game-completion/game-over-message (game-loop/run empty-board (game-setup/select-marker) :o))))

