(ns tic-tac-toe-clojure.player.computer-move)

(defmulti ai-move
  (fn [params] (:player-type (:current-player params))))
