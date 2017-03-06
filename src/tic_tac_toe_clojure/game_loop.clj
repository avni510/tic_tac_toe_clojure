(ns tic-tac-toe-clojure.game-loop
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.board :as board]
            [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.player-move :as player-move]))

(defn run [current-board current-player opponent-player]
  (if (game-evaluation/game-over? current-board)
    current-board
    (recur (player-move/make-move {:board current-board 
                                   :current-player current-player
                                   :opponent-player opponent-player}) 
            opponent-player current-player)))
