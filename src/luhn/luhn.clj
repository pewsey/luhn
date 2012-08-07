(ns luhn.luhn)

(defn- digits [n]
  (map #(Character/digit % 10) (str n)))
 
(defn luhn? [card]
  (let [sum (reduce + (map
                       (fn [d idx]
                         (if (even? idx)
                           (reduce + (digits (* d 2)))
                           d))
                       (reverse (digits card))
                       (iterate inc 1)))]
    (zero? (mod sum 10))))