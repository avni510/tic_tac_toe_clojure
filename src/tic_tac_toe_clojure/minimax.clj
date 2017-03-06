(ns tic-tac-toe-clojure.minimax
  (:require [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.board :as board]))

(defn- determine-player-marker [depth computer-marker opponent-marker]
  (if (zero? (mod depth 2))
   computer-marker
   opponent-marker))

(defn- calculate-score [board computer-marker opponent-marker depth]
  (let [winning-marker (game-evaluation/winning-marker board)]
    (if winning-marker
      (if (= winning-marker computer-marker)
        (- 100 depth)
        (- depth 100))
    0)))

(defn- generate-boards [current-player-marker board]
  (map #(board/fill-board % board current-player-marker)
       (board/open-spaces board)))

(declare optimal-score)

(defn- retrieve-score [board computer-marker opponent-marker depth]
  (if (game-evaluation/game-over? board)
    (calculate-score board computer-marker opponent-marker depth)
    (->
       (determine-player-marker depth computer-marker opponent-marker)
       (generate-boards board)
       (optimal-score computer-marker opponent-marker (inc depth)))))

(defn- min-or-max [depth]
  (if (zero? (mod depth 2))
    min
    max))

(defn- optimal-score
  [sequence-boards computer-marker opponent-marker depth]
  (->>
      (map #(retrieve-score % computer-marker opponent-marker depth)
           sequence-boards)
      (apply (min-or-max depth))))

(defn scores-map [board computer-marker opponent-marker]
  (map #(hash-map %
          (optimal-score
            (lazy-seq (vector (board/fill-board % board computer-marker)))
            computer-marker
            opponent-marker
            1))
          (board/open-spaces board)))

(defn best-move [move-score-map]
  (->> move-score-map
       (apply merge)
       (apply max-key val)
       (key)))
