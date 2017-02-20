(ns tic-tac-toe-clojure.validation-console-input
  (:require [tic-tac-toe-clojure.helpers :as helpers]))
  
(defn is-num? [input]
  (number? (read-string input)))
