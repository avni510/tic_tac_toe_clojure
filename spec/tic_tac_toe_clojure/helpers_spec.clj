(ns tic-tac-toe-clojure.helpers-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.helpers :refer :all]))

(describe "Helpers"
  (describe "is-num?"
    (it "returns true if a string is a number"
      (should= true (is-num? "6")))

    (it "returns false if a string is not a number"
      (should= false (is-num? "hello world")))))
