(ns tic-tac-toe-clojure.player-move
 (:require [tic-tac-toe-clojure.messages :as messages]      
           [tic-tac-toe-clojure.console-ui :as console-ui]
           [tic-tac-toe-clojure.validation :as validation]
           [tic-tac-toe-clojure.board :as board]
           [tic-tac-toe-clojure.computer-move :as computer-move]))


(defmulti make-move
  (fn [params] (let [player-type (:player-type (:current-player-map params))] 
                    (player-type {:human :human :simple-computer :computer :hard-computer :computer}))))
                
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

(defmethod make-move :human [params]
  (let [board (:board params)
        player-map (:current-player-map params)]
    (console-ui/print-message (messages/player-turn (:marker player-map)))
    (console-ui/print-message (messages/board-string board))
    (->
      (human-select-move board player-map)
      (board/fill-board board (:marker player-map)))))

(defmethod make-move :computer [params] 
  (println "hi there")
  (let [board (:board params)
        player-map (:current-player-map params)]
    (console-ui/print-message (messages/player-turn (:marker player-map)))
    (console-ui/print-message (messages/blank-space))
    (let [move (computer-move/ai-move params)
          updated-board (board/fill-board move board (:marker player-map))]
      (console-ui/print-message (messages/board-string updated-board))
      (console-ui/print-message (messages/computer-move move))
      updated-board)))

(defmethod make-move :default [params]
  (console-ui/print-message (messages/invalid-player-type)))
