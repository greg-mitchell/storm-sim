(ns storm-sim.adn
  "Simulates winning off Ad Nauseam"
  (:require [storm-sim.sim :as sim]
            [storm-sim.cards :as c]))

(defn initial-mana
  [{:keys [hand mana]}]
  (let [petals (count (filter (partial = :lp) hand))]
    (merge-with + mana {:b petals})))

(defn can-cast?
  [{:keys [mana] :as _s} {:keys [cost] :as _card}]
  (let [mana-diff (merge-with - mana cost)]
    (and (every? (comp not neg? val) (dissoc mana-diff :x))
         (<= 0 (reduce + (vals mana-diff))))))

(def adn-rules
  [(fn [s] (when (some (partial = :an) (:stack s))
             ))])
