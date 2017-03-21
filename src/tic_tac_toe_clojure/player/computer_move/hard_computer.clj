(ns tic-tac-toe-clojure.player.computer-move.hard-computer
  (:require [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.board :as board]
            [tic-tac-toe-clojure.player.computer-move :refer [ai-move]]))

(defn determine-initial-score [depth]
  (if (zero? (mod depth 2))
    -100
    100))

(defn calculate-score [board computer-marker opponent-marker depth]
  (let [winning-marker (game-evaluation/winning-marker board)]
    (if winning-marker
      (if (= winning-marker computer-marker)
        (- 100 depth)
        (- depth 100))
    0)))

(defn generate-boards [current-player-marker board]
  (map #(hash-map :space % :board (board/fill-board % board current-player-marker))
       (board/open-spaces board)))

(defn- determine-player-marker [depth computer-marker opponent-marker]
  (if (zero? (mod depth 2))
    opponent-marker
    computer-marker))

(defn best-move [accumulator]
  (let [board (:board (:board-and-space accumulator))
        space (:space (:board-and-space accumulator))
        depth (:depth accumulator)
        parent-accumulator (:parent-accumulator accumulator)
        children (:children accumulator)
        computer-marker (:computer-marker (:markers accumulator))
        opponent-marker (:opponent-marker (:markers accumulator))]

  (if (and (zero? depth) (empty? children))
    space
    (do
      (if (or (game-evaluation/game-over? board) (empty? children))
        (let [score (calculate-score board computer-marker opponent-marker depth)]
          (if (zero? (mod depth 2))
            (if (< score (:score parent-accumulator))
              (recur (assoc parent-accumulator :children (rest (:children parent-accumulator))
                                   :score score
                                   :board-and-space (assoc (:board-and-space parent-accumulator)
                                                           :space space)))
              (recur (assoc parent-accumulator :children (rest (:children parent-accumulator)))))
            (if (> score (:score parent-accumulator))
              (recur (assoc parent-accumulator :children (rest (:children parent-accumulator))
                            :score score
                            :board-and-space (assoc (:board-and-space parent-accumulator)
                                                    :space space)))
              (recur (assoc parent-accumulator :children (rest (:children parent-accumulator)))))))
        (recur {:board-and-space (first children)
                :score (determine-initial-score (inc depth))
                :depth (inc depth)
                :parent-accumulator accumulator
                :children (generate-boards (determine-player-marker (+ 2 depth)
                                                                    computer-marker
                                                                    opponent-marker) (:board (first children)))
                 :markers (:markers accumulator)}))))))

(defmethod ai-move :hard-computer [params]
  (let [board (:board params)
        current-player (:current-player params)
        opponent-player (:opponent-player params)]
    (best-move {:board-and-space
                {:board board
                 :space nil}
                 :score -100
                 :depth 0
                 :parent nil
                 :markers {:computer-marker (:marker current-player) :opponent-marker (:marker opponent-player)}
                 :children (generate-boards (:marker current-player) board)})))
