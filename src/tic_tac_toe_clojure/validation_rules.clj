(ns tic-tac-toe-clojure.validation-rules
  (:require [tic-tac-toe-clojure.helpers :as helpers]))

(def board-min
  0)

(defn- board-max [board]
  (dec (count board)))

(defn cell-occupied? [board index]
  (let [cell (nth board index)]
    (not (number? cell))))

(defn invalid-cell? [board input-cell]
  (not (<= board-min input-cell (board-max board))))

