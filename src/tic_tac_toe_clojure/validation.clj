(ns tic-tac-toe-clojure.validation)

(def board-min
  0)

(defn- board-max [board]
  (dec (count board)))

(defn- cell-occupied? [board index]
  (let [cell (nth board (read-string index))]
    (not (empty? cell))))

(defn- is-num? [input]
  (number? (read-string input)))

(defn- invalid-position? [board user-input]
  (if (not (apply is-num? [user-input]))
    true
    (not (<= board-min (read-string user-input) (board-max board)))))

(defn execute [board move]
  (cond 
    (invalid-position? board move) {:errors "Please enter an integer between 0 and 8"}
    (cell-occupied? board move) {:errors "This cell is taken, please enter another move"}
    :else nil))
