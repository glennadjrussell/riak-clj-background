(ns riak-clj-playground.core
  (:require [clojure.tools.logging :as log]
            [riak-clj-playground.riak :as rk]))

(def default-bucket "sale_item")

(def test-item-key "test-item-key")

(def test-item
  {:total-ex-tax 100.0
   :total 120.0})

(def default-n-val 5)

(defn -main
  [& args]
  (let [conn (rk/connect-to-riak)]
    (rk/create-bucket conn default-bucket default-n-val)
    (rk/store-json conn default-bucket test-item-key test-item)
    (log/info "Querying back value" (rk/query conn default-bucket test-item-key))))

