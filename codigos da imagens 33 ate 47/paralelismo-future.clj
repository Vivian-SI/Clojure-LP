;;Figura 42
(ns paralelismo-future.core
  (:gen-class))

(defn -main []
  (let [resultado (future (do (Thread/sleep 1000) (* 10 20)))]
    (println "Calculando...")
    (println "Resultado:" @resultado)))