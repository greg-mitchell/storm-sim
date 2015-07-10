(ns storm-sim.util)

(defn sum-vals
  "Reduce a map from anything to ints into the sum of the values."
  [int-map]
  (reduce #(+ %1 (or (val %2) 0)) 0 int-map))
