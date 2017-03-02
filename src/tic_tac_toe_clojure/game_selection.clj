(ns tic-tac-toe-clojure.game-selection
  (:require [tic-tac-toe-clojure.validation :as validation]
           [tic-tac-toe-clojure.messages :as messages]
           [tic-tac-toe-clojure.console-ui :as console-ui]))

(defn- invalid-menu-selection [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (keyword (console-ui/get-user-input)))

(defn- valid-game-type-loop [game-type-selection game-menu]
  (let [errors-hash (validation/game-type 
                      game-menu 
                      game-type-selection)]
  (if (:errors errors-hash)
    (recur (invalid-menu-selection errors-hash) game-menu)
    game-type-selection)))

(defn- find-game-type [game-type-selection]
  (if (= game-type-selection "1. Human V. Simple Computer")
    :human-v-simple-computer
    :human-v-hard-computer))
  
(defn run [game-menu]
  (console-ui/print-message (messages/game-type-instructions))
  (console-ui/print-message (messages/blank-space))
  (console-ui/print-message (messages/game-menu-instructions))
  (console-ui/print-message (messages/blank-space))
  (dorun (map #(console-ui/print-message %) (vals game-menu)))
  (-> 
     (console-ui/get-user-input)
     (keyword)
     (valid-game-type-loop game-menu)
     (game-menu)
     (find-game-type)))
