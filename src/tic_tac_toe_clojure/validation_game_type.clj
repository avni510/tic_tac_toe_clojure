(ns tic-tac-toe-clojure.validation-game-type)

(defn invalid-game-type? [game-menu game-type-selection]
  (not (contains? game-menu game-type-selection)))

