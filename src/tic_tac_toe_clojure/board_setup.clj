(ns tic-tac-toe-clojure.board-setup)

(def empty-3X3-board
  [0 1 2
   3 4 5
   6 7 8])

(def empty-4X4-board
  [0 1 2  3
   4 5 6  7
   8 9 10 11
   12 13 14 15])

(defn determine-empty-board [board-type]
  (cond
    (= board-type :3X3-board) empty-3X3-board
    (= board-type :4X4-board) empty-4X4-board
    :else (throw (Exception. "invalid board type"))))
