(ns tic-tac-toe-clojure.validation-console-input
  (:require [tic-tac-toe-clojure.helpers :as helpers]))
  
(defn is-num? [input]
  (and (not (empty? input)) (boolean (re-matches #"\d*" input))))
