(ns storm-sim.sim
  "Implements core simulation functionality given initial conditions and an
  arbitrary set of rules to simulate.")

(defrecord State [graveyard hand library play stack mana storm])

(defn terminal? [state]
  (boolean (some (partial = state) [:win :lose :no-moves])))

(defn step
  [state rules]
  (or (some #(% state) rules)
      :no-moves))

(defn simulate
  [state rules]
  (if (terminal? state)
    state
    (recur (step state rules) rules)))
