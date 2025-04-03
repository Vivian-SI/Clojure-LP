;;Código da figura 16

;; Função normal
(defn minha-funcao
   ( * x x))

;; Função que recebe outra função como argumento
( defn aplicar-funcao [f valor]
   (f valor))

;; Função que retorna outra função
(defn criar-multiplicador [n]
   (fn [x] (* x n)))

