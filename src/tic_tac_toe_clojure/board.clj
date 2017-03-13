(ns tic-tac-toe-clojure.board
  (:require [clojure.string :as string]))

(defn fill-board [index board marker]
  (assoc board index marker))

(defn is-open? [space]
  (number? space))

(defn open-spaces [board]
  (filter #(is-open? %) board))

(defn board-dimension [board]
  (int (Math/sqrt (count board))))

(defn convert-space-to-string [space]
  (if (is-open? space)
    (if (< space 10)
      (str "  " space " ")
      (str " " space " "))
    (str "  " (string/upper-case (name space)) " ")))

(defn marker->string [marker]
  (-> marker name string/upper-case))

(defn string->marker [string]
  (-> string string/lower-case keyword))
