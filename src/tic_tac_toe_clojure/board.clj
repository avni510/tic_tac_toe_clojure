(ns tic-tac-toe-clojure.board)

(def empty-board 
  [
   0 1 2
   3 4 5
   6 7 8
  ])

(defn get-board [board-vector]
  board-vector)

(defn fill-board [index board marker]
    (assoc board index marker))

