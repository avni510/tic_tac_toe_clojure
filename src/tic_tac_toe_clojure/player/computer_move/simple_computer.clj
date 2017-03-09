(ns tic-tac-toe-clojure.player.computer-move.simple-computer
  (:require [tic-tac-toe-clojure.player.computer-move :refer [ai-move]]
            [tic-tac-toe-clojure.helpers :as helpers]
            [tic-tac-toe-clojure.board :as board]))

(defn- simple-computer-move [board]
  (helpers/random-number (board/open-spaces board)))

(defmethod ai-move :simple-computer [params]
  (let [board (:board params)]
    (simple-computer-move board)))
