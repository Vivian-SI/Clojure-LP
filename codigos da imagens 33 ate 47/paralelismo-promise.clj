;;Figura 44 
(ns paralelismo-promise.core
  (:gen-class))

(defn -main []
  (let [p (promise)]
    (future (do (Thread/sleep 1000) (deliver p (* 10 2))))
    (println "Aguardando promise...")
    (println "Resultado:" @p)))