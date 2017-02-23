(ns tic-tac-toe-clojure.player-move
 (:require [tic-tac-toe-clojure.messages :as messages]      
           [tic-tac-toe-clojure.console-ui :as console-ui]
           [tic-tac-toe-clojure.validation :as validation]
           [tic-tac-toe-clojure.validation-rules :as validation-rules]
           [tic-tac-toe-clojure.helpers :as helpers]
           [tic-tac-toe-clojure.board :as board]))


(defmulti make-move
  (fn [board player-map] (:player-type player-map)))

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

(defmethod make-move :human [board player-map]
  (console-ui/print-message (messages/player-turn (:marker player-map)))
  (console-ui/print-message (messages/board-string board))
  (->
    (human-select-move board player-map)
    (board/fill-board board (:marker player-map))))

(defn- computer-move [board]
  (helpers/random-number (count board)))

(defn- valid-move-loop-computer [move board]
  (if (validation-rules/cell-occupied? board move)
    (recur (computer-move board) board)
    move))

(defmethod make-move :computer [board player-map] 
  (console-ui/print-message (messages/player-turn (:marker player-map)))
  (console-ui/print-message (messages/blank-space))
  (let [move (valid-move-loop-computer (computer-move board) board)
        updated-board (board/fill-board move board (:marker player-map))]
    (console-ui/print-message (messages/board-string updated-board))
    (console-ui/print-message (messages/computer-move move))
    updated-board))

(defmethod make-move :default [board player-map]
  (console-ui/print-message (messages/invalid-player-type)))
