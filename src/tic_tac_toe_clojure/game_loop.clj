(ns tic-tac-toe-clojure.game-loop
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.board :as board]
            [tic-tac-toe-clojure.game-evaluation :as game-evaluation]))

(defn- invalid-move [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (console-ui/get-user-input))

(defn- valid-move-loop [move board]
  (let [errors-hash (validation/execute-move board move)]
    (if (:errors errors-hash)
      (recur (invalid-move errors-hash) board)
      move)))

(defn- select-move [board]
  (console-ui/print-message (messages/player-move))
  (console-ui/print-message (messages/blank-space))
  (-> 
    (console-ui/get-user-input)
    (valid-move-loop board)
    (read-string)))

(defn- player-turn [current-board current-marker]
  (console-ui/print-message (messages/player-turn current-marker)) 
  (console-ui/print-message (messages/board-string current-board))
  (->
    (select-move current-board)
    (board/fill-board current-board current-marker)))

(defn run [current-board current-marker opponent-marker]
  (if (game-evaluation/game-over? current-board)
    current-board
    (recur (player-turn current-board current-marker) 
           opponent-marker current-marker)))


  

