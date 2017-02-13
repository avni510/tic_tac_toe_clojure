(ns tic-tac-toe-clojure.board)

(def empty-board 
  [
   "" "" ""
   "" "" ""
   "" "" ""
  ]
)

(defn get-board [board-vector]
  board-vector
)

(defn fill-board [board index marker]
  (assoc board index marker)
)

