(ns luhn.generate)
(:require [luhn.luhn :as l])
          
(defn- to_string [n pad]
  (format (str "%0" pad "d") n))

(defn- generate [to pad]
  (for [ x (range to)] (to_string x pad)))

(defn cards [ iin range last_four ]
  (map #(str iin % last_four) (generate range (count (str range)))))

(defn check-em [ cardlist ]
  (count (filter true? (map l/luhn? (seq cardlist)))))