;;Figura 39 
(ns concorrencia-ref-stm.core
  (:gen-class))

(def conta1 (ref 100))
(def conta2 (ref 200))

(defn transferir [de para valor]
  (dosync
    (alter de - valor)
    (alter para + valor)))

(defn -main []
  (future (transferir conta1 conta2 50))
  (future (transferir conta2 conta1 30))
  
  (Thread/sleep 1000)
  (println "Conta1:" @conta1 "Conta2:" @conta2))