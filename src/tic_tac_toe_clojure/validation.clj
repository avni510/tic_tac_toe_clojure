(ns tic-tac-toe-clojure.validation
  (:require
    [tic-tac-toe-clojure.validation.console-input :as console-input]
    [tic-tac-toe-clojure.validation.rules :as rules]
    [tic-tac-toe-clojure.validation.game-type :as game-type]))

(defn move [board move]
  (cond
    (not (console-input/is-num? move)) {:errors "This selection is invalid, please enter an integer between 0 and 8"}
    (rules/invalid-cell? board (read-string move)) {:errors "This selection is invalid, please enter an integer between 0 and 8"}
    (rules/cell-occupied? board (read-string move)) {:errors "This cell is taken, please enter another move"}
    :else {:errors nil}))

(defn marker [marker]
  (if (rules/invalid-marker? marker)
    {:errors "This selection is invalid, please enter a marker between the characters A-Z"}
    {:errors nil}))

(defn game-type [game-menu game-type-selection]
  (if (game-type/invalid-game-type? game-menu game-type-selection)
    {:errors "Please enter a valid menu option"}
    {:errors nil}))
