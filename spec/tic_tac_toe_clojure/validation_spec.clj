(ns tic-tac-toe-clojure.validation-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe-clojure.validation :refer :all]))


(describe "validation"
  (it "returns true if the cell is open" 
      (should= true (cell-open?  [ 
                                    "X" "" ""
                                    "" "" "X"
                                    "O" "O" "X"
                                  ] 4))
  )

  (it "returns false if the cell is not open" 
      (should= false (cell-open?  [ 
                                    "X" "" ""
                                    "" "" "X"
                                    "O" "O" "X"
                                  ] 0))
  )

  (it "returns true if the input is a number between 0 to 8"
      (should= true (valid-position? "0")
   ))

;  (it "returns false if the input is a number less than 0 or greater than 8"
;      (should= false (valid-position? "9")
;   ))
;
  (it "returns false if the input is a string"
      (should= false (valid-position? "z")
   ))
)

