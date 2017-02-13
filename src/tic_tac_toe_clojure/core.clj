(ns tic-tac-toe-clojure.core)

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

(defn cell-open? [board index]
  (let [cell (nth board index)]
    (empty? cell)
  )
)
