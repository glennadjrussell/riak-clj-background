(defproject riak-clj-playground "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/tools.logging "0.3.1"]
                 [org.clojure/clojure "1.7.0"]
                 [com.novemberain/welle "3.0.0"]]
  :main ^:skip-aot riak-clj-playground.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
