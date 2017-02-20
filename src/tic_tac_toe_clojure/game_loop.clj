(ns tic-tac-toe-clojure.game-loop
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]))

; store human and computer markers? 
; game loop 
  ; recursive function
  ; base case if game is over exit loop 
  ; display who's turn it is
  ; display board
  ; get move
  ; validation on move
  ; fill board
  ; call game loop again

;(defn- invalid-move [errors-hash]
;  (console-ui/print-message (:errors errors-hash))
;  (console-ui/get-user-input))
;
;(defn valid-move-loop [board move]
;  (let [errors-hash (validation/execute-move board move)]
;    (if (:errors errors-hash)
;      (recur board (invalid-move errors-hash))
;      move)))


