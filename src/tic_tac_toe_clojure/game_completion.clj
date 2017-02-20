(ns tic-tac-toe-clojure.game-completion
  (:require [tic-tac-toe-clojure.game-evaluation :as game-evaluation]
            [tic-tac-toe-clojure.messages :as messages]))

(defn game-over-message [board]
  (if (game-evaluation/tied? board)
    (messages/tied-game)
    (messages/won-game (game-evaluation/winning-marker board))))


