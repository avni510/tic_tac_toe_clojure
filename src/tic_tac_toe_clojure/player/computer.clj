(ns tic-tac-toe-clojure.player.computer
  (:require [tic-tac-toe-clojure.player :refer [play-turn]]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.player.computer-move :as computer-move]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.board :as board]))

(defmethod play-turn :computer [params]
  (let [board (:board params)
        current-player (:current-player params)
        computer-marker (:marker current-player)]
    (console-ui/print-message (messages/player-turn computer-marker))
    (console-ui/print-message (messages/blank-space))
    (let [move (computer-move/ai-move params)
          updated-board (board/fill-board move board computer-marker)]
      (console-ui/print-message (messages/board-string updated-board))
      (console-ui/print-message (messages/computer-move move))
      updated-board)))
