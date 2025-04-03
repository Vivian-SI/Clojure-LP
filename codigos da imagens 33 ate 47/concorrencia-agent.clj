;;Figura 40
(ns concorrencia-agent.core
  (:gen-class))

(def saldo (agent 100))

(defn -main []
  (send saldo + 50)
  (await saldo)
  (println "Saldo final:" @saldo))