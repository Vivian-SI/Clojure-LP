;if com condições simples
(if true "Sim" "Não") ;; => "Sim"
(if false "Sim" "Não") ;; => "Não"

;when executa o bloco se a condição for verdadeira
(when true
  (println "Executando...") "Retorno final")
;; Saída: "Executando..."
;; => Retorno: "Retorno final"

;cond aninhamento de condições
(cond
  (= x 1) "Um"
  (= x 2) "Dois"
  :else "Outro") ;; else funciona como um default