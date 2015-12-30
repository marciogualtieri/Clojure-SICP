(ns sicp.core-test
  (:require [clojure.test :refer :all]
            [sicp.core :refer :all]))

(deftest test-square-root
  (defn discrepancy [expected-value actual-value]
    (Math/abs (float (- expected-value actual-value)))
    )
  (def max-error 0.001)
  (testing "Square root of two."
    (is (< (discrepancy 1.414 (square-root 2 max-error))
           max-error)
        )
    )
  )

(deftest test-fibonnaci
  (test "Fibonacci of ten.")
  (is (= 55 (fibonacci 10))
      )
  )

(deftest test-solve-hanoi-towers
  (testing "Solve Hanoi Towers puzzle with 3 disks."
    (def expected-solution ['(\A \B), '(\A \C), '(\B \C), '(\A \B), '(\C \A), '(\C \B), '(\A \B)])
    (is (= (solve-hanoi-towers 3 \A \B \C) expected-solution))
    )
  )
