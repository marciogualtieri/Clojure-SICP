(ns sicp.core
  (:gen-class))

(use '[clojure.string :only (join)])

(defn square-root [x precision]
  (defn guess-close-enough? [guess x]
    (< (Math/abs (- (Math/pow guess 2) x)) precision)
    )
  (defn improve-guess [guess x]
    (/ (+ guess (/ x guess)) 2)
    )
  (defn try-guess [guess]
    (if (guess-close-enough? guess x)
      guess
      (try-guess (improve-guess guess x))
      )
    )
  (try-guess 1)
  )

(defn fibonacci [index]
  (if (< index 2)
    index
    (+ (fibonacci (- index 1)) (fibonacci (- index 2)))
    )
  )

(defn solve-hanoi-towers [number-of-disks from-peg to-peg spare-peg]
  (if (> number-of-disks 0) (concat
                              (solve-hanoi-towers (dec number-of-disks) from-peg spare-peg to-peg)
                              [(seq [from-peg to-peg])]
                              (solve-hanoi-towers (dec number-of-disks) spare-peg to-peg from-peg)
                              )
                            )
  )

(defn -main
  "Functions from SICP course"
  [& args]
  (def x 2.0)
  (def precision 0.001)
  (def index 10)
  (def number-of-disks 3)
  (println (format "SQUARE ROOT OF %.3f: %.3f" x (float (square-root x precision))))
  (println (format "FIBONACCI NUMBER WITH INDEX %d: %d" index (fibonacci index)))
  (println (format "HANOI TOWERS SOLUTION FOR %d DISKS: %s" number-of-disks (join \, (solve-hanoi-towers number-of-disks \A \B \C))))
  )