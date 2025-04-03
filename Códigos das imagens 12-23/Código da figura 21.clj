;;Código da figura 21

;; Função nomeada
(defn soma [a b]
  (+ a b))

(soma 3 5) ;; Saída: 8

;;Mesma função na forma de função anônima
(( fn [a b] (+ a b)) 3 5) ;; Saída: 8
