(ns tic-tac-toe-clojure.game-loop
  (:require [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.player :as player]))

(defn run [current-board current-player opponent-player]
  (if (game-evaluation/game-over? current-board)
    current-board
    (recur (player/play-turn {:board current-board
                                   :current-player current-player
                                   :opponent-player opponent-player})
            opponent-player current-player)))
