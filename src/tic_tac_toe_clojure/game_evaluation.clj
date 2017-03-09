(ns tic-tac-toe-clojure.game-evaluation
 (:require [tic-tac-toe-clojure.board :as board]))

(defn- find-winning-value [winning-value-in-row]
  (let [marker (first winning-value-in-row)]
    (if (boolean marker)
      marker
      (if (empty? winning-value-in-row)
        nil
        (recur (rest winning-value-in-row))))))

(defn- find-equivalent-marker [row]
  (if (apply = row)
    (first row)
    nil))

(defn- split-board-by-rows [board]
  (partition (board/board-dimension board) board))

(defn- won-by-rows [board]
  (->
    (map #(find-equivalent-marker %) 
         (split-board-by-rows board))
    (find-winning-value)))

(defn- split-board-by-columns [board]
  (apply map list (split-board-by-rows board)))
                   
(defn- won-by-columns [board]
  (->
    (map #(find-equivalent-marker %) (split-board-by-columns board))
    (find-winning-value)))

(defn- diagonal-top-to-bottom [board]
  (let [board-width (board/board-dimension board)]
        (map #(get board %) 
              (map #(* % (dec board-width)) 
                   (range 1 (inc board-width))))))

(defn- diagonal-bottom-to-top [board]
  (let [board-width (board/board-dimension board)]
        (map #(get board %) 
             (map #(* % (inc board-width)) 
                  (range 0 board-width)))))

(defn- won-by-diagonals [board]
  (let [first-diagonal-values (diagonal-top-to-bottom board)
        second-diagonal-values (diagonal-bottom-to-top board)]
    (->>
        (concat first-diagonal-values second-diagonal-values)
        (partition (board/board-dimension board))
        (map #(find-equivalent-marker %))
        (find-winning-value))))
      
(defn tied? [current-board]
  (empty? (board/open-spaces current-board)))

(defn winning-marker [current-board]
  (or (won-by-rows current-board)
      (won-by-columns current-board)
      (won-by-diagonals current-board)))

(defn game-over? [current-board]
  (or (tied? current-board)
      (boolean (winning-marker current-board))))
