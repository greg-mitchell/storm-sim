(ns storm-sim.decklist
  "Pre-built decklists for simulation. Decklists are maps from card keyword to count"
  (:require [storm-sim.cards :as c]
            [storm-sim.util :as util]))

(def traditional
  {:pon 4
   :bs 4
   :gp 4
   :pre 4
   :dr 4
   :cr 4
   :lp 4
   :led 4
   :it 4
   :pif 1
   :toa 1
   :an 1
   :land 15})

(defn valid-decklist? [decklist]
  (and (>= 60 (util/sum-vals decklist))
       (every? (comp c/cards key) decklist)))
