(ns tic-tac-toe-clojure.console-ui
  (:require [clojure.string :as string]))

(defn print-message [message]
  (println message))

(defn get-user-input []
  (string/trim (read-line)))
