(ns tic-tac-toe-clojure.player
 (:require [tic-tac-toe-clojure.messages :as messages]
           [tic-tac-toe-clojure.console-ui :as console-ui]))


(defmulti play-turn
  (fn [params] (let [player-type (:player-type (:current-player params))]
                    (player-type {:human :human
                                  :simple-computer :computer
                                  :hard-computer :computer}))))

(defmethod play-turn :default [params]
  (console-ui/print-message (messages/invalid-player-type)))
