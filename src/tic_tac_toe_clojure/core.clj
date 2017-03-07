(ns tic-tac-toe-clojure.core
  (:require [tic-tac-toe-clojure.console-runner :as console-runner]
            [tic-tac-toe-clojure.player.human]
            [tic-tac-toe-clojure.player.computer]
            [tic-tac-toe-clojure.player.computer-move.simple-computer]
            [tic-tac-toe-clojure.player.computer-move.hard-computer]))

(defn -main []
  (console-runner/run))
