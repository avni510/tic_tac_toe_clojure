(ns tic-tac-toe-clojure.player.computer-move.hard-computer-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.player.computer-move :refer [ai-move]]
            [tic-tac-toe-clojure.player.computer-move.hard-computer :refer :all]))

(describe "Hard Computer"
  (describe "ai-move"
    (context "there are two spots open"
      (it "returns the spots where the computer is most likely to win"
        (should= 4 (ai-move {:board [
                                     :o :o :x
                                     :x 4 :o
                                     :x 7 :o]
                             :current-player {:player-type :hard-computer :marker :x}
                             :opponent-player {:player-type :human :marker :o}}))

        (should= 8 (ai-move {:board [
                                     :o :x 2
                                     :x :x :o
                                     :o :o 8]
                             :current-player {:player-type :hard-computer :marker :x}
                             :opponent-player {:player-type :human :marker :o}}))))

    (context "there are three spots open"
      (it "returns the spots where the computer is most likely to win"
        (should= 4 (ai-move {:board [
                                     :o :o :x
                                     :x 4 5
                                     :x 7 :o]
                             :current-player {:player-type :hard-computer :marker :x}
                             :opponent-player {:player-type :human :marker :o}}))

        (should= 1 (ai-move {:board [
                                     :x 1 :x
                                     3 :o 5
                                     :o :o :x]
                             :current-player {:player-type :hard-computer :marker :x}
                             :opponent-player {:player-type :human :marker :o}}))

        (should= 6 (ai-move {:board [
                                     0 :x :o
                                     :x :o 5
                                     6 :o :x]
                             :current-player {:player-type :hard-computer :marker :x}
                             :opponent-player {:player-type :human :marker :o}}))))

    (context "there are four spots open"
      (it "returns the spots where the computer is most likely to win"
         (should= 4 (ai-move {:board [
                                      :o :o :x
                                      3 4 5
                                      :x 7 :o]
                              :current-player {:player-type :hard-computer :marker :x}
                              :opponent-player {:player-type :human :marker :o}}))

         (should= 8 (ai-move {:board [
                                      0 :x :o
                                      3 :x 5
                                      :o :o 8]
                              :current-player {:player-type :hard-computer :marker :x}
                              :opponent-player {:player-type :human :marker :o}}))))

    (context "there are six spots open"
      (it "returns the spots where the computer is most likely to win"
         (should= 3 (ai-move {:board  [
                                       :x 1 2
                                       3 :o 5
                                       :x 7 8]
                              :current-player {:player-type :hard-computer :marker :o}
                              :opponent-player {:player-type :human :marker :x}}))))))
