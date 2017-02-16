(ns tic-tac-toe-clojure.helpers)

(defn is-num? [input]
  (number? (read-string input)))

