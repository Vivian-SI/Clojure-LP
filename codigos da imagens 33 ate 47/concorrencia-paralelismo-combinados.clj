;;Figura 45
(ns concorrencia-paralelismo-combinados.core
  (:gen-class))

(def contador (atom 0))

(defn incrementar []
  (swap! contador inc))

(defn -main []
  (let [futuros (doall (repeatedly 10 #(future (incrementar))))]
    (doseq [f futuros] @f)
    (println "Valor final do contador:" @contador)))