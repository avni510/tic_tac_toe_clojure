(ns tic-tac-toe-clojure.game-selection
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]))

(defn- invalid-menu-selection [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (console-ui/get-user-input))

(defn- valid-game-selection-loop [game-selection menu]
  (let [errors-hash (validation/game-type
                      menu
                      game-selection)]
  (if (:errors errors-hash)
    (recur (invalid-menu-selection errors-hash) menu)
    game-selection)))

(defn- find-game [game-selection]
  (cond
    (= game-selection "1. Human V. Simple Computer") :human-v-simple-computer
    (= game-selection "2. Human V. Hard Computer") :human-v-hard-computer
    (= game-selection "1. 3X3 board") :3X3-board
    (= game-selection "2. 4X4 board") :4X4-board))

(defn run [user-instructions menu]
  (console-ui/print-message user-instructions)
  (console-ui/print-message (messages/blank-space))
  (console-ui/print-message (messages/game-menu-instructions))
  (console-ui/print-message (messages/blank-space))
  (dorun (map #(console-ui/print-message %) (vals menu)))
  (->
     (console-ui/get-user-input)
     (valid-game-selection-loop menu)
     (keyword)
     (menu)
     (find-game)))
