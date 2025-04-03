;;Código da figura 19

;; Criando um atom com valor inicial 0
(def contador (atom 0))

;; Criando duas referências (refs) para simular contas bancárias
(def saldo-conta1 (ref 1000))
(def saldo-conta2 (ref 500))

(def -main []
  ;; Transferindo 200 de conta1 para conta2
(dosync
   (alter saldo-conta1 - 200)
   (alter saldo-conta2 + 200))

;; Verificando os saldos após a transferência
(println "Saldo da conta 1:" @saldo-conta1) ;; Saída: 800
(println "Saldo da conta 2:" @saldo-conta2)) ;; Saída: 700
