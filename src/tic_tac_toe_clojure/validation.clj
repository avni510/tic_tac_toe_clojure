(ns tic-tac-toe-clojure.validation)

(def board-min
  0
)

(def board-max
  8
)

(defn cell-open? [board index]
  (let [cell (nth board index)]
    (empty? cell)
  )
)

(defn- is-num? [input]
  (number? (read-string input))
)

(defn valid-position? [user-input]
  (if (apply is-num? [user-input])
    (<= board-min (read-string user-input) board-max)
    false
  )
)

