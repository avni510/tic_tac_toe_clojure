(ns tic-tac-toe-clojure.validation-console-input-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation-console-input :refer :all]))

(describe "Validation Console Input"
  (describe "is-num?"
    (it "returns true if the user enters a number"
      (should= true (is-num? "100")))

    (it "returns false if the user enters a word"
      (should= false (is-num? "five")))

    (it "returns false if the user enters a blank space"
      (should= false (is-num? "")))
          
    (it "returns false if the user enters a special character"
      (should= false (is-num? ",")))))
          
