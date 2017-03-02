(ns tic-tac-toe-clojure.player-setup
  (:require [clojure.string :as string]
            [tic-tac-toe-clojure.helpers :as helpers]))

(def letters-in-alphabet
  26)

(def letter-a-ascii-value
  65)

(defn create-human-player [human-marker]
  (assoc {:player-type :human} :marker human-marker))

(defn- generate-computer-marker []
  (-> 
    (helpers/random-number letters-in-alphabet) 
    (+ letter-a-ascii-value)
    (char)
    (str)
    (string/lower-case)
    (keyword)))

(defn- computer-marker [human-marker]
  (let [opponent-marker (generate-computer-marker)]
    (if (= human-marker opponent-marker)
      (recur computer-marker)
      opponent-marker)))

(defn create-simple-computer-player [human-marker]
  (assoc {:player-type :simple-computer} 
         :marker (computer-marker human-marker)))

(defn create-hard-computer-player [human-marker]
  (assoc {:player-type :hard-computer} 
         :marker (computer-marker human-marker)))
  
