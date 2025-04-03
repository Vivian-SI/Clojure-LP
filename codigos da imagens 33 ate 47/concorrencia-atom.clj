;;Figura 38
(ns concorrencia-atom.core
  (:gen-class))

(def contador (atom 0))

(defn incrementar []
  (swap! contador inc))

(defn -main []
  (dotimes [_ 10]
    (future (incrementar)))
  
  (Thread/sleep 1000)
  (println "Contador final:" @contador))