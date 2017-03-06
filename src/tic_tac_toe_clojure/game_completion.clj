(ns tic-tac-toe-clojure.game-completion
  (:require [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.messages :as messages]
            [tic-tac-toe-clojure.console-ui :as console-ui]))

(defn game-over-message [board]
  (console-ui/print-message (messages/board-string board))
  (let [winning-marker (game-evaluation/winning-marker board)]
    (if winning-marker
      (messages/won-game winning-marker)
      (messages/tied-game))))
