(ns tic-tac-toe-clojure.computer-move
 (:require [tic-tac-toe-clojure.validation-rules :as validation-rules]
           [tic-tac-toe-clojure.helpers :as helpers]
           [tic-tac-toe-clojure.minimax :as minimax]
           [tic-tac-toe-clojure.board :as board]
           ))

(defmulti ai-move
  (fn [params] (:player-type (:current-player params))))

(defn- simple-computer-move [board]
  (helpers/random-number (board/open-spaces board)))

(defmethod ai-move :simple-computer [params]
  (let [board (:board params)]
    (->
        (simple-computer-move board))))

(defmethod ai-move :hard-computer [params]
  (let [board (:board params)
        current-player (:current-player params)
        opponent-player (:opponent-player params)]
    (-> (minimax/scores-map board (:marker current-player)
                                  (:marker opponent-player))
        (minimax/best-move))))
