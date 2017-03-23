(ns tic-tac-toe-clojure.console-runner
  (:require [tic-tac-toe-clojure.game-loop :as game-loop]
            [tic-tac-toe-clojure.game-completion :as game-completion]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.game-type-setup :as game-type-setup]
            [tic-tac-toe-clojure.board-setup :as board-setup]
            [tic-tac-toe-clojure.game-selection :as game-selection]
            [tic-tac-toe-clojure.player-setup :as player-setup]))

(def board-menu
  {:1 "1. 3X3 board"
   :2 "2. 4X4 board"})

(def game-type-menu
  {:1 "1. Human V. Simple Computer"
   :2 "2. Human V. Hard Computer"})

(defn run []
  (let [empty-board (->
                      (messages/board-type-instructions)
                      (game-selection/run board-menu)
                      (board-setup/determine-empty-board))
        game-type (->
                   (messages/game-type-instructions)
                   (game-selection/run game-type-menu))
        [human-player computer-player] (->>
                                          (game-type-setup/select-marker)
                                          (game-type-setup/game-players
                                            game-type))]
    (-> (game-loop/run empty-board human-player computer-player)
        (game-completion/game-over-message)
        (console-ui/print-message))))
