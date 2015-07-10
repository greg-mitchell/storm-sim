(ns storm-sim.cards
  "Defines a Card and a database of cards"
  (:require [storm-sim.util :as util]))

(defrecord Card [name cost])

(defrecord Cost [w u b r g x])

(defn map->Cost [{:keys [w u b r g x]}]
  (Cost. (or w 0)
         (or u 0)
         (or b 0)
         (or r 0)
         (or g 0)
         (or x 0)))

(defn cmc [cost]
  (util/sum-vals cost))

(def cards
  "Map from a keyword to the canonical instantiation of that card"
  {:pon (->Card "Ponder" (map->Cost {:u 1}))
   :bs (->Card "Brainstorm" (map->Cost {:u 1}))
   :pre (->Card "Preordain" (map->Cost {:u 1}))
   :gp (->Card "Gitaxian Probe" (map->Cost {:u 1}))
   :sdt (->Card "Sensei's Divining Top" (map->Cost {:x 1}))
   :dr (->Card "Dark Ritual" (map->Cost {:b 1}))
   :cr (->Card "Cabal Ritual" (map->Cost {:b 1 :x 1}))
   :fil (->Card "Rain of Filth" (map->Cost {:b 1}))
   :lp (->Card "Lotus Petal" (map->Cost {}))
   :led (->Card "Lion's Eye Diamond" (map->Cost {}))
   :it (->Card "Infernal Tutor" (map->Cost {:b 1 :x 1}))
   :gt (->Card "Grim Tutor" (map->Cost {:b 2 :x 1}))
   :pif (->Card "Past in Flames" (map->Cost {:r 1 :x 3}))
   :toa (->Card "Tendrils of Agony" (map->Cost {:b 2 :x 2}))
   :etw (->Card "Empty the Warrens" (map->Cost {:r 1 :x 3}))
   :an (->Card "Ad Nauseam" (map->Cost {:b 2 :x 3}))
   :land (->Card "Generic Land" (map->Cost {}))})
