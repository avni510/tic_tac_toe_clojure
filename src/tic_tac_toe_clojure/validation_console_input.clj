(ns tic-tac-toe-clojure.validation-console-input)

(defn is-num? [input]
  (and (not (empty? input))
       (boolean (re-matches #"\d*" input))))
