(ns tic-tac-toe-clojure.rules
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]))

(defn- invalid-move [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (console-ui/get-user-input))

(defn valid-move-loop [board move]
  (let [errors-hash (validation/execute board move)]
    (if (:errors errors-hash)
      (recur board (invalid-move errors-hash))
      move)))


