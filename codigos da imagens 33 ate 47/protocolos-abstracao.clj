;;Figura 33
(ns protocolos-abstracao.core
  (:gen-class))

(defprotocol Operacoes
  (somar [this x])
  (multiplicar [this x]))

(defrecord Calculadora [valor]
  Operacoes
  (somar [this x] (+ valor x))
  (multiplicar [this x] (* valor x)))

(defn -main []
  (let [calc (->Calculadora 10)]
    (println "Soma:" (somar calc 5))
    (println "Multiplicação:" (multiplicar calc 3))))