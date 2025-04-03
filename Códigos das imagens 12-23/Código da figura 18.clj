;;Código da figura 18

;;Criando um atom com valor inicial 0
(def contador (atom 0))
(defn -main[]
;;Atualizando o valor do atom
(swap! contador inc) ;; Incrementa 1
(println @contador) ;; Saída: 1

(reset! contador 10) ;; Define o valor como 10
(println @contador)) ;; Saída: 10
