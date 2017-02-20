(ns tic-tac-toe-clojure.validation
  (:require 
    [tic-tac-toe-clojure.validation-console-input :as validation-console-input]
    [tic-tac-toe-clojure.validation-rules :as validation-rules]))

(defn execute [board move]
  (cond 
    (not (validation-console-input/is-num? move)) {:errors "Please enter an integer between 0 and 8"}
    (validation-rules/invalid-cell? board (read-string move)) {:errors "Please enter an integer between 0 and 8"}
    (validation-rules/cell-occupied? board (read-string move)) {:errors "This cell is taken, please enter another move"}
    :else {:errors nil}))
