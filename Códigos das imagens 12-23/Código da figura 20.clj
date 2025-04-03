;;Código da figura 20

;; Criando uma variável global dinâmica
(def ^:dynamic *ttaxa* 0.1)

;; Criando uma função que usa a variável global
(defn calcular-preco [valor]
  ( * valor( + 1 *taxa*)))

(defn -main []
  ;; Chamadas dentro da função principal
  (println (calcular-preco 100))) ;; Saída: 110.0

  ;; Mudando temporariamente o valor da taxa dentro de um escopo
  (binding [*taxa* 0.2]
    (println (calcular-preco 100))) ;; Saída: 120.0
