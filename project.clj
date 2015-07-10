(defproject storm-sim "0.1.0-SNAPSHOT"
  :description "Simulator for ANT"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot storm-sim.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
