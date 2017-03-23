(ns tic-tac-toe-clojure.player.human
  (:require [tic-tac-toe-clojure.player :refer [play-turn]]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.board :as board]))

(defn- invalid-move [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (console-ui/get-user-input))

(defn- valid-move-loop [move board]
  (let [errors-hash (validation/move board move)]
    (if (:errors errors-hash)
      (recur (invalid-move errors-hash) board)
      move)))

(defn- select-move [board human-player]
  (console-ui/print-message (messages/player-move-instructions board))
  (console-ui/print-message (messages/blank-space))
  (->
    (console-ui/get-user-input)
    (valid-move-loop board)
    (read-string)))

(defmethod play-turn :human [params]
  (let [board (:board params)
        human-player (:current-player params)
        human-marker (:marker human-player)]
    (console-ui/print-message (messages/player-turn human-marker))
    (console-ui/print-message (messages/board-string board))
    (->
      (select-move board human-player)
      (board/fill-board board human-marker))))
