(ns tic-tac-toe-clojure.validation-console-input-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation-console-input :refer :all]))

(describe "Validation Console Input"
  (describe "is-num?"
    (it "returns true if the user enters a number"
      (should= true (is-num? "8")))

    (it "returns false if the user does not enters a number"
      (should= false (is-num? "five")))))
          
