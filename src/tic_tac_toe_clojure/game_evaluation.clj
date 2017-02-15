(ns tic-tac-toe-clojure.game-evaluation)

(defn- same-marker? [cell1 cell2 cell3]
  (and (= cell1 cell2 cell3) (not-empty cell1)))

(defn- won-by-rows [board]
  (let [[cell0 cell1 cell2 cell3 cell4 cell5 cell6 cell7 cell8] board]
    (cond 
      (same-marker? cell0 cell1 cell2) cell0 
      (same-marker? cell3 cell4 cell5) cell3
      (same-marker? cell6 cell7 cell8) cell6
      :else nil)))

(defn- won-by-columns [board]
  (let [[cell0 cell1 cell2 cell3 cell4 cell5 cell6 cell7 cell8] board]
    (cond
      (same-marker? cell0 cell3 cell6) cell0
      (same-marker? cell1 cell4 cell7) cell1
      (same-marker? cell2 cell5 cell8) cell2
      :else nil)))

(defn- won-by-diagonals [board]
  (let [[cell0 cell1 cell2 cell3 cell4 cell5 cell6 cell7 cell8] board]
    (cond
      (same-marker? cell0 cell4 cell8) cell0
      (same-marker? cell2 cell4 cell6) cell2
      :else nil)))

(defn tied? [current-board]
  (every? not-empty current-board))

(defn winning-marker [current-board]
  (or (won-by-rows current-board) 
      (won-by-columns current-board) 
      (won-by-diagonals current-board)))

(defn game-over? [current-board]
  (or (tied? current-board) 
      (boolean (winning-marker current-board))))


