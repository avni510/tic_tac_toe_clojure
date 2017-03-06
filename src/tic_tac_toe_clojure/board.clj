(ns tic-tac-toe-clojure.board)

(defn get-board [board-vector]
  board-vector)

(defn fill-board [index board marker]
    (assoc board index marker))

(defn- is-open? [space]
  (number? space))

(defn open-spaces [board]
  (filter #(is-open? %) board))

