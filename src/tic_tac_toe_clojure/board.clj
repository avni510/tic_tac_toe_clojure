(ns tic-tac-toe-clojure.board)

(defn fill-board [index board marker]
  (assoc board index marker))

(defn- is-open? [space]
  (number? space))

(defn open-spaces [board]
  (filter #(is-open? %) board))

(defn board-dimension [board]
  (int (Math/sqrt (count board))))
