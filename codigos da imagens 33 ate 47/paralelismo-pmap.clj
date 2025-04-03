;;Figura 43
(ns paralelismo-pmap.core
  (:gen-class))

(defn -main []
  (println "Resultado pmap:" (pmap inc [1 2 3 4 5])))