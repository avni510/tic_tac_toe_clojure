(ns tic-tac-toe-clojure.core
  (:require [tic-tac-toe-clojure.console-runner :as console-runner]
            [tic-tac-toe-clojure.human]
            [tic-tac-toe-clojure.computer]
            [tic-tac-toe-clojure.simple-computer]
            [tic-tac-toe-clojure.hard-computer]))

(defn -main []
  (console-runner/run))




