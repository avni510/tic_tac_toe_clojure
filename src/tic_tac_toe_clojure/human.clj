(ns tic-tac-toe-clojure.human
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

(defn- human-select-move [board player-map]
  (console-ui/print-message (messages/player-move))
  (console-ui/print-message (messages/blank-space))
  (->
    (console-ui/get-user-input)
    (valid-move-loop board)
    (read-string)))

(defmethod play-turn :human [params]
  (let [board (:board params)
        player-map (:current-player params)
        human-marker (:marker player-map)]
    (console-ui/print-message (messages/player-turn human-marker))
    (console-ui/print-message (messages/board-string board))
    (->
      (human-select-move board player-map)
      (board/fill-board board human-marker))))
