(ns tic-tac-toe-clojure.board-setup-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.board-setup :refer :all]))

(describe "Board Selection"
  (describe "determine-empty-board"
    (it "returns an empty 3X3 board if the 3X3 board type is passed in"
      (should= empty-3X3-board (determine-empty-board :3X3-board)))

    (it "returns an empty 4X4 board if the 4X4 board type is passed in"
      (should= empty-4X4-board (determine-empty-board :4X4-board)))

    (it "raises an errors if the board type is invalid"
      (should= "caught : invalid board type" (try (determine-empty-board :hello_world)
                                                  (catch Exception e (str "caught : " (.getMessage e))))))))
