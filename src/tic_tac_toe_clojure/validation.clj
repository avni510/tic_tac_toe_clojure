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
  (if (apply is-num? [user-input])
    (not (<= board-min (read-string user-input) (board-max board)))
    true))

(defn execute [board move]
  (cond 
    (invalid-position? board move) "Please enter an integer between 0 and 8"
    (cell-occupied? board move) "This cell is taken, please enter another move"
    :else nil))
