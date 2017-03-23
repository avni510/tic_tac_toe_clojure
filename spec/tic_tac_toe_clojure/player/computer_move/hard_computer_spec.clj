(ns tic-tac-toe-clojure.player.computer-move.hard-computer-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.board :as board]
            [tic-tac-toe-clojure.player.computer-move :refer [ai-move]]
            [tic-tac-toe-clojure.player.computer-move.hard-computer :refer :all]))

(def human-marker
  :x)

(def computer-marker
  :o)

(def empty-3X3-board
  [0  1  2
    3  4  5
    6  7  8])

(describe "Hard Computer"
  (describe "ai-move"
    (context "the human is the first player and the computer is the second player"
      (defn- simulate-human-move [markers boards]
        (mapcat (fn[board] (map #(board/fill-board % board (:human-marker markers))
                                 (board/open-spaces board))) boards))

      (defn- simulate-computer-move [markers boards]
        (let [human-marker (:human-marker markers)
              computer-marker (:computer-marker markers)]
        (map #(->
                (ai-move {:board %
                          :current-player {:player-type :hard-computer :marker computer-marker}
                          :opponent-player {:player-type :human :marker human-marker}})
                (board/fill-board % computer-marker))
              boards)))

      (defn- add-to-completed-boards [game-over-boards completed-boards]
         (if (empty? game-over-boards)
           completed-boards
           (conj completed-boards game-over-boards)))

      (defn- game-over-states [simulate-move-functions in-progress-boards completed-boards]
        (let [move-function (first simulate-move-functions)
              game-over-boards (filter #(game-evaluation/game-over? %) in-progress-boards)]
          (if (empty? in-progress-boards)
            completed-boards
            (recur (reverse simulate-move-functions)
                   (move-function (remove #(game-evaluation/game-over? %) in-progress-boards))
                   (add-to-completed-boards game-over-boards completed-boards)))))

      (context "it is a 3X3 board"
        (def all-game-over-states
           (apply concat
                  (game-over-states
                    [(partial simulate-human-move
                              {:computer-marker computer-marker :human-marker human-marker})
                     (partial simulate-computer-move
                              {:computer-marker computer-marker :human-marker human-marker})]
                     (seq (vector empty-3X3-board)) [])))

        (it "only has end states of the board in the sequence all-game-over-states"
          (should= (count all-game-over-states)
                   (reduce (fn [count-game-over-boards game-over-board]
                             (if (game-evaluation/game-over? game-over-board)
                               (inc count-game-over-boards)
                               count-game-over-boards))
                           0 all-game-over-states)))

        (it "never lets the human win the game"
          (should= 0 (reduce (fn [count-wins-by-human game-over-board]
                               (if (= human-marker (game-evaluation/winning-marker game-over-board))
                                 (inc count-wins-by-human)
                                 count-wins-by-human))
                             0 all-game-over-states)))))))
