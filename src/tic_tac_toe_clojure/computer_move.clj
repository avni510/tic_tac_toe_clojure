(ns tic-tac-toe-clojure.computer-move)

(defmulti ai-move
  (fn [params] (:player-type (:current-player params))))

