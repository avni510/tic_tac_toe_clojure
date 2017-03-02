(ns tic-tac-toe-clojure.computer-move
 (:require [tic-tac-toe-clojure.validation-rules :as validation-rules]
           [tic-tac-toe-clojure.helpers :as helpers]
           [tic-tac-toe-clojure.minimax :as minimax]
           ))

(defmulti ai-move 
  (fn [params] (:player-type (:current-player-map params))))

(defn- simple-computer-move [board]
  (helpers/random-number (count board)))

(defn- valid-move-loop-simple-computer [move board]
  (if (validation-rules/cell-occupied? board move)
    (recur (simple-computer-move board) board)
    move))

(defmethod ai-move :simple-computer [params]
  (let [board (:board params)]
    (->
        (simple-computer-move board)
        (valid-move-loop-simple-computer board))))

(defmethod ai-move :hard-computer [params]
  (let [board (:board params)
        current-player-map (:current-player-map params)
        opponent-player-map (:opponent-player-map params)]
    (-> (minimax/scores-map board (:marker current-player-map) 
                                  (:marker opponent-player-map))
        (minimax/best-move))))


