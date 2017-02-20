(ns tic-tac-toe-clojure.game-setup 
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [clojure.string :as string]))

(defn- invalid-marker [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (console-ui/get-user-input))

(defn- valid-marker-loop [marker]
  (let [errors-hash (validation/execute-marker marker)]
    (if (:errors errors-hash)
      (recur (invalid-marker errors-hash))
      marker)))

(defn select-marker []
  (console-ui/print-message (messages/game-instructions))
  (console-ui/print-message (messages/blank-space))
  (-> 
    (console-ui/get-user-input)
    (valid-marker-loop)
    (string/lower-case)
    (keyword)))
