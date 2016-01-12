(ns riak-clj-playground.riak
  (:require [clojure.tools.logging :as log]
            [clojurewerkz.welle.core :as wc]
            [clojurewerkz.welle.buckets :as wb]
            [clojurewerkz.welle.kv :as kv])
  (:import com.basho.riak.client.http.util.Constants))

(def json-content-type {:content-type Constants/CTYPE_JSON_UTF8})

(defn connect-to-riak []
  (log/info "Connecting to riak")
  (wc/connect))

(defn create-bucket [conn bucket n-val]
  {:pre [(some? conn)]}
  (log/info "Creating bucket" bucket)
  (wb/create conn bucket {:n-val n-val}))

(defn store-json [conn bucket key json-val]
  {:pre [(some? conn)
         (map? json-val)]}
  (log/info "Storing in bucket" key "value" json-val)
  (kv/store conn bucket key json-val json-content-type))

(defn query [conn bucket key]
  {:pre [(some? conn)]}
  (log/info "Retrieving" key "from" bucket)
  (kv/fetch conn bucket key))

