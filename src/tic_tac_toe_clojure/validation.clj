(ns tic-tac-toe-clojure.validation
  (:require 
    [tic-tac-toe-clojure.validation-console-input :as validation-console-input]
    [tic-tac-toe-clojure.validation-rules :as validation-rules]))

(defn execute-move [board move]
  (cond 
    (not (validation-console-input/is-num? move)) {:errors "This selection is invalid, please enter an integer between 0 and 8"}
    (validation-rules/invalid-cell? board (read-string move)) {:errors "This selection is invalid, please enter an integer between 0 and 8"}
    (validation-rules/cell-occupied? board (read-string move)) {:errors "This cell is taken, please enter another move"}
    :else {:errors nil}))

(defn execute-marker [marker]
  (if (validation-rules/invalid-marker? marker)
    {:errors "This selection is invalid, please enter a marker between the characters A-Z"}
    {:errors nil}))
