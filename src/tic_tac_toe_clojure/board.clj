(ns tic-tac-toe-clojure.board)

(defn get-board [board-vector]
  board-vector)

(defn fill-board [index board marker]
    (assoc board index marker))

