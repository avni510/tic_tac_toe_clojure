(ns tic-tac-toe-clojure.console-ui)

(defn print-message [message]
  (println message))

(defn get-user-input []
  (read-line))
