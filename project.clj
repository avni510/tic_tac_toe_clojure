(defproject tic_tac_toe_clojure "0.1.0-SNAPSHOT"
  :description "tic tac toe human v. unbeatable computer"
  :url "https://github.com/avni510/tic_tac_toe_clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]]
  :test-paths ["spec"]
  :resource-paths ["src"]
  :main tic-tac-toe-clojure.core)
