(ns tic-tac-toe-clojure.game-setup 
  (:require [tic-tac-toe-clojure.validation :as validation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]
            [tic-tac-toe-clojure.player-setup :as player-setup]
            [clojure.string :as string]))

(defn- invalid-marker [errors-hash]
  (console-ui/print-message (:errors errors-hash))
  (console-ui/get-user-input))

(defn- valid-marker-loop [marker]
  (let [errors-hash (validation/marker marker)]
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

(defn- computer-marker-message [computer-player-map]
  (-> (:marker computer-player-map)
      (messages/computer-marker)
      (console-ui/print-message)))

(defn- determine-players [game-type human-marker]
  (if (= game-type :human-v-simple-computer)
    [(player-setup/create-human-player human-marker) 
     (player-setup/create-simple-computer-player human-marker)]
    [(player-setup/create-human-player human-marker) 
     (player-setup/create-hard-computer-player human-marker)]))

(defn game-players [game-type human-marker]
  (let [[human-player-map computer-player-map] 
        (determine-players game-type human-marker)]
    (computer-marker-message computer-player-map)
    (console-ui/print-message (messages/blank-space))
    [human-player-map computer-player-map]))



