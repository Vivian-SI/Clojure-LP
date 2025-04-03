;;Figura 47 
(ns efeitos-colaterais.core
  (:gen-class))

(def contador-global (atom 0))

(defn soma-com-efeito-colateral [a b]
  (swap! contador-global inc)
  (+ a b))

(defn -main []
  (println "Resultado da soma:" (soma-com-efeito-colateral 3 4))
  (println "Contador global:" @contador-global))